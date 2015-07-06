package models;

public class Galeria {
	
	private int id;
	private byte[] foto;
	private Instalacion instalacionId;
	
	public Galeria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Galeria(int id, byte[] foto, Instalacion instalacionId) {
		super();
		this.id = id;
		this.foto = foto;
		this.instalacionId = instalacionId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Instalacion getInstalacionId() {
		return instalacionId;
	}

	public void setInstalacionId(Instalacion instalacionId) {
		this.instalacionId = instalacionId;
	}
}
