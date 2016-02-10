package controllers;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;

public class ControllerRegistrarAfiliado extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;

	@Listen("onClick = #btnverAfiliado")
	public void showModalRegistrarMienbroJunta(Event e){
		Window window = (Window)Executions.createComponents("socio/administrarSocio/registrarAfiliado.zul", null, null);
		window.doModal();
	}
}
