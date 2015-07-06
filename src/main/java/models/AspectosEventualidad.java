package models;

public class AspectosEventualidad {
	
	private int id;
	private Aspecto aspectoId;
	private Eventualidad eventualidadId;
	private String gravedad;
	
	public AspectosEventualidad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AspectosEventualidad(int id, Aspecto aspectoId,
			Eventualidad eventualidadId, String gravedad) {
		super();
		this.id = id;
		this.aspectoId = aspectoId;
		this.eventualidadId = eventualidadId;
		this.gravedad = gravedad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Aspecto getAspectoId() {
		return aspectoId;
	}

	public void setAspectoId(Aspecto aspectoId) {
		this.aspectoId = aspectoId;
	}

	public Eventualidad getEventualidadId() {
		return eventualidadId;
	}

	public void setEventualidadId(Eventualidad eventualidadId) {
		this.eventualidadId = eventualidadId;
	}

	public String getGravedad() {
		return gravedad;
	}

	public void setGravedad(String gravedad) {
		this.gravedad = gravedad;
	}
}
