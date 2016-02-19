package modelos;

// Generated 18/02/2016 10:39:38 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * TipoInstalacion generated by hbm2java
 */
public class TipoInstalacion implements java.io.Serializable {

	private int idTipoInstalacion;
	private String descripcion;
	private Set<Instalacion> instalacions = new HashSet<Instalacion>(0);

	public TipoInstalacion() {
	}

	public TipoInstalacion(int idTipoInstalacion, String descripcion) {
		this.idTipoInstalacion = idTipoInstalacion;
		this.descripcion = descripcion;
	}

	public TipoInstalacion(int idTipoInstalacion, String descripcion,
			Set<Instalacion> instalacions) {
		this.idTipoInstalacion = idTipoInstalacion;
		this.descripcion = descripcion;
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

	public Set<Instalacion> getInstalacions() {
		return this.instalacions;
	}

	public void setInstalacions(Set<Instalacion> instalacions) {
		this.instalacions = instalacions;
	}

}
