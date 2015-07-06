package models;

import java.util.Date;

public class Postulacion {
	
	private int id;
	private Date fecha;
	private Accion accionId;
	private Postulado postuladoId;
	private String padrino1;
	private String padrino2;
	private Socio socioId;
	
	public Postulacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Postulacion(int id, Date fecha, Accion accionId,
			Postulado postuladoId, String padrino1, String padrino2,
			Socio socioId) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.accionId = accionId;
		this.postuladoId = postuladoId;
		this.padrino1 = padrino1;
		this.padrino2 = padrino2;
		this.socioId = socioId;
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

	public Accion getAccionId() {
		return accionId;
	}

	public void setAccionId(Accion accionId) {
		this.accionId = accionId;
	}

	public Postulado getPostuladoId() {
		return postuladoId;
	}

	public void setPostuladoId(Postulado postuladoId) {
		this.postuladoId = postuladoId;
	}

	public String getPadrino1() {
		return padrino1;
	}

	public void setPadrino1(String padrino1) {
		this.padrino1 = padrino1;
	}

	public String getPadrino2() {
		return padrino2;
	}

	public void setPadrino2(String padrino2) {
		this.padrino2 = padrino2;
	}

	public Socio getSocioId() {
		return socioId;
	}

	public void setSocioId(Socio socioId) {
		this.socioId = socioId;
	}
}
