package models;

import java.util.Date;

public class Desvinculacion {
	
	private int id;
	private Date fecha;
	private String motivo;
	private Accion accionId;
	private MotivoDesvinculacion motivoDesvinculacionId;
	private Socio socioId;
	
	public Desvinculacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Desvinculacion(int id, Date fecha, String motivo, Accion accionId,
			MotivoDesvinculacion motivoDesvinculacionId, Socio socioId) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.motivo = motivo;
		this.accionId = accionId;
		this.motivoDesvinculacionId = motivoDesvinculacionId;
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

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Accion getAccionId() {
		return accionId;
	}

	public void setAccionId(Accion accionId) {
		this.accionId = accionId;
	}

	public MotivoDesvinculacion getMotivoDesvinculacionId() {
		return motivoDesvinculacionId;
	}

	public void setMotivoDesvinculacionId(
			MotivoDesvinculacion motivoDesvinculacionId) {
		this.motivoDesvinculacionId = motivoDesvinculacionId;
	}

	public Socio getSocioId() {
		return socioId;
	}

	public void setSocioId(Socio socioId) {
		this.socioId = socioId;
	}
}
