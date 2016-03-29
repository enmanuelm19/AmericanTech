package controllers;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Window;

import Dao.InstalacionEventoDao;
import Dao.NoticiaDao;
import modelos.Evento;
import modelos.Foto;
import modelos.InstalacionEvento;
import modelos.Noticia;
import viewModel.CalendarioEvent;

public class CalendarEditorViewModel {

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
			try {
				for (Noticia noticia : new NoticiaDao().obtenerNoticiasevento(getEventoSelected())) {				
						setImagenInstalacion(noticia.getFoto());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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