package models;

import java.util.ArrayList;
import java.util.List;

public class TipoEvento {

	private int id;
	private String descripcion;
	private String estatus;
	
	private String descFiltro;
	private String idFiltro;
	//Coleccion de Eventos. relacion uno a muchos
	private List<Evento> eventos= new ArrayList<Evento>();
	
	public TipoEvento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoEvento(int id, String descripcion,String status) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.estatus=status;
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
	
	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	public void setDescFiltro(String descFiltro) {
		this.descFiltro = descFiltro==null?"":descFiltro.trim();
	}
	//funcion get para el atributo a filtrar.
	public String getDescFiltro() {
		return descFiltro;
	}

	public String getIdFiltro() {
		return idFiltro;
	}

	public void setIdFiltro(String idFiltro) {
		this.idFiltro = idFiltro==null?"":idFiltro.trim();
	}
	
}
