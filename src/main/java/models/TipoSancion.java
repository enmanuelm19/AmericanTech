package models;

import java.util.ArrayList;
import java.util.List;

public class TipoSancion {

	private int id;
	private String descripcion;

	//Coleccion de sanciones.. relacion uno a muchos
	private List<Sancion> sancions=new ArrayList<Sancion>();
	
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

	public List<Sancion> getSancions() {
		return sancions;
	}

	public void setSancions(List<Sancion> sancions) {
		this.sancions = sancions;
	}
}
