package controllers;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;

public class ControladorModalAbrir extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;

	@Listen("onClick = #btnRegTipoInstalacion")
	public void showModal(Event e) {
		// create a window programmatically and use it as a modal dialog.
		Window window = (Window) Executions.createComponents("configuracion/categoria/registrarTipoInstalacion.zul",
				null, null);
		window.doModal();
	}

	@Listen("onClick = #btnRegTipoActividad")
	public void ikhjk(Event e) {
		// create a window programmatically and use it as a modal dialog.
		Window window = (Window) Executions.createComponents("configuracion/categoria/registrarTipoActividad.zul", null,
				null);
		window.doModal();

	}

	@Listen("onClick = #btnRegistrarRecurso")
	public void showModalRecurso(Event e) {
		// create a window programmatically and use it as a modal dialog.
		Window window = (Window) Executions.createComponents("configuracion/categoria/registrarRecurso.zul", null,
				null);
		window.doModal();

	}

	@Listen("onClick = #btnRegTipoEvento")
	public void showModalTipoEvento(Event e) {
		// create a window programmatically and use it as a modal dialog.
		Window window = (Window) Executions.createComponents("configuracion/categoria/registrarTipoEvento.zul", null,
				null);
		window.doModal();

	}

	@Listen("onClick = #btnRegTipoPreferencia")
	public void showModalTipoPreferencia(Event e) {
		// create a window programmatically and use it as a modal dialog.
		Window window = (Window) Executions.createComponents("configuracion/categoria/registrarTipoPreferencia.zul",
				null, null);
		window.doModal();

	}

	@Listen("onClick = #btnRegTipoNoticia")
	public void kkkk(Event e) {
		// create a window programmatically and use it as a modal dialog.
		Window window = (Window) Executions.createComponents("configuracion/categoria/registrarTipoNoticia.zul", null,
				null);
		window.doModal();

	}

	@Listen("onClick = #btnTipoDesvinculacionRegistrar")
	public void showModalTipoDesvinculacion(Event e) {
		// create a window programmatically and use it as a modal dialog.
		Window window = (Window) Executions.createComponents("configuracion/categoria/registrarTipoDesvinculacion.zul",
				null, null);
		window.doModal();
	}

	@Listen("onClick = #btnPatrocinatesRegistrar")
	public void showModalPatrocinante(Event e) {
		// create a window programmatically and use it as a modal dialog.
		Window window = (Window) Executions.createComponents("configuracion/registrarPatrocinante.zul", null, null);
		window.doModal();
	}

	@Listen("onClick = #btnPreferenciasRegistrar")
	public void showModalPreferencia(Event e) {
		Window window = (Window) Executions.createComponents("configuracion/registrarPreferencias.zul", null, null);
		window.doModal();
	}

	@Listen("onClick = #btnProveedoresRegistrar")
	public void showModalProveedor(Event e) {
		// create a window programmatically and use it as a modal dialog.
		Window window = (Window) Executions.createComponents("configuracion/registrarProveedor.zul", null, null);
		window.doModal();
	}

	@Listen("onClick = #btnOpinionRegistrar")
	public void showModalOpinion(Event e) {
		// create a window programmatically and use it as a modal dialog.
		Window window = (Window) Executions.createComponents("socio/buzon/opinion.zul", null, null);
		window.doModal();
	}

	@Listen("onClick = #btnSolicitarAlquiler")
	public void showModalAlquiler(Event e) {
		// create a window programmatically and use it as a modal dialog.
		Window window = (Window) Executions.createComponents("instalacion/solicitudAlquiler.zul", null, null);
		window.doModal();
	}

	@Listen("onClick = #btnRegEstadoReservacion")
	public void showModalEstadoReservacion(Event e) {
		Window window = (Window) Executions.createComponents("configuracion/categoria/registrarEstadoReservacion.zul",
				null, null);
		window.doModal();
	}

	@Listen("onClick = #btnRegMotivoPostulacion")
	public void showModalMotivoPostulacion(Event e) {
		Window window = (Window) Executions.createComponents("configuracion/categoria/registrarMotivoPostulacion.zul",
				null, null);
		window.doModal();
	}

	@Listen("onClick = #btnRegCargos")
	public void showModalCargos(Event e) {
		Window window = (Window) Executions.createComponents("configuracion/categoria/registrarCargoJunta.zul", null,
				null);
		window.doModal();
	}

	@Command
	public void showModalOpiniones(Event e) {
		// create a window programmatically and use it as a modal dialog.
		Window window = (Window) Executions.createComponents("socio/administrarSocio/opinionesPostulante.zul", null,
				null);
		window.doModal();
	}
	
	@Listen("onClick = #btnRegMiembroJunta")
	public void showModalRegistrarMienbroJunta(Event e){
		Window window = (Window)Executions.createComponents("configuracion/registrarMiembroJunta.zul", null, null);
		window.doModal();
	}
	
	@Listen("onClick = #btnRegistrarReglas")
	public void showModalRegistrarReglasVisitas(Event e){
		Window window = (Window)Executions.createComponents("configuracion/registrarRegla.zul", null, null);
		window.doModal();
	}
	
	@Listen("onClick = #btnRegistrarReglasAfiliacion")
	public void showModalRegistrarReglasAfiliacion(Event e){
		Window window = (Window)Executions.createComponents("configuracion/registrarRegla.zul", null, null);
		window.doModal();
	}
	
	@Listen("onClick = #btnRegistrarPostulado")
	public void showModalRegistrarPostulado(Event e){
		Window window = (Window)Executions.createComponents("postulado/registrarPostulado.zul", null, null);
		window.doModal();
	}
	
	


}
