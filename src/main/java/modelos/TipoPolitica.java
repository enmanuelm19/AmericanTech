package modelos;

// Generated 25/02/2016 12:54:56 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * TipoPolitica generated by hbm2java
 */
public class TipoPolitica implements java.io.Serializable {

	private int idTipoPolitica;
	private String descripcion;
	private boolean activo;
	private Set<Politica> politicas = new HashSet<Politica>(0);

	public TipoPolitica() {
	}

	public TipoPolitica(int idTipoPolitica, boolean activo) {
		this.idTipoPolitica = idTipoPolitica;
		this.activo = activo;
	}

	public TipoPolitica(int idTipoPolitica, String descripcion, boolean activo,
			Set<Politica> politicas) {
		this.idTipoPolitica = idTipoPolitica;
		this.descripcion = descripcion;
		this.activo = activo;
		this.politicas = politicas;
	}

	public int getIdTipoPolitica() {
		return this.idTipoPolitica;
	}

	public void setIdTipoPolitica(int idTipoPolitica) {
		this.idTipoPolitica = idTipoPolitica;
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

	public Set<Politica> getPoliticas() {
		return this.politicas;
	}

	public void setPoliticas(Set<Politica> politicas) {
		this.politicas = politicas;
	}

}
