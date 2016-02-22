package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import modelos.MotivoDesvinculacion;

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

import Dao.MotivoDesvinculacionDao;

public class MotivoDesvinculacionViewModel {

	private List<MotivoDesvinculacion> tiposAll;
	private MotivoDesvinculacionDao tipoDao;
	private String descFiltro;
	private String idFiltro;

	@Init
	public void init() throws Exception {
		
		tiposAll = new ArrayList<MotivoDesvinculacion>();
		tipoDao = new MotivoDesvinculacionDao();
		tiposAll = tipoDao.obtenerTodos();
	}

	public ListModelList<MotivoDesvinculacion> getAllMotivoDesvinculacion() {

		return new ListModelList<MotivoDesvinculacion>(tiposAll);
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
	public void showModal(@BindingParam("Tipo") MotivoDesvinculacion tipo) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("MotivoDesvinculacion", tipo);
		Window window = (Window) Executions.createComponents("configuracion/categoria/registrarTipoDesvinculacion.zul",
				null, args);
		window.doModal();
	}

	@Command
	@NotifyChange({ "allMotivoDesvinculacion", "cantRegistros" })
	public void eliminar(@BindingParam("Tipo") final MotivoDesvinculacion tipo) {

		Messagebox.show("Estas seguro de eliminar " + tipo.getDescripcion(), "Confirmar",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {
								tipoDao.eliminarMotivoDesvinculacion(tipo);
								tiposAll = tipoDao.obtenerTodos();
								Messagebox.show(tipo.getDescripcion() + " ha sido eliminado", "", Messagebox.OK,
										Messagebox.INFORMATION);
								BindUtils.postGlobalCommand(null, null, "refreshMotivoDesvinculacion", null);
							} catch (Exception e) {
								Messagebox.show(e.getMessage(), tipo.getDescripcion() + " No se pudo eliminar",
										Messagebox.OK, Messagebox.ERROR);
							}
						}
					}
				});
	}

	@Command
	@NotifyChange({ "allMotivoDesvinculacion", "cantRegistros" })
	public void filtro() throws Exception {
		List<MotivoDesvinculacion> tip = new ArrayList<MotivoDesvinculacion>();
		String desc = getDescFiltro().toLowerCase();
		String id = getIdFiltro().toLowerCase();

		for (Iterator<MotivoDesvinculacion> i = tipoDao.obtenerTodos().iterator(); i.hasNext();) {
			MotivoDesvinculacion tmp = i.next();
			if (tmp.getDescripcion().toLowerCase().contains(desc)
					&& String.valueOf(tmp.getIdMotivoDesvinculacion()).toLowerCase().contains(id)) {
				tip.add(tmp);
			}
		}
		tiposAll = tip;
	}

	@GlobalCommand
	@NotifyChange({ "allMotivoDesvinculacion", "cantRegistros" })
	public void refreshMotivoDesvinculacion() throws Exception {
		tiposAll = tipoDao.obtenerTodos();
	}
}



