package modelos;

// Generated 07/02/2016 10:09:11 AM by Hibernate Tools 4.3.1

/**
 * PreferenciaPersona generated by hbm2java
 */
public class PreferenciaPersona implements java.io.Serializable {

	private int idPreferenciaPersona;
	private Persona persona;
	private Preferencia preferencia;

	public PreferenciaPersona() {
	}

	public PreferenciaPersona(int idPreferenciaPersona, Persona persona,
			Preferencia preferencia) {
		this.idPreferenciaPersona = idPreferenciaPersona;
		this.persona = persona;
		this.preferencia = preferencia;
	}

	public int getIdPreferenciaPersona() {
		return this.idPreferenciaPersona;
	}

	public void setIdPreferenciaPersona(int idPreferenciaPersona) {
		this.idPreferenciaPersona = idPreferenciaPersona;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Preferencia getPreferencia() {
		return this.preferencia;
	}

	public void setPreferencia(Preferencia preferencia) {
		this.preferencia = preferencia;
	}

}
