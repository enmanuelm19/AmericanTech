package models;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Eventualidad {
	
	private int id;
	private String descripcion;
	private Date fecha;
	private Evento eventoId;
	private Usuario usuarioId;
	private Instalacion instalacionId;

	//Coleccion de aspectosEventualidades.. relacion uno a muchos
	private List<AspectosEventualidad> aspectos= new ArrayList<AspectosEventualidad>();
	
	public Eventualidad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Eventualidad(int id, String descripcion, Date fecha,
			Evento eventoId, Usuario usuarioId, Instalacion instalacionId) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.eventoId = eventoId;
		this.usuarioId = usuarioId;
		this.instalacionId = instalacionId;
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

	public Evento getEventoId() {
		return eventoId;
	}

	public void setEventoId(Evento eventoId) {
		this.eventoId = eventoId;
	}

	public Usuario getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Instalacion getInstalacionId() {
		return instalacionId;
	}

	public void setInstalacionId(Instalacion instalacionId) {
		this.instalacionId = instalacionId;
	}

	public List<AspectosEventualidad> getAspectos() {
		return aspectos;
	}

	public void setAspectos(List<AspectosEventualidad> aspectos) {
		this.aspectos = aspectos;
	}
}
