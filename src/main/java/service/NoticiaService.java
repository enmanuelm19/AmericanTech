package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Noticia;

public class NoticiaService {
	static int id=0;
	static List<Noticia> no= new ArrayList<Noticia>();
	static{
		no.add(new Noticia(id++,"Titulo", "descripcion", null, new Date(), true, null, null, null, null));
		no.add(new Noticia(id++,"Titulo", "descripcion", null, new Date(), true, null, null, null, null));
		no.add(new Noticia(id++,"Titulo", "descripcion", null, new Date(), true, null, null, null, null));
		no.add(new Noticia(id++,"Titulo", "descripcion", null, new Date(), true, null, null, null, null));
		no.add(new Noticia(id++,"Titulo", "descripcion", null, new Date(), true, null, null, null, null));
	}
	public static List<Noticia> getNo() {
		return no;
	}
	
}

