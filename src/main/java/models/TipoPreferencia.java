package models;

import java.util.ArrayList;
import java.util.List;

public class TipoPreferencia {
	
	private int id;
	private String descripcion;
	
	//Coleccion de preferencias.. relacion uno a muchos
	private List<Preferencia> preferencias= new ArrayList<Preferencia>();
	
	public TipoPreferencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoPreferencia(int id, String descripcion) {
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

	public List<Preferencia> getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(List<Preferencia> preferencias) {
		this.preferencias = preferencias;
	}
}
