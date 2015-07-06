package models;

public class EstadoReservacion {
	
	private int id;
	private String descripcion;
	private Reservacion reservacionId;
	
	public EstadoReservacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EstadoReservacion(int id, String descripcion,
			Reservacion reservacionId) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.reservacionId = reservacionId;
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

	public Reservacion getReservacionId() {
		return reservacionId;
	}

	public void setReservacionId(Reservacion reservacionId) {
		this.reservacionId = reservacionId;
	}
}
