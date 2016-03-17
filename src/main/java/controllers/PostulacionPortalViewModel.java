package controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javassist.bytecode.stackmap.BasicBlock.Catch;
import modelos.MotivoPostulacion;
import modelos.Noticia;
import modelos.Persona;
import modelos.Postulacion;
import modelos.Postulado;
import modelos.Preferencia;
import modelos.PreferenciaPersona;
import modelos.Socio;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.media.Media;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;

import util.ManejadorArchivo;
import Dao.MotivoPostulacionDao;
import Dao.NoticiaDao;
import Dao.PersonaDao;
import Dao.PostulacionDao;
import Dao.PostuladoDao;
import Dao.PreferenciaDao;
import Dao.PreferenciaPersonaDao;
import Dao.SocioDao;
import Dao.TipoNoticiaDao;

public class PostulacionPortalViewModel {
	private PreferenciaDao preferenciaDao;
	private List<Preferencia> temporalPreferencia;
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
	private PersonaDao personaDao;
	private PreferenciaPersona perfePersona;
	private PreferenciaPersonaDao prefPersonaDao;
	private Noticia noticia;
	private TipoNoticiaDao tipoNoticiaDao;
	private NoticiaDao noticiaDao;
	@Init
	public void init() throws Exception{
		this.preferenciaDao= new PreferenciaDao();
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
		this.personaDao= new PersonaDao();
		this.prefPersonaDao= new PreferenciaPersonaDao();
		this.perfePersona= new PreferenciaPersona();
		this.temporalPreferencia= new ArrayList<Preferencia>();
		this.noticiaDao= new NoticiaDao();
		this.tipoNoticiaDao= new TipoNoticiaDao();
		System.out.println("kdkladk");
	}
	public ListModelList<Preferencia> getPreferencias() {
		return new ListModelList<Preferencia>(this.preferencias);
	}
	
	public List<Preferencia> getTemporalPreferencia() {
		return temporalPreferencia;
	}

	public void setTemporalPreferencia(List<Preferencia> temporalPreferencia) {
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
						factor = -1; //Aun no celebra su cumplea√±os
					}
				} else {
			factor = -1; //Aun no celebra su cumplea√±os
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
	
	@SuppressWarnings("deprecation")
	@Command
	@NotifyChange({"preferencias","temporalPreferencia","persona","uploadedImage","postulacion"})
	public void agregarPostulacion() throws Exception{
		if(this.persona.getNombre().equalsIgnoreCase("")||this.persona.getApellido().equalsIgnoreCase("")
			||this.persona.getDireccion().equalsIgnoreCase("")||this.persona.getTelefono().equals("")
			||this.persona.getTelefonoFijo().equalsIgnoreCase("")||this.persona.getCorreo().equalsIgnoreCase("")
			||this.persona.getFechaNac().equals(now)||this.persona.getSexo().equalsIgnoreCase("")
			||this.postulacion.getCarnetPadrino1().equalsIgnoreCase("")||this.postulacion.getCarnetPadrino2().equalsIgnoreCase("")
			||this.imagenPostulado==false){
			Messagebox.show("Debe llenar todos los campos", "Error", Messagebox.OK, Messagebox.EXCLAMATION);
		}else{
			if(validarCedula()==true){
				if(this.validarEdad()==false){
					Messagebox.show("Debe ser mayor de edad para postularse", "Error", Messagebox.OK, Messagebox.EXCLAMATION);
				}
				else{
					try{
						if(this.postulacion.getCarnetPadrino1().equalsIgnoreCase(this.postulacion.getCarnetPadrino2())){
							Messagebox.show("Referencias de padrinos no pueden ser idÈnticas. Verifique sus credenciales", "Error", Messagebox.OK, Messagebox.EXCLAMATION);
						}
						else{
							this.padrino1=this.socioDao.obtenerSocioCarnet(this.postulacion.getCarnetPadrino1());
							this.padrino2=this.socioDao.obtenerSocioCarnet(this.postulacion.getCarnetPadrino2());
							if(!this.padrino1.equals(null) && !this.padrino2.equals(null)){
								this.persona.setFoto(ManejadorArchivo.subirImagen(uploadedImage));
								this.personaDao.agregarPersona(persona);
								this.postulado.setPersona(this.persona);
								this.postulado.setActivo(true);
								this.postulacion.setPostulado(postulado);
								this.postulacion.setActivo(true);
								this.postulacion.setFecha(new Date());
								for(int i=0; i<this.temporalPreferencia.size(); i++){
									this.perfePersona.setPersona(persona);
									this.perfePersona.setPreferencia(this.temporalPreferencia.get(i));
									this.perfePersona.setActivo(true);
									this.prefPersonaDao.agregarPreferenciaPersona(perfePersona);
								}
								this.postulacionDao.agregarPostulacion(postulacion);
								
								/*********************NOTICIA*******************/
								this.noticia=new Noticia();
								this.noticia.setTitulo("Nueva PostulaciÛn");
								this.noticia.setDescripcion("El Sr(a). "+this.persona.getNombre()+" "+this.persona.getApellido()+", se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra secciÛn de opiniones postulantes!");
								this.noticia.setTipoNoticia(this.tipoNoticiaDao.obtenerTipoNoticia(5));
								this.noticia.setFechaCreacion(now);
								this.noticia.setCaducidad(now);
								this.noticia.setPublico(false);
								this.noticia.setFoto(this.persona.getFoto());
								this.noticia.setActivo(true);
								this.noticiaDao.agregarNoticia(noticia);
								this.persona=new Persona();
								this.temporalPreferencia= new ArrayList<Preferencia>();
								this.postulacion= new Postulacion();
								this.postulado= new Postulado();
								this.preferencias= preferenciaDao.obtenerTodos();
								this.uploadedImage=null;
								this.inicializar();
								Messagebox.show("Pronto sera contactado por nuestro personal", "°Solicitud Enviada!", Messagebox.OK, Messagebox.INFORMATION);
							}
						}
					}
					catch(NullPointerException e){
						Messagebox.show("Referencias de padrinos no existentes como socios activos. Verifique sus credenciales", "Error", Messagebox.OK, Messagebox.EXCLAMATION);
					}
				}
			}
			else{
				Messagebox.show("CÈdula encontrada en nuestros registros", "Aviso", Messagebox.OK, Messagebox.EXCLAMATION);
			}
		}
		
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
	
	public boolean validarCedula() throws Exception{
		boolean valido=false;
		Persona p= new Persona();
		p=personaDao.obtenerPersonaCedula(this.persona.getIdentificacion());
		try{
			if(!p.equals(null))
				valido=false;
		}
		catch(NullPointerException e){
			valido= true;
		}
		return valido;
	}
}