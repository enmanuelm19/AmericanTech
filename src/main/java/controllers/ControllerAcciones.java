package controllers;
import java.util.List;

import models.Accion;
import models.Grupo;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

import service.AccionService;

public class ControllerAcciones {
	
	 
	    @Command
	    public void showModal(Event e) {
	        //create a window programmatically and use it as a modal dialog.
	        Window window = (Window)Executions.createComponents(
	                "registrarAccion.zul", null, null);
	        window.doModal();
	    }
	 
	    @Command
	    public void showModal1(Event e) {
	        //create a window programmatically and use it as a modal dialog.
	        Window window = (Window)Executions.createComponents(
	                "desvincularAccion.zul", null, null);
	        window.doModal();
	    }
	    @Command
	    public void showModal2(Event e) {
	        //create a window programmatically and use it as a modal dialog.
	        Window window = (Window)Executions.createComponents(
	                "desvincularAccion.zul", null, null);
	        window.doModal();
	    }
	    @Command
	    public void showModal3(Event e) {
	        //create a window programmatically and use it as a modal dialog.
	        Window window = (Window)Executions.createComponents(
	                "desvincularAccion.zul", null, null);
	        window.doModal();
	    }
	 
	 private List<Accion> listaAcciones = AccionService.getAcciones();
	 public ListModelList<Accion> getAccionesAll() {
		 
			return new ListModelList<Accion>(listaAcciones);
		}

}
