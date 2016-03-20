package modelos;

import java.text.SimpleDateFormat;

// Generated 05/03/2016 11:15:24 PM by Hibernate Tools 4.3.1

import java.util.Date;

/**
 * Actividad generated by hbm2java
 */
public class Actividad implements java.io.Serializable {

	private int idActividad;
	private Evento evento;
	private String descripcion;
	private Date fechaTope;
	private Date fechaRealizacion;
	private Integer valorEsperado;
	private Integer valorReal;
	private boolean finalizada;
	private boolean activo;

	public Actividad() {
	}

	public Actividad(int idActividad, Evento evento, String descripcion,
			boolean finalizada, boolean activo) {
		this.idActividad = idActividad;
		this.evento = evento;
		this.descripcion = descripcion;
		this.finalizada = finalizada;
		this.activo = activo;
	}

	public Actividad(int idActividad, Evento evento, String descripcion,
			Date fechaTope, Date fechaRealizacion, Integer valorEsperado,
			Integer valorReal, boolean finalizada, boolean activo) {
		this.idActividad = idActividad;
		this.evento = evento;
		this.descripcion = descripcion;
		this.fechaTope = fechaTope;
		this.fechaRealizacion = fechaRealizacion;
		this.valorEsperado = valorEsperado;
		this.valorReal = valorReal;
		this.finalizada = finalizada;
		this.activo = activo;
	}

	public int getIdActividad() {
		return this.idActividad;
	}

	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaTope() {
		return this.fechaTope;
	}

	public void setFechaTope(Date fechaTope) {
		this.fechaTope = fechaTope;
	}

	public Date getFechaRealizacion() {
		return this.fechaRealizacion;
	}

	public void setFechaRealizacion(Date fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}

	public Integer getValorEsperado() {
		return this.valorEsperado;
	}

	public void setValorEsperado(Integer valorEsperado) {
		this.valorEsperado = valorEsperado;
	}

	public Integer getValorReal() {
		return this.valorReal;
	}

	public void setValorReal(Integer valorReal) {
		this.valorReal = valorReal;
	}

	public boolean isFinalizada() {
		return this.finalizada;
	}

	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	//Metodos adicionales para la actividad
	
	public String getFechaTopeString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(fechaTope);
	}

	public String getEstado() {

		if (this.finalizada)
			return "Finalizada";
		else
			return "No finalizada";
	}
	
public String getVariacion(){
		
		if(valorReal==null || valorReal == valorEsperado)
			return "-";
		else if(valorReal>valorEsperado)
			return "+"+String.valueOf(valorReal-valorEsperado);
		else return String.valueOf(valorReal-valorEsperado);
	}


}
