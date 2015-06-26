package controllers;



import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;

public class ControllerInicioSesion extends SelectorComposer<Component>{
	
	@Listen("onClick =#linkRecuperarContrasenna")
	public void showModal(Event e){
		Window window = (Window)Executions.createComponents(
                "recuperarContrasenna.zul", null, null);
        window.doModal();
	}

}
