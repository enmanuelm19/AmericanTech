package service;

import java.util.ArrayList;
import java.util.List;

import models.Actividad;

public class ActividadService {

	static int id=0;
	static List<Actividad> actividades = new ArrayList<Actividad>();
	static{
		actividades.add(new Actividad(id++,"Caimanera de Futbol","En Proceso","Verdadero", null));
		actividades.add(new Actividad(id++,"Caimanera de Softbol","Pendiente","Verdadero", null));
		actividades.add(new Actividad(id++,"Caimanera de Basquet","En Proceso","Verdadero", null));
	}
	public static List<Actividad> getActividades() {
		return actividades;
	}
	public static void setActividades(List<Actividad> actividades) {
		ActividadService.actividades = actividades;
	}
	
	
}
