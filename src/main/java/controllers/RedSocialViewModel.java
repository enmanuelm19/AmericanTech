package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import modelos.RedSocial;


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

import Dao.RedSocialDao;


public class RedSocialViewModel {

	private List<RedSocial> redesAll;
	private RedSocialDao redDao;
	private String descFiltro;
	private String idFiltro;

	@Init
	public void init() throws Exception {
		
		redesAll = new ArrayList<RedSocial>();
		redDao = new RedSocialDao();
		redesAll = redDao.obtenerTodos();
	}

	public ListModelList<RedSocial> getAllRedSocial() {

		return new ListModelList<RedSocial>(redesAll);
	}

	public String getCantRegistros() {
		return redesAll.size() + " items en la lista";
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
	public void showModal(@BindingParam("Red") RedSocial red) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("RedSocial", red);
		Window window = (Window) Executions.createComponents("configuracion/categoria/registrarRedSocial.zul",
				null, args);
		window.doModal();
	}

	@Command
	@NotifyChange({ "allRedSocial", "cantRegistros" })
	public void eliminar(@BindingParam("Red") final RedSocial red) {

		Messagebox.show("Estas seguro de eliminar " + red.getDescripcion(), "American Tech",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {
								redDao.eliminarRedSocial(red);
								redesAll = redDao.obtenerTodos();
								Messagebox.show(red.getDescripcion() + " ha sido eliminado", "American Tech", Messagebox.OK,
										Messagebox.INFORMATION);
								BindUtils.postGlobalCommand(null, null, "refreshRedSocial", null);
							} catch (Exception e) {
								Messagebox.show(e.getMessage(), red.getDescripcion() + " American Tech",
										Messagebox.OK, Messagebox.ERROR);
							}
						}
					}
				});
	}

	@Command
	@NotifyChange({ "allRedSocial", "cantRegistros" })
	public void filtro() throws Exception {
		List<RedSocial> reds = new ArrayList<RedSocial>();
		String desc = getDescFiltro().toLowerCase();
		String id = getIdFiltro().toLowerCase();

		for (Iterator<RedSocial> i = redDao.obtenerTodos().iterator(); i.hasNext();) {
			RedSocial tmp = i.next();
			if (tmp.getDescripcion().toLowerCase().contains(desc)
					&& String.valueOf(tmp.getIdRedSocial()).toLowerCase().contains(id)) {
				reds.add(tmp);
			}
		}
		redesAll = reds;
	}

	@GlobalCommand
	@NotifyChange({ "allRedSocial", "cantRegistros" })
	public void refreshRedSocial() throws Exception {
		redesAll = redDao.obtenerTodos();
	}
}

