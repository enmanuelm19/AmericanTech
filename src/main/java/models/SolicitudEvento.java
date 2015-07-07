package models;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class SolicitudEvento {
	private int id;
	private Date fechaEvento;
	private String descripcion;
	private Date fechaSolicitud;
	private Socio socioId;
	
	//Coleccion de Estados de solicitud. relacion uno a muchos.
	private List<EstadoSolicitud> estados= new ArrayList<EstadoSolicitud>();
	
	public SolicitudEvento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SolicitudEvento(int id, Date fechaEvento, String descripcion,
			Date fechaSolicitud, Socio socioId) {
		super();
		this.id = id;
		this.fechaEvento = fechaEvento;
		this.descripcion = descripcion;
		this.fechaSolicitud = fechaSolicitud;
		this.socioId = socioId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Socio getSocioId() {
		return socioId;
	}

	public void setSocioId(Socio socioId) {
		this.socioId = socioId;
	}

	public List<EstadoSolicitud> getEstados() {
		return estados;
	}

	public void setEstados(List<EstadoSolicitud> estados) {
		this.estados = estados;
	}
	
}
