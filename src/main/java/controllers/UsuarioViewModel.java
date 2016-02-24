package controllers;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.Window;

public class UsuarioViewModel extends SelectorComposer<Component>{
	private static final long serialVersionUID = 1L;

	@Command
	public void showModal(Event e) {
		//create a window programmatically and use it as a modal dialog.
		Window window = (Window)Executions.createComponents(
				"administracion/seguridad/agregarUsuario.zul", null, null);
		window.doModal();
	}
}
