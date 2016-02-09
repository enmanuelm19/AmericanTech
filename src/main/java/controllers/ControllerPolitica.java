package controllers;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;

public class ControllerPolitica extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;

	@Listen("onClick = #btnRegistrarReglas")
	public void showModalRegistrarReglasVisitas(Event e) {
		Window window = (Window) Executions.createComponents("configuracion/registrarRegla.zul", null, null);
		window.doModal();
	}

	@Listen("onClick = #btnRegistrarReglasAfiliacion")
	public void showModalRegistrarReglasAfiliacion(Event e) {
		Window window = (Window) Executions.createComponents("configuracion/registrarRegla.zul", null, null);
		window.doModal();
	}

}
