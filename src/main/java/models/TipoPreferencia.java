package models;

import java.util.HashSet;
import java.util.Set;

public class TipoPreferencia {
	
	private int id;
	private String descripcion;
	
	//Coleccion de preferencias.. relacion uno a muchos
	private Set<Preferencia> preferencias= new HashSet<Preferencia>();
	
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

	public Set<Preferencia> getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(Set<Preferencia> preferencias) {
		this.preferencias = preferencias;
	}
}
