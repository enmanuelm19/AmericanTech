package modelos;

// Generated 07/02/2016 10:09:11 AM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Venta generated by hbm2java
 */
public class Venta implements java.io.Serializable {

	private int idVenta;
	private Accion accion;
	private MotivoVenta motivoVenta;
	private Date fecha;
	private float monto;
	private Set<Postulacion> postulacions = new HashSet<Postulacion>(0);

	public Venta() {
	}

	public Venta(int idVenta, MotivoVenta motivoVenta, Date fecha, float monto) {
		this.idVenta = idVenta;
		this.motivoVenta = motivoVenta;
		this.fecha = fecha;
		this.monto = monto;
	}

	public Venta(int idVenta, Accion accion, MotivoVenta motivoVenta,
			Date fecha, float monto, Set<Postulacion> postulacions) {
		this.idVenta = idVenta;
		this.accion = accion;
		this.motivoVenta = motivoVenta;
		this.fecha = fecha;
		this.monto = monto;
		this.postulacions = postulacions;
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

	public MotivoVenta getMotivoVenta() {
		return this.motivoVenta;
	}

	public void setMotivoVenta(MotivoVenta motivoVenta) {
		this.motivoVenta = motivoVenta;
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

	public Set<Postulacion> getPostulacions() {
		return this.postulacions;
	}

	public void setPostulacions(Set<Postulacion> postulacions) {
		this.postulacions = postulacions;
	}

}