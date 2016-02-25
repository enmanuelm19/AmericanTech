package modelos;

// Generated 25/02/2016 01:23:37 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Proveedor generated by hbm2java
 */
public class Proveedor implements java.io.Serializable {

	private int idProveedor;
	private String nombre;
	private String direccion;
	private String telefono;
	private String correo;
	private boolean activo;
	private Set<ProveedorActividad> proveedorActividads = new HashSet<ProveedorActividad>(
			0);

	public Proveedor() {
	}

	public Proveedor(int idProveedor, String nombre, String direccion,
			String telefono, String correo, boolean activo) {
		this.idProveedor = idProveedor;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.activo = activo;
	}

	public Proveedor(int idProveedor, String nombre, String direccion,
			String telefono, String correo, boolean activo,
			Set<ProveedorActividad> proveedorActividads) {
		this.idProveedor = idProveedor;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.activo = activo;
		this.proveedorActividads = proveedorActividads;
	}

	public int getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public Set<ProveedorActividad> getProveedorActividads() {
		return this.proveedorActividads;
	}

	public void setProveedorActividads(
			Set<ProveedorActividad> proveedorActividads) {
		this.proveedorActividads = proveedorActividads;
	}

}
