package models;

import java.util.HashSet;
import java.util.Set;

public class TipoEmpleado {
	
	private int id;
	private String descripcion;
	
	//Coleccion de empleados. relacion uno a muchos
	private Set<Empleado> empleados=new HashSet<Empleado>();
	
	public TipoEmpleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoEmpleado(int id, String descripcion) {
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

	public Set<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}
}
