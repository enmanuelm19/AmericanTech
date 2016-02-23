package controllers;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;

public class ControllerEvento extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;
	 
	 @Listen("onClick = #btnRegistrarActividad")
	    public void showModalRegistrarActividades(Event e) {
	        //create a window programmatically and use it as a modal dialog.
	        Window window = (Window)Executions.createComponents(
	                "evento/administrarEvento/registrarActividad.zul", null, null);
	        window.doModal();
	    }
	 
	 @Listen("onClick = #btnCancelar")
	    public void showModalCancelarEvento(Event e) {
	        //create a window programmatically and use it as a modal dialog.
	        Window window = (Window)Executions.createComponents(
	                "evento/administrarEvento/cancelar.zul", null, null);
	        window.doModal();
	    }
	 
	 @Listen("onClick = #btnRegistrarEvento")
	    public void showModalRegistarEvento(Event e) {
	        //create a window programmatically and use it as a modal dialog.
	        Window window = (Window)Executions.createComponents(
	                "evento/administrarEvento/registrarEvento.zul", null, null);
	        window.doModal();
	    }
	 
	 @Listen("onClick = #btnEditarEvento")
	    public void showModalEditarEvento(Event e) {
	        //create a window programmatically and use it as a modal dialog.
	        Window window = (Window)Executions.createComponents(
	                "evento/administrarEvento/registrarEvento.zul", null, null);
	        window.doModal();
	    }
	 
	 @Listen("onClick = #btnEstadoEvento")
	 public void mostrarAfiliado(){
		 Window window = (Window)Executions.createComponents("evento/administrarEvento/finalizarEvento.zul", null, null);
		 window.doModal();

	 }
	

}
