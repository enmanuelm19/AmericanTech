package models;

import java.util.ArrayList;
import java.util.List;

public class Exonerado {
	
	private int id;
	private String personalIdentificacion;
	private byte[] personalFoto;
	private Persona personaId;
	
	//coleccion de Sanciones.. relacion uno a muchos
	private List<Sancion> sanciones=new ArrayList<Sancion>();
	
	public Exonerado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Exonerado(int id, String personalIdentificacion,
			byte[] personalFoto, Persona personaId) {
		super();
		this.id = id;
		this.personalIdentificacion = personalIdentificacion;
		this.personalFoto = personalFoto;
		this.personaId = personaId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPersonalIdentificacion() {
		return personalIdentificacion;
	}

	public void setPersonalIdentificacion(String personalIdentificacion) {
		this.personalIdentificacion = personalIdentificacion;
	}

	public byte[] getPersonalFoto() {
		return personalFoto;
	}

	public void setPersonalFoto(byte[] personalFoto) {
		this.personalFoto = personalFoto;
	}

	public Persona getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Persona personaId) {
		this.personaId = personaId;
	}

	public List<Sancion> getSanciones() {
		return sanciones;
	}

	public void setSanciones(List<Sancion> sanciones) {
		this.sanciones = sanciones;
	}
}
