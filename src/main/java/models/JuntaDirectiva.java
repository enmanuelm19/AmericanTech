package models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class JuntaDirectiva {
	
	private int id;
	private Date fechaInic;
	private Date fechaFin;
	private Club clubId;

	//coleccion de Miembros.. relacion uno a muchos
	private Set<MiembroJunta> miembros=new HashSet<MiembroJunta>();
	
	public JuntaDirectiva() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JuntaDirectiva(int id, Date fechaInic, Date fechaFin, Club clubId) {
		super();
		this.id = id;
		this.fechaInic = fechaInic;
		this.fechaFin = fechaFin;
		this.clubId = clubId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Club getClubId() {
		return clubId;
	}

	public void setClubId(Club clubId) {
		this.clubId = clubId;
	}

	public Set<MiembroJunta> getMiembros() {
		return miembros;
	}

	public void setMiembros(Set<MiembroJunta> miembros) {
		this.miembros = miembros;
	}
}
