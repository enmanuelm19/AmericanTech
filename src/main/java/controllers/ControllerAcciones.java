package controllers;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;

public class ControllerAcciones extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;
	 
	 @Listen("onClick = #btnRegAcciones")
	    public void showModal(Event e) {
	        //create a window programmatically and use it as a modal dialog.
	        Window window = (Window)Executions.createComponents(
	                "registrarAccion.zul", null, null);
	        window.doModal();
	    }
	 
	 @Listen("onClick = #btnDesvincular")
	    public void showModal1(Event e) {
	        //create a window programmatically and use it as a modal dialog.
	        Window window = (Window)Executions.createComponents(
	                "desvincularAccion.zul", null, null);
	        window.doModal();
	    }
	 @Listen("onClick = #btnDesvincular1")
	    public void showModal2(Event e) {
	        //create a window programmatically and use it as a modal dialog.
	        Window window = (Window)Executions.createComponents(
	                "desvincularAccion.zul", null, null);
	        window.doModal();
	    }
	 @Listen("onClick = #btnDesvincular2")
	    public void showModal3(Event e) {
	        //create a window programmatically and use it as a modal dialog.
	        Window window = (Window)Executions.createComponents(
	                "desvincularAccion.zul", null, null);
	        window.doModal();
	    }

}
