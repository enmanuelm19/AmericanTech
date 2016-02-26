package modelos;

// Generated 26/02/2016 11:27:56 AM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Alquiler generated by hbm2java
 */
public class Alquiler implements java.io.Serializable {

	private int idAlquiler;
	private Reservacion reservacion;
	private Date fecha;
	private String nroTransaccion;
	private float monto;
	private boolean activo;
	private Set<ArchivoAlquiler> archivoAlquilers = new HashSet<ArchivoAlquiler>(
			0);

	public Alquiler() {
	}

	public Alquiler(int idAlquiler, Reservacion reservacion, Date fecha,
			String nroTransaccion, float monto, boolean activo) {
		this.idAlquiler = idAlquiler;
		this.reservacion = reservacion;
		this.fecha = fecha;
		this.nroTransaccion = nroTransaccion;
		this.monto = monto;
		this.activo = activo;
	}

	public Alquiler(int idAlquiler, Reservacion reservacion, Date fecha,
			String nroTransaccion, float monto, boolean activo,
			Set<ArchivoAlquiler> archivoAlquilers) {
		this.idAlquiler = idAlquiler;
		this.reservacion = reservacion;
		this.fecha = fecha;
		this.nroTransaccion = nroTransaccion;
		this.monto = monto;
		this.activo = activo;
		this.archivoAlquilers = archivoAlquilers;
	}

	public int getIdAlquiler() {
		return this.idAlquiler;
	}

	public void setIdAlquiler(int idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public Reservacion getReservacion() {
		return this.reservacion;
	}

	public void setReservacion(Reservacion reservacion) {
		this.reservacion = reservacion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNroTransaccion() {
		return this.nroTransaccion;
	}

	public void setNroTransaccion(String nroTransaccion) {
		this.nroTransaccion = nroTransaccion;
	}

	public float getMonto() {
		return this.monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<ArchivoAlquiler> getArchivoAlquilers() {
		return this.archivoAlquilers;
	}

	public void setArchivoAlquilers(Set<ArchivoAlquiler> archivoAlquilers) {
		this.archivoAlquilers = archivoAlquilers;
	}

}
