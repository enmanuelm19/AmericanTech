package models;

import java.util.ArrayList;
import java.util.List;

public class Preferencia {
	
	private int id;
	private String descripcion;
	private TipoPreferencia tipoPreferenciaId;
	
	//coleccion de Personas.. relacion muchos a muchos
	private List<Persona> personas= new ArrayList<Persona>();
	
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

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	
}
