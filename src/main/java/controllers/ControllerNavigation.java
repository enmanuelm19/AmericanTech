//Created by: Enmanuel Medina, Team: O'Sullivan
package controllers;

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
	@Wire
	private Navitem btnReglas;
	//Configuracion -> Categorias
	@Wire
	private Navitem btnTipoSugerencia;
	@Wire
	private Navitem btnTipoNoticia;
	@Wire
	private Navitem btnTipoEvento;
	@Wire
	private Navitem btnTipoPreferencia;
	@Wire
	private Navitem btnTipoInstalacion;
	@Wire
	private Navitem btnTipoSancion;
	@Wire
	private Navitem btnRecurso;
	@Wire
	private Navitem btnEstadoReservacion;
	@Wire
	private Navitem btnMotivoPostulacion;
	
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
		
		pagina = "configuracion/preferencia.zul";
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
	
	public void onClick$btnReglas(){
		
		pagina = "configuracion/reglasClub.zul";
		contenido.getChildren().clear();
		contenido = (Div) Executions.createComponents(pagina, null, null);
	}
	
	//Configuracion -> Categoria
	public void onClick$btnTipoSugerencia(){
		
		pagina = "configuracion/categoria/tipoSugerencia.zul";
		contenido.getChildren().clear();
		contenido = (Div) Executions.createComponents(pagina, null, null);
	}

	public void onClick$btnTipoNoticia(){
		
		pagina = "configuracion/categoria/tipoNoticia.zul";
		contenido.getChildren().clear();
		contenido = (Div) Executions.createComponents(pagina, null, null);
	}
	
	public void onClick$btnTipoEvento(){
		
		pagina = "configuracion/categoria/tipoEventoPrincipal.zul";
		contenido.getChildren().clear();
		contenido = (Div) Executions.createComponents(pagina, null, null);
	}
	
	public void onClick$btnTipoPreferencia(){
		
		pagina = "configuracion/categoria/tipoPreferencia.zul";
		contenido.getChildren().clear();
		contenido = (Div) Executions.createComponents(pagina, null, null);
	}
	
	public void onClick$btnTipoInstalacion(){
		
		pagina = "configuracion/categoria/tipoInstalacion.zul";
		contenido.getChildren().clear();
		contenido = (Div) Executions.createComponents(pagina, null, null);
	}
	
	public void onClick$btnTipoSancion(){
		
		pagina = "configuracion/categoria/tiposSanciones.zul";
		contenido.getChildren().clear();
		contenido = (Div) Executions.createComponents(pagina, null, null);
	}
	
	public void onClick$btnRecurso(){
		
		pagina = "configuracion/categoria/recursos.zul";
		contenido.getChildren().clear();
		contenido = (Div) Executions.createComponents(pagina, null, null);
	}
	
	public void onClick$btnEstadoReservacion(){
		
		pagina = "configuracion/categoria/estadoReservacion.zul";
		contenido.getChildren().clear();
		contenido = (Div) Executions.createComponents(pagina, null, null);
	}
	
	public void onClick$btnMotivoPostulacion(){
		
		pagina = "configuracion/categoria/motivoPostulacion.zul";
		contenido.getChildren().clear();
		contenido = (Div) Executions.createComponents(pagina, null, null);
	}
}
