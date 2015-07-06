package models;

import java.util.Date;

public class Opinion {
	private int id;
	private String descripcion;
	private Date fecha;
	private int calificacion;
	private Postulacion postulacionId;
	private Usuario usuarioId;
	
	public Opinion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Opinion(int id, String descripcion, Date fecha, int calificacion,
			Postulacion postulacionId, Usuario usuarioId) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.calificacion = calificacion;
		this.postulacionId = postulacionId;
		this.usuarioId = usuarioId;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public Postulacion getPostulacionId() {
		return postulacionId;
	}

	public void setPostulacionId(Postulacion postulacionId) {
		this.postulacionId = postulacionId;
	}

	public Usuario getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}
}
