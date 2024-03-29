package modelos;

// Generated 05/03/2016 11:15:24 PM by Hibernate Tools 4.3.1

import java.util.Date;

/**
 * Sancion generated by hbm2java
 */
public class Sancion implements java.io.Serializable {

	private int idSancion;
	private Afiliado afiliado;
	private Eventualidad eventualidad;
	private MotivoSancion motivoSancion;
	private Socio socio;
	private TipoSancion tipoSancion;
	private String descripcion;
	private Date fechaInic;
	private Date fechaFin;
	private Float monto;
	private boolean activo = true;

	public Sancion() {
	}

	public Sancion(int idSancion, TipoSancion tipoSancion, String descripcion,
			boolean activo) {
		this.idSancion = idSancion;
		this.tipoSancion = tipoSancion;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public Sancion(int idSancion, Afiliado afiliado, Eventualidad eventualidad,
			MotivoSancion motivoSancion, Socio socio, TipoSancion tipoSancion,
			String descripcion, Date fechaInic, Date fechaFin, Float monto,
			boolean activo) {
		this.idSancion = idSancion;
		this.afiliado = afiliado;
		this.eventualidad = eventualidad;
		this.motivoSancion = motivoSancion;
		this.socio = socio;
		this.tipoSancion = tipoSancion;
		this.descripcion = descripcion;
		this.fechaInic = fechaInic;
		this.fechaFin = fechaFin;
		this.monto = monto;
		this.activo = activo;
	}

	public int getIdSancion() {
		return this.idSancion;
	}

	public void setIdSancion(int idSancion) {
		this.idSancion = idSancion;
	}

	public Afiliado getAfiliado() {
		return this.afiliado;
	}

	public void setAfiliado(Afiliado afiliado) {
		this.afiliado = afiliado;
	}

	public Eventualidad getEventualidad() {
		return this.eventualidad;
	}

	public void setEventualidad(Eventualidad eventualidad) {
		this.eventualidad = eventualidad;
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

	public TipoSancion getTipoSancion() {
		return this.tipoSancion;
	}

	public void setTipoSancion(TipoSancion tipoSancion) {
		this.tipoSancion = tipoSancion;
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

}
