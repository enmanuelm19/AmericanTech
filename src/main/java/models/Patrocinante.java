package models;

import java.util.ArrayList;
import java.util.List;

public class Patrocinante {
	
	private int id;
	private Persona personaId;
	
	//Coleccion de eventos.. relacion muchos a muchos
	private List<Evento> eventos= new ArrayList<Evento>();
	
	
	public Patrocinante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patrocinante(int id, Persona personaId) {
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

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
}
