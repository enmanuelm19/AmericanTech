//Created by: Enmanuel Medina, Team: O'Sullivan
package service;

import java.util.ArrayList;
import java.util.List;

import models.Aspecto;

public class AspectoService {

	static int id = 0;
	static List<Aspecto> aspectos = new ArrayList<Aspecto>();
	static{
		aspectos.add(new Aspecto(id++, "Aspecto1"));
		aspectos.add(new Aspecto(id++, "Aspecto2"));
		aspectos.add(new Aspecto(id++, "Aspecto3"));
		aspectos.add(new Aspecto(id++, "Aspecto4"));
		aspectos.add(new Aspecto(id++, "Aspecto5"));
		aspectos.add(new Aspecto(id++, "Aspecto6"));
		aspectos.add(new Aspecto(id++, "Aspecto7"));
	}
	public static List<Aspecto> getAspectos() {
		return aspectos;
	}
	public static void setAspectos(List<Aspecto> aspectos) {
		AspectoService.aspectos = aspectos;
	}
	
	
	
}
