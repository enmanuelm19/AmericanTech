package models;

public class Empleado {
	
	private int id;
	private Persona personaId;
	private TipoEmpleado tipoEmpleadoId;
	
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empleado(int id, Persona personaId, TipoEmpleado tipoEmpleadoId) {
		super();
		this.id = id;
		this.personaId = personaId;
		this.tipoEmpleadoId = tipoEmpleadoId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Persona getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Persona personaId) {
		this.personaId = personaId;
	}

	public TipoEmpleado getTipoEmpleadoId() {
		return tipoEmpleadoId;
	}

	public void setTipoEmpleadoId(TipoEmpleado tipoEmpleadoId) {
		this.tipoEmpleadoId = tipoEmpleadoId;
	}
	
}
