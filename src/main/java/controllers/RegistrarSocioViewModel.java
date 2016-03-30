package controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.AccionDao;
import Dao.EstadoAccionDao;
import Dao.NoticiaDao;
import Dao.PostulacionDao;
import Dao.SocioDao;
import Dao.TipoNoticiaDao;
import modelos.Accion;
import modelos.Noticia;
import modelos.Postulacion;
import modelos.Socio;
import util.ManejadorMail;
import modelos.EstadoAccion;

public class RegistrarSocioViewModel {
	private Postulacion postulacion;
	private SocioDao socioDao;
	private List<Accion> acciones;
	private AccionDao accionDao;
	private Accion seleccionada;
	private String nroCarnet;
	private PostulacionDao postulacionDao;
	private EstadoAccionDao estadoAccionDao;
	private Socio socio;
	private Noticia noticia;
	private TipoNoticiaDao tipoNoticiaDao;
	private NoticiaDao noticiaDao;
	
	@Init
	public void init(@ExecutionArgParam("Postulacion") Postulacion postulacions) throws Exception{
		this.postulacion=postulacions;
		this.accionDao= new AccionDao();
		this.acciones= new ArrayList<Accion>();
		this.socio= new Socio();
		this.socioDao= new SocioDao();
		this.tipoNoticiaDao = new TipoNoticiaDao();
		this.noticiaDao= new NoticiaDao();
		List<Accion> acc=accionDao.obtenerTodos();
		for (int i = 0; i < acc.size(); i++) {
			if(acc.get(i).getEstadoAccion().getIdEstadoAccion()==2)
				this.acciones.add(acc.get(i));
		}
	}
	
	public ListModelList<Accion> getAccionesAll(){
		return new ListModelList<Accion>(acciones);
	}
	
	public String getCantidadAcciones(){
		return acciones.size() + " items en la lista";
	}
	public Postulacion getPostulacion(){
		return this.postulacion;
	}

	public int getCalcularEdad() {
		Calendar birth = new GregorianCalendar();
		Calendar today = new GregorianCalendar();
		int age=0;
		int factor=0;
		Date birthDate=this.postulacion.getPostulado().getPersona().getFechaNac();
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

	public Accion getSeleccionada() {
		return this.seleccionada;
	}

	public void setSeleccionada(Accion seleccionada) {
		this.seleccionada = seleccionada;
	}
	
	
	public String getNroCarnet() {
		return nroCarnet;
	}

	public void setNroCarnet(String nroCarnet) {
		this.nroCarnet = nroCarnet;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}
	
	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {
		if (getNroCarnet() != null && !getNroCarnet().equalsIgnoreCase("")) {
			if(validarCarnet()==true)
				Messagebox.show("El número de carnet ya existe", "American Tech", Messagebox.OK, Messagebox.INFORMATION);
			else{
			if(this.seleccionada!=null){
				this.postulacion.setAprobado(true);
				this.socio= new Socio();
				socio.setPersona(this.postulacion.getPostulado().getPersona());
				socio.setPostulacion(this.postulacion);
				socio.setNroCarnet(this.getNroCarnet());
				this.accionDao= new AccionDao();
				
				this.socioDao.agregarSocio(this.socio);
				postulacionDao= new PostulacionDao();
				postulacionDao.eliminarPostulacion(this.postulacion);
				
				this.estadoAccionDao= new EstadoAccionDao();
				EstadoAccion est= estadoAccionDao.obtenerEstadoAccion(1);
				seleccionada.setSocio(socio);
				seleccionada.setEstadoAccion(est);
				accionDao.actualizarAccion(seleccionada);
				
				//AQUI CAMBIO EL ESTADO DE LA ACCION
				Messagebox.show("El Sr(a) "+socio.getPersona().getNombre()+" "+socio.getPersona().getApellido()+" es ahora un socio del Centro Atlético América", "American Tech", Messagebox.OK, Messagebox.INFORMATION);
				publicarNoticia();
				Noticia n= noticiaDao.obtenerNoticiaPostulacion(postulacion);
				noticiaDao.eliminarNoticia(n);
				String mensaje, destinatario, asunto;
				mensaje = "Sr(a) " + socio.getPersona().getNombre() + " " + socio.getPersona().getApellido()
						+ " nos complace informarle que ha sido aceptado como mienbro en la familia americanista, pronto sera contactado por nuestro personal "
						+ "para asignarle sus credenciales de acceso a la plataforma American Tech";
				destinatario = socio.getPersona().getCorreo();
				asunto = "Centro Atlético América | Aprobación de Postulación";
				ManejadorMail.enviarEmail(mensaje, destinatario, asunto);
				BindUtils.postGlobalCommand(null, null, "refreshPostulantes", null);
				win.detach();
			} else {
				Messagebox.show("Debe seleccionar un acción a vincular", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
			}
			}
		} else {
			Messagebox.show("El campo Número Carnet no puede estar vacio", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		}
	}
	public void publicarNoticia() throws Exception{
		this.noticia=new Noticia();
		this.noticia.setTitulo("Nuevo Socio");
		this.noticia.setDescripcion("El Sr(a). "+socio.getPersona().getNombre()+" "+socio.getPersona().getApellido()+" es un nuevo intengrante de la familia americanista");
		this.noticia.setTipoNoticia(this.tipoNoticiaDao.obtenerTipoNoticia(6));
		this.noticia.setFechaCreacion(new Date());
		this.noticia.setFoto(socio.getPersona().getFoto());
		this.noticia.setPublico(false);
		Date dia= new Date();
		dia.setDate(new Date().getDate()+5);
		this.noticia.setCaducidad(dia);
		this.noticia.setPublico(true);
		this.noticia.setActivo(true);
		this.noticiaDao.agregarNoticia(noticia);
	}
	
	public boolean validarCarnet() throws Exception{
		List<Socio> so= socioDao.obtenerTodos();
		boolean val=false;
		for(int i=0; i<so.size(); i++){
			if(so.get(i).getNroCarnet().equalsIgnoreCase(nroCarnet))
				val=true;
		}
		return val;
	}
}
	
