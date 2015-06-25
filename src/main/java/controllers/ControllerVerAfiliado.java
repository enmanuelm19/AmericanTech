//Responsable Hector Gil
package controllers;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;


public class ControllerVerAfiliado extends SelectorComposer<Component> {
	

	private static final long serialVersionUID = 1L;
	 
		
	 @Listen("onClick = #btnVerAfiliado")
	 public void mostrar(){
		 Window window = (Window)Executions.createComponents("verAfiliadoSocio.zul", null, null);
		 window.doModal();

	 }

}



