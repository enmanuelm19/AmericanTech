package controllers;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;



public class ControladorModalAbrir extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;

	@Listen("onClick = #btnRegTipoInstalacion")
	public void showModal(Event e) {
		//create a window programmatically and use it as a modal dialog.
		Window window = (Window)Executions.createComponents(
				"registrarTipoInstalacion.zul", null, null);
		window.doModal();
		
		
		
	}
	@Listen("onClick = #btnRegTipoActividad")
	public void ikhjk(Event e) {
		//create a window programmatically and use it as a modal dialog.
		Window window = (Window)Executions.createComponents(
				"registrarTipoActividad.zul", null, null);
		window.doModal();
	
	}
	
	@Listen("onClick = #btnRegistrarRecurso")
	public void showModalRecurso(Event e) {
		//create a window programmatically and use it as a modal dialog.
		Window window = (Window)Executions.createComponents(
				"registrarRecurso.zul", null, null);
		window.doModal();
	
	}
	
	@Listen("onClick = #btnRegTipoEvento")
	public void showModalTipoEvento(Event e) {
		//create a window programmatically and use it as a modal dialog.
		Window window = (Window)Executions.createComponents(
				"registrarTipoEvento.zul", null, null);
		window.doModal();
	
	}
	
	@Listen("onClick = #btnRegTipoPreferencia")
	public void showModalTipoPreferencia(Event e) {
		//create a window programmatically and use it as a modal dialog.
		Window window = (Window)Executions.createComponents(
				"registrarTipoPreferencia.zul", null, null);
		window.doModal();
	
	}
	
	@Listen("onClick = #btnRegTipoNoticia")
	public void kkkk(Event e) {
		//create a window programmatically and use it as a modal dialog.
		Window window = (Window)Executions.createComponents(
				"registrarTipoNoticia.zul", null, null);
		window.doModal();
	
	}
	
	
	@Listen("onClick = #btnTipoDesvinculacionRegistrar")
    public void showModalTipoDesvinculacion(Event e) {
        //create a window programmatically and use it as a modal dialog.
        Window window = (Window)Executions.createComponents(
                "registrarTipoDesvinculacion.zul", null, null);
        window.doModal();
    }
	
	@Listen("onClick = #btnPatrocinatesRegistrar")
    public void showModalPatrocinante(Event e) {
        //create a window programmatically and use it as a modal dialog.
        Window window = (Window)Executions.createComponents(
                "registrarPatrocinante.zul", null, null);
        window.doModal();
    }
	

	@Listen("onClick = #btnProveedoresRegistrar")
    public void showModalProveedor(Event e) {
        //create a window programmatically and use it as a modal dialog.
        Window window = (Window)Executions.createComponents(
                "registrarProveedor.zul", null, null);
        window.doModal();
    }
	
	@Listen("onClick = #btnOpinionRegistrar")
    public void showModalOpinion(Event e) {
        //create a window programmatically and use it as a modal dialog.
        Window window = (Window)Executions.createComponents(
                "opinion.zul", null, null);
        window.doModal();
    }
	

	
}

