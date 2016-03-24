package modelos;

import java.text.SimpleDateFormat;

// Generated 05/03/2016 11:15:24 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Evento generated by hbm2java
 */
public class Evento implements java.io.Serializable {

	private int idEvento;
	private CancelacionEvento cancelacionEvento;
	private EstadoEvento estadoEvento;
	private String nombre;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private boolean publico;
	private boolean activo;
	private Set<Noticia> noticias = new HashSet<Noticia>(0);
	private Set<PreferenciaEvento> preferenciaEventos = new HashSet<PreferenciaEvento>(
			0);
	private Set<Actividad> actividads = new HashSet<Actividad>(0);
	private Set<InstalacionEvento> instalacionEventos = new HashSet<InstalacionEvento>(
			0);
	private Set<IndicadorEvento> indicadorEventos = new HashSet<IndicadorEvento>(
			0);
	private Set<CalendarioFecha> calendarioFechas = new HashSet<CalendarioFecha>(
			0);

	public Evento() {
	}

	public Evento(int idEvento, EstadoEvento estadoEvento, String nombre,
			String descripcion, Date fechaInicio, Date fechaFin,
			boolean publico, boolean activo) {
		this.idEvento = idEvento;
		this.estadoEvento = estadoEvento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.publico = publico;
		this.activo = activo;
	}

	public Evento(int idEvento, CancelacionEvento cancelacionEvento,
			EstadoEvento estadoEvento, String nombre, String descripcion,
			Date fechaInicio, Date fechaFin, boolean publico, boolean activo,
			Set<Noticia> noticias, Set<PreferenciaEvento> preferenciaEventos,
			Set<Actividad> actividads,
			Set<InstalacionEvento> instalacionEventos,
			Set<IndicadorEvento> indicadorEventos,
			Set<CalendarioFecha> calendarioFechas) {
		this.idEvento = idEvento;
		this.cancelacionEvento = cancelacionEvento;
		this.estadoEvento = estadoEvento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.publico = publico;
		this.activo = activo;
		this.noticias = noticias;
		this.preferenciaEventos = preferenciaEventos;
		this.actividads = actividads;
		this.instalacionEventos = instalacionEventos;
		this.indicadorEventos = indicadorEventos;
		this.calendarioFechas = calendarioFechas;
	}

	public int getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public CancelacionEvento getCancelacionEvento() {
		return this.cancelacionEvento;
	}

	public void setCancelacionEvento(CancelacionEvento cancelacionEvento) {
		this.cancelacionEvento = cancelacionEvento;
	}

	public EstadoEvento getEstadoEvento() {
		return this.estadoEvento;
	}

	public void setEstadoEvento(EstadoEvento estadoEvento) {
		this.estadoEvento = estadoEvento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public boolean isPublico() {
		return this.publico;
	}

	public void setPublico(boolean publico) {
		this.publico = publico;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<Noticia> getNoticias() {
		return this.noticias;
	}

	public void setNoticias(Set<Noticia> noticias) {
		this.noticias = noticias;
	}

	public Set<PreferenciaEvento> getPreferenciaEventos() {
		return this.preferenciaEventos;
	}

	public void setPreferenciaEventos(Set<PreferenciaEvento> preferenciaEventos) {
		this.preferenciaEventos = preferenciaEventos;
	}

	public Set<Actividad> getActividads() {
		return this.actividads;
	}

	public void setActividads(Set<Actividad> actividads) {
		this.actividads = actividads;
	}

	public Set<InstalacionEvento> getInstalacionEventos() {
		return this.instalacionEventos;
	}

	public void setInstalacionEventos(Set<InstalacionEvento> instalacionEventos) {
		this.instalacionEventos = instalacionEventos;
	}

	public Set<IndicadorEvento> getIndicadorEventos() {
		return this.indicadorEventos;
	}

	public void setIndicadorEventos(Set<IndicadorEvento> indicadorEventos) {
		this.indicadorEventos = indicadorEventos;
	}

	public Set<CalendarioFecha> getCalendarioFechas() {
		return this.calendarioFechas;
	}

	public void setCalendarioFechas(Set<CalendarioFecha> calendarioFechas) {
		this.calendarioFechas = calendarioFechas;
	}
	
	//Metodos Extra para el evento
	
	public String getHoraString(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		return dateFormat.format(fechaInicio)+"-"+dateFormat.format(fechaFin);
	}
	
	public String getFechaInicioString(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(fechaInicio);
	}
	
	public String getFechaFinString(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(fechaFin);
	}
	
	public boolean isVisible(){
		if(this.estadoEvento.getIdEstadoEvento()!=5 && this.estadoEvento.getIdEstadoEvento()!=4)
			return true;		
		return false;
	}
	
	public Set<InstalacionEvento> getInstalacionEventosActive() {
		Set<InstalacionEvento> temp = new HashSet<InstalacionEvento>(0);
		for(InstalacionEvento instalacionE: instalacionEventos)
			if(instalacionE.isActivo())
				temp.add(instalacionE);
		return temp;
	}
	
	public Set<IndicadorEvento> getIndicadorEventosActive() {
		Set<IndicadorEvento> temp = new HashSet<IndicadorEvento>(0);
		for(IndicadorEvento indicadorE: indicadorEventos)
			if(indicadorE.isActivo())
				temp.add(indicadorE);
		return temp;
	}
	
	public Set<Actividad> getActividadsActive() {
		Set<Actividad> temp = new HashSet<Actividad>(0);
		for(Actividad actividad: actividads)
			if(actividad.isActivo())
				temp.add(actividad);
		return temp;
	}
	
	public Set<PreferenciaEvento> getPreferenciaEventosActive() {
		Set<PreferenciaEvento> temp = new HashSet<PreferenciaEvento>(0);
		for(PreferenciaEvento preferenciaE: preferenciaEventos)
			if(preferenciaE.isActivo())
				temp.add(preferenciaE);
		return temp;
	}

}
