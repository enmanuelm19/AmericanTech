//Created by: Enmanuel Medina, Team: O'Sullivan
package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Accion;
import models.Desvinculacion;
import models.MotivoDesvinculacion;

public class DesvinculacionService {

	static int id=0;
	static List<Desvinculacion> desvinculaciones = new ArrayList<Desvinculacion>();
	static List<Accion> acciones = AccionService.getAcciones();
	static List<MotivoDesvinculacion> motivos = MotivoDesvinculacionService.getMo();
	static{
		desvinculaciones.add(new Desvinculacion(id++, new Date(), "Por vago", acciones.get(2), motivos.get(1), acciones.get(2).getSocioId()));
	}
	public static List<Desvinculacion> getDesvinculaciones() {
		return desvinculaciones;
	}
	public static void setDesvinculaciones(List<Desvinculacion> desvinculaciones) {
		DesvinculacionService.desvinculaciones = desvinculaciones;
	}
	
}
