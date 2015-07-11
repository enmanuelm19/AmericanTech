package service;

import java.util.ArrayList;
import java.util.List;

import models.Preferencia;
import models.TipoPreferencia;

public class PreferenciaService {
	static int id=0;
	static List<Preferencia> pr= new ArrayList<Preferencia>();
	static TipoPreferencia tp= new TipoPreferencia(1, "descripcion");
	static{
		pr.add(new Preferencia(id++, "descripcion", tp));
		pr.add(new Preferencia(id++, "descripcion", tp));
		pr.add(new Preferencia(id++, "descripcion", tp));
		pr.add(new Preferencia(id++, "descripcion", tp));
		pr.add(new Preferencia(id++, "descripcion", tp));
		pr.add(new Preferencia(id++, "descripcion", tp));
		pr.add(new Preferencia(id++, "descripcion", tp));
	}
	public static List<Preferencia> getPr() {
		return pr;
	}
	
}
