package models;

public class EstadoSolicitud {
	
	private int id;
	private String descripcion;
	private SolicitudEvento solicitudEventoId;
	
	public EstadoSolicitud() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EstadoSolicitud(int id, String descripcion,
			SolicitudEvento solicitudEventoId) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.solicitudEventoId = solicitudEventoId;
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
	
	public SolicitudEvento getSolicitudEventoId() {
		return solicitudEventoId;
	}
	
	public void setSolicitudEventoId(SolicitudEvento solicitudEventoId) {
		this.solicitudEventoId = solicitudEventoId;
	}
}
