package controllers;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;

public class ControllerCancelarEvento extends SelectorComposer<Component> {
	

	private static final long serialVersionUID = 1L;
	 
		
	 @Listen("onClick = #btnCancelarEvento")
	 public void mostrarAfiliado(){
		 Window window = (Window)Executions.createComponents("evento/administrarEvento/cancelar.zul", null, null);
		 window.doModal();

	 }
}
