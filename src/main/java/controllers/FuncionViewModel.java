package controllers;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.ListModelList;

import Dao.FuncionDao;
import modelos.Funcion;



public class FuncionViewModel {
	
	private List<Funcion> funciones = new ArrayList<Funcion>();
	private FuncionDao funcionDao = new FuncionDao();
	
	public ListModelList<Funcion> getFunciones() throws Exception{
		funciones = funcionDao.obtenerTodos();
		return new ListModelList<Funcion>(funciones);
		
	}

}
