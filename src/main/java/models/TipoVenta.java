package models;

import java.util.ArrayList;
import java.util.List;

public class TipoVenta {
	private int id;
	private String descripcion;

	//Coleccion de ventas.. relacion uno a muchos
	private List<Venta> ventas= new ArrayList<Venta>();
	
	public TipoVenta() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TipoVenta(int id, String descripcion) {
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

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}
}
