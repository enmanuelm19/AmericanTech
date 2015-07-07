package models;

import java.util.ArrayList;
import java.util.List;

public class Funcion {
	
	private int id;
	private String nombre;
	private String url;
	
	//coleccion de Grupos.. relacion muchos a muchos
	private List<Grupo> grupos= new ArrayList<Grupo>();
	
	public Funcion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Funcion(int id, String nombre, String url) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
}
