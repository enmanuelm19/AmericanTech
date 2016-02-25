package modelos;

// Generated 25/02/2016 12:54:56 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * ClienteExterno generated by hbm2java
 */
public class ClienteExterno implements java.io.Serializable {

	private int idCliente;
	private String nombre;
	private String apellido;
	private String correo;
	private boolean activo;
	private Set<Sugerencia> sugerencias = new HashSet<Sugerencia>(0);

	public ClienteExterno() {
	}

	public ClienteExterno(int idCliente, String nombre, String apellido,
			String correo, boolean activo) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.activo = activo;
	}

	public ClienteExterno(int idCliente, String nombre, String apellido,
			String correo, boolean activo, Set<Sugerencia> sugerencias) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.activo = activo;
		this.sugerencias = sugerencias;
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<Sugerencia> getSugerencias() {
		return this.sugerencias;
	}

	public void setSugerencias(Set<Sugerencia> sugerencias) {
		this.sugerencias = sugerencias;
	}

}
