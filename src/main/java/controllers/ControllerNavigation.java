//Created by: Enmanuel Medina, Team: O'Sullivan
package controllers;

import org.apache.poi.hssf.record.formula.functions.Na;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkmax.zul.Navitem;
import org.zkoss.zul.Div;

public class ControllerNavigation extends GenericForwardComposer<Component>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Configuracion
	@Wire
	private Navitem btnPerfilClub;
	@Wire
	private Navitem btnJuntaDirectiva;
	@Wire
	private Navitem btnPreferencias;
	@Wire
	private Navitem btnInstalaciones;
	@Wire
	private Navitem btnProveedores;
	@Wire
	private Navitem btnPatrocinantes;
	//Configuracion -> Categorias
	
	private Div contenido;
	private String pagina;
	
	
	//Configuracion
	public void onClick$btnPerfilClub(){
		
		pagina = "configuracion/perfilClub.zul";
		contenido.getChildren().clear();
		contenido = (Div) Executions.createComponents(pagina, null, null);
	}

	
	public void onClick$btnJuntaDirectiva(){
		
		pagina = "configuracion/juntaDirectiva.zul";
		contenido.getChildren().clear();
		contenido = (Div) Executions.createComponents(pagina, null, null);
	}
	
	public void onClick$btnPreferencias(){
		
		pagina = "configuracion/Preferencia.zul";
		contenido.getChildren().clear();
		contenido = (Div) Executions.createComponents(pagina, null, null);
	}
	
	public void onClick$btnInstalaciones(){
		
		pagina = "configuracion/gestionarInstalaciones.zul";
		contenido.getChildren().clear();
		contenido = (Div) Executions.createComponents(pagina, null, null);
	}
	
	public void onClick$btnProveedores(){
		System.out.println("ola");
		pagina = "configuracion/proveedores.zul";
		contenido.getChildren().clear();
		contenido = (Div) Executions.createComponents(pagina, null, null);
	}
	
	public void onClick$btnPatrocinantes(){
		
		pagina = "configuracion/patrocinantes.zul";
		contenido.getChildren().clear();
		contenido = (Div) Executions.createComponents(pagina, null, null);
	}

}
