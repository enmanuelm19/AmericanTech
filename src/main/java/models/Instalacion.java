package models;

import java.util.ArrayList;
import java.util.List;

public class Instalacion {
	
	private int id;
	private String descripcion;
	private int capacidad;
	
	//coleccion de actividades.. relacion muchos a muchos
	private List<Actividad> actividades= new ArrayList<Actividad>();
	
	//coleccion de Recursos.. relacion muchos a muchos
	private List<Recurso> recursos= new ArrayList<Recurso>();
	
	//coleccion de Reservaciones.. relacion uno a muchos
	private List<Reservacion> reservaciones= new ArrayList<Reservacion>();
	
	//coleccion de Eventualidades.. relacion uno a muchos
	private List<Eventualidad> eventualidades= new ArrayList<Eventualidad>();
	
	//coleccion de Galeria.. relacion uno a muchos
	private List<Galeria> galerias= new ArrayList<Galeria>();
	
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

	public List<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}

	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}

	public List<Reservacion> getReservaciones() {
		return reservaciones;
	}

	public void setReservaciones(List<Reservacion> reservaciones) {
		this.reservaciones = reservaciones;
	}

	public List<Eventualidad> getEventualidades() {
		return eventualidades;
	}

	public void setEventualidades(List<Eventualidad> eventualidades) {
		this.eventualidades = eventualidades;
	}

	public List<Galeria> getGalerias() {
		return galerias;
	}

	public void setGalerias(List<Galeria> galerias) {
		this.galerias = galerias;
	}
}
