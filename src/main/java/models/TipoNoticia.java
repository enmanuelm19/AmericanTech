package models;

import java.util.HashSet;
import java.util.Set;

public class TipoNoticia {

	private int id;
	private String descripcion;
	
	//Coleccion de noticias.. relacion uno a muchos
	private Set<Noticia> noticias=new HashSet<Noticia>();
	
	public TipoNoticia() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TipoNoticia(int id, String descripcion) {
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

	public Set<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(Set<Noticia> noticias) {
		this.noticias = noticias;
	}
	
}
