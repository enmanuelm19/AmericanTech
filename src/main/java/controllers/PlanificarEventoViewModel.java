package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.ActividadDao;
import Dao.EstadoEventoDao;
import Dao.EventoDao;
import Dao.IndicadorEventoDao;
import modelos.Actividad;
import modelos.Evento;
import modelos.Indicador;
import modelos.IndicadorEvento;

public class PlanificarEventoViewModel {

	private List<Evento> eventosAll;
	private List<Evento>  eventosEyF;
	private List<Evento> eventosPorPlanificar;
	private List<Evento> eventosListoEjecutar;
	private List<Evento> eventosEjecucion;
	private EventoDao eventoDao;
	private String nombreFiltro;
	private ActividadDao actividadDao;
	private IndicadorEventoDao indicadorEventoDao;
	private EstadoEventoDao estadoEventoDao;

	@Init
	public void init() throws Exception {

		eventosAll = new ArrayList<Evento>();
		eventosEyF = new ArrayList<Evento>();
		eventoDao = new EventoDao();
		estadoEventoDao = new EstadoEventoDao();
		actividadDao = new ActividadDao();
		indicadorEventoDao = new IndicadorEventoDao();

		eventosPorPlanificar = eventoDao.obtenerPorEstado(estadoEventoDao.obtenerEstadoEvento(1));
		eventosListoEjecutar = eventoDao.obtenerPorEstado(estadoEventoDao.obtenerEstadoEvento(2));
		eventosEjecucion = eventoDao.obtenerPorEstado(estadoEventoDao.obtenerEstadoEvento(3));

		eventosAll.addAll(eventosPorPlanificar);
		eventosAll.addAll(eventosListoEjecutar);
		eventosAll.addAll(eventosEjecucion);
		
		eventosEyF.addAll(eventosListoEjecutar);
		eventosEyF.addAll(eventosEjecucion);
		

	}

	public ListModelList<Evento> getAllEventos() {
		return new ListModelList<Evento>(eventosAll);
	}
	
	public ListModelList<Evento> getAllEventosEyF() {
		
		return new ListModelList<Evento>(eventosEyF);
	}

	public String getCantRegistros() {
		return eventosAll.size() + " items en la lista";
	}

	public String getNombreFiltro() {
		if (nombreFiltro == null)
			return "";
		return nombreFiltro;
	}

	public void setNombreFiltro(String nombreFiltro) {
		this.nombreFiltro = nombreFiltro == null ? "" : nombreFiltro.trim();
	}

	@Command
	public void showModal(@BindingParam("evento") Evento evento) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("evento", evento);
		Window window = (Window) Executions.createComponents("evento/administrarEvento/registrarActividades.zul", null,
				args);
		window.doModal();
	}

	@Command
	@NotifyChange({ "allEventos", "cantRegistros" })
	public void filtro() throws Exception {
		List<Evento> evento = new ArrayList<Evento>();
		String nomb = getNombreFiltro().toLowerCase();

		for (Iterator<Evento> i = eventoDao.obtenerTodos().iterator(); i.hasNext();) {
			Evento tmp = i.next();
			if (tmp.getNombre().toLowerCase().contains(nomb)) {
				evento.add(tmp);
			}
		}
		eventosAll = evento;
	}

	@GlobalCommand
	@NotifyChange({ "allEventos", "cantRegistros" })
	public void refreshEventos() throws Exception {
		eventosAll = eventoDao.obtenerTodos();
	}

	@Command
	@NotifyChange({ "allEventosEyF", "cantRegistros" })
	public void actualizarActividads(@BindingParam("evento") Evento evento) throws Exception {

		boolean listo = true;
		boolean algunaFinalizada = false;
		
		for(Actividad actividad: evento.getActividadsActive()){
			if(actividad.getFechaRealizacion()!=null || actividad.getValorReal()!=null){
				if(actividad.getFechaRealizacion()==null || actividad.getFechaRealizacion().after(actividad.getFechaTope())){
					Messagebox.show("Fecha no valida de la actividad: "+actividad.getDescripcion(), "Warning", Messagebox.OK, Messagebox.EXCLAMATION);
					listo = false;
					break;
				}
				else if(actividad.getValorReal()==null){
					Messagebox.show("valor real no valido de la actividad: "+actividad.getDescripcion(), "Warning", Messagebox.OK, Messagebox.EXCLAMATION);
					listo = false;
					break;
					
				}else{
					algunaFinalizada = true;
					actividad.setFinalizada(true);
				}
				
			}else actividad.setFinalizada(false);
		}
		
		if(listo && algunaFinalizada){
			evento.setEstadoEvento(estadoEventoDao.obtenerEstadoEvento(2));
			eventoDao.actualizarEvento(evento);
			Messagebox.show(
					"actividades del evento: "+evento.getNombre()+" ha sido actualizado exitosamente", "",
					Messagebox.OK, Messagebox.INFORMATION);
		}
		
		if(listo && !algunaFinalizada){
			evento.setEstadoEvento(estadoEventoDao.obtenerEstadoEvento(3));
			eventoDao.actualizarEvento(evento);
			Messagebox.show(
					"actividades del evento: "+evento.getNombre()+" ha sido actualizado exitosamente", "",
					Messagebox.OK, Messagebox.INFORMATION);
		}
		
	
	}

	

	@Command
	@NotifyChange({ "allEventosEyF", "cantRegistros" })
	public void actualizarIndicadores(@BindingParam("evento") Evento evento) throws Exception {
		
		boolean todasFinalizada = true;
		for(IndicadorEvento indicadorEvento: evento.getIndicadorEventosActive()){
			if(indicadorEvento.getValorReal()==null)
				todasFinalizada = false;
		}
		
		if(todasFinalizada){
			evento.setEstadoEvento(estadoEventoDao.obtenerEstadoEvento(4));
			
		}
		eventoDao.actualizarEvento(evento);
		Messagebox.show(
				"indicadores del evento: "+evento.getNombre()+" ha sido actualizado exitosamente", "",
				Messagebox.OK, Messagebox.INFORMATION);
		
	}


}
