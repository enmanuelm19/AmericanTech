package models;

import java.util.ArrayList;
import java.util.List;

public class EstadoAccion {
	
	private int id;
	private String descripcion;

	//Coleccion de acciones.. relacion uno a muchos
	private List<Accion> accions= new ArrayList<Accion>();
	
	public EstadoAccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EstadoAccion(int id, String descripcion) {
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

	public List<Accion> getAccions() {
		return accions;
	}

	public void setAccions(List<Accion> accions) {
		this.accions = accions;
	}
}
