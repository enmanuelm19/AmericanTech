//Created by: Enmanuel Medina, Team: O'Sullivan
package controllers;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Div;

public class ControllerNavigation extends GenericForwardComposer<Component>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private Div contenedor1;
	private Div contenedor;
	private Div contenido;
	private String pagina;
	
	
	//Configuracion
	public void onClick$btnPerfilClub(){
		
		pagina = "configuracion/perfilClub.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}

	
	public void onClick$btnJuntaDirectiva(){
		
		pagina = "configuracion/juntaDirectiva.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnPreferencias(){
		
		pagina = "configuracion/preferencia.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnInstalaciones(){
		
		pagina = "configuracion/gestionarInstalaciones.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnProveedores(){
		pagina = "configuracion/proveedores.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnPatrocinantes(){
		
		pagina = "configuracion/patrocinantes.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnReglas(){
		
		pagina = "configuracion/reglasClub.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	//Configuracion -> Categoria
	public void onClick$btnTipoSugerencia(){
		
		pagina = "configuracion/categoria/tipoSugerencia.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}

	public void onClick$btnTipoNoticia(){
		
		pagina = "configuracion/categoria/tipoNoticia.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnTipoEvento(){
		
		pagina = "configuracion/categoria/tipoEventoPrincipal.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnTipoPreferencia(){
		
		pagina = "configuracion/categoria/tipoPreferencia.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnTipoInstalacion(){
		
		pagina = "configuracion/categoria/tipoInstalacion.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnTipoSancion(){
		
		pagina = "configuracion/categoria/tiposSanciones.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnRecurso(){
		
		pagina = "configuracion/categoria/recursos.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnEstadoReservacion(){
		
		pagina = "configuracion/categoria/estadoReservacion.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnMotivoPostulacion(){
		
		pagina = "configuracion/categoria/motivoPostulacion.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnTipoActividad(){
		
		pagina = "configuracion/categoria/tipoActividad.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnMotivoVenta(){
		
		pagina = "configuracion/categoria/motivoVenta.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnTipoDesvinculacion(){
		
		pagina = "configuracion/categoria/tipoDesvinculacion.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnCargoJunta(){
		
		pagina = "configuracion/categoria/cargoJunta.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	//Socio
	public void onClick$btnAcciones(){
		
		pagina = "socio/acciones.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnMiPerfil(){
		
		pagina = "socio/miPerfil.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnMisSanciones(){
		
		pagina = "socio/misSanciones.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnSolicitarVenta(){
		
		pagina = "socio/solicitarVenta.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	//Socio -> Administrar Socio
	public void onClick$btnRegistrarSocio(){
		
		pagina = "socio/administrarSocio/postulantes.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnRegistro(){
		
		pagina = "socio/administrarSocio/registrarSocio.zul";
		contenedor1.getChildren().clear();
		contenedor1 = (Div) Executions.createComponents(pagina, null, null);
	}
	
	public void onClick$btnSanciones(){
		
		pagina = "socio/administrarSocio/sanciones.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnOpiniones(){
		
		pagina = "socio/administrarSocio/mostrarOpinion.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	//Socio -> Buzon
	public void onClick$btnSugerencias(){
		
		pagina = "socio/buzon/vistaGeneralSugerencias.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnOpinion(){
		pagina = "socio/buzon/opinionPostulacion.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	//Instalacion
	public void onClick$btnVisitas(){
		
		pagina = "instalacion/registrarVisita.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnMisReservaciones(){
		
		pagina = "instalacion/misReservaciones.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnAlquileres(){
		
		pagina = "instalacion/administrarAlquileres.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnMisAlquileres(){
		
		pagina = "instalacion/misAlquileres.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnEventualidades(){
		
		pagina = "instalacion/registrarEventualidadInst.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	//Evento
	public void onClick$btnSolicitudesEvento(){
		
		pagina = "evento/solicitudesEvento.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnRegistrarEvento(){
		
		pagina = "evento/administrarEvento/registrarEvento.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnPlanificarEvento(){
		
		pagina = "evento/administrarEvento/planificarEvento.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnEjecutarEvento(){
		
		pagina = "evento/administrarEvento/ejecutarEvento.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnCancelarEvento(){
		
		pagina = "evento/administrarEvento/cancelarEvento.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnEventualidadEvento(){
		
		pagina = "instalacion/registrarEventualidadInst.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	//Administracion
	public void onClick$btnUsuarioConsulta(){
		
		pagina = "administracion/seguridad/usuarioGeneral.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnUsuarioConsulta2(){
		
		pagina = "administracion/seguridad/usuarioGeneral.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnUsuarioConsulta3(){
		
		pagina = "administracion/seguridad/usuarioGeneral.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnGrupos(){
		
		pagina = "administracion/seguridad/mostrarGrupos.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnFunciones(){
		
		pagina = "administracion/seguridad/administrarFunciones.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnEmpleados(){
		
		pagina = "administracion/adjuntarEmpleados.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnCartelera(){
		
		pagina = "administracion/cartelera.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	
	public void onClick$btnPostulado(){
		
		pagina = "postulado/postulado.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
	//Consultas
	public void onClick$btnConsultaSugerencias(){
		
		pagina = "consultas/sugerencia.zul";
		contenido.getChildren().clear();
		contenedor = (Div) Executions.createComponents(pagina, null, null);
		contenido.appendChild(contenedor);
	}
}
