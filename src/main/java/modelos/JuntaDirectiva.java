package modelos;

// Generated 25/02/2016 01:23:37 AM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * JuntaDirectiva generated by hbm2java
 */
public class JuntaDirectiva implements java.io.Serializable {

	private int idJuntaDirectiva;
	private Club club;
	private Date fechaInic;
	private Date fechaFin;
	private boolean activo;
	private Set<MiembroJunta> miembroJuntas = new HashSet<MiembroJunta>(0);

	public JuntaDirectiva() {
	}

	public JuntaDirectiva(int idJuntaDirectiva, Club club, Date fechaInic,
			Date fechaFin, boolean activo) {
		this.idJuntaDirectiva = idJuntaDirectiva;
		this.club = club;
		this.fechaInic = fechaInic;
		this.fechaFin = fechaFin;
		this.activo = activo;
	}

	public JuntaDirectiva(int idJuntaDirectiva, Club club, Date fechaInic,
			Date fechaFin, boolean activo, Set<MiembroJunta> miembroJuntas) {
		this.idJuntaDirectiva = idJuntaDirectiva;
		this.club = club;
		this.fechaInic = fechaInic;
		this.fechaFin = fechaFin;
		this.activo = activo;
		this.miembroJuntas = miembroJuntas;
	}

	public int getIdJuntaDirectiva() {
		return this.idJuntaDirectiva;
	}

	public void setIdJuntaDirectiva(int idJuntaDirectiva) {
		this.idJuntaDirectiva = idJuntaDirectiva;
	}

	public Club getClub() {
		return this.club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public Date getFechaInic() {
		return this.fechaInic;
	}

	public void setFechaInic(Date fechaInic) {
		this.fechaInic = fechaInic;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<MiembroJunta> getMiembroJuntas() {
		return this.miembroJuntas;
	}

	public void setMiembroJuntas(Set<MiembroJunta> miembroJuntas) {
		this.miembroJuntas = miembroJuntas;
	}

}
