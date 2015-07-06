package models;

import java.util.HashSet;
import java.util.Set;

public class Grupo {
	
	private int id;
	private String descripcion;
	
	//coleccion de Usuarios.. relacion muchos a muchos
	private Set<Usuario> usuarios= new HashSet<Usuario>();
	
	//coleccion de Funciones.. relacion muchos a muchos
	private Set<Funcion> funciones= new HashSet<Funcion>();
	
	public Grupo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Grupo(int id, String descripcion) {
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

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Set<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(Set<Funcion> funciones) {
		this.funciones = funciones;
	}
}
