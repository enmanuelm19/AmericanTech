package controllers;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;

public class ControllerRegistrarInstalaciones extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;

	@Listen("onClick = #btnInstalacionesRegistrar")
	public void showModalInstalaciones(Event e) {
		// create a window programmatically and use it as a modal dialog.
		Window window = (Window) Executions.createComponents("configuracion/registrarInstalacion.zul", null, null);
		window.doModal();
	}

}
