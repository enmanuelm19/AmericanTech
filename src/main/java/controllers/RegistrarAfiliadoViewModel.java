package controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.media.Media;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import util.ManejadorArchivo;
import Dao.AfiliadoDao;
import Dao.PersonaDao;
import Dao.PreferenciaDao;
import Dao.PreferenciaPersonaDao;
import Dao.SocioDao;
import Dao.TipoAfiliadoDao;
import Dao.TipoPreferenciaDao;
import modelos.Accion;
import modelos.Afiliado;
import modelos.Persona;
import modelos.Preferencia;
import modelos.PreferenciaPersona;
import modelos.Socio;
import modelos.TipoAfiliado;
import modelos.TipoPreferencia;

public class RegistrarAfiliadoViewModel {
	private Socio socio;
	private Persona persona;
	private PersonaDao personaDao;
	private List<TipoAfiliado> tipoAfiliados;
	private TipoAfiliadoDao tipoAfiliadoDao;
	private Afiliado afiliado;
	private AfiliadoDao afiliadoDao;
	private TipoPreferencia tipoPreferencia;
	private List<TipoPreferencia> tiposPreferencias;
	private List<Preferencia> preferencias;
	private List<Preferencia> preferenciasAll;
	private TipoPreferenciaDao tipoPreferenciaDao;
	private PreferenciaDao preferenciaDao;
	private Preferencia preferencia;
	private PreferenciaPersona preferenciaPersona;
	private PreferenciaPersonaDao preferenciaPersonaDao;
	private Date fechaNac;
	private boolean imagenNuevaAfiliado = false;
	private Media uploadedImage;
	private TipoAfiliado tipoAfiliado;
	private String nroCarnet="";
	private ArrayList<Preferencia> temporalPreferencia;
	private boolean fotodefault;
	
	@Init
	public void init(@ExecutionArgParam("socioss") Socio socioss) throws Exception{
		this.socio= socioss;
		persona= new Persona();
		tipoAfiliadoDao= new TipoAfiliadoDao();
		tipoAfiliados= tipoAfiliadoDao.obtenerTodos();
		afiliado= new Afiliado();
		preferenciaDao= new PreferenciaDao();
		tipoPreferenciaDao= new TipoPreferenciaDao();
		tipoPreferencia= new TipoPreferencia();
		preferencia= new Preferencia();
		tiposPreferencias= tipoPreferenciaDao.obtenerTodos();
		preferencias= new ArrayList<Preferencia>();
		preferenciasAll= new ArrayList<Preferencia>();
		temporalPreferencia = new ArrayList<Preferencia>();
		fotodefault=true;
	}
	public boolean isFotodefault() {
		return fotodefault;
	}
	public Persona getPersona() {
		return persona;
	}
	
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	public ListModelList<TipoAfiliado> getTiposAfiliados(){
		return new ListModelList<TipoAfiliado>(tipoAfiliados);
	}
	
	public ListModelList<TipoPreferencia> getTiposPreferencias(){
		return new ListModelList<TipoPreferencia>(tiposPreferencias);
	}
	
	public ListModelList<Preferencia> getPreferencias() throws Exception{
		return new ListModelList<Preferencia>(this.preferenciaDao.obtenerTodos());
	}
	public ListModelList<Preferencia> getPreferenciasAll(){
		return new ListModelList<Preferencia>(preferenciasAll);
	}
	public ArrayList<Preferencia> getTemporalPreferencia() {
		return temporalPreferencia;
	}

	public void setTemporalPreferencia(ArrayList<Preferencia> temporalPreferencia) {
		this.temporalPreferencia = temporalPreferencia;
	}
	public Afiliado getAfiliado() {
		return afiliado;
	}
	
	public void setAfiliado(Afiliado afiliado) {
		this.afiliado = afiliado;
	}
	
