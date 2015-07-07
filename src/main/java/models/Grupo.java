package models;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
	
	private int id;
	private String descripcion;
	
	//Atributo descFiltro para Filtrar
	private String descFiltro="";
	
	//coleccion de Usuarios.. relacion muchos a muchos
	private List<Usuario> usuarios= new ArrayList<Usuario>();
	
	//coleccion de Funciones.. relacion muchos a muchos
	private List<Funcion> funciones= new ArrayList<Funcion>();
	
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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(List<Funcion> funciones) {
		this.funciones = funciones;
	}
	
	//funcion set para el atributo a filtrar.
	public void setDescFiltro(String descFiltro) {
		this.descFiltro = descFiltro==null?"":descFiltro.trim();
	}
	//funcion get para el atributo a filtrar.
	public String getDescFiltro() {
		return descFiltro;
	}

}
