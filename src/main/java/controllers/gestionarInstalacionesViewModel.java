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

import Dao.FotoDao;
import Dao.InstalacionDao;
import Dao.RecursoInstalacionDao;
import modelos.Accion;
import modelos.Foto;
import modelos.Instalacion;
import modelos.RecursoInstalacion;
import modelos.TipoInstalacion;



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
	private List<Foto> listFotos;
	private FotoDao fotosInstDao;
	private String nombreFiltro;
	private String tipoFiltro;
	

	@Init
	public void init() throws Exception {
		
		instalacion = new Instalacion();
		recursoInstalacion = new RecursoInstalacion();
		allinstalaciones = new ArrayList<Instalacion>();
		allrecursoinstalaciones = new ArrayList<RecursoInstalacion>();
		recursoInstalacionDao = new RecursoInstalacionDao();
		listFotos = new ArrayList<Foto>();
		fotosInstDao = new FotoDao();
		//listFotos = fotosInstDao.obtenerFotoinstalacion(instalacion);
		
		instalacionDao = new InstalacionDao();
		allinstalaciones = instalacionDao.obtenerTodos();
		allrecursoinstalaciones = recursoInstalacionDao.obtenerTodos();
	}

	public ListModelList<Instalacion> getAllInstalaciones() {

		return new ListModelList<Instalacion>(allinstalaciones);
	}
	public ListModelList<RecursoInstalacion> getAllRecursoInstalacion(Instalacion i) {
		
		return new ListModelList<RecursoInstalacion>(i.getRecursoInstalacions());
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
//	public String getPropietarioFiltro() {
//		if(propietarioFiltro==null)
//			return "";
//		return propietarioFiltro;
//	}
//
//	public void setPropietarioFiltro(String propietarioFiltro) {
//		this.propietarioFiltro = propietarioFiltro==null?"":propietarioFiltro.trim();
//	}
	@Command
	public void showModalRegInst(@BindingParam("instalacion") Instalacion instalacion) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("instalacion", instalacion);
		Window window = (Window) Executions.createComponents("configuracion/registrarInstalacion.zul",
				null, args);
		window.doModal();
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

	public String getNombreFiltro() {
		if(nombreFiltro==null)
			return "";
		return nombreFiltro;
	}

	public void setNombreFiltro(String nombreFiltro) {
		this.nombreFiltro = nombreFiltro==null?"":nombreFiltro.trim();
	}
	
	public String getTipoFiltro() {
		if(tipoFiltro==null)
			return "";
		return tipoFiltro;
	}

	public void setTipoFiltro(String tipoFiltro) {
		this.tipoFiltro = tipoFiltro==null?"":tipoFiltro.trim();
	}
	
	@Command
	@NotifyChange({ "allInstalaciones", "cantInstalaciones" })
	public void filtro() throws Exception {
		List<Instalacion> tip = new ArrayList<Instalacion>();
		String nom = getNombreFiltro().toLowerCase();
		String tipo = getTipoFiltro().toLowerCase();
		//System.out.println("condicion "+condicion);
		for (Iterator<Instalacion> i = instalacionDao.obtenerTodos().iterator(); i.hasNext();) {
			Instalacion tmp = i.next();
			
				System.out.println("Instalacion "+tmp.getNombre());
				
				if (tmp.getNombre().toLowerCase().contains(nom) && tmp.getTipoInstalacion().getDescripcion().toLowerCase().contains(tipo)) {
						tip.add(tmp);
			}
			
		}
		this.allinstalaciones = tip;
	}
	
	@Command
	@NotifyChange({ "allinstalaciones", "cantInstalaciones" })
	public void eliminar(@BindingParam("instalacion") final Instalacion instalacion) {

		Messagebox.show("Estas seguro de eliminar " + instalacion.getNombre(), "Confirmar",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {
								instalacionDao.eliminarInstalacion(instalacion);
								allinstalaciones = instalacionDao.obtenerTodos();
								Messagebox.show(instalacion.getDescripcion() + " ha sido eliminado", "", Messagebox.OK,
										Messagebox.INFORMATION);
								BindUtils.postGlobalCommand(null, null, "refreshInstalacion", null);
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
	


}