	public ListModelList<Afiliado> getAfiliadosSocios(){
		return new ListModelList<Afiliado>(this.socio.getAfiliados());
	}
	public String getCantidadAfiliado(){
		return this.socio.getAfiliados().size()+" items en la lista";
	}
	public TipoAfiliado getTipoAfiliado() {
		return tipoAfiliado;
	}
	
	@NotifyChange({"nroCarnet"})
	public void setTipoAfiliado(TipoAfiliado tipoAfiliado) {
		if(tipoAfiliado.getIdTipoAfiliado()==1){
			if(cantidadTipoAfiliado(1)==1){
				Messagebox.show("El socio ya tiene asocioado un afiliado de parentesco "+tipoAfiliado.getDescripcion() , "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
				this.tipoAfiliado=new TipoAfiliado(0,"",false);
				this.afiliado.setTipoAfiliado(null);
			}
			else{
				this.nroCarnet=socio.getNroCarnet()+"-"+tipoAfiliado.getSubfijo();
				this.tipoAfiliado = tipoAfiliado;
				this.afiliado.setTipoAfiliado(tipoAfiliado);
			}
		}else if(tipoAfiliado.getIdTipoAfiliado()==2){
			if(cantidadTipoAfiliado(2)==1){
				Messagebox.show("El socio ya tiene asocioado un afiliado de parentesco "+tipoAfiliado.getDescripcion() , "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
				this.tipoAfiliado=new TipoAfiliado(0,"",false);
				this.afiliado.setTipoAfiliado(null);
			}
			else{
				this.nroCarnet=socio.getNroCarnet()+"-"+tipoAfiliado.getSubfijo();
				this.tipoAfiliado = tipoAfiliado;
				this.afiliado.setTipoAfiliado(tipoAfiliado);
			}
		}
		else{
			this.nroCarnet=socio.getNroCarnet()+"-"+(Integer.parseInt(tipoAfiliado.getSubfijo())+cantidadTipoAfiliado(tipoAfiliado.getIdTipoAfiliado()));	
			this.tipoAfiliado = tipoAfiliado;
			this.afiliado.setTipoAfiliado(tipoAfiliado);
		}	
		
	}

	@Command
	@NotifyChange({"uploadedImageAfiliado","fotodefault"})
	public void uploadImage(@BindingParam("media") Media myMedia) {
		imagenNuevaAfiliado = true;
		uploadedImage = myMedia;
		fotodefault=false;
	}
	
	public Media getUploadedImageAfiliado() {
		return uploadedImage;
	}
	

	public void setUploadedImageAfiliado(Media uploadedImage) {
		this.uploadedImage = uploadedImage;
	}

	
	public int cantidadTipoAfiliado(int cod){
		int cant=0;
		for(Iterator<Afiliado> i = socio.getAfiliados().iterator(); i.hasNext();) {
			Afiliado tmp = i.next();
			if(tmp.getTipoAfiliado().getIdTipoAfiliado()==cod){
				cant++;
			}
		}
		return cant;
	}
	
	public String getNroCarnet(){
		if(nroCarnet.equalsIgnoreCase(""))
			return socio.getNroCarnet()+"-";
		else
			return nroCarnet;
	}
	public int getCalcularEdad() {
		Calendar birth = new GregorianCalendar();
		Calendar today = new GregorianCalendar();
		int age=0;
		int factor=0;
		
		Date birthDate;
		if(this.getFechaNac()==null)
			return 0;
		else{
			birthDate=this.getFechaNac();
			Date currentDate=new Date(); //current date
			birth.setTime(birthDate);
			today.setTime(currentDate);
			if (today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)) {
				if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
					if (today.get(Calendar.DATE) > birth.get(Calendar.DATE)) {
						factor = -1; //Aun no celebra su cumpleaños
					}
				} else {
			factor = -1; //Aun no celebra su cumpleaños
			}
			
			} 
			age=(today.get(Calendar.YEAR)-birth.get(Calendar.YEAR))+factor;
			return age;
		}
	}

