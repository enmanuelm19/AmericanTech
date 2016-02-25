package modelos;

// Generated 25/02/2016 12:54:56 AM by Hibernate Tools 4.3.1

/**
 * FuncionGrupo generated by hbm2java
 */
public class FuncionGrupo implements java.io.Serializable {

	private int idFuncionGrupo;
	private Funcion funcion;
	private Grupo grupo;
	private boolean activo;

	public FuncionGrupo() {
	}

	public FuncionGrupo(int idFuncionGrupo, Funcion funcion, Grupo grupo,
			boolean activo) {
		this.idFuncionGrupo = idFuncionGrupo;
		this.funcion = funcion;
		this.grupo = grupo;
		this.activo = activo;
	}

	public int getIdFuncionGrupo() {
		return this.idFuncionGrupo;
	}

	public void setIdFuncionGrupo(int idFuncionGrupo) {
		this.idFuncionGrupo = idFuncionGrupo;
	}

	public Funcion getFuncion() {
		return this.funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
