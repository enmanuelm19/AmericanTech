package models;

import java.util.ArrayList;
import java.util.List;

public class Socio {
	
	private int id;
	private String nroCarnet;
	private Persona personaId;
	
	//Coleccion de Acciones que puede tener un Socio. Relacion Uno a muchos;
	private List<Accion> acciones=new ArrayList<Accion>();
	
	//Coleccion de Afiliados que puede tener un Socio. Relacion uno a muchos;
	private List<Afiliado> afiliados= new ArrayList<Afiliado>();
	
	//Coleccion de Sanciones que puede tener un Socio. Relacion Uno a muchos;
	private List<Sancion> sanciones= new ArrayList<Sancion>();
	
	//Coleccion de Visitas que puede tener un Socio. Relacion Uno a muchos;
	private List<Visita> visitas=new ArrayList<Visita>();
	
	//Coleccion de Reservaciones que puede tener un Socio. Relacion Uno a muchos;
	private List<Reservacion> reservaciones=new ArrayList<Reservacion>();
	
	//Coleccion de SolicitudEvento que puede tener un Socio. Relacion Uno a muchos;
	private List<SolicitudEvento> solicitudEventos=new ArrayList<SolicitudEvento>();

	//coleccion de Desvinculaciones.. relacion uno a muchos
	private List<Desvinculacion> desvinculaciones=new ArrayList<Desvinculacion>();
	
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

	public List<Accion> getAcciones() {
		return acciones;
	}

	public void setAcciones(List<Accion> acciones) {
		this.acciones = acciones;
	}

	public List<Afiliado> getAfiliados() {
		return afiliados;
	}

	public void setAfiliados(List<Afiliado> afiliados) {
		this.afiliados = afiliados;
	}

	public List<Sancion> getSanciones() {
		return sanciones;
	}

	public void setSanciones(List<Sancion> sanciones) {
		this.sanciones = sanciones;
	}

	public List<Visita> getVisitas() {
		return visitas;
	}

	public void setVisitas(List<Visita> visitas) {
		this.visitas = visitas;
	}

	public List<Reservacion> getReservaciones() {
		return reservaciones;
	}

	public void setReservaciones(List<Reservacion> reservaciones) {
		this.reservaciones = reservaciones;
	}

	public List<SolicitudEvento> getSolicitudEventos() {
		return solicitudEventos;
	}

	public void setSolicitudEventos(List<SolicitudEvento> solicitudEventos) {
		this.solicitudEventos = solicitudEventos;
	}

	public List<Desvinculacion> getDesvinculaciones() {
		return desvinculaciones;
	}

	public void setDesvinculaciones(List<Desvinculacion> desvinculaciones) {
		this.desvinculaciones = desvinculaciones;
	}
	
}
