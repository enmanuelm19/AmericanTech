package controllers;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import modelos.Accion;
import modelos.Afiliado;
import modelos.Preferencia;
import modelos.PreferenciaPersona;
import modelos.Socio;
import modelos.TipoEventualidad;
import modelos.TipoPreferencia;
import modelos.Usuario;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import util.ManejadorArchivo;
import Dao.AccionDao;
import Dao.AfiliadoDao;
import Dao.PreferenciaDao;
import Dao.PreferenciaPersonaDao;
import Dao.SocioDao;
import Dao.TipoPreferenciaDao;
import Dao.UsuarioDao;

public class MiPerfilViewModel {

	private Usuario usuario;
	private PreferenciaPersonaDao preferenciaPDAO;
	private AfiliadoDao afiliadoDao;
	private AccionDao accionDao;
	private SocioDao socioDao;
	private Socio socio;
	private UsuarioDao usuarioDao;
	private PreferenciaDao preferenciaDao;
	private TipoPreferenciaDao tPreferenciaDao;
	private TipoPreferencia tipoPreferenciaSelected;
	private ArrayList<Preferencia> temporalPreferencia;
	private Set<PreferenciaPersona> PreferenciasPersona;
	private Media uploadedImage;
	private boolean imagenNueva = false;
	private Afiliado afiliado;
	private boolean verAfiliado;
	private Set<Afiliado> afiliados;


	@Init
	public void init() throws Exception {
		usuario = (Usuario) Sessions.getCurrent().getAttribute("Usuario");
		this.preferenciaPDAO = new PreferenciaPersonaDao();
		this.afiliadoDao = new AfiliadoDao();
		this.accionDao = new AccionDao();
		this.socioDao = new SocioDao();
		this.afiliado= afiliadoDao.obtenerPorPersona(usuario.getPersona());
		this.socio = socioDao.obtenerSocioPersona(usuario.getPersona());
		if(this.afiliado==null && this.socio==null){
			verAfiliado=false;
		}else{
			if(this.afiliado!=null){
				verAfiliado=false;
				this.afiliados= new HashSet<Afiliado>();
			} else if(this.socio!=null){
				verAfiliado=true;
				this.afiliados= this.socio.getAfiliados();
			}
		}
		preferenciaDao = new PreferenciaDao();
		tPreferenciaDao = new TipoPreferenciaDao();
		temporalPreferencia = new ArrayList<Preferencia>();
		PreferenciasPersona = usuario.getPersona().getPreferenciaPersonas();
		preferenciaPDAO = new PreferenciaPersonaDao();
		this.usuarioDao= new UsuarioDao();
		
	}
	
	
	public boolean isVerAfiliado() {
		return verAfiliado;
	}



	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public TipoPreferencia getTipoPreferenciaSelected() {
		return tipoPreferenciaSelected;
	}

	public ArrayList<Preferencia> getTemporalPreferencia() {
		return temporalPreferencia;
	}

	public void setTemporalPreferencia(ArrayList<Preferencia> temporalPreferencia) {
		this.temporalPreferencia = temporalPreferencia;
	}

	@NotifyChange("preferenciasPorTipo")
	public void setTipoPreferenciaSelected(TipoPreferencia tipoPreferenciaSelected) {
		this.tipoPreferenciaSelected = tipoPreferenciaSelected;
	}

	public ListModelList<PreferenciaPersona> getAllPreferenciasPersona(){
		
		ArrayList<PreferenciaPersona> preferenciasMostrar = new ArrayList<PreferenciaPersona>();
		for(PreferenciaPersona preferenciaPersona:PreferenciasPersona){
			if(preferenciaPersona.isActivo())
				preferenciasMostrar.add(preferenciaPersona);
		}
		return new ListModelList<PreferenciaPersona>(preferenciasMostrar);
	}

	public ListModelList<Afiliado> getAllAfiliados() throws Exception {
		return new ListModelList<Afiliado>(usuario.getPersona().getSocios().iterator().next().getAfiliados());
	}

	public ListModelList<Accion> getAllAcciones() throws Exception {

		return new ListModelList<Accion>(accionDao.obtenerPorSocio(socio));
	}
	
