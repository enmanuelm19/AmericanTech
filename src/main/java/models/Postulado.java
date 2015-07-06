package models;

import java.util.HashSet;
import java.util.Set;

public class Postulado {
	
	private int id;
	private Persona personaId;
	
	//Coleccion de postulaciones.. relacion uno a muchos
	private Set<Postulacion> postulacions= new HashSet<Postulacion>();
	
	public Postulado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Postulado(int id, Persona personaId) {
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

	public Set<Postulacion> getPostulacions() {
		return postulacions;
	}

	public void setPostulacions(Set<Postulacion> postulacions) {
		this.postulacions = postulacions;
	}
}
