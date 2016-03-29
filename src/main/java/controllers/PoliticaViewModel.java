package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import modelos.Politica;


import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.PoliticaDao;


public class PoliticaViewModel {
	
	private List<Politica> reglasAll;
	private PoliticaDao politicaDao;
	private String descFiltro;
	
	@Init
	public void init() throws Exception {
		
		reglasAll = new ArrayList<Politica>();
		politicaDao = new PoliticaDao();
		reglasAll = politicaDao.obtenerTodos();
	}
	
	public ListModelList<Politica> getAllPoliticas() {

		return new ListModelList<Politica>(reglasAll);
	}
	
	public String getCantRegistros() {
		return reglasAll.size() + " items en la lista";
	}

	public String getDescFiltro() {
		if(descFiltro==null)
			return "";
		return descFiltro;
	}
	
	public void setDescFiltro(String descFiltro) {
		this.descFiltro = descFiltro==null?"":descFiltro.trim();
	}
	
	
	@Command
	public void showModal(@BindingParam("Politica") Politica politica) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("Politica", politica);
		Window window = (Window) Executions.createComponents("configuracion/registrarRegla.zul",null, args);
		window.doModal();
	}
	

	
	@Command
	@NotifyChange({ "allPoliticas", "cantRegistros" })
	public void eliminar(@BindingParam("Politica") final Politica politica) {

		Messagebox.show("Estas seguro de eliminar " + politica.getDescripcion(), "American Tech",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {
								politicaDao.eliminarPolitica(politica);;
								reglasAll = politicaDao.obtenerTodos();
								Messagebox.show("La política ha sido eliminada", "American Tech", Messagebox.OK, Messagebox.INFORMATION);
								BindUtils.postGlobalCommand(null, null, "refreshReglas", null);
							} catch (Exception e) {
								Messagebox.show(e.getMessage(), "American Tech", Messagebox.OK, Messagebox.ERROR);
							}
						}
					}
				});
	}

	@Command
	@NotifyChange({"allPoliticas", "cantRegistros" })
	public void filtro() throws Exception {
		List<Politica> tip = new ArrayList<Politica>();
		String desc = getDescFiltro().toLowerCase();

		for (Iterator<Politica> i = politicaDao.obtenerTodos().iterator(); i.hasNext();) {
			Politica tmp = i.next();
			if (tmp.getDescripcion().toLowerCase().contains(desc)) {
				tip.add(tmp);
			}
		}
		reglasAll = tip;
	}

	@GlobalCommand
	@NotifyChange({"allPoliticas", "cantRegistros" })
	public void refreshReglas() throws Exception {
		reglasAll = politicaDao.obtenerTodos();
	}


}
