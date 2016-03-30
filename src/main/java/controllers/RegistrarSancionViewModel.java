package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import modelos.Afiliado;
import modelos.Eventualidad;
import modelos.Persona;
import modelos.Postulacion;
import modelos.Sancion;
import modelos.Socio;
import modelos.TipoSancion;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.AfiliadoDao;
import Dao.EventualidadDao;
import Dao.PersonaDao;
import Dao.SancionDao;
import Dao.SocioDao;
import Dao.TipoSancionDao;

public class RegistrarSancionViewModel {
	private Sancion sancion;
	private SocioDao socioDao;
	private PersonaDao personaDao;
	private Persona persona;
	private Socio socio;
	private String carnet;
	private String cedula="";
	private boolean editable, multa, suspencion, enableCarnet, enableCedula,sancionSocio,sancionAfiliado, verEventualidad=false;
	private List<Eventualidad> evetualidades;
	private Eventualidad evetualidad;
	private TipoSancionDao tipoSancionDao;
	private List<TipoSancion> tiposSancions;
	private TipoSancion tipoSancion;
	private Date fechaInicio, fechaFin;
	private float multabs;
	private SancionDao sancionDao;
	private EventualidadDao eventualidadDao;
	private Eventualidad temporalEventualidad;
	private boolean eventualidadTemporal;
	private Afiliado afiliado;
	private AfiliadoDao afiliadoDao;
	@Init
	public void init(@ExecutionArgParam("Sancion") Sancion sancion) throws Exception{
		tipoSancionDao= new TipoSancionDao();
		tiposSancions=tipoSancionDao.obtenerTodos();
		eventualidadDao= new EventualidadDao();
		socioDao= new SocioDao();
		afiliadoDao= new AfiliadoDao();
		if(sancion==null){
			this.editable=false;
			this.sancion= new Sancion();
			this.multa=false;
			this.suspencion=false;
			this.persona= new Persona();
			this.socio= new Socio();
			this.enableCarnet=true;
			this.enableCedula=true;
			this.evetualidades= new ArrayList<Eventualidad>();
			this.fechaInicio=new Date();
			this.fechaFin= new Date();
			this.multabs=0;
			this.sancionAfiliado=false;
			this.sancionSocio=false;
			this.sancion.setDescripcion("");
		}
		else{
			this.editable=true;
			this.sancion=sancion;
			this.enableCarnet=false;
			this.enableCedula=false;
			this.carnet=sancion.getSocio().getNroCarnet();
			this.cedula=sancion.getSocio().getPersona().getIdentificacion();
			this.tipoSancion=sancion.getTipoSancion();
			this.persona=sancion.getSocio().getPersona();
			try {
				if(!sancion.getSocio().equals(null)){
					this.evetualidades= eventualidadDao.obtenerEventualidadUsuario(socio.getPersona());
					this.sancionSocio=true;
					this.sancionAfiliado=false;
				}
				else{
					this.evetualidades= eventualidadDao.obtenerEventualidadUsuario(afiliado.getPersona());
					this.sancionSocio=false;
					this.sancionAfiliado=true;
				}
				this.evetualidades.add(sancion.getEventualidad());
				this.evetualidad=sancion.getEventualidad();
				this.temporalEventualidad=sancion.getEventualidad();
				this.verEventualidad=true;
				this.eventualidadTemporal=true;
			} catch (NullPointerException e) {
				// TODO: handle exception
				evetualidades= new ArrayList<Eventualidad>();
				verEventualidad=false;
				this.eventualidadTemporal=false;
			}
			if(sancion.getTipoSancion().getIdTipoSancion()==1){
				verEventualidad=false;
			}
			if (sancion.getMonto()==null) {
				this.multa=false;
				this.multabs=0;
			}
			else{
				this.multa=true;
				this.multabs= this.sancion.getMonto();
			}
			if(sancion.getFechaInic()==null){
				this.suspencion=false;
				this.fechaInicio=new Date();
				this.fechaFin= new Date();
			}
			else{
				this.suspencion=true;
				this.fechaFin=sancion.getFechaFin();
				this.fechaInicio=sancion.getFechaInic();
			}
		}
	}

	public ListModelList<Eventualidad> getEventualidades(){
		return new ListModelList<Eventualidad>(evetualidades);
	}
	
	public ListModelList<TipoSancion> getTiposSancions(){
		return new ListModelList<TipoSancion>(tiposSancions);
	}
	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public Sancion getSancion() {
		return sancion;
	}

	public boolean isMulta() {
		return multa;
	}
	
	public void setMulta(boolean multa) {
		this.multa = multa;
	}

	public boolean isSuspencion() {
		return suspencion;
	}

	public void setSuspencion(boolean suspencion) {
		this.suspencion = suspencion;
	}

	public Persona getPersona() {
		return persona;
	}

