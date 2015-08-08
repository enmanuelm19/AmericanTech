package controllers;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Window;

public class gestionarInstalacionesViewModel {
	@Command
    public void showModalRegInst(Event e) {
        //create a window programmatically and use it as a modal dialog.
        Window window = (Window)Executions.createComponents(
                "configuracion/registrarInstalacion.zul", null, null);
        window.doModal();
    }
}
