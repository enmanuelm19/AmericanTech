package modelos;

// Generated 26/02/2016 11:27:56 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * TipoActividad generated by hbm2java
 */
public class TipoActividad implements java.io.Serializable {

	private int idTipoActividad;
	private String descripcion;
	private boolean activo;
	private Set<Actividad> actividads = new HashSet<Actividad>(0);

	public TipoActividad() {
	}

	public TipoActividad(int idTipoActividad, String descripcion, boolean activo) {
		this.idTipoActividad = idTipoActividad;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public TipoActividad(int idTipoActividad, String descripcion,
			boolean activo, Set<Actividad> actividads) {
		this.idTipoActividad = idTipoActividad;
		this.descripcion = descripcion;
		this.activo = activo;
		this.actividads = actividads;
	}

	public int getIdTipoActividad() {
		return this.idTipoActividad;
	}

	public void setIdTipoActividad(int idTipoActividad) {
		this.idTipoActividad = idTipoActividad;
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

	public Set<Actividad> getActividads() {
		return this.actividads;
	}

	public void setActividads(Set<Actividad> actividads) {
		this.actividads = actividads;
	}

}
