package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Cargo;
import models.Club;
import models.JuntaDirectiva;
import models.MiembroJunta;
import models.Persona;
import models.Usuario;

public class MiembroJuntaService {
	static int id=0;
	static Cargo carg=new Cargo(1, "Miembro");
	static Club c= new Club(1, "j-1234567-8", "Centro Altetico America", "Avenida Fuerzas Armadas", "02512553654", "jsjksjaklks", "wklkdakslk", null, "");
	static JuntaDirectiva jun= new JuntaDirectiva(1, new Date(),new Date(), c);
	static Persona per= new Persona(1, "", null, "","", "", "", new Date(), ' ', "", "", "","");
	static Usuario usu= new Usuario(1, "123", "usuario","","", per);
	static List<MiembroJunta> miembros= new ArrayList<MiembroJunta>();
	static{
		miembros.add(new MiembroJunta(id++, carg, jun, usu));
		miembros.add(new MiembroJunta(id++, carg, jun, usu));
		miembros.add(new MiembroJunta(id++, carg, jun, usu));
		miembros.add(new MiembroJunta(id++, carg, jun, usu));
		miembros.add(new MiembroJunta(id++, carg, jun, usu));
		miembros.add(new MiembroJunta(id++, carg, jun, usu));
		miembros.add(new MiembroJunta(id++, carg, jun, usu));
	}
	public static List<MiembroJunta> getMiembros() {
		return miembros;
	}
	
}
