package modelos;

// Generated 25/02/2016 12:54:56 AM by Hibernate Tools 4.3.1

/**
 * MiembroJunta generated by hbm2java
 */
public class MiembroJunta implements java.io.Serializable {

	private int idJuntaMiembro;
	private Cargo cargo;
	private JuntaDirectiva juntaDirectiva;
	private Persona persona;
	private boolean activo;

	public MiembroJunta() {
	}

	public MiembroJunta(int idJuntaMiembro, Cargo cargo,
			JuntaDirectiva juntaDirectiva, Persona persona, boolean activo) {
		this.idJuntaMiembro = idJuntaMiembro;
		this.cargo = cargo;
		this.juntaDirectiva = juntaDirectiva;
		this.persona = persona;
		this.activo = activo;
	}

	public int getIdJuntaMiembro() {
		return this.idJuntaMiembro;
	}

	public void setIdJuntaMiembro(int idJuntaMiembro) {
		this.idJuntaMiembro = idJuntaMiembro;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public JuntaDirectiva getJuntaDirectiva() {
		return this.juntaDirectiva;
	}

	public void setJuntaDirectiva(JuntaDirectiva juntaDirectiva) {
		this.juntaDirectiva = juntaDirectiva;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
