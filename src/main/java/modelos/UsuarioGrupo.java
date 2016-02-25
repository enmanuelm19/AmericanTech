package modelos;

// Generated 25/02/2016 01:23:37 AM by Hibernate Tools 4.3.1

/**
 * UsuarioGrupo generated by hbm2java
 */
public class UsuarioGrupo implements java.io.Serializable {

	private int idUsuarioGrupo;
	private Grupo grupo;
	private Usuario usuario;
	private boolean activo;

	public UsuarioGrupo() {
	}

	public UsuarioGrupo(int idUsuarioGrupo, Grupo grupo, Usuario usuario,
			boolean activo) {
		this.idUsuarioGrupo = idUsuarioGrupo;
		this.grupo = grupo;
		this.usuario = usuario;
		this.activo = activo;
	}

	public int getIdUsuarioGrupo() {
		return this.idUsuarioGrupo;
	}

	public void setIdUsuarioGrupo(int idUsuarioGrupo) {
		this.idUsuarioGrupo = idUsuarioGrupo;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
