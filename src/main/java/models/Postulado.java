package models;

import java.util.ArrayList;
import java.util.List;

public class Postulado {
	
	private int id;
	private Persona personaId;
	
	//Coleccion de postulaciones.. relacion uno a muchos
	private List<Postulacion> postulacions= new ArrayList<Postulacion>();
	
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

	public List<Postulacion> getPostulacions() {
		return postulacions;
	}

	public void setPostulacions(List<Postulacion> postulacions) {
		this.postulacions = postulacions;
	}
}
