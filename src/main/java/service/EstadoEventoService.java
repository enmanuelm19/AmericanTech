//Created by: Enmanuel Medina, Team: O'Sullivan
package service;

import java.util.ArrayList;
import java.util.List;

import models.EstadoEvento;

public class EstadoEventoService {
	
	static int id=0;
	static List<EstadoEvento> estados = new ArrayList<EstadoEvento>();
	static{
		estados.add(new EstadoEvento(id++,"En curso"));
		estados.add(new EstadoEvento(id++,"Cancelado"));
		estados.add(new EstadoEvento(id++,"Pospuesto"));
		estados.add(new EstadoEvento(id++,"Iniciando"));
		estados.add(new EstadoEvento(id++,"Espera de Aprobacion"));
	}
	public static List<EstadoEvento> getEstados() {
		return estados;
	}
	public static void setEstados(List<EstadoEvento> estados) {
		EstadoEventoService.estados = estados;
	}
	
	

}
