package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;
import Dao.EventoDao;
import modelos.Evento;
public class EventoViewModel {

	private List<Evento> eventosAll;
	private EventoDao eventoDao;
	private String nombreFiltro;

	@Init
	public void init() throws Exception {
		
		eventosAll = new ArrayList<Evento>();
		eventoDao = new EventoDao();
		eventosAll = eventoDao.obtenerTodos();
				
	}

	public ListModelList<Evento> getAllEventos() {
		return new ListModelList<Evento>(eventosAll);
	}
	
	public String getCantRegistros() {
		return eventosAll.size() + " items en la lista";
	}
	
	public String getNombreFiltro() {
		if(nombreFiltro==null)
			return "";
		return nombreFiltro;
	}

	public void setNombreFiltro(String nombreFiltro) {
		this.nombreFiltro = nombreFiltro==null?"":nombreFiltro.trim();
	}

	@Command
	public void showModal(@BindingParam("evento") Evento evento) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("evento", evento);
		Window window = (Window) Executions.createComponents("evento/administrarEvento/registrarEvento.zul",
				null, args);
		window.doModal();
	}
	
	@Command
	public void cancelar(@BindingParam("evento") final Evento evento) {

		Map<String, Object> args = new HashMap<String, Object>();
		args.put("evento", evento);
		Window window = (Window) Executions.createComponents("evento/administrarEvento/cancelar.zul",
				null, args);
		window.doModal();
	}
	
	@Command
	@NotifyChange({ "allEventos", "cantRegistros" })
	public void filtro() throws Exception {
		List<Evento> evento = new ArrayList<Evento>();
		String nomb = getNombreFiltro().toLowerCase();
		
		for (Iterator<Evento> i = eventoDao.obtenerTodos().iterator(); i.hasNext();) {
			Evento tmp = i.next();
			if (tmp.getNombre().toLowerCase().contains(nomb)) {
				evento.add(tmp);
			}
		}
		eventosAll = evento;
	}

	@GlobalCommand
	@NotifyChange({ "allEventos", "cantRegistros" })
	public void refreshEventos() throws Exception {
		eventosAll = eventoDao.obtenerTodos();
	}
}
