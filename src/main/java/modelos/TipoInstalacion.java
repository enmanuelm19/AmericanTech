package modelos;

// Generated 25/02/2016 12:54:56 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * TipoInstalacion generated by hbm2java
 */
public class TipoInstalacion implements java.io.Serializable {

	private int idTipoInstalacion;
	private String descripcion;
	private boolean activo;
	private Set<Instalacion> instalacions = new HashSet<Instalacion>(0);

	public TipoInstalacion() {
	}

	public TipoInstalacion(int idTipoInstalacion, String descripcion,
			boolean activo) {
		this.idTipoInstalacion = idTipoInstalacion;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public TipoInstalacion(int idTipoInstalacion, String descripcion,
			boolean activo, Set<Instalacion> instalacions) {
		this.idTipoInstalacion = idTipoInstalacion;
		this.descripcion = descripcion;
		this.activo = activo;
		this.instalacions = instalacions;
	}

	public int getIdTipoInstalacion() {
		return this.idTipoInstalacion;
	}

	public void setIdTipoInstalacion(int idTipoInstalacion) {
		this.idTipoInstalacion = idTipoInstalacion;
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

	public Set<Instalacion> getInstalacions() {
		return this.instalacions;
	}

	public void setInstalacions(Set<Instalacion> instalacions) {
		this.instalacions = instalacions;
	}

}
