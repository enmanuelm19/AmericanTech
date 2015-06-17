package com.ucla.america.controllers;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;
import org.zkoss.zk.ui.*;

public class RegistrarEventualidadControlador extends SelectorComposer<Component> {
    private static final long serialVersionUID = 1L;
     
    @Listen("onClick = #btnRegistrar")
    public void showModal(Event e) {
        //create a window programmatically and use it as a modal dialog.
        Window window = (Window)Executions.createComponents(
                "/vistas/instalacion/dialogo/registrarEventualidadDialog.zul", null, null);
        window.doModal();
    }
}