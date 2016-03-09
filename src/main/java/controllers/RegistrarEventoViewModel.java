package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
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
import Dao.EstadoEventoDao;
import Dao.EventoDao;
import Dao.IndicadorDao;
import Dao.InstalacionDao;
import Dao.InstalacionEventoDao;
import Dao.PreferenciaDao;
import Dao.ReservacionDao;
import Dao.TipoPreferenciaDao;
import modelos.Evento;
import modelos.Indicador;
import modelos.IndicadorEvento;
import modelos.Instalacion;
import modelos.InstalacionEvento;
import modelos.Preferencia;
import modelos.PreferenciaEvento;
import modelos.Reservacion;
import modelos.TipoPreferencia;

public class RegistrarEventoViewModel {

	private Evento evento;
	private boolean editable;
	private EventoDao eventoDao;
	private TipoPreferenciaDao tPreferenciaDao;
	private PreferenciaDao preferenciaDao;
	private InstalacionDao instalacionDao;
	private IndicadorDao indicadorDao;
	private EstadoEventoDao estadoEDao;
	private ReservacionDao reservacionDao;
	private InstalacionEventoDao instalacionEventoDao;
	private TipoPreferencia tipoPreferenciaSelected;
	private ArrayList<Preferencia> temporalPreferencia;
	private ArrayList<Instalacion> temporalInstalaciones;
	private IndicadorEvento indicadorEvento;
	private Set<PreferenciaEvento> listPreferenciaEvento;
	private Set<InstalacionEvento> listInstalacionEvento;
	private Set<IndicadorEvento> listIndicadorEvento;

	@Init
	public void init(@ExecutionArgParam("evento") Evento evento) {
		if (evento == null) {
			this.evento = new Evento();
			listPreferenciaEvento = new HashSet<PreferenciaEvento>();
			listInstalacionEvento = new HashSet<InstalacionEvento>();
			listIndicadorEvento = new HashSet<IndicadorEvento>();
			this.editable = false;
		} else {
			this.evento = evento;
			listPreferenciaEvento = evento.getPreferenciaEventos();
			listInstalacionEvento = evento.getInstalacionEventos();
			listIndicadorEvento = evento.getIndicadorEventos();
			this.editable = true;
		}
		eventoDao = new EventoDao();
		reservacionDao = new ReservacionDao();
		estadoEDao = new EstadoEventoDao();
		indicadorDao = new IndicadorDao();
		tPreferenciaDao = new TipoPreferenciaDao();
		preferenciaDao = new PreferenciaDao();
		instalacionDao = new InstalacionDao();
		temporalPreferencia = new ArrayList<Preferencia>();
		temporalInstalaciones = new ArrayList<Instalacion>();
		indicadorEvento = new IndicadorEvento();
		instalacionEventoDao = new InstalacionEventoDao();

	}

	@NotifyChange("preferenciasPorTipo")
	public TipoPreferencia getTipoPreferenciaSelected() {
		return tipoPreferenciaSelected;
	}

	@NotifyChange("preferenciasPorTipo")
	public void setTipoPreferenciaSelected(TipoPreferencia tipoPreferenciaSelected) {
		this.tipoPreferenciaSelected = tipoPreferenciaSelected;
	}

	public ArrayList<Preferencia> getTemporalPreferencia() {

		return temporalPreferencia;
	}

	public void setTemporalPreferencia(ArrayList<Preferencia> temporalPreferencia) {
		this.temporalPreferencia = temporalPreferencia;
	}

	public ArrayList<Instalacion> getTemporalInstalaciones() {
		return temporalInstalaciones;
	}

	public void setTemporalInstalaciones(ArrayList<Instalacion> temporalInstalaciones) {
		this.temporalInstalaciones = temporalInstalaciones;
	}

