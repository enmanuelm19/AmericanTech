package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import modelos.TipoNoticia;

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

import Dao.TipoNoticiaDao;

public class TipoNoticiaViewModel {

	private List<TipoNoticia> tiposAll;
	private TipoNoticiaDao tipoDao;
	private String descFiltro;
	private String idFiltro;

	@Init
	public void init() throws Exception {
		
		tiposAll = new ArrayList<TipoNoticia>();
		tipoDao = new TipoNoticiaDao();
		tiposAll = tipoDao.obtenerTodos();
	}

	public ListModelList<TipoNoticia> getAllTipoNoticia() {

		return new ListModelList<TipoNoticia>(tiposAll);
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
	public void showModal(@BindingParam("Tipo") TipoNoticia tipo) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("TipoNoticia", tipo);
		Window window = (Window) Executions.createComponents("configuracion/categoria/registrarTipoNoticia.zul",
				null, args);
		window.doModal();
	}

	@Command
	@NotifyChange({ "allTipoNoticia", "cantRegistros" })
	public void eliminar(@BindingParam("Tipo") final TipoNoticia tipo) {

		Messagebox.show("Estas seguro de eliminar " + tipo.getDescripcion(), "American Tech",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {
								tipoDao.eliminarTipoNoticia(tipo);
								tiposAll = tipoDao.obtenerTodos();
								Messagebox.show(tipo.getDescripcion() + " ha sido eliminado", "American Tech", Messagebox.OK,
										Messagebox.INFORMATION);
								BindUtils.postGlobalCommand(null, null, "refreshTipoNoticia", null);
							} catch (Exception e) {
								Messagebox.show(e.getMessage(), tipo.getDescripcion() + "American Tech",
										Messagebox.OK, Messagebox.ERROR);
							}
						}
					}
				});
	}

	@Command
	@NotifyChange({ "allTipoNoticia", "cantRegistros" })
	public void filtro() throws Exception {
		List<TipoNoticia> tip = new ArrayList<TipoNoticia>();
		String desc = getDescFiltro().toLowerCase();
		String id = getIdFiltro().toLowerCase();

		for (Iterator<TipoNoticia> i = tipoDao.obtenerTodos().iterator(); i.hasNext();) {
			TipoNoticia tmp = i.next();
			if (tmp.getDescripcion().toLowerCase().contains(desc)
					&& String.valueOf(tmp.getIdTipoNoticia()).toLowerCase().contains(id)) {
				tip.add(tmp);
			}
		}
		tiposAll = tip;
	}

	@GlobalCommand
	@NotifyChange({ "allTipoNoticia", "cantRegistros" })
	public void refreshTipoNoticia() throws Exception {
		tiposAll = tipoDao.obtenerTodos();
	}
}
