//Created by: Enmanuel Medina, Team: O'Sullivan
package service;


import java.util.ArrayList;
import java.util.List;

import models.Cargo;

public class CargoService {
	
	static int id = 0;
	static List<Cargo> cargos = new ArrayList<Cargo>();
	static{
		cargos.add(new Cargo(id++, "Presidente"));
		cargos.add(new Cargo(id++, "Vicepresidente1"));
		cargos.add(new Cargo(id++, "Vicepresidente2"));
		cargos.add(new Cargo(id++, "Tesorero"));
		cargos.add(new Cargo(id++, "Presidente Tribunal Disciplinario"));
	}
	public static List<Cargo> getCargos() {
		return cargos;
	}
	public static void setCargos(List<Cargo> cargos) {
		CargoService.cargos = cargos;
	}

}
