package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import modelos.MotivoCancelacion;

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

import Dao.MotivoCancelacionDao;

public class MotivoCancelacionViewModel {

	private List<MotivoCancelacion> tiposAll;
	private MotivoCancelacionDao tipoDao;
	private String descFiltro;
	private String idFiltro;

	@Init
	public void init() throws Exception {
		
		tiposAll = new ArrayList<MotivoCancelacion>();
		tipoDao = new MotivoCancelacionDao();
		tiposAll = tipoDao.obtenerTodos();
	}

	public ListModelList<MotivoCancelacion> getAllMotivoCancelacion() {

		return new ListModelList<MotivoCancelacion>(tiposAll);
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
	public void showModal(@BindingParam("Tipo") MotivoCancelacion tipo) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("MotivoCancelacion", tipo);
		Window window = (Window) Executions.createComponents("configuracion/categoria/registrarMotivoCancelacion.zul",
				null, args);
		window.doModal();
	}

	@Command
	@NotifyChange({ "allMotivoCancelacion", "cantRegistros" })
	public void eliminar(@BindingParam("Tipo") final MotivoCancelacion tipo) {

		Messagebox.show("Estas seguro de eliminar " + tipo.getDescripcion(), "Confirmar",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {
								tipoDao.eliminarMotivoCancelacion(tipo);
								tiposAll = tipoDao.obtenerTodos();
								Messagebox.show(tipo.getDescripcion() + " ha sido eliminado", "", Messagebox.OK,
										Messagebox.INFORMATION);
								BindUtils.postGlobalCommand(null, null, "refreshMotivoCancelacion", null);
							} catch (Exception e) {
								Messagebox.show(e.getMessage(), tipo.getDescripcion() + " No se pudo eliminar",
										Messagebox.OK, Messagebox.ERROR);
							}
						}
					}
				});
	}

	@Command
	@NotifyChange({ "allMotivoCancelacion", "cantRegistros" })
	public void filtro() throws Exception {
		List<MotivoCancelacion> tip = new ArrayList<MotivoCancelacion>();
		String desc = getDescFiltro().toLowerCase();
		String id = getIdFiltro().toLowerCase();

		for (Iterator<MotivoCancelacion> i = tipoDao.obtenerTodos().iterator(); i.hasNext();) {
			MotivoCancelacion tmp = i.next();
			if (tmp.getDescripcion().toLowerCase().contains(desc)
					&& String.valueOf(tmp.getIdMotivoCancelacion()).toLowerCase().contains(id)) {
				tip.add(tmp);
			}
		}
		tiposAll = tip;
	}

	@GlobalCommand
	@NotifyChange({ "allMotivoCancelacion", "cantRegistros" })
	public void refreshMotivoCancelacion() throws Exception {
		tiposAll = tipoDao.obtenerTodos();
	}
}




