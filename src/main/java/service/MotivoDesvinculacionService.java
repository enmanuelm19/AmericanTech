package service;

import java.util.ArrayList;
import java.util.List;

import models.MotivoDesvinculacion;

public class MotivoDesvinculacionService {
	static int id=0;
	static List<MotivoDesvinculacion> mo= new ArrayList<MotivoDesvinculacion>();
	static{
		mo.add(new MotivoDesvinculacion(id++,"Pelea"));
		mo.add(new MotivoDesvinculacion(id++,"Mal Comportamiento"));
		mo.add(new MotivoDesvinculacion(id++,"Embriedad"));
	}
	
	public static List<MotivoDesvinculacion> getMo() {
		return mo;
	}
	
}
