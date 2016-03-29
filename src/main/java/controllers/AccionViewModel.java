package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import modelos.EstadoAccion;
import modelos.Preferencia;
import modelos.TipoSugerencia;
import modelos.Accion;
import models.Grupo;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.AccionDao;
import Dao.EstadoAccionDao;
import Dao.TipoSugerenciaDao;

public class AccionViewModel {
	
	 	private AccionDao accionDAO= new AccionDao();
		private List<Accion> listaAcciones;
		private String propietarioFiltro;
		private String apellidoFiltro;
		private String condicionFiltro;
		private String nroAccionFiltro;
		
		@Init
		public void init() throws Exception {
			listaAcciones = accionDAO.obtenerTodos();
		}
	
	    @Command
	    public void showModal(@BindingParam("Accion") Accion accion) {
	    	Map<String, Object> args = new HashMap<String, Object>();
	    	args.put("accion", accion);
	    	Window window = (Window)Executions.createComponents("socio/registrarAccion.zul", null, args);
	        window.doModal();
	    }
	 
	    @Command
	    public void showModal1(Event e) {
	        //create a window programmatically and use it as a modal dialog.
	        Window window = (Window)Executions.createComponents(
	                "desvincularAccion.zul", null, null);
	        window.doModal();
	    }
	    @Command
	    public void showModal2(Event e) {
	        //create a window programmatically and use it as a modal dialog.
	        Window window = (Window)Executions.createComponents(
	                "desvincularAccion.zul", null, null);
	        window.doModal();
	    }
	    @Command
	    public void showModal3(Event e) {
	        //create a window programmatically and use it as a modal dialog.
	        Window window = (Window)Executions.createComponents(
	                "desvincularAccion.zul", null, null);
	        window.doModal();
	    }
	    
	public ListModelList<Accion> getAccionesAll() {
		 return new ListModelList<Accion>(listaAcciones);
	}
	public String getCantidadRegistros(){
		return listaAcciones.size() + " items en la lista";
	}

	@Command
	@NotifyChange({ "accionesAll", "cantidadRegistros" })
	public void eliminar(@BindingParam("Accion") final Accion accion) {
		Messagebox.show("Estas seguro de eliminar la accion " + accion.getNroAccion(), "American Tech",
		Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
			public void onEvent(Event evt) throws InterruptedException {
				if (evt.getName().equals("onOK")) {
					try {
						accionDAO.eliminarAccion(accion);
						listaAcciones = accionDAO.obtenerTodos();
						Messagebox.show("La Accion " +accion.getNroAccion()+ " ha sido eliminada", "American Tech", Messagebox.OK, Messagebox.INFORMATION);
						BindUtils.postGlobalCommand(null, null, "refreshAcciones", null);
					} catch (Exception e) {
						Messagebox.show(e.getMessage(), "La Acci�n "+accion.getNroAccion() + " no se pudo eliminar", Messagebox.OK, Messagebox.ERROR);
					}
				}
			}
		});
	}
	@GlobalCommand
	@NotifyChange({ "accionesAll", "cantidadRegistros" })
	public void refreshAcciones() throws Exception{
		listaAcciones=accionDAO.obtenerTodos();
	}

	public String getPropietarioFiltro() {
		if(propietarioFiltro==null)
			return "";
		return propietarioFiltro;
	}

	public void setPropietarioFiltro(String propietarioFiltro) {
		this.propietarioFiltro = propietarioFiltro==null?"":propietarioFiltro.trim();
	}

	public String getCondicionFiltro() {
		if(condicionFiltro==null)
			return "";
		return condicionFiltro;
	}

	public void setCondicionFiltro(String condicionFiltro) {
		this.condicionFiltro = condicionFiltro==null?"":condicionFiltro.trim();
	}
	public String getApellidoFiltro() {
		if(apellidoFiltro==null)
			return "";
		return apellidoFiltro;
	}

	public void setApellidoFiltro(String apellidoFiltro) {
		this.apellidoFiltro = apellidoFiltro==null?"":apellidoFiltro.trim();
	}
	public String getNroAccionFiltro() {
		if(nroAccionFiltro==null)
			return "";
		return nroAccionFiltro;
	}

	public void setNroAccionFiltro(String nroAccionFiltro) {
		this. nroAccionFiltro =  nroAccionFiltro==null?"": nroAccionFiltro.trim();
	}
	@Command
	@NotifyChange({ "accionesAll", "cantidadRegistros" })
	public void filtro() throws Exception {
		List<Accion> tip = new ArrayList<Accion>();
		String prop = getPropietarioFiltro().toLowerCase();
		String apell = getApellidoFiltro().toLowerCase();
		String condicion = getCondicionFiltro().toLowerCase();
		String nro= getNroAccionFiltro().toLowerCase();
		for (Iterator<Accion> i = accionDAO.obtenerTodos().iterator(); i.hasNext();) {
			Accion tmp = i.next();
			try{
				
				if (tmp.getSocio().getPersona().getNombre().toLowerCase().contains(prop) &&
					tmp.getSocio().getPersona().getApellido().toLowerCase().contains(apell)
					&& tmp.getEstadoAccion().getNombre().toLowerCase().contains(condicion) && tmp.getNroAccion().toLowerCase().contains(nro)) {
						tip.add(tmp);
			}
			} catch (NullPointerException e) {
				if(tmp.getEstadoAccion().getNombre().toLowerCase().contains(condicion)) {
					tip.add(tmp);
				}
			}
		}
		this.listaAcciones = tip;
	}
}
