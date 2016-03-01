package modelos;

// Generated 01/03/2016 02:05:25 AM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Sancion generated by hbm2java
 */
public class Sancion implements java.io.Serializable {

	private int idSancion;
	private MotivoSancion motivoSancion;
	private Socio socio;
	private String descripcion;
	private Date fechaInic;
	private Date fechaFin;
	private Float monto;
	private boolean activo = true;
	private Set<Eventualidad> eventualidads = new HashSet<Eventualidad>(0);

	public Sancion() {
	}

	public Sancion(int idSancion, MotivoSancion motivoSancion,
			String descripcion, Date fechaInic, Date fechaFin, boolean activo) {
		this.idSancion = idSancion;
		this.motivoSancion = motivoSancion;
		this.descripcion = descripcion;
		this.fechaInic = fechaInic;
		this.fechaFin = fechaFin;
		this.activo = activo;
	}

	public Sancion(int idSancion, MotivoSancion motivoSancion, Socio socio,
			String descripcion, Date fechaInic, Date fechaFin, Float monto,
			boolean activo, Set<Eventualidad> eventualidads) {
		this.idSancion = idSancion;
		this.motivoSancion = motivoSancion;
		this.socio = socio;
		this.descripcion = descripcion;
		this.fechaInic = fechaInic;
		this.fechaFin = fechaFin;
		this.monto = monto;
		this.activo = activo;
		this.eventualidads = eventualidads;
	}

	public int getIdSancion() {
		return this.idSancion;
	}

	public void setIdSancion(int idSancion) {
		this.idSancion = idSancion;
	}

	public MotivoSancion getMotivoSancion() {
		return this.motivoSancion;
	}

	public void setMotivoSancion(MotivoSancion motivoSancion) {
		this.motivoSancion = motivoSancion;
	}

	public Socio getSocio() {
		return this.socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInic() {
		return this.fechaInic;
	}

	public void setFechaInic(Date fechaInic) {
		this.fechaInic = fechaInic;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Float getMonto() {
		return this.monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<Eventualidad> getEventualidads() {
		return this.eventualidads;
	}

	public void setEventualidads(Set<Eventualidad> eventualidads) {
		this.eventualidads = eventualidads;
	}

}
