package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Opinion;
import models.Persona;
import models.Usuario;

public class OpinionService {
	static int id=0;
	static List<Opinion> op= new ArrayList<Opinion>();
	static Persona per= new Persona(1, "", null, "","", "", "", new Date(), ' ', "", "", "","");
	static Usuario usu= new Usuario(1, "123", "usuario","","", per);
	static{
		op.add(new Opinion(id++, "descripcion", new Date(), 5, null, usu));
		op.add(new Opinion(id++, "descripcion", new Date(), 5, null, usu));
		op.add(new Opinion(id++, "descripcion", new Date(), 5, null, usu));
		op.add(new Opinion(id++, "descripcion", new Date(), 5, null, usu));
		op.add(new Opinion(id++, "descripcion", new Date(), 5, null, usu));
	}
	
	public static List<Opinion> getOp() {
		return op;
	}
	
}
