package modelos;

// Generated 05/03/2016 11:15:24 PM by Hibernate Tools 4.3.1

/**
 * PreferenciaPersona generated by hbm2java
 */
public class PreferenciaPersona implements java.io.Serializable {

	private int idPreferenciaPersona;
	private Persona persona;
	private Preferencia preferencia;
	private boolean activo = true;

	public PreferenciaPersona() {
	}

	public PreferenciaPersona(int idPreferenciaPersona, Persona persona,
			Preferencia preferencia, boolean activo) {
		this.idPreferenciaPersona = idPreferenciaPersona;
		this.persona = persona;
		this.preferencia = preferencia;
		this.activo = activo;
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

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
