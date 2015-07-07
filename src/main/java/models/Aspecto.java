package models;

import java.util.ArrayList;
import java.util.List;

public class Aspecto {
	
	private int id;
	private String descripcion;

	//Coleccion de aspectoEventualidad.. relacion uno a muchos
	private List<AspectosEventualidad> aspectos= new ArrayList<AspectosEventualidad>();
	
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

	public List<AspectosEventualidad> getAspectos() {
		return aspectos;
	}

	public void setAspectos(List<AspectosEventualidad> aspectos) {
		this.aspectos = aspectos;
	}
}
