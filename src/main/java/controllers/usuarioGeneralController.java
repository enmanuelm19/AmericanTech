package controllers;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;

public class usuarioGeneralController extends SelectorComposer<Component>{
	 private static final long serialVersionUID = 1L;
	 
	 @Listen("onClick = #btnUsuarioGeneralReg")
	    public void showModal(Event e) {
	        //create a window programmatically and use it as a modal dialog.
	        Window window = (Window)Executions.createComponents(
	                "agregarUsuario.zul", null, null);
	        window.doModal();
	    }
	}