package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import models.Funcion;
import models.Grupo;

import org.apache.poi.hssf.record.ArrayRecord;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

public class grupoGeneralViewModel {
	private Grupo grupo = new Grupo();
	private static List<Grupo> gruposAll=new ArrayList<Grupo>(); //Coleccion que tiene que ser estatica.. esta se va a usar como referencia en el filtro

	private List<Grupo> grupoTodos=gruposAll;//Coleccion con que se llenara la grid
	private List<Funcion> funcionAll=new ArrayList<Funcion>();
	
	static {
    	gruposAll.add(new Grupo(1,"Administracion"));
    	gruposAll.add(new Grupo(2,"Secretaria"));
    	gruposAll.add(new Grupo(3,"Socios"));
    	gruposAll.add(new Grupo(4,"Empleados"));
    	gruposAll.add(new Grupo(5,"Junta Directiva"));
    	gruposAll.add(new Grupo(6,"Presidencia"));
    	gruposAll.add(new Grupo(7,"VicePresidencia"));
    	gruposAll.add(new Grupo(8,"Gerencia"));
    }
    
	//Metodo que se llama para llenar la grid
    public ListModelList<Grupo> getGruposAll() {
		return new ListModelList<Grupo>(grupoTodos);
	}
    public ListModelList<Funcion> getFuncionAll(){
    	return new ListModelList<Funcion>(funcionAll);
    }
    public Grupo getGrupo(){
    	return grupo;
    }
    
	 @Command
	 public void showModal(Event e) {
		 Window window = (Window)Executions.createComponents("registrarGrupo.zul", null, null);
	     	window.doModal();
	 }
	 	
	 @Command
	 @NotifyChange("gruposAll")//Notificar que hay cambios en el metodo getGruposAll()
	 public void filtroGrupo() {
		 grupoTodos=getGruposFiltros(grupo);
	 }
	 
	 //Metodo que se Llama en el campo filtro..
	 public List<Grupo> getGruposFiltros(Grupo g){
		 List<Grupo> grup = new ArrayList<Grupo>();
		String desc = g.getDescFiltro().toLowerCase();//asignar las letras escritas en el campo filtro
		for (Iterator<Grupo> i = gruposAll.iterator(); i.hasNext();) {
			Grupo tmp = i.next();
			if (tmp.getDescripcion().toLowerCase().contains(desc)) {//comparo si en el campo descripcion estan las letras que tipee.
				grup.add(tmp);
			}
		}
			return grup; 
	 }
	 
	 @Command
	 @NotifyChange("funcionAll")
	 public void funcionesGrupo(@BindingParam("Grupo") Grupo g){
		 funcionAll= (List<Funcion>) g.getFunciones();
	 }
	 
}
