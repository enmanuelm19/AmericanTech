package controllers;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Window;

import Dao.InstalacionEventoDao;
import modelos.Evento;
import modelos.Foto;
import modelos.InstalacionEvento;
import viewModel.CalendarioEvent;

public class ExternalCalendarEditorViewModel {

	private CalendarioEvent calendarEventData = new CalendarioEvent();

	private Evento eventoSelected = new Evento();

	private String imagenInstalacion;

	private boolean visible = false;

	public CalendarioEvent getCalendarEvent() {
		return calendarEventData;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Init
	public void init(@ExecutionArgParam("evento") Evento evento) {
		if (evento != null) {
			setEventoSelected(evento);
			for (InstalacionEvento instalacionE : getEventoSelected().getInstalacionEventos()) {
				for (Foto foto : instalacionE.getInstalacion().getFotos()) {
					setImagenInstalacion(foto.getUrl());
				}
			}
		}
	}

	public Evento getEventoSelected() {
		return eventoSelected;
	}

	public void setEventoSelected(Evento eventoSelected) {
		this.eventoSelected = eventoSelected;
	}

	public String getImagenInstalacion() {
		return imagenInstalacion;
	}

	public void setImagenInstalacion(String imagenInstalacion) {
		this.imagenInstalacion = imagenInstalacion;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}
}