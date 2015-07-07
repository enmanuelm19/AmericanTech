package models;

import java.util.ArrayList;
import java.util.List;

public class Proveedor {
	private int id;
	private Persona personaId;
	
	//coleccion de Alquileres.. relacion muchos a muchos
	private List<Alquiler> alquileres=new ArrayList<Alquiler>();
	
	//coleccion de Actividades.. relacion muchos a muchos
	private List<Actividad> actividades= new ArrayList<Actividad>();
	
	public Proveedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Proveedor(int id, Persona personaId) {
		super();
		this.id = id;
		this.personaId = personaId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Persona getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Persona personaId) {
		this.personaId = personaId;
	}

	public List<Alquiler> getAlquileres() {
		return alquileres;
	}

	public void setAlquileres(List<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}

	public List<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}
	
}
