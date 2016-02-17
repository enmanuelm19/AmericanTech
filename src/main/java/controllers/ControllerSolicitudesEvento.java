package controllers;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;

public class ControllerSolicitudesEvento extends SelectorComposer<Component> {
	
	private static final long serialVersionUID = 1L;

	@Listen("onClick = #btnSolicitarEvento")
	public void showModal(Event e) {
		// create a window programmatically and use it as a modal dialog.
		Window window = (Window) Executions.createComponents("evento/solicitarEvento.zul",null, null);
		window.doModal();
	}
	
	@Listen("onClick = #btnAprobar")
	public void showModalSolicitudes(Event e) {
		// create a window programmatically and use it as a modal dialog.
		Window window = (Window) Executions.createComponents("evento/administrarEvento/registrarEvento.zul",null, null);
		window.doModal();
	}
	
	@Listen("onClick = #btnCancelar")
	public void showModalCancelar(Event e) {
		// create a window programmatically and use it as a modal dialog.
		Window window = (Window) Executions.createComponents("evento/administrarEvento/cancelar.zul",null, null);
		window.doModal();
	}
	
	
	
	

}
