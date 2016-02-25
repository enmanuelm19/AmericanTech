package modelos;

// Generated 25/02/2016 12:54:56 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Preferencia generated by hbm2java
 */
public class Preferencia implements java.io.Serializable {

	private int idPreferencia;
	private TipoPreferencia tipoPreferencia;
	private String descripcion;
	private boolean activo;
	private Set<PreferenciaEvento> preferenciaEventos = new HashSet<PreferenciaEvento>(
			0);
	private Set<PreferenciaPersona> preferenciaPersonas = new HashSet<PreferenciaPersona>(
			0);
	private Set<NoticiaPreferencia> noticiaPreferencias = new HashSet<NoticiaPreferencia>(
			0);
	private Set<PreferenciaSolicitud> preferenciaSolicituds = new HashSet<PreferenciaSolicitud>(
			0);

	public Preferencia() {
	}

	public Preferencia(int idPreferencia, TipoPreferencia tipoPreferencia,
			String descripcion, boolean activo) {
		this.idPreferencia = idPreferencia;
		this.tipoPreferencia = tipoPreferencia;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public Preferencia(int idPreferencia, TipoPreferencia tipoPreferencia,
			String descripcion, boolean activo,
			Set<PreferenciaEvento> preferenciaEventos,
			Set<PreferenciaPersona> preferenciaPersonas,
			Set<NoticiaPreferencia> noticiaPreferencias,
			Set<PreferenciaSolicitud> preferenciaSolicituds) {
		this.idPreferencia = idPreferencia;
		this.tipoPreferencia = tipoPreferencia;
		this.descripcion = descripcion;
		this.activo = activo;
		this.preferenciaEventos = preferenciaEventos;
		this.preferenciaPersonas = preferenciaPersonas;
		this.noticiaPreferencias = noticiaPreferencias;
		this.preferenciaSolicituds = preferenciaSolicituds;
	}

	public int getIdPreferencia() {
		return this.idPreferencia;
	}

	public void setIdPreferencia(int idPreferencia) {
		this.idPreferencia = idPreferencia;
	}

	public TipoPreferencia getTipoPreferencia() {
		return this.tipoPreferencia;
	}

	public void setTipoPreferencia(TipoPreferencia tipoPreferencia) {
		this.tipoPreferencia = tipoPreferencia;
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

	public Set<PreferenciaEvento> getPreferenciaEventos() {
		return this.preferenciaEventos;
	}

	public void setPreferenciaEventos(Set<PreferenciaEvento> preferenciaEventos) {
		this.preferenciaEventos = preferenciaEventos;
	}

	public Set<PreferenciaPersona> getPreferenciaPersonas() {
		return this.preferenciaPersonas;
	}

	public void setPreferenciaPersonas(
			Set<PreferenciaPersona> preferenciaPersonas) {
		this.preferenciaPersonas = preferenciaPersonas;
	}

	public Set<NoticiaPreferencia> getNoticiaPreferencias() {
		return this.noticiaPreferencias;
	}

	public void setNoticiaPreferencias(
			Set<NoticiaPreferencia> noticiaPreferencias) {
		this.noticiaPreferencias = noticiaPreferencias;
	}

	public Set<PreferenciaSolicitud> getPreferenciaSolicituds() {
		return this.preferenciaSolicituds;
	}

	public void setPreferenciaSolicituds(
			Set<PreferenciaSolicitud> preferenciaSolicituds) {
		this.preferenciaSolicituds = preferenciaSolicituds;
	}

}
