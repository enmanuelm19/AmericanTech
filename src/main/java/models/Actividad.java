package models;

import java.util.ArrayList;
import java.util.List;

public class Actividad {
	
	private int id;
	private String descripcion;
	private String condicion;
	private String disponibilidad;
	private TipoActividad tipoActividadId;
	
	//Coleccion de Eventos.. Relacion muchos a muchos;
	private List<Evento> eventos=new ArrayList<Evento>();
	
	//coleccion de Instalciones.. relacion muchos a muchos:
	private List<Instalacion> instalaciones=new ArrayList<Instalacion>();
	
	//coleccion de Proveedores.. relacion muchos a muchos
	private List<Proveedor> proveedores=new ArrayList<Proveedor>();
	
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

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public List<Instalacion> getInstalaciones() {
		return instalaciones;
	}

	public void setInstalaciones(List<Instalacion> instalaciones) {
		this.instalaciones = instalaciones;
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
}
