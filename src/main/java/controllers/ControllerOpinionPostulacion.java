package controllers;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;

public class ControllerOpinionPostulacion extends SelectorComposer<Component> {
	@Listen("onClick = #btnOpinionRegistrar")
	public void showModalOpinion(Event e) {
		// create a window programmatically and use it as a modal dialog.
		Window window = (Window) Executions.createComponents("socio/buzon/registrarOpinion.zul", null, null);
		window.doModal();
	}
}
