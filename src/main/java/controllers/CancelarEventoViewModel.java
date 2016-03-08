package controllers;




import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;



import modelos.Evento;


public class CancelarEventoViewModel {

		private Evento evento;
		
		@Init
		public void init(@ExecutionArgParam("evento") Evento evento) {
			this.evento = evento;
		}
		
		public Evento getEvento() {
			return evento;
		}

		public void setEvento(Evento evento) {
			this.evento = evento;
		}



		@Command
		public void guardar(){
			
		}
		
}