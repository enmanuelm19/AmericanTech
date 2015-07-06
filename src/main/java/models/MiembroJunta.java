package models;

public class MiembroJunta {
	
	private int id;
	private Cargo cargoId;
	private JuntaDirectiva juntaDirectivaId;
	private Usuario usuarioId;
	
	public MiembroJunta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MiembroJunta(int id, Cargo cargoId, JuntaDirectiva juntaDirectivaId,
			Usuario usuarioId) {
		super();
		this.id = id;
		this.cargoId = cargoId;
		this.juntaDirectivaId = juntaDirectivaId;
		this.usuarioId = usuarioId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cargo getCargoId() {
		return cargoId;
	}

	public void setCargoId(Cargo cargoId) {
		this.cargoId = cargoId;
	}

	public JuntaDirectiva getJuntaDirectivaId() {
		return juntaDirectivaId;
	}

	public void setJuntaDirectivaId(JuntaDirectiva juntaDirectivaId) {
		this.juntaDirectivaId = juntaDirectivaId;
	}

	public Usuario getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}	
}
