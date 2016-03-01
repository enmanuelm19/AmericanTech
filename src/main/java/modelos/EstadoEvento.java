package modelos;

// Generated 01/03/2016 02:05:25 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * EstadoEvento generated by hbm2java
 */
public class EstadoEvento implements java.io.Serializable {

	private int idEstadoEvento;
	private String nombre;
	private boolean activo = true;
	private Set<Evento> eventos = new HashSet<Evento>(0);

	public EstadoEvento() {
	}

	public EstadoEvento(int idEstadoEvento, String nombre, boolean activo) {
		this.idEstadoEvento = idEstadoEvento;
		this.nombre = nombre;
		this.activo = activo;
	}

	public EstadoEvento(int idEstadoEvento, String nombre, boolean activo,
			Set<Evento> eventos) {
		this.idEstadoEvento = idEstadoEvento;
		this.nombre = nombre;
		this.activo = activo;
		this.eventos = eventos;
	}

	public int getIdEstadoEvento() {
		return this.idEstadoEvento;
	}

	public void setIdEstadoEvento(int idEstadoEvento) {
		this.idEstadoEvento = idEstadoEvento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<Evento> getEventos() {
		return this.eventos;
	}

	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}

}
