package models;

public class Tarea {
	private int id;
	private String descripcion;
	private Actividad actividadId;
	
	public Tarea() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tarea(int id, String descripcion, Actividad actividadId) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.actividadId = actividadId;
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

	public Actividad getActividadId() {
		return actividadId;
	}

	public void setActividadId(Actividad actividadId) {
		this.actividadId = actividadId;
	}
}
