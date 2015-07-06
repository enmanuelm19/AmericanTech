package models;

import java.util.Date;

public class Noticia {
	
	private int id;
	private String titulo;
	private String descripcion;
	private byte[] foto;
	private Date caducidad;
	private boolean publico;
	private Accion accionId;
	private Evento eventoId;
	private Postulacion postulacionId;
	private TipoNoticia tipoNoticiaId;
	
	public Noticia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Noticia(int id, String titulo, String descripcion, byte[] foto,
			Date caducidad, boolean publico, Accion accionId, Evento eventoId,
			Postulacion postulacionId, TipoNoticia tipoNoticiaId) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.foto = foto;
		this.caducidad = caducidad;
		this.publico = publico;
		this.accionId = accionId;
		this.eventoId = eventoId;
		this.postulacionId = postulacionId;
		this.tipoNoticiaId = tipoNoticiaId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Date getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(Date caducidad) {
		this.caducidad = caducidad;
	}

	public boolean isPublico() {
		return publico;
	}

	public void setPublico(boolean publico) {
		this.publico = publico;
	}

	public Accion getAccionId() {
		return accionId;
	}

	public void setAccionId(Accion accionId) {
		this.accionId = accionId;
	}

	public Evento getEventoId() {
		return eventoId;
	}

	public void setEventoId(Evento eventoId) {
		this.eventoId = eventoId;
	}

	public Postulacion getPostulacionId() {
		return postulacionId;
	}

	public void setPostulacionId(Postulacion postulacionId) {
		this.postulacionId = postulacionId;
	}

	public TipoNoticia getTipoNoticiaId() {
		return tipoNoticiaId;
	}

	public void setTipoNoticiaId(TipoNoticia tipoNoticiaId) {
		this.tipoNoticiaId = tipoNoticiaId;
	}
	
}
