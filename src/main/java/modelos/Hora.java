package modelos;

// Generated 01/03/2016 02:05:25 AM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Hora generated by hbm2java
 */
public class Hora implements java.io.Serializable {

	private int idHora;
	private Date valorHorario;
	private boolean activo = true;
	private Set<CalendarioHora> calendarioHoras = new HashSet<CalendarioHora>(0);

	public Hora() {
	}

	public Hora(int idHora, Date valorHorario, boolean activo) {
		this.idHora = idHora;
		this.valorHorario = valorHorario;
		this.activo = activo;
	}

	public Hora(int idHora, Date valorHorario, boolean activo,
			Set<CalendarioHora> calendarioHoras) {
		this.idHora = idHora;
		this.valorHorario = valorHorario;
		this.activo = activo;
		this.calendarioHoras = calendarioHoras;
	}

	public int getIdHora() {
		return this.idHora;
	}

	public void setIdHora(int idHora) {
		this.idHora = idHora;
	}

	public Date getValorHorario() {
		return this.valorHorario;
	}

	public void setValorHorario(Date valorHorario) {
		this.valorHorario = valorHorario;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<CalendarioHora> getCalendarioHoras() {
		return this.calendarioHoras;
	}

	public void setCalendarioHoras(Set<CalendarioHora> calendarioHoras) {
		this.calendarioHoras = calendarioHoras;
	}

}