	public ListModelList<TipoPreferencia> getAllTipoPreferencia() throws Exception {

		return new ListModelList<TipoPreferencia>(tPreferenciaDao.obtenerTodos());
	}
/*
	public ListModelList<Preferencia> getPreferenciasPorTipo() throws Exception {
		if (tipoPreferenciaSelected != null) {
			return new ListModelList<Preferencia>(preferenciaDao.obtenerPreferenciasTipo(tipoPreferenciaSelected));
		}
		return new ListModelList<Preferencia>();
	}
	*/
	public ListModelList<Preferencia> getPreferenciasAll() throws Exception{
		List<Preferencia> preferencias= new ArrayList<Preferencia>();
		if(this.afiliado!=null){
			List<Preferencia> p=this.preferenciaDao.obtenerTodos();
			for(int j=0; j<p.size(); j++){
				boolean val=false;

				for(Iterator<PreferenciaPersona> i=afiliado.getPersona().getPreferenciaPersonas().iterator(); i.hasNext();){
					PreferenciaPersona tmp= i.next();
					if(tmp.getPreferencia().getIdPreferencia()==p.get(j).getIdPreferencia()){
						val=true;
					}
				}
				if(val==false)
					preferencias.add(p.get(j));
			}
		}
		else if(this.socio!=null){
			List<Preferencia> p=this.preferenciaDao.obtenerTodos();
			for(int j=0; j<p.size(); j++){
				boolean val=false;
				for(Iterator<PreferenciaPersona> i=socio.getPersona().getPreferenciaPersonas().iterator(); i.hasNext();){
					PreferenciaPersona tmp= i.next();
					if(tmp.getPreferencia().getIdPreferencia()==p.get(j).getIdPreferencia()){
						val=true;
					}
				}
				if(val==false)
					preferencias.add(p.get(j));
			}
		}
		return new ListModelList<Preferencia>(preferencias);
			
			/*
				
				
		} else if(this.socio!=null){
			List<Preferencia> p=this.preferenciaDao.obtenerTodos();
			
			for(Iterator<PreferenciaPersona> i=socio.getPersona().getPreferenciaPersonas().iterator(); i.hasNext();){
				boolean val=false;
				PreferenciaPersona tmp= i.next();
				
				for(int j=0; j<p.size(); j++){
					if(tmp.getPreferencia().getIdPreferencia()==p.get(j).getIdPreferencia()){
						val=true;
					}
				}
				if(val==false)
					preferencias.add(p.get(j));
			}*/
		}
	
	public String getCantidadPreferencias(){
		return getAllPreferenciasPersona().size()+" items en la lista";
	} 
	
	public String getCantidadAcciones() throws Exception{
		return getAllAcciones().size()+" items en la lista";
	} 
	
	public String getCantidadAfiliado() throws Exception{
		return getAllAfiliados().size()+" items en la lista";
	} 

	public int getCalcularEdad() {
		Calendar birth = new GregorianCalendar();
		Calendar today = new GregorianCalendar();
		int age=0;
		int factor=0;
		Date birthDate= this.usuario.getPersona().getFechaNac();
		Date currentDate= new Date(); //current date
		birth.setTime(birthDate);
		today.setTime(currentDate);
		if (today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)) {
			if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
				if (today.get(Calendar.DATE) > birth.get(Calendar.DATE)) {
					factor = -1;
				}
			} else {
		factor = -1; 
		}
		
		} 
		age=(today.get(Calendar.YEAR)-birth.get(Calendar.YEAR))+factor;
		return age;
	}
	

	
	@Command
	@NotifyChange({ "allPreferenciasPersona", "cantidadPreferencias" })
	public void agregarPreferenciasPersona() {

		PreferenciaPersona preferenciaPersona;
		for (Preferencia preferencia : temporalPreferencia) {
			if (buscarPreferecia(preferencia) == null) {
				preferenciaPersona = new PreferenciaPersona();
				preferenciaPersona.setPersona(usuario.getPersona());
				preferenciaPersona.setActivo(true);
				preferenciaPersona.setPreferencia(preferencia);
				PreferenciasPersona.add(preferenciaPersona);
			}
		}
	}
	
	public Preferencia buscarPreferecia(Preferencia preferencia) {
		for (PreferenciaPersona preferenciaPersona : PreferenciasPersona) {
			if (preferenciaPersona.getPreferencia().getIdPreferencia() == preferencia.getIdPreferencia())
				return preferencia;
		}
		return null;
	}
	
	@Command
	@NotifyChange({ "allPreferenciasPersona", "cantidadPreferencias","preferenciasAll" })
	public void eliminarPreferencia(@BindingParam("PreferenciaP") PreferenciaPersona p) throws Exception {
		if(preferenciaPDAO.obtenerPreferenciaPersona(p.getIdPreferenciaPersona())!=null)
			p.setActivo(false);
		else PreferenciasPersona.remove(p);
		
	}
	



	public void setImagenNueva(boolean imagenNueva) {
		this.imagenNueva = imagenNueva;
	}
	

	@Command
	@NotifyChange("uploadedImage")
	public void upload(@BindingParam("media") Media myMedia){
		imagenNueva=true;
		uploadedImage = myMedia;
	}

	public Media getUploadedImage() {
		return uploadedImage;
	}


	public void setUploadedImage(Media uploadedImage) {
		this.uploadedImage = uploadedImage;
	}
	
	@Command
	public void guardar() throws Exception{
		if(imagenNueva){
			this.usuario.getPersona().setFoto(ManejadorArchivo.subirImagen(uploadedImage));
		}
		
		this.usuarioDao.actualizarUsuario(usuario);
		Messagebox.show("Usuario " + usuario.getPersona().getNombre()
				+ " ha sido actualizado", "American Tech", Messagebox.OK,
				Messagebox.INFORMATION);
		
	}
	
	@Command
	public void cancelar() {
		Executions.sendRedirect("/vistas/index.zul");
	}
	
	@Command
	public void showModal(@BindingParam("cambiar") Usuario usuario) {


		Map<String, Object> args = new HashMap<String, Object>();
		args.put("Usuario", usuario);
		Window window = (Window) Executions.createComponents("socio/cambiarClave.zul",
				null, args);
		window.doModal();
	}
	
	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}
	
	
	
}
