package models;

import java.util.HashSet;
import java.util.Set;

public class Instalacion {
	
	private int id;
	private String descripcion;
	private int capacidad;
	
	//coleccion de actividades.. relacion muchos a muchos
	private Set<Actividad> actividades= new HashSet<Actividad>();
	
	//coleccion de Recursos.. relacion muchos a muchos
	private Set<Recurso> recursos= new HashSet<Recurso>();
	
	//coleccion de Reservaciones.. relacion uno a muchos
	private Set<Reservacion> reservaciones= new HashSet<Reservacion>();
	
	//coleccion de Eventualidades.. relacion uno a muchos
	private Set<Eventualidad> eventualidades= new HashSet<Eventualidad>();
	
	//coleccion de Galeria.. relacion uno a muchos
	private Set<Galeria> galerias= new HashSet<Galeria>();
	
	public Instalacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Instalacion(int id, String descripcion, int capacidad) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
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

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public Set<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(Set<Actividad> actividades) {
		this.actividades = actividades;
	}

	public Set<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(Set<Recurso> recursos) {
		this.recursos = recursos;
	}

	public Set<Reservacion> getReservaciones() {
		return reservaciones;
	}

	public void setReservaciones(Set<Reservacion> reservaciones) {
		this.reservaciones = reservaciones;
	}

	public Set<Eventualidad> getEventualidades() {
		return eventualidades;
	}

	public void setEventualidades(Set<Eventualidad> eventualidades) {
		this.eventualidades = eventualidades;
	}

	public Set<Galeria> getGalerias() {
		return galerias;
	}

	public void setGalerias(Set<Galeria> galerias) {
		this.galerias = galerias;
	}
}
