package modelos;

// Generated 14/02/2016 02:21:08 PM by Hibernate Tools 4.3.1

/**
 * CalendarioHora generated by hbm2java
 */
public class CalendarioHora implements java.io.Serializable {

	private int idCalendarioHora;
	private CalendarioFecha calendarioFecha;
	private Hora hora;

	public CalendarioHora() {
	}

	public CalendarioHora(int idCalendarioHora,
			CalendarioFecha calendarioFecha, Hora hora) {
		this.idCalendarioHora = idCalendarioHora;
		this.calendarioFecha = calendarioFecha;
		this.hora = hora;
	}

	public int getIdCalendarioHora() {
		return this.idCalendarioHora;
	}

	public void setIdCalendarioHora(int idCalendarioHora) {
		this.idCalendarioHora = idCalendarioHora;
	}

	public CalendarioFecha getCalendarioFecha() {
		return this.calendarioFecha;
	}

	public void setCalendarioFecha(CalendarioFecha calendarioFecha) {
		this.calendarioFecha = calendarioFecha;
	}

	public Hora getHora() {
		return this.hora;
	}

	public void setHora(Hora hora) {
		this.hora = hora;
	}

}
