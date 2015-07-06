package models;

import java.util.Date;

public class Venta {
	
	private int id;
	private Date fecha;
	private float monto;
	private Accion accionId;
	private Postulacion postulacionId;
	private TipoVenta tipoVentaId;
	
	public Venta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Venta(int id, Date fecha, float monto, Accion accionId,
			Postulacion postulacionId, TipoVenta tipoVentaId) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.monto = monto;
		this.accionId = accionId;
		this.postulacionId = postulacionId;
		this.tipoVentaId = tipoVentaId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public Accion getAccionId() {
		return accionId;
	}

	public void setAccionId(Accion accionId) {
		this.accionId = accionId;
	}

	public Postulacion getPostulacionId() {
		return postulacionId;
	}

	public void setPostulacionId(Postulacion postulacionId) {
		this.postulacionId = postulacionId;
	}

	public TipoVenta getTipoVentaId() {
		return tipoVentaId;
	}

	public void setTipoVentaId(TipoVenta tipoVentaId) {
		this.tipoVentaId = tipoVentaId;
	}
}
