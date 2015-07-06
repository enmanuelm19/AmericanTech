package models;

import java.util.HashSet;
import java.util.Set;

public class Socio {
	
	private int id;
	private String nroCarnet;
	private Persona personaId;
	
	//Coleccion de Acciones que puede tener un Socio. Relacion Uno a muchos;
	private Set<Accion> acciones=new HashSet<Accion>();
	
	//Coleccion de Afiliados que puede tener un Socio. Relacion uno a muchos;
	private Set<Afiliado> afiliados= new HashSet<Afiliado>();
	
	//Coleccion de Sanciones que puede tener un Socio. Relacion Uno a muchos;
	private Set<Sancion> sanciones= new HashSet<Sancion>();
	
	//Coleccion de Visitas que puede tener un Socio. Relacion Uno a muchos;
	private Set<Visita> visitas=new HashSet<Visita>();
	
	//Coleccion de Reservaciones que puede tener un Socio. Relacion Uno a muchos;
	private Set<Reservacion> reservaciones=new HashSet<Reservacion>();
	
	//Coleccion de SolicitudEvento que puede tener un Socio. Relacion Uno a muchos;
	private Set<SolicitudEvento> solicitudEventos=new HashSet<SolicitudEvento>();

	//coleccion de Desvinculaciones.. relacion uno a muchos
	private Set<Desvinculacion> desvinculaciones=new HashSet<Desvinculacion>();
	
	public Socio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Socio(int id, String nroCarnet, Persona personaId) {
		super();
		this.id = id;
		this.nroCarnet = nroCarnet;
		this.personaId = personaId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNroCarnet() {
		return nroCarnet;
	}

	public void setNroCarnet(String nroCarnet) {
		this.nroCarnet = nroCarnet;
	}

	public Persona getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Persona personaId) {
		this.personaId = personaId;
	}

	public Set<Accion> getAcciones() {
		return acciones;
	}

	public void setAcciones(Set<Accion> acciones) {
		this.acciones = acciones;
	}

	public Set<Afiliado> getAfiliados() {
		return afiliados;
	}

	public void setAfiliados(Set<Afiliado> afiliados) {
		this.afiliados = afiliados;
	}

	public Set<Sancion> getSanciones() {
		return sanciones;
	}

	public void setSanciones(Set<Sancion> sanciones) {
		this.sanciones = sanciones;
	}

	public Set<Visita> getVisitas() {
		return visitas;
	}

	public void setVisitas(Set<Visita> visitas) {
		this.visitas = visitas;
	}

	public Set<Reservacion> getReservaciones() {
		return reservaciones;
	}

	public void setReservaciones(Set<Reservacion> reservaciones) {
		this.reservaciones = reservaciones;
	}

	public Set<SolicitudEvento> getSolicitudEventos() {
		return solicitudEventos;
	}

	public void setSolicitudEventos(Set<SolicitudEvento> solicitudEventos) {
		this.solicitudEventos = solicitudEventos;
	}

	public Set<Desvinculacion> getDesvinculaciones() {
		return desvinculaciones;
	}

	public void setDesvinculaciones(Set<Desvinculacion> desvinculaciones) {
		this.desvinculaciones = desvinculaciones;
	}
	
}
