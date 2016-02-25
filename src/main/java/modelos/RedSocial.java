package modelos;

// Generated 25/02/2016 01:23:37 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * RedSocial generated by hbm2java
 */
public class RedSocial implements java.io.Serializable {

	private int idRedSocial;
	private String descripcion;
	private boolean activo;
	private Set<RedPersona> redPersonas = new HashSet<RedPersona>(0);
	private Set<RedClub> redClubs = new HashSet<RedClub>(0);

	public RedSocial() {
	}

	public RedSocial(int idRedSocial, String descripcion, boolean activo) {
		this.idRedSocial = idRedSocial;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public RedSocial(int idRedSocial, String descripcion, boolean activo,
			Set<RedPersona> redPersonas, Set<RedClub> redClubs) {
		this.idRedSocial = idRedSocial;
		this.descripcion = descripcion;
		this.activo = activo;
		this.redPersonas = redPersonas;
		this.redClubs = redClubs;
	}

	public int getIdRedSocial() {
		return this.idRedSocial;
	}

	public void setIdRedSocial(int idRedSocial) {
		this.idRedSocial = idRedSocial;
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

	public Set<RedPersona> getRedPersonas() {
		return this.redPersonas;
	}

	public void setRedPersonas(Set<RedPersona> redPersonas) {
		this.redPersonas = redPersonas;
	}

	public Set<RedClub> getRedClubs() {
		return this.redClubs;
	}

	public void setRedClubs(Set<RedClub> redClubs) {
		this.redClubs = redClubs;
	}

}
