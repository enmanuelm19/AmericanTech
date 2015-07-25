//Created by: Enmanuel Medina, Team: O'Sullivan
package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.EstadoSolicitud;
import models.Socio;
import models.SolicitudEvento;

public class EstadoSolicitudService {

	static int id=0;
	static SolicitudEvento solicitud = new SolicitudEvento(id++, new Date(), "Dia del socio del america xD", new Date(),new Socio(id++,"123124",PersonaService.getPer().get(1)));
	static List<EstadoSolicitud> estados = new ArrayList<EstadoSolicitud>();
	static{
		estados.add(new EstadoSolicitud(id++,"Aprobado",solicitud));
		estados.add(new EstadoSolicitud(id++,"Rechazado",solicitud));
		estados.add(new EstadoSolicitud(id++,"En espera",solicitud));
		estados.add(new EstadoSolicitud(id++,"Cancelado",solicitud));
	}
	public static List<EstadoSolicitud> getEstados() {
		return estados;
	}
	public static void setEstados(List<EstadoSolicitud> estados) {
		EstadoSolicitudService.estados = estados;
	}
	
	
}
