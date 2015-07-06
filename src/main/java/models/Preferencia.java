package models;

import java.util.HashSet;
import java.util.Set;

public class Preferencia {
	
	private int id;
	private String descripcion;
	private TipoPreferencia tipoPreferenciaId;
	
	//coleccion de Personas.. relacion muchos a muchos
	private Set<Persona> personas= new HashSet<Persona>();
	
	public Preferencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Preferencia(int id, String descripcion,
			TipoPreferencia tipoPreferenciaId) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.tipoPreferenciaId = tipoPreferenciaId;
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

	public TipoPreferencia getTipoPreferenciaId() {
		return tipoPreferenciaId;
	}

	public void setTipoPreferenciaId(TipoPreferencia tipoPreferenciaId) {
		this.tipoPreferenciaId = tipoPreferenciaId;
	}

	public Set<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}
	
}
