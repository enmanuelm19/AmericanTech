package models;

import java.util.Date;

public class Sancion {
	private int id;
	private Date fechaInic;
	private Date fechaFin;
	private float monto;
	private Exonerado eoneradoId;
	private Socio socioId;
	private TipoSancion tipoSancionId;
	
	public Sancion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sancion(int id, Date fechaInic, Date fechaFin, float monto,
			Exonerado eoneradoId, Socio socioId, TipoSancion tipoSancionId) {
		super();
		this.id = id;
		this.fechaInic = fechaInic;
		this.fechaFin = fechaFin;
		this.monto = monto;
		this.eoneradoId = eoneradoId;
		this.socioId = socioId;
		this.tipoSancionId = tipoSancionId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaInic() {
		return fechaInic;
	}

	public void setFechaInic(Date fechaInic) {
		this.fechaInic = fechaInic;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public Exonerado getEoneradoId() {
		return eoneradoId;
	}

	public void setEoneradoId(Exonerado eoneradoId) {
		this.eoneradoId = eoneradoId;
	}

	public Socio getSocioId() {
		return socioId;
	}

	public void setSocioId(Socio socioId) {
		this.socioId = socioId;
	}

	public TipoSancion getTipoSancionId() {
		return tipoSancionId;
	}

	public void setTipoSancionId(TipoSancion tipoSancionId) {
		this.tipoSancionId = tipoSancionId;
	}
}
