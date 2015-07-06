package models;

import java.util.HashSet;
import java.util.Set;

public class TipoSancion {

	private int id;
	private String descripcion;

	//Coleccion de sanciones.. relacion uno a muchos
	private Set<Sancion> sancions=new HashSet<Sancion>();
	
	public TipoSancion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoSancion(int id, String descripcion) {
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

	public Set<Sancion> getSancions() {
		return sancions;
	}

	public void setSancions(Set<Sancion> sancions) {
		this.sancions = sancions;
	}
}
