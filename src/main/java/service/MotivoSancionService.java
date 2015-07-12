package service;

import java.util.ArrayList;
import java.util.List;

import models.MotivoSancion;

public class MotivoSancionService {
	static int id=0;
	static List<MotivoSancion> mo= new ArrayList<MotivoSancion>();
	static{
		mo.add(new MotivoSancion(id++, "Pelea"));
		mo.add(new MotivoSancion(id++, "Morosidad"));
		mo.add(new MotivoSancion(id++, "Mal Comportamiento"));
		mo.add(new MotivoSancion(id++, "Daño Instalacion"));
	}
	public static List<MotivoSancion> getMo() {
		return mo;
	}
	
}
