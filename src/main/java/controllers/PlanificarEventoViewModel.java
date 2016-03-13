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
import modelos.Actividad;
import modelos.Evento;

public class PlanificarEventoViewModel {

	private List<Evento> eventosAll;
	private EventoDao eventoDao;
	private String nombreFiltro;
	private ActividadDao actividadDao;
	private EstadoEventoDao estadoEventoDao;

	@Init
	public void init() throws Exception {

		eventosAll = new ArrayList<Evento>();
		eventoDao = new EventoDao();
		eventosAll = eventoDao.obtenerTodos();
		actividadDao = new ActividadDao();
		estadoEventoDao = new EstadoEventoDao();

	}

	public ListModelList<Evento> getAllEventos() {
		return new ListModelList<Evento>(eventosAll);
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
		
		if(actividad.getValorReal()!=null && actividad.getValorReal()>0){
			if(actividad.getFechaRealizacion()!=null && !actividad.getFechaRealizacion().after(actividad.getFechaTope())){
				actividad.setFinalizada(true);
				actividadDao.actualizarActividad(actividad);
				cambiarEstadoEvento(actividad.getEvento());
				Messagebox.show("Actividad " + actividad.getDescripcion() + " ha sido ejecutada exitosamente", "",
						Messagebox.OK, Messagebox.INFORMATION);
			}else Messagebox.show("Fecha de realizacion  o valor real no valido", "Warning", Messagebox.OK,
					Messagebox.EXCLAMATION);
			
		}else if(actividad.getValorReal()!=null && actividad.getValorReal()==0){
			actividad.setFechaRealizacion(null);
			actividad.setFinalizada(true);
			actividadDao.actualizarActividad(actividad);
			actividadDao.actualizarActividad(actividad);
			cambiarEstadoEvento(actividad.getEvento());
			Messagebox.show("Actividad " + actividad.getDescripcion() + " ha sido ejecutada exitosamente", "",
					Messagebox.OK, Messagebox.INFORMATION);
		}
	}
	
	public void cambiarEstadoEvento(Evento evento) throws Exception{
		evento.setEstadoEvento(estadoEventoDao.obtenerEstadoEvento(3));
		eventoDao.actualizarEvento(evento);
	}
}
