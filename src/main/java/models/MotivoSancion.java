package models;

public class MotivoSancion {
	
	private int id;
	private String descripcion;
	
	public MotivoSancion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MotivoSancion(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
