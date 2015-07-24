//Created by: Enmanuel Medina, Team: O'Sullivan
package service;

import java.util.ArrayList;
import java.util.List;

import models.Actividad;
import models.TipoActividad;

public class ActividadService {

	static int id=0;
	static TipoActividad tipoActividad = new TipoActividad(1,"Deporte");
	static List<Actividad> actividades = new ArrayList<Actividad>();
	static{
		actividades.add(new Actividad(id++,"Caimanera de Futbol","En Proceso","Verdadero", tipoActividad));
		actividades.add(new Actividad(id++,"Caimanera de Softbol","Pendiente","Verdadero", tipoActividad));
		actividades.add(new Actividad(id++,"Caimanera de Basquet","En Proceso","Verdadero", tipoActividad));
	}
	public static List<Actividad> getActividades() {
		return actividades;
	}
	public static void setActividades(List<Actividad> actividades) {
		ActividadService.actividades = actividades;
	}
	
	
}
