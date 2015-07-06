package models;

import java.util.HashSet;
import java.util.Set;

public class MotivoDesvinculacion {
	
	private int id;
	private String descripcion;

	//Coleccion de desvinculaciones.. relacion uno a muchos
	private Set<Desvinculacion> desvinculacions= new HashSet<Desvinculacion>();
	
	public MotivoDesvinculacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MotivoDesvinculacion(int id, String descripcion) {
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

	public Set<Desvinculacion> getDesvinculacions() {
		return desvinculacions;
	}

	public void setDesvinculacions(Set<Desvinculacion> desvinculacions) {
		this.desvinculacions = desvinculacions;
	}	
}