	public Preferencia getPreferencia() {
		return preferencia;
	}
	
	
	@NotifyChange({"preferencias","preferenciasAll","cantidadInteres","preferencia"})
	public void setPreferencia(Preferencia preferencia) {
		this.preferencia = preferencia;
		preferenciasAll.add(preferencia);
		preferencia= new Preferencia();
	}
	@Command
	@NotifyChange({ "preferenciasAll","cantidadInteres"})
	public void agregarPreferenciasPersona() {
		for(int i=0; i<temporalPreferencia.size(); i++)
			preferenciasAll.add(temporalPreferencia.get(i));
	}
	
	public TipoPreferencia getTipoPreferencia() {
		return tipoPreferencia;
	}
	@NotifyChange({"preferencias"})
	public void setTipoPreferencia(TipoPreferencia tipoPreferencia) throws Exception {
		this.tipoPreferencia = tipoPreferencia;
		preferencias= preferenciaDao.obtenerPreferenciasTipo(tipoPreferencia);
	}
	
	@Command
	@NotifyChange({"preferenciasAll","cantidadInteres"})
	public void eliminarInteres(@BindingParam("Interes") Preferencia pref){
		preferenciasAll.remove(pref);
	}
	
	public String getCantidadInteres(){
		return preferenciasAll.size()+" items en la lista";
	}
	
	@Command
	public void registrarAfiliado(@BindingParam("win") Window win) throws Exception{
		try{
			if(persona.getIdentificacion().equalsIgnoreCase("") || persona.getNombre().equalsIgnoreCase("")||
					persona.getApellido().equalsIgnoreCase("")|| persona.getTelefono().equalsIgnoreCase("")||
					persona.getCorreo().equalsIgnoreCase("")|| persona.getSexo().equalsIgnoreCase("")||
					persona.getDireccion().equalsIgnoreCase("")|| afiliado.getTipoAfiliado().equals(null)){
						Messagebox.show("Verifique que todo los datos estén llenos", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
			}
			else{
				personaDao= new PersonaDao();
				persona.setFechaNac(fechaNac);
				if(this.imagenNuevaAfiliado==true){
					this.persona.setFoto(ManejadorArchivo.subirImagen(uploadedImage));
				}
				persona.setActivo(true);
				personaDao.agregarPersona(persona);
				afiliado.setNroCarnet(getNroCarnet());
				afiliado.setPersona(persona);
				afiliado.setSocio(socio);
				afiliado.setActivo(true);
					
				afiliadoDao= new AfiliadoDao();
				afiliadoDao.agregarAfiliado(afiliado);
				preferenciaPersonaDao= new PreferenciaPersonaDao();
				if(preferenciasAll.size()>0){
					for(int i=0; i<preferenciasAll.size(); i++){
						preferenciaPersona=new PreferenciaPersona();
						preferenciaPersona.setPersona(persona);
						preferenciaPersona.setPreferencia(preferenciasAll.get(i));
						preferenciaPersona.setActivo(true);
						preferenciaPersonaDao.agregarPreferenciaPersona(preferenciaPersona);
				}
							
			}
						
			win.detach();
			BindUtils.postGlobalCommand(null, null, "refreshSocios", null);
			Messagebox.show("El Sr(a) "	+ afiliado.getPersona().getNombre() +" "+afiliado.getPersona().getApellido()
					+ " es ahora un afiliado del Sr. "+socio.getPersona().getNombre()+" "+socio.getPersona().getApellido(), "American Tech",
					Messagebox.OK, Messagebox.INFORMATION);
			}
		}
		catch(NullPointerException e){
			Messagebox.show("Verifique que todo los datos estén llenos", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
			
		}
	}
	
	@Command
	public void cancelar(@BindingParam("win") Window win){
		win.detach();
	}

	public Date getFechaNac() {
		return fechaNac;
	}
	@NotifyChange({"calcularEdad"})
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	
}
