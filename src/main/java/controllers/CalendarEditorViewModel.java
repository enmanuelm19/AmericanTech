package controllers;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Window;

import modelos.Evento;
import viewModel.CalendarioEvent;

public class CalendarEditorViewModel {

	private CalendarioEvent calendarEventData = new CalendarioEvent();

	private Evento eventoSelected = new Evento();

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
		}	
	}

	public Evento getEventoSelected() {
		return eventoSelected;
	}

	public void setEventoSelected(Evento eventoSelected) {
		this.eventoSelected = eventoSelected;
	}
	
	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}
}