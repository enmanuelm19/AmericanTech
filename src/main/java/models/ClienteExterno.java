package models;

import java.util.ArrayList;
import java.util.List;

public class ClienteExterno {
	
	private int id;
	private String nombre;
	private String apellido;
	private String correo;
	
	//coleccion de Sugerencias.. relacion uno a muchos
	private List<Sugerencia> sugerencias= new ArrayList<Sugerencia>();
	
	public ClienteExterno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClienteExterno(int id, String nombre, String apellido, String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public List<Sugerencia> getSugerencias() {
		return sugerencias;
	}

	public void setSugerencias(List<Sugerencia> sugerencias) {
		this.sugerencias = sugerencias;
	}
}
