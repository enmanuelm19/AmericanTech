//Created by: Enmanuel Medina, Team: O'Sullivan
package service;

import java.util.ArrayList;
import java.util.List;

import models.Accion;
import models.EstadoAccion;
import models.Persona;
import models.Socio;



public class AccionService {
	
	static int id = 0;
	static Persona persona = new Persona(1,"20.387.728",null,"Enmanuel", "Jose", "Medina", "Delgado", null, 'M', "correo@proveedor.com", "555-5555","999-9999","Laboratorio SI");
	static Socio socio = new Socio(1,"12345", persona );
	static EstadoAccion estadoAccion = new EstadoAccion(1,"Disponible");
	static List<Accion> acciones = new ArrayList<Accion>();
	static{
		acciones.add(new Accion(id++,30,"Disponible",estadoAccion,socio));
		acciones.add(new Accion(id++,30,"No Disponible",estadoAccion,socio));
		acciones.add(new Accion(id++,30,"No Disponible",estadoAccion,socio));
	}
	public static List<Accion> getAcciones() {
		return acciones;
	}
	public static void setAcciones(List<Accion> acciones) {
		AccionService.acciones = acciones;
	}
}
