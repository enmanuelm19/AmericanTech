package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;
import Dao.ActividadDao;
import Dao.EstadoEventoDao;
import Dao.EventoDao;
import Dao.TipoActividadDao;
import modelos.Actividad;
import modelos.Evento;
import modelos.TipoActividad;

public class RegistrarActividadViewModel {
	
	private Actividad actividad;
	private TipoActividadDao tipoActividadDao;
	private EventoDao eventoDao;
	private EstadoEventoDao estadoEDao;
	private ActividadDao actividadDao;
	private Set<Actividad> listActividads;
	private Evento evento;
	
	@Init
	public void init(@ExecutionArgParam("evento") Evento evento) {
		this.evento = evento;
		listActividads = evento.getActividads();
		eventoDao = new EventoDao();
		estadoEDao = new EstadoEventoDao();
		actividadDao = new ActividadDao();
		actividad = new Actividad();
		tipoActividadDao = new TipoActividadDao();
	}

	public Actividad getActividad() {
		return actividad;
	}
	
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public List<TipoActividad> getAllTipoActividad() throws Exception{
		return tipoActividadDao.obtenerTodos();
	}
	
	public ListModelList<Actividad> getActividadsEvento() throws Exception {
		ArrayList<Actividad> actividadsMostrar = new ArrayList<Actividad>();
		for(Actividad actividad: listActividads){
			if(actividad.isActivo())
				actividadsMostrar.add(actividad);
		}
		return new ListModelList<Actividad>(actividadsMostrar);
	}
	
	public String getCantidadActividads() throws Exception {
		
		return getActividadsEvento().size() + " items en la lista";
	}
	
	@Command
	@NotifyChange({ "actividadsEvento", "cantidadActividads", "actividad" })
	public void agregar() {
		if (isRango(evento.getFechaInicio(), evento.getFechaFin(), actividad.getFechaTope())) {
			if (actividad.getDescripcion() != null && !actividad.getDescripcion().equals("")
					&& actividad.getTipoActividad() != null && actividad.getValorEsperado() != null) {
				actividad.setEvento(evento);
				listActividads.add(actividad);
				actividad = new Actividad();
			}
		} else
			Messagebox.show("la fecha tope debe estar en el rango [" + evento.getFechaInicioString() + ","
					+ evento.getFechaFinString() + "]", "Warning", Messagebox.OK, Messagebox.EXCLAMATION);
	}
	
	public boolean isRango(Date a, Date b, Date d) {

		return a.compareTo(d) * d.compareTo(b) >= 0;
	}
	
	@Command
	@NotifyChange({ "actividadsEvento", "cantidadActividads" })
	public void eliminar(@BindingParam("actividad") Actividad act) throws Exception {
		
		System.out.println("voy a eliminar id "+act.getIdActividad());
		
		if(actividadDao.obtenerActividad(act.getIdActividad())==null)
			listActividads.remove(act);
		else act.setActivo(false);
	
	}
	
	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {

		if(listActividads.size()>0){
			
			if(getActividadsEvento().size()>0)
				this.evento.setEstadoEvento(estadoEDao.obtenerEstadoEvento(2));
			else this.evento.setEstadoEvento(estadoEDao.obtenerEstadoEvento(1));
			
			this.evento.setActividads(listActividads);
			System.out.println(evento.getActividads());
			eventoDao.actualizarEvento(evento);
			BindUtils.postGlobalCommand(null, null, "refreshEventos", null);
			Messagebox.show(
					"El evento " + evento.getNombre()
					+ " ha actualizado las actividades exitosamente", "",
					Messagebox.OK, Messagebox.INFORMATION);
			win.detach();
		}
	}
	
	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}
	
}
