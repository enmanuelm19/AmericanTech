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
	 public void mostrarAfiliado(){
		 Window window = (Window)Executions.createComponents("socio/verAfiliadoSocio.zul", null, null);
		 window.doModal();

	 }
	 @Listen("onClick = #btnVerListaActividades")
	 public void mostrarListaActividades(){
		 Window window = (Window)Executions.createComponents("evento/administrarEvento/listaActividades.zul", null, null);
		 window.doModal();

	 }

	 @Listen("onClick = #btnRegistrarMotivoVenta")
	 public void mostrarRegistrarMotivoVenta(){
		 Window window = (Window)Executions.createComponents("configuracion/categoria/registrarMotivoVenta.zul", null, null);
		 window.doModal();

	 }
	 @Listen("onClick = #btnEditarMotivoVenta")
	 public void mostrarEditarMotivoVenta(){
		 Window window = (Window)Executions.createComponents("registrarMotivoVenta.zul", null, null);
		 window.doModal();

	 }


}






