package modelos;

// Generated 25/02/2016 01:23:37 AM by Hibernate Tools 4.3.1

import java.util.Date;

/**
 * Opinion generated by hbm2java
 */
public class Opinion implements java.io.Serializable {

	private int idOpinion;
	private Postulacion postulacion;
	private Usuario usuario;
	private String descripcion;
	private Date fecha;
	private short calificacion;
	private boolean activo;

	public Opinion() {
	}

	public Opinion(int idOpinion, Postulacion postulacion, Usuario usuario,
			String descripcion, Date fecha, short calificacion, boolean activo) {
		this.idOpinion = idOpinion;
		this.postulacion = postulacion;
		this.usuario = usuario;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.calificacion = calificacion;
		this.activo = activo;
	}

	public int getIdOpinion() {
		return this.idOpinion;
	}

	public void setIdOpinion(int idOpinion) {
		this.idOpinion = idOpinion;
	}

	public Postulacion getPostulacion() {
		return this.postulacion;
	}

	public void setPostulacion(Postulacion postulacion) {
		this.postulacion = postulacion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public short getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(short calificacion) {
		this.calificacion = calificacion;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