	public Socio getSocio() {
		return socio;
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	@Command
	@NotifyChange({"carnet","socio","persona","eventualidades","cedula"})
	public void buscarCarnet() throws Exception{
		if(carnet==""||carnet==null){
			Messagebox.show("Campo Carnet Vacio", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		}
		else{
			this.socioDao= new SocioDao();
			this.socio=socioDao.obtenerSocioCarnet(carnet);
			this.afiliado=this.afiliadoDao.obtenerPorNroCarnet(carnet);
			if(this.socio==null && this.afiliado==null){
				Messagebox.show("Carnet no encontrado", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
				this.carnet="";
		
			}
			else{
				try{
				if(!this.socio.equals(null)){
					sancionSocio=true;
					sancionAfiliado=false;
					this.persona=socio.getPersona();
				}
				}
				catch(NullPointerException e){
					sancionSocio=false;
					sancionAfiliado=true;
					this.persona=afiliado.getPersona();
				}

				this.cedula=persona.getIdentificacion();
				this.evetualidades= eventualidadDao.obtenerEventualidadUsuario(persona);
			}
		}
	}
	
	@Command
	@NotifyChange({"cedula","persona","eventualidades","carnet"})
	public void buscarCedula() throws Exception{
		if(cedula==""||cedula==null){
			Messagebox.show("Campo Cédula Vacio", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		}
		else{
			this.personaDao= new PersonaDao();
			this.persona=personaDao.obtenerPersonaCedula(cedula);
			this.evetualidades=eventualidadDao.obtenerEventualidadUsuario(persona);
			this.socio=this.socioDao.obtenerSocioPersona(persona);
			this.afiliado=this.afiliadoDao.obtenerPorPersona(persona);
			if(this.socio==null && this.afiliado==null){
				Messagebox.show("Cédula no encontrada", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
				this.cedula="";
				this.persona=new Persona();
			}
			else{
				try{
				if(!this.socio.equals(null)){
					sancionSocio=true;
					sancionAfiliado=false;
					carnet=socio.getNroCarnet();
				}
				}
				catch(NullPointerException e){
					sancionSocio=false;
					sancionAfiliado=true;
					carnet=afiliado.getNroCarnet();
				}
			}
		}
	}
	public boolean isEnableCarnet() {
		return enableCarnet;
	}

	public boolean isEnableCedula() {
		return enableCedula;
	}

	public Eventualidad getEvetualidad() {
		return evetualidad;
	}
	
	@NotifyChange({"sancion"})
	public void setEvetualidad(Eventualidad evetualidad) {
		this.evetualidad = evetualidad;
		this.sancion.setDescripcion(evetualidad.getDescripcion());
	}

	public TipoSancion getTipoSancion() {
		return tipoSancion;
	}

	@NotifyChange({"verEventualidad"})
	public void setTipoSancion(TipoSancion tipoSancion) {
		this.tipoSancion = tipoSancion;
		if(tipoSancion.getIdTipoSancion()==2){
			this.verEventualidad=true;
		}
		else{
			this.verEventualidad=false;
		}
	}

	public boolean isVerEventualidad() {
		return verEventualidad;
	}

	public void setVerEventualidad(boolean verEventualidad) {
		this.verEventualidad = verEventualidad;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		if(fechaInicio.after(fechaFin)){
			Messagebox.show("Fecha de inicio de suspensión debe ser antes a la de fin de suspensión", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		}
		else{
			this.fechaInicio = fechaInicio;
		}

	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		if(fechaFin.before(fechaInicio)){
			Messagebox.show("Fecha de fin de suspensión debe ser despues a la de inicio de suspesión", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		}
		else{
			this.fechaFin = fechaFin;
		}
	}

	public float getMultabs() {
		return multabs;
	}
	
	public void setMultabs(float multabs) {
			this.multabs = multabs;
	}
	
	@Command
	public void guardarSancion(@BindingParam("win") Window win) throws Exception{
		if(editable==true){
			this.sancion.setTipoSancion(this.tipoSancion);
			if(this.tipoSancion.getIdTipoSancion()==1){
				if(this.sancion.getDescripcion().equalsIgnoreCase("")||this.sancion.getDescripcion()==null){
					Messagebox.show("Debe ingresar la descripción de la sanción", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
				}
				else{
					boolean validar=validacionAgregar();
					if(validar==true){
						this.actualizar(win);
					}
				}
			}
			else if(this.tipoSancion.getIdTipoSancion()==2){
				if(this.evetualidad==null){
					Messagebox.show("Debe seleccionar una Eventualidad", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
				}
				else{
					if(this.sancion.getDescripcion().equalsIgnoreCase("")){
						Messagebox.show("Verifique que los datos estén llenos", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
					}else{
					this.sancion.setEventualidad(this.evetualidad);
					boolean validar=validacionAgregar();
					if(validar==true){
						this.actualizar(win);
					}
					}
				}

			}
			else{
				if(this.sancion.getDescripcion().equalsIgnoreCase("")){
					Messagebox.show("Verifique que los datos estén llenos", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
				}else{
				
				this.sancion.setEventualidad(null);
				boolean validar=validacionAgregar();
				if(validar==true){
					this.actualizar(win);
				}}
			}
			
		}
		else{
			if(this.persona==null){
				Messagebox.show("Debe seleccionar a quien sancionar", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
			}
			else{
				if(sancionSocio==true){
					this.sancion.setSocio(this.socio);
				}
				if(sancionAfiliado==true){
					this.sancion.setAfiliado(afiliado);
				}
				
				if(this.tipoSancion==null){
					Messagebox.show("Debe seleccionar un motivo de sanción", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
				}
				else{
					this.sancion.setTipoSancion(this.tipoSancion);
					if(this.tipoSancion.getIdTipoSancion()==1){
						if(this.sancion.getDescripcion()==""||this.sancion.getDescripcion()==null){
							Messagebox.show("Debe ingresar la descripcion de la sanción", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
						}
						else{
							boolean validar=validacionAgregar();
							if(validar==true){
								this.agregar(win);
							}
						}
					}
					else if(this.tipoSancion.getIdTipoSancion()==2){
						if(this.evetualidad==null){
							Messagebox.show("Debe seleccionar una Eventualidad", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
						}
						else{
							this.sancion.setEventualidad(this.evetualidad);
							boolean validar=validacionAgregar();
							if(validar==true){
								this.agregar(win);
							}
						}

					}
					else{
						if(sancion.getDescripcion().equalsIgnoreCase("")){
						Messagebox.show("Verifique que los datos esten llenos", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);}
						else{
						this.sancion.setEventualidad(null);
						boolean validar=validacionAgregar();
						if(validar==true){
							this.agregar(win);
						}}
					}
					
				}
			}

		}
	}
	boolean validar1=false;
	boolean validar2=false;
	public boolean validacionAgregar(){
		if(this.multa==true){
			if(this.multabs<=0){
				validar1=false;
				Messagebox.show("Debe ingresar el valor de la multa", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
			}
			else if(this.multabs>=1){
				this.sancion.setMonto(this.multabs);
				validar1=true;
			}
		}
		else{
			this.sancion.setMonto(null);
			validar1=true;
		}
		
		if(this.suspencion==true){
			if(this.fechaFin.compareTo(this.fechaInicio)==0){
				Messagebox.show("Debe Ingresar un rango de fechas de suspensión", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
				validar2=false;
			}
			else{
				this.sancion.setFechaFin(this.fechaFin);
				this.sancion.setFechaInic(this.fechaInicio);
				validar2=true;
			}
		}
		else{
			this.sancion.setFechaInic(null);
			this.sancion.setFechaFin(null);
			validar2=true;
		}
		
		if(validar1==false||validar2==false){
			return false;
		}
		else{
			return true;
		}
	}
	
	public void actualizar(Window win) throws Exception{
		sancionDao= new SancionDao();
		eventualidadDao= new EventualidadDao();
		if(verEventualidad==true){
			if(!this.evetualidad.equals(temporalEventualidad)){
				this.temporalEventualidad.setActivo(true);
				this.evetualidad.setActivo(false);
				eventualidadDao.actualizarEventualidad(evetualidad);
				eventualidadDao.actualizarEventualidad(temporalEventualidad);
			}
		}
		else{
			if(eventualidadTemporal==true){
				this.temporalEventualidad.setActivo(true);
				eventualidadDao.actualizarEventualidad(temporalEventualidad);
				sancion.setEventualidad(null);
			}
		}
		sancionDao.actualizarSancion(sancion);
		Messagebox.show("La Sanción del Sr(a) " + persona.getNombre()+ " "+persona.getApellido()+ " a sido actualizada", "American Tech", Messagebox.OK, Messagebox.INFORMATION);
		BindUtils.postGlobalCommand(null, null, "refreshSancionados",null);
		win.detach();

	}
	public void agregar(Window win) throws Exception{
		sancionDao= new SancionDao();
		eventualidadDao= new EventualidadDao();
		if(verEventualidad==true){
			this.evetualidad.setActivo(false);
			eventualidadDao.actualizarEventualidad(evetualidad);
		}
		sancion.setActivo(true);
		sancionDao.agregarSancion(sancion);
		Messagebox.show("El Sr(a) " + persona.getNombre()+ " "+persona.getApellido()+ " a sido sancionado", "American Tech", Messagebox.OK, Messagebox.INFORMATION);
		BindUtils.postGlobalCommand(null, null, "refreshSancionados",null);
		win.detach();
	}
	
	@Command
	public void cancelar(@BindingParam("win") Window win){
		win.detach();
	}
	
}
