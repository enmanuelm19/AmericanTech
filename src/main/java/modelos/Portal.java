package modelos;

// Generated 05/03/2016 11:15:24 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Portal generated by hbm2java
 */
public class Portal implements java.io.Serializable {

	private int idPortal;
	private String instalacion;
	private String socio;
	private String evento;
	private boolean activo = true;
	private Set<ArchivoPortal> archivoPortals = new HashSet<ArchivoPortal>(0);

	public Portal() {
	}

	public Portal(int idPortal, boolean activo) {
		this.idPortal = idPortal;
		this.activo = activo;
	}

	public Portal(int idPortal, String instalacion, String socio,
			String evento, boolean activo, Set<ArchivoPortal> archivoPortals) {
		this.idPortal = idPortal;
		this.instalacion = instalacion;
		this.socio = socio;
		this.evento = evento;
		this.activo = activo;
		this.archivoPortals = archivoPortals;
	}

	public int getIdPortal() {
		return this.idPortal;
	}

	public void setIdPortal(int idPortal) {
		this.idPortal = idPortal;
	}

	public String getInstalacion() {
		return this.instalacion;
	}

	public void setInstalacion(String instalacion) {
		this.instalacion = instalacion;
	}

	public String getSocio() {
		return this.socio;
	}

	public void setSocio(String socio) {
		this.socio = socio;
	}

	public String getEvento() {
		return this.evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<ArchivoPortal> getArchivoPortals() {
		return this.archivoPortals;
	}

	public void setArchivoPortals(Set<ArchivoPortal> archivoPortals) {
		this.archivoPortals = archivoPortals;
	}

}
