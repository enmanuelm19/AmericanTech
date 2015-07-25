//Created by: Enmanuel Medina, Team: O'Sullivan
package service;

import java.util.ArrayList;
import java.util.List;

import models.EstadoAccion;

public class EstadoAccionService {
	
	static int id=0;
	static List<EstadoAccion> estado = new ArrayList<EstadoAccion>();
	static{
		estado.add(new EstadoAccion(id++, "Disponible"));
		estado.add(new EstadoAccion(id++, "No Disponible"));
		estado.add(new EstadoAccion(id++, "Bloqueada"));
		estado.add(new EstadoAccion(id++, "En venta"));
		estado.add(new EstadoAccion(id++, "Congelada"));
		estado.add(new EstadoAccion(id++, "Eliminada"));
	}
	public static List<EstadoAccion> getEstado() {
		return estado;
	}
	public static void setEstado(List<EstadoAccion> estado) {
		EstadoAccionService.estado = estado;
	}

}
