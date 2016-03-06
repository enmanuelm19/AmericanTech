package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import modelos.TipoEventualidad;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.TipoEventualidadDao;

public class TipoEventualidadViewModel {

	private List<TipoEventualidad> tiposAll;
	private TipoEventualidadDao tipoDao;
	private String descFiltro;
	private String idFiltro;

	@Init
	public void init() throws Exception {
		
		tiposAll = new ArrayList<TipoEventualidad>();
		tipoDao = new TipoEventualidadDao();
		tiposAll = tipoDao.obtenerTodos();
	}

	public ListModelList<TipoEventualidad> getAllTipoEventualidad() {

		return new ListModelList<TipoEventualidad>(tiposAll);
	}

	public String getCantRegistros() {
		return tiposAll.size() + " items en la lista";
	}

	public String getDescFiltro() {
		if(descFiltro==null)
			return "";
		return descFiltro;
	}

	public void setDescFiltro(String descFiltro) {
		this.descFiltro = descFiltro==null?"":descFiltro.trim();
	}

	public String getIdFiltro() {
		if(idFiltro==null)
			return "";
		return idFiltro;
	}

	public void setIdFiltro(String idFiltro) {
		this.idFiltro = idFiltro==null?"":idFiltro.trim();
	}

	@Command
	public void showModal(@BindingParam("Tipo") TipoEventualidad tipo) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("TipoEventualidad", tipo);
		Window window = (Window) Executions.createComponents("configuracion/categoria/registrarTipoEventualidad.zul",
				null, args);
		window.doModal();
	}

	@Command
	@NotifyChange({ "allTipoEventualiadad", "cantRegistros" })
	public void eliminar(@BindingParam("Tipo") final TipoEventualidad tipo) {

		Messagebox.show("Estas seguro de eliminar " + tipo.getDescripcion(), "Confirmar",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {
								tipoDao.eliminarTipoEventualidad(tipo);
								tiposAll = tipoDao.obtenerTodos();
								Messagebox.show(tipo.getDescripcion() + " ha sido eliminado", "", Messagebox.OK,
										Messagebox.INFORMATION);
								BindUtils.postGlobalCommand(null, null, "refreshTipoEventualidad", null);
							} catch (Exception e) {
								Messagebox.show(e.getMessage(), tipo.getDescripcion() + " No se pudo eliminar",
										Messagebox.OK, Messagebox.ERROR);
							}
						}
					}
				});
	}

	@Command
	@NotifyChange({ "allTipoEventualidad", "cantRegistros" })
	public void filtro() throws Exception {
		List<TipoEventualidad> tip = new ArrayList<TipoEventualidad>();
		String desc = getDescFiltro().toLowerCase();
		String id = getIdFiltro().toLowerCase();

		for (Iterator<TipoEventualidad> i = tipoDao.obtenerTodos().iterator(); i.hasNext();) {
			TipoEventualidad tmp = i.next();
			if (tmp.getDescripcion().toLowerCase().contains(desc)
					&& String.valueOf(tmp.getIdTipoEventualidad()).toLowerCase().contains(id)) {
				tip.add(tmp);
			}
		}
		tiposAll = tip;
	}

	@GlobalCommand
	@NotifyChange({ "allTipoEventualidad", "cantRegistros" })
	public void refreshTipoEventualidad() throws Exception {
		tiposAll = tipoDao.obtenerTodos();
	}
}

