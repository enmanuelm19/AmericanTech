package controllers;

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
import Dao.PreferenciaDao;
import modelos.Preferencia;

public class PreferenciaViewModel {
	
	private List<Preferencia> preferenciaAll;
	private PreferenciaDao preferenciaDao;
	private String descFiltro;
	private String idFiltro;
	private String tipoPrefrenciaFiltro;

	@Init
	public void init() throws Exception {
		
		preferenciaAll = new ArrayList<Preferencia>();
		preferenciaDao = new PreferenciaDao();
		preferenciaAll = preferenciaDao.obtenerTodos();
	}

	public ListModelList<Preferencia> getAllPreferencia() {

		return new ListModelList<Preferencia>(preferenciaAll);
	}

	public String getCantRegistros() {
		return preferenciaAll.size() + " items en la lista";
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

	public String getTipoPrefrenciaFiltro() {
		if(tipoPrefrenciaFiltro==null)
			return "";
		return tipoPrefrenciaFiltro;
	}

	public void setTipoPrefrenciaFiltro(String tipoPrefrenciaFiltro) {
		this.tipoPrefrenciaFiltro = tipoPrefrenciaFiltro==null?"":tipoPrefrenciaFiltro.trim();
	}

	@Command
	public void showModal(@BindingParam("preferencia") Preferencia preferencia) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("preferencia", preferencia);
		Window window = (Window) Executions.createComponents("configuracion/categoria/registrarPreferencia.zul",
				null, args);
		window.doModal();
	}

	@Command
	@NotifyChange({ "allPreferencia", "cantRegistros" })
	public void eliminar(@BindingParam("preferencia") final Preferencia preferencia) {

		Messagebox.show("Estas seguro de eliminar " + preferencia.getDescripcion(), "American Tech",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {
								preferenciaDao.eliminarPreferencia(preferencia);
								preferenciaAll = preferenciaDao.obtenerTodos();
								Messagebox.show(preferencia.getDescripcion() + " ha sido eliminado", "American Tech", Messagebox.OK,
										Messagebox.INFORMATION);
								BindUtils.postGlobalCommand(null, null, "refreshPreferencia", null);
							} catch (Exception e) {
								Messagebox.show(e.getMessage(), preferencia.getDescripcion() + " American Tech", 
										Messagebox.OK, Messagebox.ERROR);
							}
						}
					}
				});
	}

	@Command
	@NotifyChange({ "allPreferencia", "cantRegistros" })
	public void filtro() throws Exception {
		List<Preferencia> pref = new ArrayList<Preferencia>();
		String desc = getDescFiltro().toLowerCase();
		String id = getIdFiltro().toLowerCase();
		String descTipo = getTipoPrefrenciaFiltro().toLowerCase();

		for (Iterator<Preferencia> i = preferenciaDao.obtenerTodos().iterator(); i.hasNext();) {
			Preferencia tmp = i.next();
			if (tmp.getDescripcion().toLowerCase().contains(desc) && tmp.getTipoPreferencia().getDescripcion().toLowerCase().contains(descTipo)
					&& String.valueOf(tmp.getIdPreferencia()).toLowerCase().contains(id)) {
				pref.add(tmp);
			}
		}
		preferenciaAll = pref;
	}

	@GlobalCommand
	@NotifyChange({ "allPreferencia", "cantRegistros" })
	public void refreshPreferencia() throws Exception {
		preferenciaAll = preferenciaDao.obtenerTodos();
	}

}
