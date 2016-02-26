package modelos;

// Generated 26/02/2016 11:27:56 AM by Hibernate Tools 4.3.1

import java.util.Date;

/**
 * Desvinculacion generated by hbm2java
 */
public class Desvinculacion implements java.io.Serializable {

	private int idDesvinculacion;
	private Accion accion;
	private MotivoDesvinculacion motivoDesvinculacion;
	private Socio socio;
	private Date fecha;
	private String motivo;
	private boolean activo;

	public Desvinculacion() {
	}

	public Desvinculacion(int idDesvinculacion, Accion accion,
			MotivoDesvinculacion motivoDesvinculacion, Socio socio, Date fecha,
			boolean activo) {
		this.idDesvinculacion = idDesvinculacion;
		this.accion = accion;
		this.motivoDesvinculacion = motivoDesvinculacion;
		this.socio = socio;
		this.fecha = fecha;
		this.activo = activo;
	}

	public Desvinculacion(int idDesvinculacion, Accion accion,
			MotivoDesvinculacion motivoDesvinculacion, Socio socio, Date fecha,
			String motivo, boolean activo) {
		this.idDesvinculacion = idDesvinculacion;
		this.accion = accion;
		this.motivoDesvinculacion = motivoDesvinculacion;
		this.socio = socio;
		this.fecha = fecha;
		this.motivo = motivo;
		this.activo = activo;
	}

	public int getIdDesvinculacion() {
		return this.idDesvinculacion;
	}

	public void setIdDesvinculacion(int idDesvinculacion) {
		this.idDesvinculacion = idDesvinculacion;
	}

	public Accion getAccion() {
		return this.accion;
	}

	public void setAccion(Accion accion) {
		this.accion = accion;
	}

	public MotivoDesvinculacion getMotivoDesvinculacion() {
		return this.motivoDesvinculacion;
	}

	public void setMotivoDesvinculacion(
			MotivoDesvinculacion motivoDesvinculacion) {
		this.motivoDesvinculacion = motivoDesvinculacion;
	}

	public Socio getSocio() {
		return this.socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
