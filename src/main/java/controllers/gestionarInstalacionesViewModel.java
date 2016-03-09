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

import Dao.InstalacionDao;
import Dao.RecursoInstalacionDao;
import modelos.Instalacion;
import modelos.RecursoInstalacion;



public class gestionarInstalacionesViewModel {
	
	private List<Instalacion> allinstalaciones;
	private InstalacionDao instalacionDao;
	private List<RecursoInstalacion> allrecursoinstalaciones;
	private RecursoInstalacionDao recursoInstalacionDao;
	private Instalacion instalacion;
	private RecursoInstalacion recursoInstalacion;
	private String descFiltro;
	private String idFiltro;
	private int id;
	//private String tipoPrefrenciaFiltro;

	@Init
	public void init() throws Exception {
		
		instalacion = new Instalacion();
		recursoInstalacion = new RecursoInstalacion();
		allinstalaciones = new ArrayList<Instalacion>();
		allrecursoinstalaciones = new ArrayList<RecursoInstalacion>();
		recursoInstalacionDao = new RecursoInstalacionDao();
		
		allrecursoinstalaciones = recursoInstalacionDao.obtenerTodos();
		instalacionDao = new InstalacionDao();
		allinstalaciones = instalacionDao.obtenerTodos();
		
	}

	public ListModelList<Instalacion> getAllInstalaciones() {

		return new ListModelList<Instalacion>(allinstalaciones);
	}
	public ListModelList<RecursoInstalacion> getAllRecursoInstalacion() {

		return new ListModelList<RecursoInstalacion>(allrecursoinstalaciones);
	}
	public Instalacion getInstalacion() {
		return instalacion;
	}

	public void setInstalacion(Instalacion instalacion) {
		this.instalacion = instalacion;
	}

	public String getCantInstalaciones() {
		return allinstalaciones.size() + " items en la lista";
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
	/*
	public String getTipoPrefrenciaFiltro() {
		if(tipoPrefrenciaFiltro==null)
			return "";
		return tipoPrefrenciaFiltro;
	}

	public void setTipoPrefrenciaFiltro(String tipoPrefrenciaFiltro) {
		this.tipoPrefrenciaFiltro = tipoPrefrenciaFiltro==null?"":tipoPrefrenciaFiltro.trim();
	}*/

	@Command
	@NotifyChange({ "allinstalaciones", "cantInstalaciones" })
	public void eliminar(@BindingParam("instalacion") final Instalacion instalaciones) {

		Messagebox.show("Estas seguro de eliminar " + instalacion.getDescripcion(), "Confirmar",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {
								instalacionDao.eliminarInstalacion(instalacion);
								allinstalaciones = instalacionDao.obtenerTodos();
								Messagebox.show(instalacion.getDescripcion() + " ha sido eliminado", "", Messagebox.OK,
										Messagebox.INFORMATION);
								BindUtils.postGlobalCommand(null, null, "refreshPreferencia", null);
							} catch (Exception e) {
								Messagebox.show(e.getMessage(), instalacion.getDescripcion() + " No se pudo eliminar",
										Messagebox.OK, Messagebox.ERROR);
							}
						}
					}
				});
	}
	/*
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
	*/
	@GlobalCommand
	@NotifyChange({ "allInstalaciones", "cantInstalaciones" })
	public void refreshInstalacion() throws Exception {
		allinstalaciones =   instalacionDao.obtenerTodos();
	}
	
	@Command
    public void showModalRegInst(Event e) {
        //create a window programmatically and use it as a modal dialog.
        Window window = (Window)Executions.createComponents(
                "configuracion/registrarInstalacion.zul", null, null);
        window.doModal();
    }
}
