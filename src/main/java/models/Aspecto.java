package models;

import java.util.HashSet;
import java.util.Set;

public class Aspecto {
	
	private int id;
	private String descripcion;

	//Coleccion de aspectoEventualidad.. relacion uno a muchos
	private Set<AspectosEventualidad> aspectos= new HashSet<AspectosEventualidad>();
	
	public Aspecto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aspecto(int id, String descripcion) {
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

	public Set<AspectosEventualidad> getAspectos() {
		return aspectos;
	}

	public void setAspectos(Set<AspectosEventualidad> aspectos) {
		this.aspectos = aspectos;
	}
}
