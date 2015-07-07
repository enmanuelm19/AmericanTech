package models;

import java.util.ArrayList;
import java.util.List;

public class TipoActividad {

	private int id;
	private String descripcion;
	
	//Coleccion de Actividades.. relacion uno a muchos
	private List<Actividad> actividads=new ArrayList<Actividad>();

	
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

	public List<Actividad> getActividads() {
		return actividads;
	}

	public void setActividads(List<Actividad> actividads) {
		this.actividads = actividads;
	}
	
}
