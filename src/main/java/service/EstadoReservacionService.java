//Created by: Enmanuel Medina, Team: O'Sullivan
package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.EstadoReservacion;
import models.Reservacion;
import models.Socio;

public class EstadoReservacionService {

	static int id=0;
	static Reservacion reservacion = new Reservacion(id++, new Date(), new Date(), new Date(), InstalacionService.getInstalacions().get(1), new Socio(id++,"12345",PersonaService.getPer().get(1)));
	static List<EstadoReservacion> estados = new ArrayList<EstadoReservacion>();
	static{
		estados.add(new EstadoReservacion(id++, "Aprobado", reservacion));
		estados.add(new EstadoReservacion(id++, "Rechazado", reservacion));
		estados.add(new EstadoReservacion(id++, "En espera", reservacion));
		estados.add(new EstadoReservacion(id++, "Pospuesto", reservacion));
	}
	public static List<EstadoReservacion> getEstados() {
		return estados;
	}
	public static void setEstados(List<EstadoReservacion> estados) {
		EstadoReservacionService.estados = estados;
	}
	
	
}
