package service;

import java.util.ArrayList;
import java.util.List;

import models.TipoSugerencia;

public class TipoSugerenciaService {
	
	static int id=0;
	static List<TipoSugerencia> tipoS= new ArrayList<TipoSugerencia>();
	static List<TipoSugerencia> tipoActivos=new ArrayList<TipoSugerencia>();
	static{
		tipoS.add(new TipoSugerencia(id++, "sugerencia","A" ));
		tipoS.add(new TipoSugerencia(id++, "sugerencia","A" ));
		tipoS.add(new TipoSugerencia(id++, "sugerencia", "A" ));
	}
	
	
	public static List<TipoSugerencia> getTipoSugerencia() {
		tipoActivos=new ArrayList<TipoSugerencia>();
		for(int i=0; i<tipoS.size(); i++){
			if(tipoS.get(i).getEstatus()=="A")
				tipoActivos.add(tipoS.get(i));
		}
		return tipoActivos;
	}
	
	public static void agregarTipoSugerencia(TipoSugerencia tipo){
		tipo.setEstatus("A");
		tipo.setId(id++);
		tipoS.add(tipo);
	}
	
	public static void updateTipoSugerencia(TipoSugerencia tipo){
		for(int i=0; i<tipoS.size(); i++){
			if(tipoS.get(i).getId() == tipo.getId()){
				System.out.println("entro a editar");
				tipoS.set(i, tipo);
			}
		}
	}
	

}

