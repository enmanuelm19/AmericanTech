package models;

import java.util.ArrayList;
import java.util.List;

public class TipoNoticia {

	private int id;
	private String descripcion;
	
	//Coleccion de noticias.. relacion uno a muchos
	private List<Noticia> noticias=new ArrayList<Noticia>();
	
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

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}
	
}
