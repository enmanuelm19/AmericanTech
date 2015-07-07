package models;

import java.util.ArrayList;
import java.util.List;

public class Recurso {
	
	private int id;
	private String descripcion;
	
	//coleccion de Instalaciones.. relacion muchos a muchos
	private List<Instalacion> intInstalaciones=new ArrayList<Instalacion>();
	
	public Recurso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recurso(int id, String descripcion) {
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

	public List<Instalacion> getIntInstalaciones() {
		return intInstalaciones;
	}

	public void setIntInstalaciones(List<Instalacion> intInstalaciones) {
		this.intInstalaciones = intInstalaciones;
	}
}
