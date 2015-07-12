package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Invitado;
import models.Persona;

public class PersonaService {
	static int id=0;
	static List<Persona> per= new ArrayList<Persona>();
	static{
		per.add(new Persona(id++,"22186230", null, "Fidel", "Antonio", "Aliaga", "Alejos", new Date(), 'M', "fidel.alejos@gmail.com", "04145038322", "02512551693", "Barquisimeto"));
		per.add(new Persona(id++,"12345678", null, "Enmanuel", "Juan", "Medina", "Gutierrez", new Date(), 'M', "enmanuel@gmail.com", "04141234567", "02512551693", "Barquisimeto"));
		per.add(new Persona(id++,"23456789", null, "Jose", "Manuel", "perez", "Gutierrez", new Date(), 'M', "jm@gmail.com", "04141234567", "02512551693", "Barquisimeto"));
		per.add(new Persona(id++,"34567890", null, "Laura", "Josefina", "Medina", "Velez", new Date(), 'M', "lj@gmail.com", "04141234567", "02512551693", "Barquisimeto"));
		per.add(new Persona(id++,"45678901", null, "Jose", "Luis", "Pereira", "Gutierrez", new Date(), 'M', "jl@gmail.com", "04141234567", "02512551693", "Barquisimeto"));
		per.add(new Persona(id++,"56789012", null, "Maria", "Juana", "Perez", "Gutierrez", new Date(), 'M', "mj@gmail.com", "04141234567", "02512551693", "Barquisimeto"));
	}
	public static List<Persona> getPer() {
		return per;
	}
	
}
