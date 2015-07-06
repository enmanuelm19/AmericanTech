package models;

import java.util.HashSet;
import java.util.Set;

public class TipoActividad {

	private int id;
	private String descripcion;
	
	//Coleccion de Actividades.. relacion uno a muchos
	private Set<Actividad> actividads=new HashSet<Actividad>();

	
	public TipoActividad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoActividad(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
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

	public Set<Actividad> getActividads() {
		return actividads;
	}

	public void setActividads(Set<Actividad> actividads) {
		this.actividads = actividads;
	}
	
}
