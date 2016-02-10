package models;

import java.util.ArrayList;
import java.util.List;

public class Proveedor {
	private int id;
	private String nombre;
	private String direccion;
	private String telefono;
	private String correo;
	
	//coleccion de Alquileres.. relacion muchos a muchos
	private List<Alquiler> alquileres=new ArrayList<Alquiler>();
	
	//coleccion de Actividades.. relacion muchos a muchos
	private List<Actividad> actividades= new ArrayList<Actividad>();
	
	public Proveedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Proveedor(int id, String nombre, String direccion, String telefono, String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public List<Alquiler> getAlquileres() {
		return alquileres;
	}

	public void setAlquileres(List<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}

	public List<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}
	
}
