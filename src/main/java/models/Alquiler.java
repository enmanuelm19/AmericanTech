package models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Alquiler {
	
	private int id;
	private Date fecha;
	private Date hora;
	private float monto;
	private Reservacion reservacionId;
	
	//coleccion de Invitados.. relacion uno a muchos
	private Set<Invitado> invitados=new HashSet<Invitado>();
	
	//coleccion de Proveedores.. relacion muchos a muchos
	private Set<Proveedor> proveedores= new HashSet<Proveedor>();
	
	public Alquiler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Alquiler(int id, Date fecha, Date hora, float monto,
			Reservacion reservacionId) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.monto = monto;
		this.reservacionId = reservacionId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public Reservacion getReservacionId() {
		return reservacionId;
	}

	public void setReservacionId(Reservacion reservacionId) {
		this.reservacionId = reservacionId;
	}

	public Set<Invitado> getInvitados() {
		return invitados;
	}

	public void setInvitados(Set<Invitado> invitados) {
		this.invitados = invitados;
	}

	public Set<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(Set<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
}
