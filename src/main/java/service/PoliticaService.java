package service;

import java.util.ArrayList;
import java.util.List;

import models.Club;
import models.Politica;

public class PoliticaService {
	static int id= 0;
	static List<Politica> po= new ArrayList<Politica>();
	static Club c= new Club(1, "j-1234567-8", "Centro Altetico America", "Avenida Fuerzas Armadas", "02512553654", "jsjksjaklks", "wklkdakslk", null, "");
	
	static{
		po.add(new Politica(id++, "parametro", 5, c));
		po.add(new Politica(id++, "parametro", 5, c));
		po.add(new Politica(id++, "parametro", 5, c));
		po.add(new Politica(id++, "parametro", 5, c));
		po.add(new Politica(id++, "parametro", 5, c));
		po.add(new Politica(id++, "parametro", 5, c));
		po.add(new Politica(id++, "parametro", 5, c));
	}
	public static List<Politica> getPo() {
		return po;
	}
	
}
