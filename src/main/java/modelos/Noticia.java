package modelos;

// Generated 06/03/2016 06:03:48 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Noticia generated by hbm2java
 */
public class Noticia implements java.io.Serializable {

	private int idNoticia;
	private Evento evento;
	private TipoNoticia tipoNoticia;
	private String titulo;
	private String descripcion;
	private String foto;
	private Date fechaCreacion;
	private Date caducidad;
	private boolean publico;
	private String enlace;
	private boolean activo = true;
	private Set<NoticiaPreferencia> noticiaPreferencias = new HashSet<NoticiaPreferencia>(
			0);

	public Noticia() {
	}

	public Noticia(int idNoticia, TipoNoticia tipoNoticia, String descripcion,
			Date fechaCreacion, Date caducidad, boolean publico, boolean activo) {
		this.idNoticia = idNoticia;
		this.tipoNoticia = tipoNoticia;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.caducidad = caducidad;
		this.publico = publico;
		this.activo = activo;
	}

	public Noticia(int idNoticia, Evento evento, TipoNoticia tipoNoticia,
			String titulo, String descripcion, String foto, Date fechaCreacion,
			Date caducidad, boolean publico, String enlace, boolean activo,
			Set<NoticiaPreferencia> noticiaPreferencias) {
		this.idNoticia = idNoticia;
		this.evento = evento;
		this.tipoNoticia = tipoNoticia;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.foto = foto;
		this.fechaCreacion = fechaCreacion;
		this.caducidad = caducidad;
		this.publico = publico;
		this.enlace = enlace;
		this.activo = activo;
		this.noticiaPreferencias = noticiaPreferencias;
	}

	public int getIdNoticia() {
		return this.idNoticia;
	}

	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public TipoNoticia getTipoNoticia() {
		return this.tipoNoticia;
	}

	public void setTipoNoticia(TipoNoticia tipoNoticia) {
		this.tipoNoticia = tipoNoticia;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getCaducidad() {
		return this.caducidad;
	}

	public void setCaducidad(Date caducidad) {
		this.caducidad = caducidad;
	}

	public boolean isPublico() {
		return this.publico;
	}

	public void setPublico(boolean publico) {
		this.publico = publico;
	}

	public String getEnlace() {
		return this.enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<NoticiaPreferencia> getNoticiaPreferencias() {
		return this.noticiaPreferencias;
	}

	public void setNoticiaPreferencias(
			Set<NoticiaPreferencia> noticiaPreferencias) {
		this.noticiaPreferencias = noticiaPreferencias;
	}

}
