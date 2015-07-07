package models;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

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
	private List<Actividad> actividades=new ArrayList<Actividad>();
	
	//coleccion de Visitas.. relacion muchos a muchos;
	private List<Visita> visitas=new ArrayList<Visita>();
	
	//coleccion de Patrocinantes.. relacion muchos a muchos;
	private List<Patrocinante> patrocinantes=new ArrayList<Patrocinante>();
	
	//coleccion de Eventualidades. relacion uno a muchos.
	private List<Eventualidad> eventualidades=new ArrayList<Eventualidad>();
	
	//coleccion de Noticias. relacion uno a muchos.
	private List<Noticia> noticias= new ArrayList<Noticia>();
	
	//coleccion de CalendarioFecha. relacion uno a muchos.
	private List<CalendarioFecha> calendarioFechas=new ArrayList<CalendarioFecha>();
	
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

	public void Id(int id) {
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

	public List<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}

	public List<Visita> getVisitas() {
		return visitas;
	}

	public void setVisitas(List<Visita> visitas) {
		this.visitas = visitas;
	}

	public List<Patrocinante> getPatrocinantes() {
		return patrocinantes;
	}

	public void setPatrocinantes(List<Patrocinante> patrocinantes) {
		this.patrocinantes = patrocinantes;
	}

	public List<Eventualidad> getEventualidades() {
		return eventualidades;
	}

	public void setEventualidades(List<Eventualidad> eventualidades) {
		this.eventualidades = eventualidades;
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	public List<CalendarioFecha> getCalendarioFechas() {
		return calendarioFechas;
	}

	public void setCalendarioFechas(List<CalendarioFecha> calendarioFechas) {
		this.calendarioFechas = calendarioFechas;
	}
	
}