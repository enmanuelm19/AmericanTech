package modelos;

// Generated 18/02/2016 10:39:38 PM by Hibernate Tools 4.3.1

import java.util.Date;

/**
 * Eventualidad generated by hbm2java
 */
public class Eventualidad implements java.io.Serializable {

	private int idEventualidad;
	private Evento evento;
	private Instalacion instalacion;
	private Persona persona;
	private String descripcion;
	private Date fecha;

	public Eventualidad() {
	}

	public Eventualidad(int idEventualidad, String descripcion, Date fecha) {
		this.idEventualidad = idEventualidad;
		this.descripcion = descripcion;
		this.fecha = fecha;
	}

	public Eventualidad(int idEventualidad, Evento evento,
			Instalacion instalacion, Persona persona, String descripcion,
			Date fecha) {
		this.idEventualidad = idEventualidad;
		this.evento = evento;
		this.instalacion = instalacion;
		this.persona = persona;
		this.descripcion = descripcion;
		this.fecha = fecha;
	}

	public int getIdEventualidad() {
		return this.idEventualidad;
	}

	public void setIdEventualidad(int idEventualidad) {
		this.idEventualidad = idEventualidad;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Instalacion getInstalacion() {
		return this.instalacion;
	}

	public void setInstalacion(Instalacion instalacion) {
		this.instalacion = instalacion;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
