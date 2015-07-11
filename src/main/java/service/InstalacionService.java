package service;

import java.util.ArrayList;
import java.util.List;

import models.Instalacion;

public class InstalacionService {
	static int id=0;
	static List<Instalacion> instalacions= new ArrayList<Instalacion>();
	static{
		instalacions.add(new Instalacion(id++, "Cancha de Bolas", 40));
		instalacions.add(new Instalacion(id++, "Salon Grande", 400));
		instalacions.add(new Instalacion(id++, "Caneies", 20));
		instalacions.add(new Instalacion(id++, "Caney Chevechita", 80));
		instalacions.add(new Instalacion(id++, "Cancha de Futbol", 40));
		instalacions.add(new Instalacion(id++, "Cancha Multiple", 40));
		instalacions.add(new Instalacion(id++, "Piscina", 40));
	}
	public static List<Instalacion> getInstalacions() {
		return instalacions;
	}
	
}
