package models;

import java.util.HashSet;
import java.util.Set;

public class TipoAfiliado {

	private int id;
	private String descripcion;

	//Coleccion de afiliados.. relacion uno a muchos
	private Set<Afiliado> afiliados= new HashSet<Afiliado>();
	
	public TipoAfiliado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoAfiliado(int id, String descripcion) {
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

	public Set<Afiliado> getAfiliados() {
		return afiliados;
	}

	public void setAfiliados(Set<Afiliado> afiliados) {
		this.afiliados = afiliados;
	}
}
