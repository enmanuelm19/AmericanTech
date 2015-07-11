package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Club;
import models.JuntaDirectiva;

public class JuntaDirectivaService {
	static int id=0;
	static List<JuntaDirectiva> juntas= new ArrayList<JuntaDirectiva>();
	static Club c= new Club(1, "j-1234567-8", "Centro Altetico America", "Avenida Fuerzas Armadas", "02512553654", "jsjksjaklks", "wklkdakslk", null, "");
	static{
		juntas.add(new JuntaDirectiva(id++, new Date(),new Date(), c));
		juntas.add(new JuntaDirectiva(id++, new Date(),new Date(), c));
		juntas.add(new JuntaDirectiva(id++, new Date(),new Date(), c));
		juntas.add(new JuntaDirectiva(id++, new Date(),new Date(), c));
		juntas.add(new JuntaDirectiva(id++, new Date(),new Date(), c));
		juntas.add(new JuntaDirectiva(id++, new Date(),new Date(), c));
		juntas.add(new JuntaDirectiva(id++, new Date(),new Date(), c));
		juntas.add(new JuntaDirectiva(id++, new Date(),new Date(), c));
		juntas.add(new JuntaDirectiva(id++, new Date(),new Date(), c));
	}
	public static List<JuntaDirectiva> getJuntas() {
		return juntas;
	}
	
}
