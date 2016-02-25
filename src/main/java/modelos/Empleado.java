package modelos;

// Generated 25/02/2016 01:23:37 AM by Hibernate Tools 4.3.1

import java.util.Date;

/**
 * Empleado generated by hbm2java
 */
public class Empleado implements java.io.Serializable {

	private int idEmpleado;
	private Persona persona;
	private TipoEmpleado tipoEmpleado;
	private Date fechaContratado;
	private boolean activo;

	public Empleado() {
	}

	public Empleado(int idEmpleado, Persona persona, TipoEmpleado tipoEmpleado,
			Date fechaContratado, boolean activo) {
		this.idEmpleado = idEmpleado;
		this.persona = persona;
		this.tipoEmpleado = tipoEmpleado;
		this.fechaContratado = fechaContratado;
		this.activo = activo;
	}

	public int getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public TipoEmpleado getTipoEmpleado() {
		return this.tipoEmpleado;
	}

	public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	public Date getFechaContratado() {
		return this.fechaContratado;
	}

	public void setFechaContratado(Date fechaContratado) {
		this.fechaContratado = fechaContratado;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
