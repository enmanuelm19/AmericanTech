//Created by: Enmanuel Medina, Team: O'Sullivan
package service;

import java.util.ArrayList;
import java.util.List;

import models.Afiliado;
import models.Persona;
import models.Socio;
import models.TipoAfiliado;

public class AfiliadoService {

	static int id=0;
	static List<Afiliado> afiliados = new ArrayList<Afiliado>();
	static List<Persona> personas = PersonaService.per;
	static TipoAfiliado tipoAfiliado = new TipoAfiliado(1,"Hijo");
	static Socio socio = new Socio(1,"12345", personas.get(2));
	static{
		afiliados.add(new Afiliado(id++,"12345-1", personas.get(1), tipoAfiliado, socio));
		afiliados.add(new Afiliado(id++,"12345-2", personas.get(3),tipoAfiliado,socio));
	}
}
