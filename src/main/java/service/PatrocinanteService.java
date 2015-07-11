package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Patrocinante;
import models.Persona;

public class PatrocinanteService {
	static int id=0;
	static List<Patrocinante> p= new ArrayList<Patrocinante>();
	static Persona per= new Persona(1, "", null, "","", "", "", new Date(), ' ', "", "", "","");
	static{
		p.add(new Patrocinante(id++, per));
		p.add(new Patrocinante(id++, per));
		p.add(new Patrocinante(id++, per));
		p.add(new Patrocinante(id++, per));
		p.add(new Patrocinante(id++, per));
		p.add(new Patrocinante(id++, per));
		p.add(new Patrocinante(id++, per));
	}
	public static List<Patrocinante> getP() {
		return p;
	}
	
}
