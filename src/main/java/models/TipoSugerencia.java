package models;

import java.util.ArrayList;
import java.util.List;

public class TipoSugerencia {
	
	private int id;
	private String descripcion;

	//Coleccion de sugerencias.. relacion uno a muchos
	private List<Sugerencia> sugerencias= new ArrayList<Sugerencia>();
	
	public TipoSugerencia() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TipoSugerencia(int id, String descripcion) {
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

	public List<Sugerencia> getSugerencias() {
		return sugerencias;
	}

	public void setSugerencias(List<Sugerencia> sugerencias) {
		this.sugerencias = sugerencias;
	}
}