	public boolean isEditable() {
		return editable;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public IndicadorEvento getIndicadorEvento() {
		return indicadorEvento;
	}

	public void setIndicadorEvento(IndicadorEvento indicadorEvento) {
		this.indicadorEvento = indicadorEvento;
	}

	public ListModelList<TipoPreferencia> getAllTipoPreferencia() throws Exception {

		return new ListModelList<TipoPreferencia>(tPreferenciaDao.obtenerTodos());
	}

	public ListModelList<Indicador> getAllIndicadores() throws Exception {

		return new ListModelList<Indicador>(indicadorDao.obtenerTodos());
	}

	public ListModelList<PreferenciaEvento> getPreferenciasEventos() throws Exception {
		ArrayList<PreferenciaEvento> preferenciasMostrar = new ArrayList<PreferenciaEvento>();
		for(PreferenciaEvento preferenciaEvento: listPreferenciaEvento){
			if(preferenciaEvento.isActivo())
				preferenciasMostrar.add(preferenciaEvento);
		}
		return new ListModelList<PreferenciaEvento>(preferenciasMostrar);
	}

	public ListModelList<InstalacionEvento> getInstalacionesEventos() throws Exception {
		ArrayList<InstalacionEvento> instalacionesMostrar = new ArrayList<InstalacionEvento>();
		for(InstalacionEvento instalacionEvento: listInstalacionEvento){
			if(instalacionEvento.isActivo())
				instalacionesMostrar.add(instalacionEvento);
		}
		return new ListModelList<InstalacionEvento>(instalacionesMostrar);
	}

	public ListModelList<IndicadorEvento> getIndicadoresEventos() throws Exception {
		ArrayList<IndicadorEvento> indicadoresMostrar = new ArrayList<IndicadorEvento>();
		for(IndicadorEvento indicadorEvento: listIndicadorEvento){
			if(indicadorEvento.isActivo())
				indicadoresMostrar.add(indicadorEvento);
		}
		return new ListModelList<IndicadorEvento>(indicadoresMostrar);
	}

	public String getCantidadPreferencias() {
		return listPreferenciaEvento.size() + " items en la lista";
	}

	public String getCantidadInstalaciones() {
		return listInstalacionEvento.size() + " items en la lista";
	}

	public String getCantidadIndicadores() {
		return listIndicadorEvento.size() + " items en la lista";
	}

	public ListModelList<Preferencia> getPreferenciasPorTipo() throws Exception {
		if (tipoPreferenciaSelected != null) {
			return new ListModelList<Preferencia>(preferenciaDao.obtenerPreferenciasTipo(tipoPreferenciaSelected));
		}
		return new ListModelList<Preferencia>();
	}

	public ListModelList<Instalacion> getInstalaciones() throws Exception {

		return new ListModelList<Instalacion>(instalacionDao.obtenerTodos());

	}

	@Command
	@NotifyChange({ "preferenciasEventos", "cantidadPreferencias" })
	public void agregarPreferenciasEvento() {

		PreferenciaEvento preferenciaEvento;
		for (Preferencia preferencia : temporalPreferencia) {
			if (buscarPreferecia(preferencia) == null) {
				preferenciaEvento = new PreferenciaEvento();
				preferenciaEvento.setEvento(evento);
				preferenciaEvento.setActivo(true);
				preferenciaEvento.setPreferencia(preferencia);
				listPreferenciaEvento.add(preferenciaEvento);
			}
		}
	}

	@Command
	@NotifyChange({ "instalacionesEventos", "cantidadInstalaciones", "disabled" })
	public void agregarInstalacionesEvento() throws Exception {

		InstalacionEvento instalacionEvento;
		if (evento.getFechaInicio() != null && evento.getFechaFin() != null && evento.getFechaInicio().before(evento.getFechaFin()))
			for (Instalacion instalacion : temporalInstalaciones) {
				if (isDisponible(instalacion)) {
					if (buscarInstalacion(instalacion) == null) {
						instalacionEvento = new InstalacionEvento();
						instalacionEvento.setEvento(evento);
						instalacionEvento.setActivo(true);
						instalacionEvento.setInstalacion(instalacion);
						listInstalacionEvento.add(instalacionEvento);
					}
				} else
					Messagebox.show(
							instalacion.getNombre()
									+ " no se encuentra disponible en el rango de fecha selecionado",
							"Warning", Messagebox.OK, Messagebox.EXCLAMATION);
			}
		else
			Messagebox.show("Por favor indique rango de fechas del evento de forma correcta", "Warning", Messagebox.OK,
					Messagebox.EXCLAMATION);
	}

	public boolean isDisponible(Instalacion instalacion) throws Exception {

		// verificamos que no este reservada esa intalacion
		for (Reservacion reservacion : reservacionDao.obtenerReservacionesInstalacion(instalacion)) {

			if (isRango(reservacion.getFechaInicio(), reservacion.getFechaFin(), evento.getFechaInicio()))
				return false;
			if (isRango(reservacion.getFechaInicio(), reservacion.getFechaFin(), evento.getFechaFin()))
				return false;
			if (isRango(evento.getFechaInicio(), evento.getFechaFin(), reservacion.getFechaInicio()))
				return false;

		}

		// verificamos que no se vaya usar esa instalacion en un evento
		for (InstalacionEvento instalacionEvento : instalacionEventoDao.obtenerPorInstalacion(instalacion)) {
			System.out.println("entro por evento");
			if (isRango(instalacionEvento.getEvento().getFechaInicio(), instalacionEvento.getEvento().getFechaFin(),
					evento.getFechaInicio()))
				return false;
			if (isRango(instalacionEvento.getEvento().getFechaInicio(), instalacionEvento.getEvento().getFechaFin(),
					evento.getFechaFin()))
				return false;
			if (isRango(evento.getFechaInicio(), evento.getFechaFin(), instalacionEvento.getEvento().getFechaInicio()))
				return false;
		}

		return true;

	}

	public boolean isRango(Date a, Date b, Date d) {

		return a.compareTo(d) * d.compareTo(b) >= 0;
	}

	@Command
	@NotifyChange({ "indicadoresEventos", "indicadorEvento", "cantidadIndicadores" })
	public void agregarIndicadorEvento() {

		if (this.indicadorEvento.getIndicador() != null) {
			for (IndicadorEvento indicadorEvento : listIndicadorEvento) {
				if (indicadorEvento.getIndicador().getIdIndicador() == this.indicadorEvento.getIndicador()
						.getIdIndicador())
					return;
			}
			this.indicadorEvento.setEvento(evento);
			listIndicadorEvento.add(this.indicadorEvento);
			this.indicadorEvento = new IndicadorEvento();
		}
	}

	@Command
	@NotifyChange({ "preferenciasEventos", "cantidadPreferencias" })
	public void eliminarPreferenciaEvento(@BindingParam("preferenciaEvento") PreferenciaEvento p) {
		if(this.editable)
			p.setActivo(false);
		else listPreferenciaEvento.remove(p);
		
	}

	@Command
	@NotifyChange({ "instalacionesEventos", "cantidadInstalaciones" ,"disabled"})
	public void eliminarInstalacionEvento(@BindingParam("instalacionEvento") InstalacionEvento i) {
		if(this.editable)
			i.setActivo(false);
		else listInstalacionEvento.remove(i);
	}

	@Command
	@NotifyChange({ "indicadoresEventos", "indicadorEvento", "cantidadIndicadores" })
	public void eliminarIndicadorEvento(@BindingParam("indicadorEvento") IndicadorEvento in) {
		if(this.editable)
			in.setActivo(false);
		else listIndicadorEvento.remove(in);
	}

	public Preferencia buscarPreferecia(Preferencia preferencia) {
		for (PreferenciaEvento preferenciaEvento : listPreferenciaEvento) {
			if (preferenciaEvento.getPreferencia().getIdPreferencia() == preferencia.getIdPreferencia())
				return preferencia;
		}
		return null;
	}

	public Instalacion buscarInstalacion(Instalacion instalacion) {
		for (InstalacionEvento instalacionEvento : listInstalacionEvento) {
			if (instalacionEvento.getInstalacion().getIdInstalacion() == instalacion.getIdInstalacion())
				return instalacion;
		}
		return null;
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {

		if (!isCamposVacio()) {
			this.evento.setIndicadorEventos(this.listIndicadorEvento);
			this.evento.setPreferenciaEventos(this.listPreferenciaEvento);
			this.evento.setInstalacionEventos(this.listInstalacionEvento);
			this.evento.setEstadoEvento(estadoEDao.obtenerEstadoEvento(1));
			if (!editable){
				eventoDao.agregarEvento(evento);
				Messagebox.show(
						"El evento " + evento.getNombre()
								+ " ha sido registrado exitosamente", "",
						Messagebox.OK, Messagebox.INFORMATION);
			}

			else{
				eventoDao.actualizarEvento(evento);
				Messagebox.show(
						"El evento " + evento.getNombre()
								+ " ha sido actualizado exitosamente", "",
						Messagebox.OK, Messagebox.INFORMATION);
			}

			win.detach();
			BindUtils.postGlobalCommand(null, null, "refreshEventos", null);

		}
	}

	public boolean isCamposVacio() {
		if (evento.getNombre() != null && !evento.getNombre().equalsIgnoreCase("") && evento.getDescripcion() != null
				&& !evento.getDescripcion().equalsIgnoreCase("") && evento.getFechaInicio() != null
				&& evento.getFechaFin() != null && this.listIndicadorEvento.size() > 0
				&& this.listInstalacionEvento.size() > 0 && this.listPreferenciaEvento.size() > 0)
			return false;
		return true;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}
	
	public boolean isDisabled(){
		return this.listInstalacionEvento.size()>0;
	}
}
