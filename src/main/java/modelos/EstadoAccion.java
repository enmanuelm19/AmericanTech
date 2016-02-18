package modelos;

// Generated 14/02/2016 02:21:08 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * EstadoAccion generated by hbm2java
 */
public class EstadoAccion implements java.io.Serializable {

	private int idEstadoAccion;
	private String descripcion;
	private Set<Accion> accions = new HashSet<Accion>(0);

	public EstadoAccion() {
	}

	public EstadoAccion(int idEstadoAccion, String descripcion) {
		this.idEstadoAccion = idEstadoAccion;
		this.descripcion = descripcion;
	}

	public EstadoAccion(int idEstadoAccion, String descripcion,
			Set<Accion> accions) {
		this.idEstadoAccion = idEstadoAccion;
		this.descripcion = descripcion;
		this.accions = accions;
	}

	public int getIdEstadoAccion() {
		return this.idEstadoAccion;
	}

	public void setIdEstadoAccion(int idEstadoAccion) {
		this.idEstadoAccion = idEstadoAccion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Accion> getAccions() {
		return this.accions;
	}

	public void setAccions(Set<Accion> accions) {
		this.accions = accions;
	}

}
