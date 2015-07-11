package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Postulacion;

public class PostulacionService {
	static int id=0;
	static List<Postulacion> pos= new ArrayList<Postulacion>();
	static{
		pos.add(new Postulacion(id++, new Date(), null, null, null, null, null));
		pos.add(new Postulacion(id++, new Date(), null, null, null, null, null));
		pos.add(new Postulacion(id++, new Date(), null, null, null, null, null));
		pos.add(new Postulacion(id++, new Date(), null, null, null, null, null));
		pos.add(new Postulacion(id++, new Date(), null, null, null, null, null));
		pos.add(new Postulacion(id++, new Date(), null, null, null, null, null));
		pos.add(new Postulacion(id++, new Date(), null, null, null, null, null));
	}
	public static List<Postulacion> getPos() {
		return pos;
	}
	
}
