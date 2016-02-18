package modelos;

// Generated 14/02/2016 02:21:08 PM by Hibernate Tools 4.3.1

/**
 * EstadoSolicitud generated by hbm2java
 */
public class EstadoSolicitud implements java.io.Serializable {

	private int idEstadoSiolicitud;
	private SolicitudEvento solicitudEvento;
	private String descripcion;

	public EstadoSolicitud() {
	}

	public EstadoSolicitud(int idEstadoSiolicitud,
			SolicitudEvento solicitudEvento, String descripcion) {
		this.idEstadoSiolicitud = idEstadoSiolicitud;
		this.solicitudEvento = solicitudEvento;
		this.descripcion = descripcion;
	}

	public int getIdEstadoSiolicitud() {
		return this.idEstadoSiolicitud;
	}

	public void setIdEstadoSiolicitud(int idEstadoSiolicitud) {
		this.idEstadoSiolicitud = idEstadoSiolicitud;
	}

	public SolicitudEvento getSolicitudEvento() {
		return this.solicitudEvento;
	}

	public void setSolicitudEvento(SolicitudEvento solicitudEvento) {
		this.solicitudEvento = solicitudEvento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
