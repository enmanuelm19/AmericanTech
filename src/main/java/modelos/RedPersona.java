package modelos;

// Generated 01/03/2016 02:05:25 AM by Hibernate Tools 4.3.1

/**
 * RedPersona generated by hbm2java
 */
public class RedPersona implements java.io.Serializable {

	private int idRedPersona;
	private Persona persona;
	private RedSocial redSocial;
	private String enlace;
	private boolean activo = true;

	public RedPersona() {
	}

	public RedPersona(int idRedPersona, Persona persona, RedSocial redSocial,
			String enlace, boolean activo) {
		this.idRedPersona = idRedPersona;
		this.persona = persona;
		this.redSocial = redSocial;
		this.enlace = enlace;
		this.activo = activo;
	}

	public int getIdRedPersona() {
		return this.idRedPersona;
	}

	public void setIdRedPersona(int idRedPersona) {
		this.idRedPersona = idRedPersona;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public RedSocial getRedSocial() {
		return this.redSocial;
	}

	public void setRedSocial(RedSocial redSocial) {
		this.redSocial = redSocial;
	}

	public String getEnlace() {
		return this.enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
