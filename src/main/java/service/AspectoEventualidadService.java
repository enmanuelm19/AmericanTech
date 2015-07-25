//Created by: Enmanuel Medina, Team: O'Sullivan
package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Aspecto;
import models.AspectosEventualidad;
import models.Evento;
import models.Eventualidad;
import models.Instalacion;
import models.Usuario;

public class AspectoEventualidadService {

	static int id=0;
	static Evento evento = new Evento(1,"Dia de la Madre", new Date(), new Date(), null, null, null, null, 100);
	static Usuario usuario = new Usuario(3, "enmanuel", "12345678", "numero", "1", null);
	static List<Instalacion> instalaciones = InstalacionService.getInstalacions();
	static Eventualidad eventualidad = new Eventualidad(1,"Se rompio una lampara", new Date(), evento, usuario, instalaciones.get(1) );
	static List<Aspecto> aspectos = AspectoService.getAspectos();
	static List<AspectosEventualidad> aspectoEventualidad = new ArrayList<AspectosEventualidad>();
	static{
		aspectoEventualidad.add(new AspectosEventualidad(id++, aspectos.get(2), eventualidad, "Moderada"));
		aspectoEventualidad.add(new AspectosEventualidad(id++, aspectos.get(2), eventualidad, "Moderada"));
		aspectoEventualidad.add(new AspectosEventualidad(id++, aspectos.get(2), eventualidad, "Moderada"));
		aspectoEventualidad.add(new AspectosEventualidad(id++, aspectos.get(2), eventualidad, "Moderada"));
		aspectoEventualidad.add(new AspectosEventualidad(id++, aspectos.get(2), eventualidad, "Moderada"));
		aspectoEventualidad.add(new AspectosEventualidad(id++, aspectos.get(2), eventualidad, "Moderada"));
		
	}
	public static List<AspectosEventualidad> getAspectoEventualidad() {
		return aspectoEventualidad;
	}
	public static void setAspectoEventualidad(List<AspectosEventualidad> aspectoEventualidad) {
		AspectoEventualidadService.aspectoEventualidad = aspectoEventualidad;
	}
	
}
