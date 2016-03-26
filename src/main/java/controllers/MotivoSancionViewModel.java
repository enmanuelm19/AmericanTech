package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import modelos.MotivoSancion;

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

import Dao.MotivoSancionDao;

public class MotivoSancionViewModel {

	private List<MotivoSancion>  motivosAll;
	private MotivoSancionDao motivoSancionDao;
	private String descFiltro;
	private String idFiltro;

	@Init
	public void init() throws Exception {
		
		motivosAll = new ArrayList<MotivoSancion>();
		motivoSancionDao = new MotivoSancionDao();
		motivosAll = motivoSancionDao.obtenerTodos();
	}

	public ListModelList<MotivoSancion> getAllMotivoSancion() {

		return new ListModelList<MotivoSancion>(motivosAll);
	}

	public String getCantRegistros() {
		return motivosAll.size() + " items en la lista";
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
	public void showModal(@BindingParam("Motivo") MotivoSancion motivo) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("MotivoSancion", motivo);
		Window window = (Window) Executions.createComponents("configuracion/categoria/registrarMotivoSancion.zul",
				null, args);
		window.doModal();
	}

	@Command
	@NotifyChange({ "allMotivoSancion", "cantRegistros" })
	public void eliminar(@BindingParam("Motivo") final MotivoSancion motivo) {

		Messagebox.show("Estas seguro de eliminar " + motivo.getDescripcion(), "American Tech",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {
								motivoSancionDao.eliminarMotivoSancion(motivo);
								motivosAll = motivoSancionDao.obtenerTodos();
								Messagebox.show(motivo.getDescripcion() + " ha sido eliminado", "American Tech", Messagebox.OK,
										Messagebox.INFORMATION);
								BindUtils.postGlobalCommand(null, null, "refreshMotivoSancion", null);
							} catch (Exception e) {
								Messagebox.show(e.getMessage(), motivo.getDescripcion() + "American Tech",
										Messagebox.OK, Messagebox.ERROR);
							}
						}
					}
				});
	}

	@Command
	@NotifyChange({ "allMotivoSancion", "cantRegistros" })
	public void filtro() throws Exception {
		List<MotivoSancion> tip = new ArrayList<MotivoSancion>();
		String desc = getDescFiltro().toLowerCase();
		String id = getIdFiltro().toLowerCase();

		for (Iterator<MotivoSancion> i = motivoSancionDao.obtenerTodos().iterator(); i.hasNext();) {
			MotivoSancion tmp = i.next();
			if (tmp.getDescripcion().toLowerCase().contains(desc)
					&& String.valueOf(tmp.getIdMotivoSancion()).toLowerCase().contains(id)) {
				tip.add(tmp);
			}
		}
		motivosAll = tip;
	}

	@GlobalCommand
	@NotifyChange({ "allMotivoSancion", "cantRegistros" })
	public void refreshMotivoSancion() throws Exception {
		motivosAll = motivoSancionDao.obtenerTodos();
	}
}




