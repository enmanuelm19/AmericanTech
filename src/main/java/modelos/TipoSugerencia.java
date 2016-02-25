package modelos;

// Generated 25/02/2016 12:54:56 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * TipoSugerencia generated by hbm2java
 */
public class TipoSugerencia implements java.io.Serializable {

	private int idTipoSugerencia;
	private String descripcion;
	private boolean activo;
	private Set<Sugerencia> sugerencias = new HashSet<Sugerencia>(0);

	public TipoSugerencia() {
	}

	public TipoSugerencia(int idTipoSugerencia, String descripcion,
			boolean activo) {
		this.idTipoSugerencia = idTipoSugerencia;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public TipoSugerencia(int idTipoSugerencia, String descripcion,
			boolean activo, Set<Sugerencia> sugerencias) {
		this.idTipoSugerencia = idTipoSugerencia;
		this.descripcion = descripcion;
		this.activo = activo;
		this.sugerencias = sugerencias;
	}

	public int getIdTipoSugerencia() {
		return this.idTipoSugerencia;
	}

	public void setIdTipoSugerencia(int idTipoSugerencia) {
		this.idTipoSugerencia = idTipoSugerencia;
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

	public Set<Sugerencia> getSugerencias() {
		return this.sugerencias;
	}

	public void setSugerencias(Set<Sugerencia> sugerencias) {
		this.sugerencias = sugerencias;
	}

}
