package controllers;

import Dao.TipoAfiliadoDao;
import modelos.TipoAfiliado;
import modelos.TipoInstalacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

public class TipoAfiliadoViewModel {

	private List<TipoAfiliado> tiposAll;
	private TipoAfiliadoDao tipoDao;
	private String idFiltro;
	private String descFiltro;
	
	@Init
	public void init() throws Exception{
		tiposAll = new ArrayList<TipoAfiliado>();
		tipoDao = new TipoAfiliadoDao();
		tiposAll = tipoDao.obtenerTodos();	
	}
	
	public ListModelList<TipoAfiliado> getAllTipoAfiliado(){
		return new ListModelList<TipoAfiliado>(tiposAll);
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
	
	public String getCantRegistros() {
		return tiposAll.size() + " items en la lista";
	}
	
	@Command
	public void showModal(@BindingParam("Tipo") TipoAfiliado tipo) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("TipoAfiliado", tipo);
		Window window = (Window) Executions.createComponents("configuracion/categoria/registrarTipoAfiliado.zul",
				null, args);
		window.doModal();
	}
	
	@GlobalCommand
	@NotifyChange({ "allTipoAfiliado", "cantRegistros" })
	public void refreshTipoAfiliado() throws Exception {
		tiposAll = tipoDao.obtenerTodos();
	}
	
	@Command
	@NotifyChange({ "allTipoAfiliado", "cantRegistros" })
	public void filtro() throws Exception {
		List<TipoAfiliado> tip = new ArrayList<TipoAfiliado>();
		String desc = getDescFiltro().toLowerCase();
		String id = getIdFiltro().toLowerCase();

		for (Iterator<TipoAfiliado> i = tipoDao.obtenerTodos().iterator(); i.hasNext();) {
			TipoAfiliado tmp = i.next();
			if (tmp.getDescripcion().toLowerCase().contains(desc)
					&& String.valueOf(tmp.getIdTipoAfiliado()).toLowerCase().contains(id)) {
				tip.add(tmp);
			}
		}
		tiposAll = tip;
	}
	
	@Command
	@NotifyChange({ "allTipoAfiliado", "cantRegistros" })
	public void eliminar(@BindingParam("Tipo") final TipoAfiliado tipo) {

		Messagebox.show("Estas seguro de eliminar " + tipo.getDescripcion(), "American Tech",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {
								tipoDao.eliminarTipoAfiliado(tipo);;
								tiposAll = tipoDao.obtenerTodos();
								Messagebox.show(tipo.getDescripcion() + " ha sido eliminado", "American Tech", Messagebox.OK,
										Messagebox.INFORMATION);
								BindUtils.postGlobalCommand(null, null, "refreshTipoAfiliado", null);
							} catch (Exception e) {
								Messagebox.show(e.getMessage(), tipo.getDescripcion() + " American Tech",
										Messagebox.OK, Messagebox.ERROR);
							}
						}
					}
				});
	}
	
}
