package modelos;

// Generated 14/02/2016 02:21:08 PM by Hibernate Tools 4.3.1

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

	public Opinion() {
	}

	public Opinion(int idOpinion, Postulacion postulacion, Usuario usuario,
			String descripcion, Date fecha, short calificacion) {
		this.idOpinion = idOpinion;
		this.postulacion = postulacion;
		this.usuario = usuario;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.calificacion = calificacion;
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

}
