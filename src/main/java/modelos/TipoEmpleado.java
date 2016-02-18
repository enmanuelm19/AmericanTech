package modelos;

// Generated 14/02/2016 02:21:08 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * TipoEmpleado generated by hbm2java
 */
public class TipoEmpleado implements java.io.Serializable {

	private int idTipoEmpleado;
	private String descripcion;
	private Set<Empleado> empleados = new HashSet<Empleado>(0);

	public TipoEmpleado() {
	}

	public TipoEmpleado(int idTipoEmpleado, String descripcion) {
		this.idTipoEmpleado = idTipoEmpleado;
		this.descripcion = descripcion;
	}

	public TipoEmpleado(int idTipoEmpleado, String descripcion,
			Set<Empleado> empleados) {
		this.idTipoEmpleado = idTipoEmpleado;
		this.descripcion = descripcion;
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

	public Set<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}

}
