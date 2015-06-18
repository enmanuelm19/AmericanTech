package com.ucla.america.controllers;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.Window;




public class ControladoRegistrarInformacion extends GenericForwardComposer<Component> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Wire
	private Button btnbuscar;
	@Wire
	private Vbox principal;
	@Wire
	private Combobox cmbnoticia;
	@Wire
	private Div padre;
	public void onClick$btnbuscar(){
		String valor= cmbnoticia.getRawText().toString();
		String elzul;
		if (valor.equalsIgnoreCase("Operacion Accion"))
		{
			elzul="registrarInformacionAccion.zul";
		}
		else {
			elzul="registrarInformacion"+valor+".zul";
		}
		
			
		padre.getChildren().clear();
		Vbox formulario = (Vbox) Executions.createComponents(elzul, null, null);
		padre.appendChild(formulario);
		
		
		
	}
	
	

}
