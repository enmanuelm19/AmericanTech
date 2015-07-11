package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Persona;
import models.Postulado;

public class PostuladoService {
	static int id=0;
	static List<Postulado> pos= new ArrayList<Postulado>();
	static{
		pos.add(new Postulado(id++, new Persona(1,"22186230", null, "Fidel", "Antonio", "Aliaga", "Alejos", new Date(), 'M', "fidel.alejos@gmail.com", "04145038322", "02512551693", "Barquisimeto")));
		pos.add(new Postulado(id++,  new Persona(1,"12345678", null, "Enmanuel", "Juan", "Medina", "Gutierrez", new Date(), 'M', "enmanuel@gmail.com", "04141234567", "02512551693", "Barquisimeto")));
		pos.add(new Postulado(id++,  new Persona(1,"23456789", null, "Jose", "Manuel", "perez", "Gutierrez", new Date(), 'M', "jm@gmail.com", "04141234567", "02512551693", "Barquisimeto")));
		pos.add(new Postulado(id++, new Persona(1,"34567890", null, "Laura", "Josefina", "Medina", "Velez", new Date(), 'M', "lj@gmail.com", "04141234567", "02512551693", "Barquisimeto")));
		pos.add(new Postulado(id++, new Persona(1,"45678901", null, "Jose", "Luis", "Pereira", "Gutierrez", new Date(), 'M', "jl@gmail.com", "04141234567", "02512551693", "Barquisimeto")));
	}
	public static List<Postulado> getPos() {
		return pos;
	}
	
	
}
