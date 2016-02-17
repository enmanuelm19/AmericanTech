package service;

import java.util.ArrayList;
import java.util.List;
import models.TipoInstalacion;


public class TipoInstalacionService {
	static int id = 1;
	static List<TipoInstalacion> tipoI = new ArrayList<TipoInstalacion>();
	static List<TipoInstalacion> tipoActivos = new ArrayList<TipoInstalacion>();
	static{
		tipoI.add(new TipoInstalacion(id++, "Caney", "A"));
		tipoI.add(new TipoInstalacion(id++, "Salon", "A"));
		tipoI.add(new TipoInstalacion(id++, "Campo Deportivo", "A"));
		tipoI.add(new TipoInstalacion(id++, "Areas Verdes", "A"));
		tipoI.add(new TipoInstalacion(id++, "Piscina", "A"));
	}
	
	public static List<TipoInstalacion> getTipoInstalacion(){
		tipoActivos = new ArrayList<TipoInstalacion>();
		for(int i=0; i<tipoI.size(); i++){
			if(tipoI.get(i).getEstatus()=="A"){
				tipoActivos.add(tipoI.get(i));
			}
		}
		return tipoActivos;
	}
	
	public void agregarTipoInstalacion(TipoInstalacion tipo){
		tipo.setId(id++);
		tipo.setEstatus("A");
		tipoI.add(tipo);
	}
	
	public void updateTipoInstalacion(TipoInstalacion tipo){
		for(int i=0; i<tipoI.size(); i++){
			if(tipoI.get(i).getId() == tipo.getId()){
				tipoI.set(i, tipo);
			}
		}
	}
	
	
}
