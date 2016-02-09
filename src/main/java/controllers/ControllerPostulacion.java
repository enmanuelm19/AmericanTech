package controllers;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;

public class ControllerPostulacion extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;

	@Listen("onClick = #btnRegistrarPostulado")
	public void showModalRegistrarPostulado(Event e) {
		Window window = (Window) Executions.createComponents("postulado/registrarPostulado.zul", null, null);
		window.doModal();
	}
}
