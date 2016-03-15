package controllers;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModelList;

import models.Funcion;
import service.FuncionService;

public class FuncionViewModel {
	
	private List<Funcion> funciones = new ArrayList<Funcion>();
	
	public ListModelList<Funcion> getFunciones(){
		funciones = FuncionService.getFunciones();
		return new ListModelList<Funcion>(funciones);
		
	}

/* no le paren a esto
	public ListModelList<Funcion> getFunciones(){
		funciones = FuncionService.getFunciones();
		return new ListModelList<Funcion>(funciones);
		
	}


*/
}
