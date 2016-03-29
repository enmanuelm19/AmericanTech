package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import util.ManejadorMail;
import Dao.EstadoEventoDao;
import Dao.EventoDao;
import Dao.IndicadorDao;
import Dao.IndicadorEventoDao;
import Dao.InstalacionDao;
import Dao.InstalacionEventoDao;
import Dao.NoticiaDao;
import Dao.PreferenciaDao;
import Dao.PreferenciaEventoDao;
import Dao.ReservacionDao;
import Dao.SocioDao;
import Dao.TipoNoticiaDao;
import Dao.TipoPreferenciaDao;
import modelos.Evento;
import modelos.Indicador;
import modelos.IndicadorEvento;
import modelos.Instalacion;
import modelos.InstalacionEvento;
import modelos.Noticia;
import modelos.NoticiaPreferencia;
import modelos.Preferencia;
import modelos.PreferenciaEvento;
import modelos.PreferenciaPersona;
import modelos.Reservacion;
import modelos.Socio;
import modelos.TipoPreferencia;

public class RegistrarEventoViewModel {

	private Evento evento;
	private boolean editable;
	private EventoDao eventoDao;
	private TipoPreferenciaDao tPreferenciaDao;
	private PreferenciaDao preferenciaDao;
	private InstalacionDao instalacionDao;
	private IndicadorDao indicadorDao;
	private IndicadorEventoDao indicadorEventoDao;
	private PreferenciaEventoDao preferenciaEventoDao;
	private EstadoEventoDao estadoEDao;
	private ReservacionDao reservacionDao;
	private InstalacionEventoDao instalacionEventoDao;
	private TipoPreferencia tipoPreferenciaSelected;
	private ArrayList<Preferencia> temporalPreferencia;
	private ArrayList<Instalacion> temporalInstalaciones;
	private IndicadorEvento indicadorEvento;
	private Set<PreferenciaEvento> listPreferenciaEvento;
	private Set<InstalacionEvento> listInstalacionEvento;
	private Set<IndicadorEvento> listIndicadorEvento;
	private TipoNoticiaDao tipoNoticiaDao;
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
			listPreferenciaEvento = evento.getPreferenciaEventosActive();
			listInstalacionEvento = evento.getInstalacionEventosActive();
			listIndicadorEvento = evento.getIndicadorEventosActive();
			this.editable = true;
		}
		eventoDao = new EventoDao();
		reservacionDao = new ReservacionDao();
		estadoEDao = new EstadoEventoDao();
		indicadorDao = new IndicadorDao();
		tPreferenciaDao = new TipoPreferenciaDao();
		preferenciaDao = new PreferenciaDao();
		instalacionDao = new InstalacionDao();
		temporalPreferencia = new ArrayList<Preferencia>();
		temporalInstalaciones = new ArrayList<Instalacion>();
		indicadorEvento = new IndicadorEvento();
		instalacionEventoDao = new InstalacionEventoDao();
		indicadorEventoDao = new IndicadorEventoDao();
		preferenciaEventoDao = new PreferenciaEventoDao();
		tipoNoticiaDao= new TipoNoticiaDao();
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

	public ListModelList<TipoPreferencia> getAllTipoPreferencia() throws Exception {

		return new ListModelList<TipoPreferencia>(tPreferenciaDao.obtenerTodos());
	}

	public ListModelList<Indicador> getAllIndicadores() throws Exception {

		return new ListModelList<Indicador>(indicadorDao.obtenerTodos());
	}

	public ListModelList<PreferenciaEvento> getPreferenciasEventos() throws Exception {
		ArrayList<PreferenciaEvento> preferenciasMostrar = new ArrayList<PreferenciaEvento>();
		for (PreferenciaEvento preferenciaEvento : listPreferenciaEvento) {
			if (preferenciaEvento.isActivo())
				preferenciasMostrar.add(preferenciaEvento);
		}
		return new ListModelList<PreferenciaEvento>(preferenciasMostrar);
	}

	public ListModelList<InstalacionEvento> getInstalacionesEventos() throws Exception {
		ArrayList<InstalacionEvento> instalacionesMostrar = new ArrayList<InstalacionEvento>();
		for (InstalacionEvento instalacionEvento : listInstalacionEvento) {
			if (instalacionEvento.isActivo())
				instalacionesMostrar.add(instalacionEvento);
		}
		return new ListModelList<InstalacionEvento>(instalacionesMostrar);
	}

	public ListModelList<IndicadorEvento> getIndicadoresEventos() throws Exception {
		ArrayList<IndicadorEvento> indicadoresMostrar = new ArrayList<IndicadorEvento>();
		for (IndicadorEvento indicadorEvento : listIndicadorEvento) {
			if (indicadorEvento.isActivo())
				indicadoresMostrar.add(indicadorEvento);
		}
		return new ListModelList<IndicadorEvento>(indicadoresMostrar);
	}

	public String getCantidadPreferencias() throws Exception {
		return getPreferenciasEventos().size() + " items en la lista";
	}

	public String getCantidadInstalaciones() throws Exception {
		return getInstalacionesEventos().size() + " items en la lista";
	}

	public String getCantidadIndicadores() throws Exception {
		return getIndicadoresEventos().size() + " items en la lista";
	}

	public ListModelList<Preferencia> getPreferenciasPorTipo() throws Exception {
		if (tipoPreferenciaSelected != null) {
			return new ListModelList<Preferencia>(preferenciaDao.obtenerPreferenciasTipo(tipoPreferenciaSelected));
		}
		return new ListModelList<Preferencia>();
	}

	public ListModelList<Instalacion> getInstalaciones() throws Exception {

		return new ListModelList<Instalacion>(instalacionDao.obtenerTodos());

	}

	@Command
	@NotifyChange({ "preferenciasEventos", "cantidadPreferencias" })
	public void agregarPreferenciasEvento() {

		PreferenciaEvento preferenciaEvento;
		for (Preferencia preferencia : temporalPreferencia) {
			if (buscarPreferecia(preferencia) == null) {
				preferenciaEvento = new PreferenciaEvento();
				preferenciaEvento.setEvento(evento);
				preferenciaEvento.setActivo(true);
				preferenciaEvento.setPreferencia(preferencia);
				listPreferenciaEvento.add(preferenciaEvento);
			}
		}
	}

	@Command
	@NotifyChange({ "instalacionesEventos", "cantidadInstalaciones", "disabled" })
	public void agregarInstalacionesEvento() throws Exception {

		InstalacionEvento instalacionEvento;
		if (evento.getFechaInicio() != null && evento.getFechaFin() != null
				&& (evento.getFechaInicio().before(evento.getFechaFin()) || evento.getFechaInicio().getTime()-evento.getFechaFin().getTime()==0) && evento.getFechaInicio().getTime( )>= new Date().getTime())
			for (Instalacion instalacion : temporalInstalaciones) {
				if (isDisponible(instalacion)) {
					if (buscarInstalacion(instalacion) == null) {
						instalacionEvento = new InstalacionEvento();
						instalacionEvento.setEvento(evento);
						instalacionEvento.setActivo(true);
						instalacionEvento.setInstalacion(instalacion);
						listInstalacionEvento.add(instalacionEvento);
					}
				} else
					Messagebox.show(
							instalacion.getNombre() + " no se encuentra disponible en el rango de fecha selecionado",
							"American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
			}
		else
			Messagebox.show("Por favor indique rango de fechas del evento de forma correcta", "American Tech", Messagebox.OK,
					Messagebox.EXCLAMATION);
	}

	public boolean isDisponible(Instalacion instalacion) throws Exception {

		// verificamos que no este reservada esa intalacion
		for (Reservacion reservacion : reservacionDao.obtenerReservacionesInstalacion(instalacion)) {

			if (isRango(reservacion.getFechaInicio(), reservacion.getFechaFin(), evento.getFechaInicio()))
				return false;
			if (isRango(reservacion.getFechaInicio(), reservacion.getFechaFin(), evento.getFechaFin()))
				return false;
			if (isRango(evento.getFechaInicio(), evento.getFechaFin(), reservacion.getFechaInicio()))
				return false;

		}

		// verificamos que no se vaya usar esa instalacion en un evento
		for (InstalacionEvento instalacionEvento : instalacionEventoDao.obtenerPorInstalacion(instalacion)) {
			System.out.println("entro por evento");
			if (isRango(instalacionEvento.getEvento().getFechaInicio(), instalacionEvento.getEvento().getFechaFin(),
					evento.getFechaInicio()))
				return false;
			if (isRango(instalacionEvento.getEvento().getFechaInicio(), instalacionEvento.getEvento().getFechaFin(),
					evento.getFechaFin()))
				return false;
			if (isRango(evento.getFechaInicio(), evento.getFechaFin(), instalacionEvento.getEvento().getFechaInicio()))
				return false;
		}

		return true;

	}

	public boolean isRango(Date a, Date b, Date d) {

		return a.compareTo(d) * d.compareTo(b) >= 0;
	}

	@Command
	@NotifyChange({ "indicadoresEventos", "indicadorEvento", "cantidadIndicadores" })
	public void agregarIndicadorEvento() {

		if (this.indicadorEvento.getIndicador() != null) {
			for (IndicadorEvento indicadorEvento : listIndicadorEvento) {
				if (indicadorEvento.getIndicador().getIdIndicador() == this.indicadorEvento.getIndicador()
						.getIdIndicador())
					return;
			}
			this.indicadorEvento.setEvento(evento);
			listIndicadorEvento.add(this.indicadorEvento);
			this.indicadorEvento = new IndicadorEvento();
		}
	}

	@Command
	@NotifyChange({ "preferenciasEventos", "cantidadPreferencias" })
	public void eliminarPreferenciaEvento(@BindingParam("preferenciaEvento") PreferenciaEvento p) throws Exception {
		if (preferenciaEventoDao.obtenerPreferenciaEvento(p.getIdPreferenciaEvento()) != null)
			p.setActivo(false);
		else
			listPreferenciaEvento.remove(p);

	}

	@Command
	@NotifyChange({ "instalacionesEventos", "cantidadInstalaciones", "disabled" })
	public void eliminarInstalacionEvento(@BindingParam("instalacionEvento") InstalacionEvento i) throws Exception {
		if (instalacionEventoDao.obtenerInstalacionEvento(i.getIdActividadInstalacion()) != null)
			i.setActivo(false);
		else
			listInstalacionEvento.remove(i);
	}

	@Command
	@NotifyChange({ "indicadoresEventos", "indicadorEvento", "cantidadIndicadores" })
	public void eliminarIndicadorEvento(@BindingParam("indicadorEvento") IndicadorEvento in) throws Exception {
		if (indicadorEventoDao.obtenerIndicadorEvento(in.getIdIndicadorEvento()) != null)
			in.setActivo(false);
		else
			listIndicadorEvento.remove(in);
	}

	public Preferencia buscarPreferecia(Preferencia preferencia) {
		for (PreferenciaEvento preferenciaEvento : listPreferenciaEvento) {
			if (preferenciaEvento.getPreferencia().getIdPreferencia() == preferencia.getIdPreferencia())
				return preferencia;
		}
		return null;
	}

	public Instalacion buscarInstalacion(Instalacion instalacion) {
		for (InstalacionEvento instalacionEvento : listInstalacionEvento) {
			if (instalacionEvento.getInstalacion().getIdInstalacion() == instalacion.getIdInstalacion())
				return instalacion;
		}
		return null;
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {

		if (!isCamposVacio()) {
			this.evento.setIndicadorEventos(this.listIndicadorEvento);
			this.evento.setPreferenciaEventos(this.listPreferenciaEvento);
			this.evento.setInstalacionEventos(this.listInstalacionEvento);
			this.evento.setEstadoEvento(estadoEDao.obtenerEstadoEvento(1));
			if (!editable) {
				eventoDao.agregarEvento(evento);
				registrarNoticia();
				enviarEmail();
				Messagebox.show("El evento " + evento.getNombre() + " ha sido registrado exitosamente", "American Tech",
						Messagebox.OK, Messagebox.INFORMATION);
			}

			else {
				eventoDao.actualizarEvento(evento);
				actualizarNoticia();
				enviarEmail();
				Messagebox.show("El evento " + evento.getNombre() + " ha sido actualizado exitosamente", "American Tech",
						Messagebox.OK, Messagebox.INFORMATION);
			}

			win.detach();
			BindUtils.postGlobalCommand(null, null, "refreshEventos", null);

		}
		else Messagebox.show("Por favor ingrese todos los campos del evento", "American Tech", Messagebox.OK,
				Messagebox.EXCLAMATION);
	}

	public boolean isCamposVacio() {
		if (evento.getNombre() != null && !evento.getNombre().equalsIgnoreCase("") && evento.getDescripcion() != null
				&& !evento.getDescripcion().equalsIgnoreCase("") && evento.getFechaInicio() != null
				&& evento.getFechaFin() != null)
			return false;
		return true;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	public boolean isDisabled() {
		return this.listInstalacionEvento.size() > 0;
	}

	public void registrarNoticia() throws Exception {

		Noticia noticia = new Noticia();
		NoticiaDao noticiaDao = new NoticiaDao();
		noticia.setFoto("http://i.imgur.com/wGVOjvQ.png");
		noticia.setFechaCreacion(new Date());
		noticia.setCaducidad(evento.getFechaFin());
		noticia.setDescripcion("Nos complace informarle a nuestra familia americanista la realizacion de evento: "+evento.getNombre()+" Desde: "+evento.getFechaInicioString()+" Hasta: "+evento.getFechaFinString());
		noticia.setTitulo(evento.getNombre());
		noticia.setPublico(evento.isPublico());
		noticia.setTipoNoticia(tipoNoticiaDao.obtenerTipoNoticia(1));
		noticia.setEvento(evento);
		noticia.setActivo(true);
		
		Set<NoticiaPreferencia> noticiasPreferencias = new HashSet<NoticiaPreferencia>();
		
		for(PreferenciaEvento p: listPreferenciaEvento){
			NoticiaPreferencia noticiaP = new NoticiaPreferencia();
			noticiaP.setActivo(true);
			noticiaP.setNoticia(noticia);
			noticiaP.setPreferencia(p.getPreferencia());
			noticiasPreferencias.add(noticiaP);
		}
		
		noticia.setNoticiaPreferencias(noticiasPreferencias);
		noticiaDao.agregarNoticia(noticia);
		
		
	}
	
	public void enviarEmail() throws Exception {
		SocioDao socioDao = new SocioDao();

		boolean bandera = false;

		String mensaje, detinatario, asunto;

		for (Socio socio : socioDao.obtenerTodos()) {
			for (PreferenciaPersona preferenciaP : socio.getPersona().getPreferenciaPersonas()) {
				for (PreferenciaEvento preferenciaE : evento.getPreferenciaEventosActive()) {
					if (preferenciaE.getPreferencia().getIdPreferencia() == preferenciaP.getPreferencia()
							.getIdPreferencia()) {

						mensaje = "Sr(a) " + socio.getPersona().getNombre() + " " + socio.getPersona().getApellido()
								+ " nos complace informarle que la familia americanista realizara un evento que tendra origen el dia: "
								+ evento.getFechaInicioString()
								+ " para mayor informacion visite nuestra portal web www.america.com.ve, Feliz Dia att Club Centro Altetico America";
						detinatario = socio.getPersona().getCorreo();
						asunto = "Evento: " + evento.getNombre();
						ManejadorMail.enviarEmail(mensaje, detinatario, asunto);
						bandera = true;
						break;
					}

				}
				if (bandera)
					break;
			}
			bandera = false;
		}

	}
	
	public void actualizarNoticia() throws Exception{
		
		
		System.out.println("noticias sise: "+evento.getNoticias().size());
		
		
		NoticiaDao noticiaDao = new NoticiaDao();
		Noticia noticia = noticiaDao.obtenerNoticia(evento.getNoticias().iterator().next().getIdNoticia());
		noticia.setCaducidad(evento.getFechaFin());
		noticia.setDescripcion("Nos complace informarle a nuestra familia americanista la realizacion de evento: "+evento.getNombre()+" Desde: "+evento.getFechaInicioString()+" Hasta: "+evento.getFechaFinString());
		noticia.setTitulo(evento.getNombre());
		noticia.setPublico(evento.isPublico());
		noticia.setTipoNoticia(tipoNoticiaDao.obtenerTipoNoticia(1));
		noticia.setEvento(evento);
		
		Set<NoticiaPreferencia> noticiasPreferencias = new HashSet<NoticiaPreferencia>();
		
		for(PreferenciaEvento p: listPreferenciaEvento){
			NoticiaPreferencia noticiaP = new NoticiaPreferencia();
			noticiaP.setActivo(true);
			noticiaP.setNoticia(noticia);
			noticiaP.setPreferencia(p.getPreferencia());
			noticiasPreferencias.add(noticiaP);
		}
		
		
		//noticia.setActivo(true);
		noticiaDao.actualizarNoticia(noticia);
		
	}
}
