package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import modelos.TipoPreferencia;

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

import Dao.TipoPreferenciaDao;


public class TipoPreferenciaViewModel {

	private List<TipoPreferencia> tiposAll;
	private TipoPreferenciaDao tipoDao;
	private String descFiltro;
	private String idFiltro;

	@Init
	public void init() throws Exception {
		
		tiposAll = new ArrayList<TipoPreferencia>();
		tipoDao = new TipoPreferenciaDao();
		tiposAll = tipoDao.obtenerTodos();
	}

	public ListModelList<TipoPreferencia> getAllTipoPreferencia() {

		return new ListModelList<TipoPreferencia>(tiposAll);
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
	public void showModal(@BindingParam("Tipo") TipoPreferencia tipo) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("TipoPreferencia", tipo);
		Window window = (Window) Executions.createComponents("configuracion/categoria/registrarTipoPreferencia.zul",
				null, args);
		window.doModal();
	}

	@Command
	@NotifyChange({ "allTipoPreferencia", "cantRegistros" })
	public void eliminar(@BindingParam("Tipo") final TipoPreferencia tipo) {

		Messagebox.show("Estas seguro de eliminar " + tipo.getDescripcion(), "American Tech",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {
								tipoDao.eliminarTipoPreferencia(tipo);
								tiposAll = tipoDao.obtenerTodos();
								Messagebox.show(tipo.getDescripcion() + " ha sido eliminado", "American Tech", Messagebox.OK,
										Messagebox.INFORMATION);
								BindUtils.postGlobalCommand(null, null, "refreshTipoPreferencia", null);
							} catch (Exception e) {
								Messagebox.show(e.getMessage(), tipo.getDescripcion() + " American Tech",
										Messagebox.OK, Messagebox.ERROR);
							}
						}
					}
				});
	}

	@Command
	@NotifyChange({ "allTipoPreferencia", "cantRegistros" })
	public void filtro() throws Exception {
		List<TipoPreferencia> tip = new ArrayList<TipoPreferencia>();
		String desc = getDescFiltro().toLowerCase();
		String id = getIdFiltro().toLowerCase();

		for (Iterator<TipoPreferencia> i = tipoDao.obtenerTodos().iterator(); i.hasNext();) {
			TipoPreferencia tmp = i.next();
			if (tmp.getDescripcion().toLowerCase().contains(desc)
					&& String.valueOf(tmp.getIdTipoPreferencia()).toLowerCase().contains(id)) {
				tip.add(tmp);
			}
		}
		tiposAll = tip;
	}

	@GlobalCommand
	@NotifyChange({ "allTipoPreferencia", "cantRegistros" })
	public void refreshTipoPreferencia() throws Exception {
		tiposAll = tipoDao.obtenerTodos();
	}
}
