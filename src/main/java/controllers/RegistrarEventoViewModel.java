package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

import Dao.EstadoEventoDao;
import Dao.EventoDao;
import Dao.IndicadorDao;
import Dao.InstalacionDao;
import Dao.PreferenciaDao;
import Dao.TipoPreferenciaDao;
import modelos.Evento;
import modelos.Indicador;
import modelos.IndicadorEvento;
import modelos.Instalacion;
import modelos.InstalacionEvento;
import modelos.Preferencia;
import modelos.PreferenciaEvento;
import modelos.TipoPreferencia;

public class RegistrarEventoViewModel {
	
	private Evento evento;
	private boolean editable;
	private EventoDao eventoDao;
	private TipoPreferenciaDao tPreferenciaDao;
	private PreferenciaDao preferenciaDao;
	private InstalacionDao instalacionDao;
	private IndicadorDao indicadorDao;
	private EstadoEventoDao estadoEDao;
	private TipoPreferencia tipoPreferenciaSelected;
	private ArrayList<Preferencia> temporalPreferencia;
	private ArrayList<Instalacion> temporalInstalaciones;
	private IndicadorEvento indicadorEvento;
	private Set<PreferenciaEvento> listPreferenciaEvento;
	private Set<InstalacionEvento> listInstalacionEvento;
	private Set<IndicadorEvento> listIndicadorEvento;

	@Init
	public void init(@ExecutionArgParam("evento") Evento evento) {
		if (evento == null) {
			this.evento = new Evento();
			listPreferenciaEvento = new HashSet<PreferenciaEvento>();
			listInstalacionEvento = new HashSet<InstalacionEvento>();
			listIndicadorEvento = new HashSet<IndicadorEvento>();
			this.editable = false;
		} else {
			this.evento = evento;
			listPreferenciaEvento = evento.getPreferenciaEventos();
			listInstalacionEvento = evento.getInstalacionEventos();
			listIndicadorEvento = evento.getIndicadorEventos();
			this.editable = true;
		}
		eventoDao = new EventoDao();
		estadoEDao = new EstadoEventoDao();
		indicadorDao = new IndicadorDao();
		tPreferenciaDao = new TipoPreferenciaDao();
		preferenciaDao = new PreferenciaDao();
		instalacionDao = new InstalacionDao();
		temporalPreferencia = new ArrayList<Preferencia>();
		temporalInstalaciones = new ArrayList<Instalacion>();
		indicadorEvento = new IndicadorEvento();
		
	}
	
	@NotifyChange("preferenciasPorTipo")
	public TipoPreferencia getTipoPreferenciaSelected() {
		return tipoPreferenciaSelected;
	}

	@NotifyChange("preferenciasPorTipo")
	public void setTipoPreferenciaSelected(TipoPreferencia tipoPreferenciaSelected) {
		this.tipoPreferenciaSelected = tipoPreferenciaSelected;
	}
	
	public ArrayList<Preferencia> getTemporalPreferencia() {
		
		return temporalPreferencia;
	}

	public void setTemporalPreferencia(ArrayList<Preferencia> temporalPreferencia) {
		this.temporalPreferencia = temporalPreferencia;
	}
	
	public ArrayList<Instalacion> getTemporalInstalaciones() {
		return temporalInstalaciones;
	}

	public void setTemporalInstalaciones(ArrayList<Instalacion> temporalInstalaciones) {
		this.temporalInstalaciones = temporalInstalaciones;
	}

	public boolean isEditable() {
		return editable;
	}
	
	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	public IndicadorEvento getIndicadorEvento() {
		return indicadorEvento;
	}

	public void setIndicadorEvento(IndicadorEvento indicadorEvento) {
		this.indicadorEvento = indicadorEvento;
	}

	public  ListModelList<TipoPreferencia> getAllTipoPreferencia() throws Exception{
		
		return new ListModelList<TipoPreferencia>(tPreferenciaDao.obtenerTodos());
	}
	
	public  ListModelList<Indicador> getAllIndicadores() throws Exception{
		
		return new ListModelList<Indicador>(indicadorDao.obtenerTodos());
	}
	
	public  ListModelList<PreferenciaEvento> getPreferenciasEventos() throws Exception{
		
		return new ListModelList<PreferenciaEvento>(listPreferenciaEvento);
	}
	
	public  ListModelList<InstalacionEvento> getInstalacionesEventos() throws Exception{
		
		return new ListModelList<InstalacionEvento>(listInstalacionEvento);
	}
	
	public  ListModelList<IndicadorEvento> getIndicadoresEventos() throws Exception{
		
		return new ListModelList<IndicadorEvento>(listIndicadorEvento);
	}
	
	public String getCantidadPreferencias() {
		return listPreferenciaEvento.size() + " items en la lista";
	}
	
	public String getCantidadInstalaciones() {
		return listInstalacionEvento.size() + " items en la lista";
	}
	
	public String getCantidadIndicadores() {
		return listIndicadorEvento.size() + " items en la lista";
	}
	
