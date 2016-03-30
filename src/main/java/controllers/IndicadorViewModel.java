package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import modelos.Indicador;

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

import Dao.IndicadorDao;

public class IndicadorViewModel {

	private List<Indicador> indicadorAll;
	private IndicadorDao indicadorDao;
	private String descFiltro;
	private String idFiltro;

	@Init
	public void init() throws Exception {
		
		indicadorAll = new ArrayList<Indicador>();
		indicadorDao = new IndicadorDao();
		indicadorAll = indicadorDao.obtenerTodos();
	}

	public ListModelList<Indicador> getAllIndicador() {

		return new ListModelList<Indicador>(indicadorAll);
	}

	public String getCantRegistros() {
		return indicadorAll.size() + " items en la lista";
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
	public void showModal(@BindingParam("indicador") Indicador indicador) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("indicador", indicador);
		Window window = (Window) Executions.createComponents("configuracion/categoria/registrarIndicador.zul",
				null, args);
		window.doModal();
	}

	@Command
	@NotifyChange({ "allIndicador", "cantRegistros" })
	public void eliminar(@BindingParam("indicador") final Indicador indicador) {

		Messagebox.show("Estas seguro de eliminar " + indicador.getDescripcion(), "American Tech",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {
								indicadorDao.eliminarIndicador(indicador);
								indicadorAll = indicadorDao.obtenerTodos();
								Messagebox.show(indicador.getDescripcion() + " ha sido eliminado", "American Tech", Messagebox.OK,
										Messagebox.INFORMATION);
								BindUtils.postGlobalCommand(null, null, "refreshIndicador", null);
							} catch (Exception e) {
								Messagebox.show(e.getMessage(), indicador.getDescripcion() + " American Tech",
										Messagebox.OK, Messagebox.ERROR);
							}
						}
					}
				});
	}

	@Command
	@NotifyChange({ "allIndicador", "cantRegistros" })
	public void filtro() throws Exception {
		List<Indicador> tip = new ArrayList<Indicador>();
		String desc = getDescFiltro().toLowerCase();
		String id = getIdFiltro().toLowerCase();

		for (Iterator<Indicador> i = indicadorDao.obtenerTodos().iterator(); i.hasNext();) {
			Indicador tmp = i.next();
			if (tmp.getDescripcion().toLowerCase().contains(desc)
					&& String.valueOf(tmp.getIdIndicador()).toLowerCase().contains(id)) {
				tip.add(tmp);
			}
		}
		indicadorAll = tip;
	}

	@GlobalCommand
	@NotifyChange({ "allIndicador", "cantRegistros" })
	public void refreshIndicador() throws Exception {
		indicadorAll = indicadorDao.obtenerTodos();
	}
}

