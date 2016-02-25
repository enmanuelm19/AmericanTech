package modelos;

// Generated 25/02/2016 12:54:56 AM by Hibernate Tools 4.3.1

/**
 * MotivoCancelacion generated by hbm2java
 */
public class MotivoCancelacion implements java.io.Serializable {

	private int idMotivoCancelacion;
	private Evento evento;
	private String descipcion;
	private boolean activo;

	public MotivoCancelacion() {
	}

	public MotivoCancelacion(int idMotivoCancelacion, Evento evento,
			String descipcion, boolean activo) {
		this.idMotivoCancelacion = idMotivoCancelacion;
		this.evento = evento;
		this.descipcion = descipcion;
		this.activo = activo;
	}

	public int getIdMotivoCancelacion() {
		return this.idMotivoCancelacion;
	}

	public void setIdMotivoCancelacion(int idMotivoCancelacion) {
		this.idMotivoCancelacion = idMotivoCancelacion;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String getDescipcion() {
		return this.descipcion;
	}

	public void setDescipcion(String descipcion) {
		this.descipcion = descipcion;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
