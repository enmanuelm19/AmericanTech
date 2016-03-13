package modelos;

// Generated 05/03/2016 11:15:24 PM by Hibernate Tools 4.3.1

import java.util.Date;

/**
 * Venta generated by hbm2java
 */
public class Venta implements java.io.Serializable {

	private int idVenta;
	private Accion accion;
	private Postulacion postulacion;
	private Date fecha;
	private float monto;
	private boolean activo = true;

	public Venta() {
	}

	public Venta(int idVenta, Accion accion, Postulacion postulacion,
			Date fecha, float monto, boolean activo) {
		this.idVenta = idVenta;
		this.accion = accion;
		this.postulacion = postulacion;
		this.fecha = fecha;
		this.monto = monto;
		this.activo = activo;
	}

	public int getIdVenta() {
		return this.idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public Accion getAccion() {
		return this.accion;
	}

	public void setAccion(Accion accion) {
		this.accion = accion;
	}

	public Postulacion getPostulacion() {
		return this.postulacion;
	}

	public void setPostulacion(Postulacion postulacion) {
		this.postulacion = postulacion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

}
