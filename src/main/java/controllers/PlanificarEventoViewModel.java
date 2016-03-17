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
	public void actualizarActividad(@BindingParam("actividad") Actividad actividad) throws Exception {

		if (actividad.getValorReal() != null && actividad.getValorReal() > 0) {
			if (actividad.getFechaRealizacion() != null
					&& !actividad.getFechaRealizacion().after(actividad.getFechaTope())) {
				actividad.setFinalizada(true);
				actividadDao.actualizarActividad(actividad);
				cambiarEstadoEventoAEjecucion(actividad.getEvento());
				Messagebox.show("Actividad " + actividad.getDescripcion() + " ha sido ejecutada exitosamente", "",
						Messagebox.OK, Messagebox.INFORMATION);
			} else
				Messagebox.show("Fecha de realizacion  o valor real no valido", "Warning", Messagebox.OK,
						Messagebox.EXCLAMATION);

		} else if (actividad.getValorReal() != null && actividad.getValorReal() == 0) {
			actividad.setFechaRealizacion(null);
			actividad.setFinalizada(true);
			actividadDao.actualizarActividad(actividad);
			actividadDao.actualizarActividad(actividad);
			cambiarEstadoEventoAEjecucion(actividad.getEvento());
			Messagebox.show("Actividad " + actividad.getDescripcion() + " ha sido ejecutada exitosamente", "",
					Messagebox.OK, Messagebox.INFORMATION);
		}
	}

	public void cambiarEstadoEventoAEjecucion(Evento evento) throws Exception {
		evento.setEstadoEvento(estadoEventoDao.obtenerEstadoEvento(3));
		eventoDao.actualizarEvento(evento);
	}

	@Command
	@NotifyChange({ "allEventos", "cantRegistros" })
	public void actualizarIndicador(@BindingParam("indicadorEvento") IndicadorEvento indicadorE) throws Exception {
		if (indicadorE.getValorReal() != null && indicadorE.getValorReal() >= 0) {
			indicadorEventoDao.actualizarIndicadorEvento(indicadorE);
			Messagebox.show(
					"Indicador " + indicadorE.getIndicador().getDescripcion() + " ha sido actualizado exitosamente", "",
					Messagebox.OK, Messagebox.INFORMATION);
			cambiarEstadoEventoAFinalizado(indicadorE.getEvento());
		} else
			Messagebox.show("Valor real no valido", "Warning", Messagebox.OK, Messagebox.EXCLAMATION);
	}

	public void cambiarEstadoEventoAFinalizado(Evento evento) throws Exception {

		for (IndicadorEvento indicadorE : evento.getIndicadorEventosActive())
			if (indicadorE.getVariacion().equals("-"))
				return;

		evento.setEstadoEvento(estadoEventoDao.obtenerEstadoEvento(4));
		eventoDao.actualizarEvento(evento);
		Messagebox.show("Evento " + evento.getNombre() + " ha sido Finalizado exitosamente", "", Messagebox.OK,
				Messagebox.INFORMATION);

	}

}
