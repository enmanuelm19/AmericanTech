package models;

import java.util.ArrayList;
import java.util.List;

public class Accion {
	private int id;
	private float valor;
	private String disponibilidad;
	private EstadoAccion estadoAccionId;
	private Socio socioId;
	
	//coleccion de Ventas.. relacion uno a muchos
	private List<Venta> ventas= new ArrayList<Venta>();
	
	//coleccion de Postulaciones.. relacion uno a muchos
	private List<Postulacion> postulaciones= new ArrayList<Postulacion>();
	
	//coleccion de Desvinculaciones.. relacion uno a muchos
	private List<Desvinculacion> desvinculaciones=new ArrayList<Desvinculacion>();
	
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

	public void ListId(int id) {
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

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public List<Postulacion> getPostulaciones() {
		return postulaciones;
	}

	public void setPostulaciones(List<Postulacion> postulaciones) {
		this.postulaciones = postulaciones;
	}

	public List<Desvinculacion> getDesvinculaciones() {
		return desvinculaciones;
	}

	public void ListDesvinculaciones(List<Desvinculacion> desvinculaciones) {
		this.desvinculaciones = desvinculaciones;
	}
}
