package models;

import java.util.HashSet;
import java.util.Set;

public class Accion {
	private int id;
	private float valor;
	private String disponibilidad;
	private EstadoAccion estadoAccionId;
	private Socio socioId;
	
	//coleccion de Ventas.. relacion uno a muchos
	private Set<Venta> ventas= new HashSet<Venta>();
	
	//coleccion de Postulaciones.. relacion uno a muchos
	private Set<Postulacion> postulaciones= new HashSet<Postulacion>();
	
	//coleccion de Desvinculaciones.. relacion uno a muchos
	private Set<Desvinculacion> desvinculaciones=new HashSet<Desvinculacion>();
	
	public Accion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Accion(int id, float valor, String disponibilidad,
			EstadoAccion estadoAccionId, Socio socioId) {
		super();
		this.id = id;
		this.valor = valor;
		this.disponibilidad = disponibilidad;
		this.estadoAccionId = estadoAccionId;
		this.socioId = socioId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public EstadoAccion getEstadoAccionId() {
		return estadoAccionId;
	}

	public void setEstadoAccionId(EstadoAccion estadoAccionId) {
		this.estadoAccionId = estadoAccionId;
	}

	public Socio getSocioId() {
		return socioId;
	}

	public void setSocioId(Socio socioId) {
		this.socioId = socioId;
	}

	public Set<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(Set<Venta> ventas) {
		this.ventas = ventas;
	}

	public Set<Postulacion> getPostulaciones() {
		return postulaciones;
	}

	public void setPostulaciones(Set<Postulacion> postulaciones) {
		this.postulaciones = postulaciones;
	}

	public Set<Desvinculacion> getDesvinculaciones() {
		return desvinculaciones;
	}

	public void setDesvinculaciones(Set<Desvinculacion> desvinculaciones) {
		this.desvinculaciones = desvinculaciones;
	}
}
