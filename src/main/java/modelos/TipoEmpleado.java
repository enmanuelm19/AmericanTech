package modelos;

// Generated 05/03/2016 11:15:24 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * TipoEmpleado generated by hbm2java
 */
public class TipoEmpleado implements java.io.Serializable {

	private int idTipoEmpleado;
	private String descripcion;
	private boolean activo = true;
	private Set<Empleado> empleados = new HashSet<Empleado>(0);

	public TipoEmpleado() {
	}

	public TipoEmpleado(int idTipoEmpleado, String descripcion, boolean activo) {
		this.idTipoEmpleado = idTipoEmpleado;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public TipoEmpleado(int idTipoEmpleado, String descripcion, boolean activo,
			Set<Empleado> empleados) {
		this.idTipoEmpleado = idTipoEmpleado;
		this.descripcion = descripcion;
		this.activo = activo;
		this.empleados = empleados;
	}

	public int getIdTipoEmpleado() {
		return this.idTipoEmpleado;
	}

	public void setIdTipoEmpleado(int idTipoEmpleado) {
		this.idTipoEmpleado = idTipoEmpleado;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}

}
