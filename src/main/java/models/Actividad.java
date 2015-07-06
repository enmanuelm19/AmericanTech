package models;

import java.util.HashSet;
import java.util.Set;

public class Actividad {
	
	private int id;
	private String descripcion;
	private String condicion;
	private String disponibilidad;
	private TipoActividad tipoActividadId;
	
	//Coleccion de Eventos.. Relacion muchos a muchos;
	private Set<Evento> eventos=new HashSet<Evento>();
	
	//coleccion de Instalciones.. relacion muchos a muchos:
	private Set<Instalacion> instalaciones=new HashSet<Instalacion>();
	
	//coleccion de Proveedores.. relacion muchos a muchos
	private Set<Proveedor> proveedores=new HashSet<Proveedor>();
	
	public Actividad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Actividad(int id, String descripcion, String condicion,
			String disponibilidad, TipoActividad tipoActividadId) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.condicion = condicion;
		this.disponibilidad = disponibilidad;
		this.tipoActividadId = tipoActividadId;
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

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public TipoActividad getTipoActividadId() {
		return tipoActividadId;
	}

	public void setTipoActividadId(TipoActividad tipoActividadId) {
		this.tipoActividadId = tipoActividadId;
	}

	public Set<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}

	public Set<Instalacion> getInstalaciones() {
		return instalaciones;
	}

	public void setInstalaciones(Set<Instalacion> instalaciones) {
		this.instalaciones = instalaciones;
	}

	public Set<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(Set<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
}
