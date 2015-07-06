package models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Reservacion {
	
	private int id;
	private Date fecha;
	private Date fechaInic;
	private Date fechaFin;
	private Instalacion instalacionId;
	private Socio socioId;
	
	//Coleccion de Estados de reservacion.. relacion uno a muchos.
	private Set<EstadoReservacion> estados=new HashSet<EstadoReservacion>();
	
	public Reservacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservacion(int id, Date fecha, Date fechaInic, Date fechaFin,
			Instalacion instalacionId, Socio socioId) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.fechaInic = fechaInic;
		this.fechaFin = fechaFin;
		this.instalacionId = instalacionId;
		this.socioId = socioId;
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

	public Date getFechaInic() {
		return fechaInic;
	}

	public void setFechaInic(Date fechaInic) {
		this.fechaInic = fechaInic;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Instalacion getInstalacionId() {
		return instalacionId;
	}

	public void setInstalacionId(Instalacion instalacionId) {
		this.instalacionId = instalacionId;
	}

	public Socio getSocioId() {
		return socioId;
	}

	public void setSocioId(Socio socioId) {
		this.socioId = socioId;
	}

	public Set<EstadoReservacion> getEstados() {
		return estados;
	}

	public void setEstados(Set<EstadoReservacion> estados) {
		this.estados = estados;
	}
}
