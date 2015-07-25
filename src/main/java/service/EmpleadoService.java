//Created by: Enmanuel Medina, Team: O'Sullivan
package service;

import java.util.ArrayList;
import java.util.List;

import models.Empleado;
import models.Persona;
import models.TipoEmpleado;

public class EmpleadoService {
	
	static int id=0;
	static TipoEmpleado tipo = new TipoEmpleado(id++,"Secretaria");
	static List<Persona> persona = PersonaService.getPer();
	static List<Empleado> empleados = new ArrayList<Empleado>();
	static{
		empleados.add(new Empleado(id++, persona.get(4),tipo));
		empleados.add(new Empleado(id++, persona.get(4),tipo));
		empleados.add(new Empleado(id++, persona.get(4),tipo));
		empleados.add(new Empleado(id++, persona.get(4),tipo));
		empleados.add(new Empleado(id++, persona.get(4),tipo));
		empleados.add(new Empleado(id++, persona.get(4),tipo));
		empleados.add(new Empleado(id++, persona.get(4),tipo));
		empleados.add(new Empleado(id++, persona.get(4),tipo));
	}

}
