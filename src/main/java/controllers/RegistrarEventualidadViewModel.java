package controllers;

import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Messagebox;

import Dao.AfiliadoDao;
import Dao.EventualidadDao;
import Dao.InstalacionDao;
import Dao.PersonaDao;
import Dao.SocioDao;
import Dao.TipoEventualidadDao;
import modelos.Afiliado;
import modelos.Eventualidad;
import modelos.Instalacion;
import modelos.Socio;
import modelos.TipoEventualidad;
import modelos.Persona;

public class RegistrarEventualidadViewModel {

	private Eventualidad eventualidad;
	private String carnet;
	private TipoEventualidadDao daoTipoE;
	private List<TipoEventualidad> listTipoEventualidads;
	private InstalacionDao daoInstalacion;
	private List<Instalacion> listInstalacions;
	private SocioDao socioDao;
	private AfiliadoDao afiliadoDao;
	private EventualidadDao eventualidadDao;
	private PersonaDao personaDao;

	@Init
	public void init() throws Exception {
		
		this.eventualidad = new Eventualidad();
		eventualidad.setPersona(new Persona());
		this.personaDao = new PersonaDao();

		this.daoTipoE = new TipoEventualidadDao();
		listTipoEventualidads = daoTipoE.obtenerTodos();

		this.daoInstalacion = new InstalacionDao();
		listInstalacions = daoInstalacion.obtenerTodos();

		afiliadoDao = new AfiliadoDao();
		socioDao = new SocioDao();
		eventualidadDao = new EventualidadDao();
	}

	public List<Instalacion> getListInstalacions() {
		return listInstalacions;
	}

	public List<TipoEventualidad> getListTipoEventualidads() {
		return listTipoEventualidads;
	}

	public Eventualidad getEventualidad() {
		return eventualidad;
	}

	public void setEventualidad(Eventualidad eventualidad) {
		this.eventualidad = eventualidad;
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	@Command
	@NotifyChange({"eventualidad","carnet"})
	public void buscarCedula() throws Exception {
		
		if(eventualidad.getPersona().getIdentificacion()==null || eventualidad.getPersona().getIdentificacion().equals(""))
			Messagebox.show(" Nro carnet o Cedula no puede estar vacio", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		else{
			
			Persona persona = personaDao.obtenerPersonaCedula(eventualidad.getPersona().getIdentificacion());
			if(persona!=null){
				eventualidad.setPersona(persona);
				Socio socio = socioDao.obtenerSocioPersona(persona);
				if(socio!=null)
					this.carnet = socio.getNroCarnet();
				else{
					
					Afiliado afiliado = afiliadoDao.obtenerPorPersona(persona);
					if(afiliado!=null)
						this.carnet = afiliado.getNroCarnet();
					else {
						Messagebox.show(" Nro identificacion no encontrado", "American Tech", Messagebox.OK,
							Messagebox.EXCLAMATION);
						eventualidad = null;
					}
				}
				
				
			}
			else Messagebox.show(" Nro identificacion no encontrado", "American Tech", Messagebox.OK,
					Messagebox.EXCLAMATION);
				
		}

	}

	@Command
	@NotifyChange("eventualidad")
	public void buscarCarnet() throws Exception {

		if (this.carnet == null || this.carnet.equals(""))
			Messagebox.show(" Nro carneto o  Cedula no puede estar vacio", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		else {
			Socio socio = socioDao.obtenerSocioCarnet(carnet);
			if (socio != null)
				this.eventualidad.setPersona(socio.getPersona());

			else {
				Afiliado afiliado = afiliadoDao.obtenerPorNroCarnet(carnet);
				if (afiliado != null)
					this.eventualidad.setPersona(afiliado.getPersona());
				else 
					Messagebox.show(" Nro carnet no encontrado", "American Tech", Messagebox.OK,
							Messagebox.EXCLAMATION);
			}
		}
	}

	@Command
	@NotifyChange({"eventualidad","carnet"})
	public void guardar() throws Exception {

		if (eventualidad != null && eventualidad.getTipoEventualidad()!=null && eventualidad.getInstalacion()!=null) {
			this.eventualidadDao.agregarEventualidad(eventualidad);
			Messagebox.show("La eventualidad al sr(a) " + eventualidad.getPersona().getNombre()
					+ " se ha registrado exitosamente", "American Tech", Messagebox.OK, Messagebox.INFORMATION);
			eventualidad = null;
			carnet = "";
		} else
			Messagebox.show(" indique todos los datos de la eventualidad", "American Tech", Messagebox.OK,
					Messagebox.EXCLAMATION);

	}

	@Command
	public void cancelar() {
		Executions.sendRedirect("/vistas/index.zul");
	}

}
