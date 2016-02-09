package controllers;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;

public class ControllerSugerenciasSocio extends SelectorComposer<Component> {

	 
	 @Listen("onClick = #btnNuevaSugerencia")
	 public void mostrarRegistrarSugerencia(){
		 Window window = (Window)Executions.createComponents("socio/buzon/registrarSugerencia.zul", null, null);
		 window.doModal();

	 }
}
