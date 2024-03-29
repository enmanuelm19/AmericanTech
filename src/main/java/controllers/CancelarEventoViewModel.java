package controllers;

import java.util.List;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;
import Dao.EstadoEventoDao;
import Dao.EventoDao;
import Dao.MotivoCancelacionDao;
import Dao.NoticiaDao;
import modelos.CancelacionEvento;
import modelos.Evento;
import modelos.MotivoCancelacion;
import modelos.Noticia;

public class CancelarEventoViewModel {

	private Evento evento;
	private MotivoCancelacionDao motivoDao;
	private EventoDao eventoDao;
	private EstadoEventoDao estadoDao;
	private MotivoCancelacion motivoCancelacion;
	private CancelacionEvento cancelacionEvento;
	private NoticiaDao noticiaDao;

	@Init
	public void init(@ExecutionArgParam("evento") Evento evento) {
		this.evento = evento;
		motivoDao = new MotivoCancelacionDao();
		eventoDao = new EventoDao();
		motivoCancelacion = new MotivoCancelacion();
		cancelacionEvento = new CancelacionEvento();
		estadoDao = new EstadoEventoDao();
		noticiaDao = new NoticiaDao();
	}

	public List<MotivoCancelacion> getMotivosCancelacion() throws Exception {
		return motivoDao.obtenerTodos();
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public MotivoCancelacion getMotivoCancelacion() {
		return motivoCancelacion;
	}

	public void setMotivoCancelacion(MotivoCancelacion motivoCancelacion) {
		this.motivoCancelacion = motivoCancelacion;
	}

	public CancelacionEvento getCancelacionEvento() {
		return cancelacionEvento;
	}

	public void setCancelacionEvento(CancelacionEvento cancelacionEvento) {
		this.cancelacionEvento = cancelacionEvento;
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {
		if (motivoCancelacion != null && cancelacionEvento.getDescipcion() != null
				&& !cancelacionEvento.getDescipcion().equals("")) {
			cancelacionEvento.setMotivoCancelacion(motivoCancelacion);
			evento.setCancelacionEvento(cancelacionEvento);
			evento.setEstadoEvento(estadoDao.obtenerEstadoEvento(5));
			cancelarNoticia();
			eventoDao.actualizarEvento(evento);
			Messagebox.show("El evento " + evento.getNombre() + " ha sido cancelado exitosamente", "", Messagebox.OK,
					Messagebox.INFORMATION);
			win.detach();
			BindUtils.postGlobalCommand(null, null, "refreshEventos", null);
		}

	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	public void cancelarNoticia() throws Exception {
		
		Noticia noticia = evento.getNoticias().iterator().next();

		noticia.setTitulo("Cancelacion del evento " + evento.getNombre());
		noticia.setDescripcion(
				"Se le informa a nuestra familia americanista la cancelacion del evento: " + evento.getNombre()
						+ " por motivo: " + evento.getCancelacionEvento().getMotivoCancelacion().getDescripcion() + "; "
						+ evento.getCancelacionEvento().getDescipcion());
		
		noticiaDao.actualizarNoticia(noticia);
	}

}