package modelos;

// Generated 18/02/2016 10:39:38 PM by Hibernate Tools 4.3.1

import java.util.Date;

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

	public Sancion() {
	}

	public Sancion(int idSancion, MotivoSancion motivoSancion,
			String descripcion, Date fechaInic, Date fechaFin) {
		this.idSancion = idSancion;
		this.motivoSancion = motivoSancion;
		this.descripcion = descripcion;
		this.fechaInic = fechaInic;
		this.fechaFin = fechaFin;
	}

	public Sancion(int idSancion, MotivoSancion motivoSancion, Socio socio,
			String descripcion, Date fechaInic, Date fechaFin, Float monto) {
		this.idSancion = idSancion;
		this.motivoSancion = motivoSancion;
		this.socio = socio;
		this.descripcion = descripcion;
		this.fechaInic = fechaInic;
		this.fechaFin = fechaFin;
		this.monto = monto;
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

}
