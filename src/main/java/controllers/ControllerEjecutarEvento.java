package controllers;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;

public class ControllerEjecutarEvento extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;
	 
	 @Listen("onClick = #btnMostrar1")
	    public void showModal(Event e) {
	        //create a window programmatically and use it as a modal dialog.
	        Window window = (Window)Executions.createComponents(
	                "evento/administrarEvento/listaTareas.zul", null, null);
	        window.doModal();
	    }
	 
	 @Listen("onClick = #btnMostrar2")
	    public void showModal1(Event e) {
	        //create a window programmatically and use it as a modal dialog.
	        Window window = (Window)Executions.createComponents(
	                "evento/administrarEvento/listaTareas.zul", null, null);
	        window.doModal();
	    }
}
