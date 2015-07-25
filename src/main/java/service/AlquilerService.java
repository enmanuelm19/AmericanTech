//Created by: Enmanuel Medina, Team: O'Sullivan
package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Alquiler;
import models.Instalacion;
import models.Persona;
import models.Reservacion;
import models.Socio;

public class AlquilerService {
	
	static int id=0;
	static List<Instalacion> instalaciones = InstalacionService.getInstalacions();
	static Persona persona = new Persona(1,"20.387.728",null,"Enmanuel", "Jose", "Medina", "Delgado", null, 'M', "correo@proveedor.com", "555-5555","999-9999","Laboratorio SI");
	static Socio socio = new Socio(1,"12345", persona );
	static Reservacion reservacion = new Reservacion(1, new Date(), new Date(), new Date(), instalaciones.get(1), socio);
	static List<Alquiler> alquileres = new ArrayList<Alquiler>();
	static{
		alquileres.add(new Alquiler(id++, new Date(), new Date(), 5000, reservacion));
		alquileres.add(new Alquiler(id++, new Date(), new Date(), 5000, reservacion));
		alquileres.add(new Alquiler(id++, new Date(), new Date(), 5000, reservacion));
	}
	public static List<Alquiler> getAlquileres() {
		return alquileres;
	}
	public static void setAlquileres(List<Alquiler> alquileres) {
		AlquilerService.alquileres = alquileres;
	}

}
