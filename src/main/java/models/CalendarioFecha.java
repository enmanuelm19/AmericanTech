package models;

import java.util.Date;

public class CalendarioFecha {
	
	private int id;
	private String descripcion;
	private Date horaInic;
	private Date horaFin;
	private Date fecha;
	private Evento eventoId;
	private Reservacion reservacionId;
	
	public CalendarioFecha() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CalendarioFecha(int id, String descripcion, Date horaInic,
			Date horaFin, Date fecha, Evento eventoId, Reservacion reservacionId) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.horaInic = horaInic;
		this.horaFin = horaFin;
		this.fecha = fecha;
		this.eventoId = eventoId;
		this.reservacionId = reservacionId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getHoraInic() {
		return horaInic;
	}

	public void setHoraInic(Date horaInic) {
		this.horaInic = horaInic;
	}

	public Date getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Evento getEventoId() {
		return eventoId;
	}

	public void setEventoId(Evento eventoId) {
		this.eventoId = eventoId;
	}

	public Reservacion getReservacionId() {
		return reservacionId;
	}

	public void setReservacionId(Reservacion reservacionId) {
		this.reservacionId = reservacionId;
	}
}