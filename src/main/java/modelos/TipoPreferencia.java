package modelos;

// Generated 01/03/2016 02:05:25 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * TipoPreferencia generated by hbm2java
 */
public class TipoPreferencia implements java.io.Serializable {

	private int idTipoPreferencia;
	private String descripcion;
	private String color;
	private boolean activo = true;
	private Set<Preferencia> preferencias = new HashSet<Preferencia>(0);

	public TipoPreferencia() {
	}

	public TipoPreferencia(int idTipoPreferencia, String descripcion,
			boolean activo) {
		this.idTipoPreferencia = idTipoPreferencia;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public TipoPreferencia(int idTipoPreferencia, String descripcion,
			String color, boolean activo, Set<Preferencia> preferencias) {
		this.idTipoPreferencia = idTipoPreferencia;
		this.descripcion = descripcion;
		this.color = color;
		this.activo = activo;
		this.preferencias = preferencias;
	}

	public int getIdTipoPreferencia() {
		return this.idTipoPreferencia;
	}

	public void setIdTipoPreferencia(int idTipoPreferencia) {
		this.idTipoPreferencia = idTipoPreferencia;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<Preferencia> getPreferencias() {
		return this.preferencias;
	}

	public void setPreferencias(Set<Preferencia> preferencias) {
		this.preferencias = preferencias;
	}

}
