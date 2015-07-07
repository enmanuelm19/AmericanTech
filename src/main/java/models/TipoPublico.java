package models;

import java.util.ArrayList;
import java.util.List;

public class TipoPublico {

	private int id;
	private String descripcion;

	//Coleccion de eventos.. relacion uno a muchos
	private List<Evento> eventos= new ArrayList<Evento>();
	
	public TipoPublico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoPublico(int id, String descripcion) {
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

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
}
