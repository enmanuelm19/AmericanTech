package modelos;

// Generated 05/03/2016 11:15:24 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Postulado generated by hbm2java
 */
public class Postulado implements java.io.Serializable {

	private int idPostulado;
	private Persona persona;
	private boolean activo = true;
	private Set<Postulacion> postulacions = new HashSet<Postulacion>(0);

	public Postulado() {
	}

	public Postulado(int idPostulado, Persona persona, boolean activo) {
		this.idPostulado = idPostulado;
		this.persona = persona;
		this.activo = activo;
	}

	public Postulado(int idPostulado, Persona persona, boolean activo,
			Set<Postulacion> postulacions) {
		this.idPostulado = idPostulado;
		this.persona = persona;
		this.activo = activo;
		this.postulacions = postulacions;
	}

	public int getIdPostulado() {
		return this.idPostulado;
	}

	public void setIdPostulado(int idPostulado) {
		this.idPostulado = idPostulado;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<Postulacion> getPostulacions() {
		return this.postulacions;
	}

	public void setPostulacions(Set<Postulacion> postulacions) {
		this.postulacions = postulacions;
	}

}
