package controllers;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;


public class SocioController extends SelectorComposer<Component> {
	

	private static final long serialVersionUID = 1L;
	 
		
	 @Listen("onClick = #btnAgregar")
	 public void mostrarAfiliado(){
		 Window window = (Window)Executions.createComponents("socio/administrarSocio/registrarAfiliadoSocio.zul", null, null);
		 window.doModal();

	 }
	 @Listen("onClick = #btnRegistrarActividades")
	 public void mostrarRegistrarActividades(){
		 Window window = (Window)Executions.createComponents("administrarEvento/registrarActividad.zul", null, null);
		 window.doModal();

	 }
	 @Listen("onClick = #btnVerListaActividades")
	 public void mostrarListaActividades(){
		 Window window = (Window)Executions.createComponents("administrarEvento/listaActividades.zul", null, null);
		 window.doModal();

	 }
	


}



