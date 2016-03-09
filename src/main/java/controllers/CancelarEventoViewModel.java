package controllers;




import java.util.List;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;
import Dao.EventoDao;
import Dao.MotivoCancelacionDao;
import modelos.CancelacionEvento;
import modelos.Evento;
import modelos.MotivoCancelacion;


public class CancelarEventoViewModel {

		private Evento evento;
		private MotivoCancelacionDao motivoDao;
		private EventoDao eventoDao;
		private MotivoCancelacion motivoCancelacion;
		private CancelacionEvento cancelacionEvento;
		
		@Init
		public void init(@ExecutionArgParam("evento") Evento evento) {
			this.evento = evento;
			motivoDao = new MotivoCancelacionDao();
			eventoDao = new EventoDao();
			motivoCancelacion = new MotivoCancelacion();
			cancelacionEvento = new CancelacionEvento();
		}
		
		public List<MotivoCancelacion> getMotivosCancelacion() throws Exception{
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
		public void guardar(@BindingParam("win") Window win) throws Exception{
			if(motivoCancelacion!=null && cancelacionEvento.getDescipcion()!=null && !cancelacionEvento.getDescipcion().equals("")){
				cancelacionEvento.setMotivoCancelacion(motivoCancelacion);
				evento.setCancelacionEvento(cancelacionEvento);
				eventoDao.actualizarEvento(evento);
				Messagebox.show(
						"El evento " + evento.getNombre()
								+ " ha sido cancelado exitosamente", "",
						Messagebox.OK, Messagebox.INFORMATION);
				win.detach();
				BindUtils.postGlobalCommand(null, null, "refreshEventos", null);
			}
				
		}
		
		@Command
		public void cerrarModal(@BindingParam("win") Window win) {
			win.detach();
		}
		
}