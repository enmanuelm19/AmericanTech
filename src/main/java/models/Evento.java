package models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Evento {
	
	private int id;
	private String descripcion;
	private Date fecha;
	private Date hora;
	private EstadoEvento estadoEventoId;
	private SolicitudEvento solicitudId;
	private TipoEvento tipoEventoId;
	private TipoPublico tipoPublicoId;
	private int vistasEsperadas;
	
	//coleccion de Actividades.. relacion muchos a muchos;
	private Set<Actividad> actividades=new HashSet<Actividad>();
	
	//coleccion de Visitas.. relacion muchos a muchos;
	private Set<Visita> visitas=new HashSet<Visita>();
	
	//coleccion de Patrocinantes.. relacion muchos a muchos;
	private Set<Patrocinante> patrocinantes=new HashSet<Patrocinante>();
	
	//coleccion de Eventualidades. relacion uno a muchos.
	private Set<Eventualidad> eventualidades=new HashSet<Eventualidad>();
	
	//coleccion de Noticias. relacion uno a muchos.
	private Set<Noticia> noticias= new HashSet<Noticia>();
	
	//coleccion de CalendarioFecha. relacion uno a muchos.
	private Set<CalendarioFecha> calendarioFechas=new HashSet<CalendarioFecha>();
	
	public Evento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Evento(int id, String descripcion, Date fecha, Date hora,
			EstadoEvento estadoEventoId, SolicitudEvento solicitudId,
			TipoEvento tipoEventoId, TipoPublico tipoPublicoId,
			int vistasEsperadas) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.hora = hora;
		this.estadoEventoId = estadoEventoId;
		this.solicitudId = solicitudId;
		this.tipoEventoId = tipoEventoId;
		this.tipoPublicoId = tipoPublicoId;
		this.vistasEsperadas = vistasEsperadas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public EstadoEvento getEstadoEventoId() {
		return estadoEventoId;
	}

	public void setEstadoEventoId(EstadoEvento estadoEventoId) {
		this.estadoEventoId = estadoEventoId;
	}

	public SolicitudEvento getSolicitudId() {
		return solicitudId;
	}

	public void setSolicitudId(SolicitudEvento solicitudId) {
		this.solicitudId = solicitudId;
	}

	public TipoEvento getTipoEventoId() {
		return tipoEventoId;
	}

	public void setTipoEventoId(TipoEvento tipoEventoId) {
		this.tipoEventoId = tipoEventoId;
	}

	public TipoPublico getTipoPublicoId() {
		return tipoPublicoId;
	}

	public void setTipoPublicoId(TipoPublico tipoPublicoId) {
		this.tipoPublicoId = tipoPublicoId;
	}

	public int getVistasEsperadas() {
		return vistasEsperadas;
	}

	public void setVistasEsperadas(int vistasEsperadas) {
		this.vistasEsperadas = vistasEsperadas;
	}

	public Set<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(Set<Actividad> actividades) {
		this.actividades = actividades;
	}

	public Set<Visita> getVisitas() {
		return visitas;
	}

	public void setVisitas(Set<Visita> visitas) {
		this.visitas = visitas;
	}

	public Set<Patrocinante> getPatrocinantes() {
		return patrocinantes;
	}

	public void setPatrocinantes(Set<Patrocinante> patrocinantes) {
		this.patrocinantes = patrocinantes;
	}

	public Set<Eventualidad> getEventualidades() {
		return eventualidades;
	}

	public void setEventualidades(Set<Eventualidad> eventualidades) {
		this.eventualidades = eventualidades;
	}

	public Set<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(Set<Noticia> noticias) {
		this.noticias = noticias;
	}

	public Set<CalendarioFecha> getCalendarioFechas() {
		return calendarioFechas;
	}

	public void setCalendarioFechas(Set<CalendarioFecha> calendarioFechas) {
		this.calendarioFechas = calendarioFechas;
	}
	
}