package models;

import java.util.ArrayList;
import java.util.List;

public class MotivoDesvinculacion {
	
	private int id;
	private String descripcion;

	//Coleccion de desvinculaciones.. relacion uno a muchos
	private List<Desvinculacion> desvinculacions= new ArrayList<Desvinculacion>();
	
	public MotivoDesvinculacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MotivoDesvinculacion(int id, String descripcion) {
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

	public List<Desvinculacion> getDesvinculacions() {
		return desvinculacions;
	}

	public void setDesvinculacions(List<Desvinculacion> desvinculacions) {
		this.desvinculacions = desvinculacions;
	}	
}
