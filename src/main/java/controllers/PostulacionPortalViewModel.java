package controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import modelos.MotivoPostulacion;
import modelos.Persona;
import modelos.Postulacion;
import modelos.Postulado;
import modelos.Preferencia;
import modelos.Socio;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.media.Media;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;

import Dao.MotivoPostulacionDao;
import Dao.PostulacionDao;
import Dao.PostuladoDao;
import Dao.PreferenciaDao;
import Dao.SocioDao;

public class PostulacionPortalViewModel {
	private PreferenciaDao preferenciaDao;
	private Set<Preferencia> temporalPreferencia;
	private MotivoPostulacionDao motivoPostulacionDao;
	private Persona persona;
	private Postulacion postulacion;
	private PostulacionDao postulacionDao;
	private Postulado postulado;
	private PostuladoDao postuladoDao;
	private Media uploadedImage;
	private boolean imagenPostulado;
	private List<Preferencia> preferencias;
	private Date now;
	private Socio padrino1, padrino2;
	private SocioDao socioDao;
	@Init
	public void init() throws Exception{
		this.preferenciaDao= new PreferenciaDao();
		//this.temporalPreferencia = new HashSet<Preferencia>();
		this.postulacion= new Postulacion();
		this.postulacionDao= new PostulacionDao();
		this.postulado= new Postulado();
		this.persona= new Persona();
		this.inicializar();
		this.socioDao= new SocioDao();
		this.padrino1=new Socio();
		this.padrino2=new Socio();
		this.motivoPostulacionDao= new MotivoPostulacionDao();
		this.preferencias= preferenciaDao.obtenerTodos();
		System.out.println("kdkladk");
	}
	public ListModelList<Preferencia> getPreferencias() {
		return new ListModelList<Preferencia>(this.preferencias);
	}
	
	public Set<Preferencia> getTemporalPreferencia() {

		return temporalPreferencia;
	}

	public void setTemporalPreferencia(Set<Preferencia> temporalPreferencia) {
		this.temporalPreferencia = temporalPreferencia;
	}
	
	public ListModelList<MotivoPostulacion> getMotivosAll() throws Exception{
		return new ListModelList<MotivoPostulacion>(motivoPostulacionDao.obtenerTodos());
	}
	public Persona getPersona() {
		return persona;
	}
	
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public boolean validarEdad() {
		Calendar birth = new GregorianCalendar();
		Calendar today = new GregorianCalendar();
		int age=0;
		int factor=0;
		
		Date birthDate;
			birthDate=this.persona.getFechaNac();
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
			if(age<18){
				return false;
			}
			else{
				return true;
			}
		}
	
	@Command
	@NotifyChange("uploadedImage")
	public void uploadImage(@BindingParam("media") Media myMedia) {
		imagenPostulado = true;
		uploadedImage = myMedia;
	}
	
	public Media getUploadedImage() {
		return uploadedImage;
	}
	
	public void setUploadedImage(Media uploadedImage) {
		this.uploadedImage = uploadedImage;
	}
	public Postulacion getPostulacion() {
		return postulacion;
	}
	public void setPostulacion(Postulacion postulacion) {
		this.postulacion = postulacion;
	}
	
	@Command
	public void agregarPostulacion() throws Exception{
		System.out.println(this.persona.getNombre());
		System.out.println(this.persona.getApellido());
		System.out.println(this.persona.getDireccion());
		System.out.println(this.persona.getTelefono());
		System.out.println(this.persona.getTelefonoFijo());
		System.out.println(this.persona.getCorreo());
		System.out.println(this.persona.getFechaNac());
		//System.out.println(this.uploadedImage.getContentType());

		if(this.persona.getNombre().equalsIgnoreCase("")||this.persona.getApellido().equalsIgnoreCase("")
			||this.persona.getDireccion().equalsIgnoreCase("")||this.persona.getTelefono().equals("")
			||this.persona.getTelefonoFijo().equalsIgnoreCase("")||this.persona.getCorreo().equalsIgnoreCase("")
			||this.persona.getFechaNac().equals(now)||this.persona.getSexo().equalsIgnoreCase("")
			||this.postulacion.getCarnetPadrino1().equalsIgnoreCase("")||this.postulacion.getCarnetPadrino2().equalsIgnoreCase("")
			||this.imagenPostulado==false){
			Messagebox.show("Debe llenar todos los campos", "Error", Messagebox.OK, Messagebox.EXCLAMATION);
		}else{
			if(this.validarEdad()==false){
				Messagebox.show("Debe ser mayor de edad para postularse", "Error", Messagebox.OK, Messagebox.EXCLAMATION);
			}
			else{
				try{
				this.padrino1=this.socioDao.obtenerSocioCarnet(this.postulacion.getCarnetPadrino1());
				this.padrino2=this.socioDao.obtenerSocioCarnet(this.postulacion.getCarnetPadrino2());
				System.out.println("padrino1: "+this.padrino1.getIdSocio());
				System.out.println("padrino2: "+this.padrino2.getIdSocio());
				
				}
				catch(NullPointerException e){
					Messagebox.show("Referencias de padrinos no existentes como socios activos. Verifique sus credenciales", "Error", Messagebox.OK, Messagebox.EXCLAMATION);
				}
				
			}
		}
		/*} catch (Exception e) {
			// TODO: handle exception
			Messagebox.show("Debe llenar todos los campos", "try catch", Messagebox.OK, Messagebox.EXCLAMATION);
			
		}*/
		
	}
	
	public void inicializar(){
		this.persona.setNombre("");
		this.persona.setApellido("");
		this.persona.setCorreo("");
		this.persona.setTelefono("");
		this.persona.setTelefonoFijo("");
		this.persona.setFechaNac(null);
		this.persona.setSexo("");
		this.now=new Date();
		this.persona.setFechaNac(now);
		this.postulacion.setCarnetPadrino1("");
		this.postulacion.setCarnetPadrino2("");
		this.imagenPostulado=false;
	}

}