	public ArrayList<Preferencia> metodoFeo(){
		
		ArrayList<Preferencia> deportivas;
		deportivas = new ArrayList<Preferencia>();
		deportivas.add(new Preferencia(1, tipoPreferenciaSelected,"Futbol", true));
		deportivas.add(new Preferencia(1, tipoPreferenciaSelected,"Sotfbo", true));
		deportivas.add(new Preferencia(1, tipoPreferenciaSelected,"Basket", true));
		return deportivas;

	}
	
	public  ListModelList<Preferencia> getPreferenciasPorTipo() throws Exception{
		if(tipoPreferenciaSelected !=null){
			return new ListModelList<Preferencia>(preferenciaDao.obtenerPreferenciasTipo(tipoPreferenciaSelected));
		}
		return new ListModelList<Preferencia>();
	}
	
	public  ListModelList<Instalacion> getInstalaciones() throws Exception{
		
		return new ListModelList<Instalacion>(instalacionDao.obtenerTodos());
		
	}
	
	@Command
	@NotifyChange({"preferenciasEventos","cantidadPreferencias"})
	public void agregarPreferenciasEvento(){
				
		PreferenciaEvento preferenciaEvento;
		for (Preferencia preferencia: temporalPreferencia) {
			if(buscarPreferecia(preferencia)==null){
				preferenciaEvento = new PreferenciaEvento();
				preferenciaEvento.setEvento(evento);
				preferenciaEvento.setActivo(true);
				preferenciaEvento.setPreferencia(preferencia);
				listPreferenciaEvento.add(preferenciaEvento);
			}
		}
	}
	
	
	@Command
	@NotifyChange({"instalacionesEventos","cantidadInstalaciones"})
	public void agregarInstalacionesEvento(){
		
		InstalacionEvento instalacionEvento;
		for (Instalacion intalacion: temporalInstalaciones) {
			if(buscarInstalacion(intalacion)==null){
				instalacionEvento = new InstalacionEvento();
				instalacionEvento.setEvento(evento);
				instalacionEvento.setActivo(true);
				instalacionEvento.setInstalacion(intalacion);
				listInstalacionEvento.add(instalacionEvento);
			}
		}
	}
	
	@Command
	@NotifyChange({"indicadoresEventos","indicadorEvento","cantidadIndicadores"})
	public void agregarIndicadorEvento(){
		
		if(this.indicadorEvento.getIndicador()!=null){
			for (IndicadorEvento indicadorEvento: listIndicadorEvento) {
				if(indicadorEvento.getIndicador().getIdIndicador()==this.indicadorEvento.getIndicador().getIdIndicador())
					return;
			}
			this.indicadorEvento.setEvento(evento);
			listIndicadorEvento.add(this.indicadorEvento);
			this.indicadorEvento = new IndicadorEvento();
		}
	}
	
	
	@Command
	@NotifyChange({"preferenciasEventos","cantidadPreferencias"})
	public void eliminarPreferenciaEvento(@BindingParam("preferenciaEvento") PreferenciaEvento p){
		listPreferenciaEvento.remove(p);
	}
	
	@Command
	@NotifyChange({"instalacionesEventos","cantidadInstalaciones"})
	public void eliminarInstalacionEvento(@BindingParam("instalacionEvento") InstalacionEvento i){
		listInstalacionEvento.remove(i);
	}
	
	@Command
	@NotifyChange({"indicadoresEventos","indicadorEvento","cantidadIndicadores"})
	public void eliminarIndicadorEvento(@BindingParam("indicadorEvento") IndicadorEvento in){
		listIndicadorEvento.remove(in);
	}
	
	public Preferencia buscarPreferecia(Preferencia preferencia){
		for (PreferenciaEvento preferenciaEvento: listPreferenciaEvento) {
			if(preferenciaEvento.getPreferencia().equals(preferencia))
				return preferencia;
		}
		return null;
	}
	
	public Instalacion buscarInstalacion(Instalacion instalacion){
		for (InstalacionEvento instalacionEvento: listInstalacionEvento) {
			if(instalacionEvento.getInstalacion().equals(instalacion))
				return instalacion;
		}
		return null;
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {
		
		if (!isCamposVacio())
		{
			this.evento.setIndicadorEventos(this.listIndicadorEvento);
			this.evento.setPreferenciaEventos(this.listPreferenciaEvento);
			this.evento.setInstalacionEventos(this.listInstalacionEvento);
			this.evento.setEstadoEvento(estadoEDao.obtenerEstadoEvento(1));
			if (!editable)
				eventoDao.agregarEvento(evento);

			else eventoDao.actualizarEvento(evento);
				
			win.detach();
			BindUtils.postGlobalCommand(null,null,"refreshEventos",null);
			
		}	
	}
	
	public boolean isCamposVacio(){
		if(evento.getNombre() != null && !evento.getNombre().equalsIgnoreCase("") && 
				evento.getDescripcion() != null && !evento.getDescripcion().equalsIgnoreCase("") &&
				evento.getFechaInicio() != null && evento.getFechaFin() != null && this.listIndicadorEvento.size()>0 &&
				this.listInstalacionEvento.size()>0 && this.listPreferenciaEvento.size()>0)
			return false;
		return true;
	}
	
	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}
}
