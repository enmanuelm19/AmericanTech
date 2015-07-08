package service;

import java.util.ArrayList;
import java.util.List;
import models.Accion;

public class AccionService {
	
	static int id = 0;
	static List<Accion> acciones = new ArrayList<Accion>();
	static{
		acciones.add(new Accion(id++,30,"Disponible",null,null));
		acciones.add(new Accion(id++,30,"No Disponible",null,null));
		acciones.add(new Accion(id++,30,"No Disponible",null,null));
	}
	public static List<Accion> getAcciones() {
		return acciones;
	}
	public static void setAcciones(List<Accion> acciones) {
		AccionService.acciones = acciones;
	}
	
	

}
