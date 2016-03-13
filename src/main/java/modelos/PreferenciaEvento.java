package modelos;

// Generated 05/03/2016 11:15:24 PM by Hibernate Tools 4.3.1

/**
 * PreferenciaEvento generated by hbm2java
 */
public class PreferenciaEvento implements java.io.Serializable {

	private int idPreferenciaEvento;
	private Evento evento;
	private Preferencia preferencia;
	private boolean activo = true;

	public PreferenciaEvento() {
	}

	public PreferenciaEvento(int idPreferenciaEvento, Evento evento,
			Preferencia preferencia, boolean activo) {
		this.idPreferenciaEvento = idPreferenciaEvento;
		this.evento = evento;
		this.preferencia = preferencia;
		this.activo = activo;
	}

	public int getIdPreferenciaEvento() {
		return this.idPreferenciaEvento;
	}

	public void setIdPreferenciaEvento(int idPreferenciaEvento) {
		this.idPreferenciaEvento = idPreferenciaEvento;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Preferencia getPreferencia() {
		return this.preferencia;
	}

	public void setPreferencia(Preferencia preferencia) {
		this.preferencia = preferencia;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
