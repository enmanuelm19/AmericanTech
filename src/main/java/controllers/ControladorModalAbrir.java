package controllers;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;



public class ControladorModalAbrir extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;

	@Listen("onClick = #ccc")
	public void showModal(Event e) {
		//create a window programmatically and use it as a modal dialog.
		Window window = (Window)Executions.createComponents(
				"registrarTipoInstalacion.zul", null, null);
		window.doModal();
		
		
		
	}
	@Listen("onClick = #ddd")
	public void ikhjk(Event e) {
		//create a window programmatically and use it as a modal dialog.
		Window window = (Window)Executions.createComponents(
				"registrarTipoActividad.zul", null, null);
		window.doModal();
	
	}
	
	@Listen("onClick = #eee")
	public void kkkk(Event e) {
		//create a window programmatically and use it as a modal dialog.
		Window window = (Window)Executions.createComponents(
				"registrarTipoNoticia.zul", null, null);
		window.doModal();
	
	}
	
	@Listen("onClick = #fff")
	public void lll(Event e) {
		//create a window programmatically and use it as a modal dialog.
		Window window = (Window)Executions.createComponents(
				"registrarTipoSugerencia.zul", null, null);
		window.doModal();
	
	}
	
}
