package modelos;

// Generated 05/03/2016 11:15:24 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Instalacion generated by hbm2java
 */
public class Instalacion implements java.io.Serializable {

	private int idInstalacion;
	private TipoInstalacion tipoInstalacion;
	private String nombre;
	private String descripcion;
	private short capacidad;
	private float precioAlquiler;
	private boolean alquilable;
	private boolean activo = true;
	private Set<Reservacion> reservacions = new HashSet<Reservacion>(0);
	private Set<InstalacionEvento> instalacionEventos = new HashSet<InstalacionEvento>(
			0);
	private Set<Foto> fotos = new HashSet<Foto>(0);
	private Set<Eventualidad> eventualidads = new HashSet<Eventualidad>(0);
	private Set<RecursoInstalacion> recursoInstalacions = new HashSet<RecursoInstalacion>(
			0);

	public Instalacion() {
	}

	public Instalacion(int idInstalacion, TipoInstalacion tipoInstalacion,
			String nombre, String descripcion, short capacidad,
			float precioAlquiler, boolean alquilable, boolean activo) {
		this.idInstalacion = idInstalacion;
		this.tipoInstalacion = tipoInstalacion;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.precioAlquiler = precioAlquiler;
		this.alquilable = alquilable;
		this.activo = activo;
	}

	public Instalacion(int idInstalacion, TipoInstalacion tipoInstalacion,
			String nombre, String descripcion, short capacidad,
			float precioAlquiler, boolean alquilable, boolean activo,
			Set<Reservacion> reservacions,
			Set<InstalacionEvento> instalacionEventos, Set<Foto> fotos,
			Set<Eventualidad> eventualidads,
			Set<RecursoInstalacion> recursoInstalacions) {
		this.idInstalacion = idInstalacion;
		this.tipoInstalacion = tipoInstalacion;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.precioAlquiler = precioAlquiler;
		this.alquilable = alquilable;
		this.activo = activo;
		this.reservacions = reservacions;
		this.instalacionEventos = instalacionEventos;
		this.fotos = fotos;
		this.eventualidads = eventualidads;
		this.recursoInstalacions = recursoInstalacions;
	}

	public int getIdInstalacion() {
		return this.idInstalacion;
	}

	public void setIdInstalacion(int idInstalacion) {
		this.idInstalacion = idInstalacion;
	}

	public TipoInstalacion getTipoInstalacion() {
		return this.tipoInstalacion;
	}

	public void setTipoInstalacion(TipoInstalacion tipoInstalacion) {
		this.tipoInstalacion = tipoInstalacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public short getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(short capacidad) {
		this.capacidad = capacidad;
	}

	public float getPrecioAlquiler() {
		return this.precioAlquiler;
	}

	public void setPrecioAlquiler(float precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}

	public boolean isAlquilable() {
		return this.alquilable;
	}

	public void setAlquilable(boolean alquilable) {
		this.alquilable = alquilable;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<Reservacion> getReservacions() {
		return this.reservacions;
	}

	public void setReservacions(Set<Reservacion> reservacions) {
		this.reservacions = reservacions;
	}

	public Set<InstalacionEvento> getInstalacionEventos() {
		return this.instalacionEventos;
	}

	public void setInstalacionEventos(Set<InstalacionEvento> instalacionEventos) {
		this.instalacionEventos = instalacionEventos;
	}

	public Set<Foto> getFotos() {
		return this.fotos;
	}

	public void setFotos(Set<Foto> fotos) {
		this.fotos = fotos;
	}

	public Set<Eventualidad> getEventualidads() {
		return this.eventualidads;
	}

	public void setEventualidads(Set<Eventualidad> eventualidads) {
		this.eventualidads = eventualidads;
	}

	public Set<RecursoInstalacion> getRecursoInstalacions() {
		return this.recursoInstalacions;
	}

	public void setRecursoInstalacions(
			Set<RecursoInstalacion> recursoInstalacions) {
		this.recursoInstalacions = recursoInstalacions;
	}
	
	public String toString(){
		return nombre;
	}

}
