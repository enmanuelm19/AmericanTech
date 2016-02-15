package service;

import java.util.ArrayList;
import java.util.List;

import models.TipoEvento;

public class TipoEventoService {
	static int id=0;
	static List<TipoEvento> tipoE= new ArrayList<TipoEvento>();
	static List<TipoEvento> tipoActivos=new ArrayList<TipoEvento>();
	static{
		tipoE.add(new TipoEvento(id++, "Familiar","A" ));
		tipoE.add(new TipoEvento(id++, "Musical","A" ));
		tipoE.add(new TipoEvento(id++, "Cultural", "A" ));
	}
	
	public static List<TipoEvento> getTipoEvento() {
		tipoActivos=new ArrayList<TipoEvento>();
		for(int i=0; i<tipoE.size(); i++){
			if(tipoE.get(i).getEstatus()=="A")
				tipoActivos.add(tipoE.get(i));
		}
		return tipoActivos;
	}
	
	public void agregarTipoEvento(TipoEvento tipo){
		tipo.setEstatus("A");
		tipo.setId(id);
		tipoE.add(tipo);
	}
	
	public void updateTipoEvento(TipoEvento tipo){
		for(int i=0; i<tipoE.size(); i++){
			if(tipoE.get(i).getId() == tipo.getId()){
				tipoE.set(i, tipo);
			}
		}
	}
	

}
