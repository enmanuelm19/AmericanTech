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
import Dao.PostulacionDao;
import Dao.SocioDao;
import modelos.Accion;
import modelos.Postulacion;
import modelos.Socio;
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
	
	@Init
	public void init(@ExecutionArgParam("Postulacion") Postulacion postulacions) throws Exception{
		System.out.println("Apellido "+postulacions.getPostulado().getPersona().getApellido());
		this.postulacion=postulacions;
		this.accionDao= new AccionDao();
		this.acciones= new ArrayList<Accion>();
		this.socio= new Socio();
		this.socioDao= new SocioDao();

		List<Accion> acc=accionDao.obtenerTodos();
		for (int i = 0; i < acc.size(); i++) {
			System.out.println("nro: " +acc.get(i).getEstadoAccion().getIdEstadoAccion());
			if(acc.get(i).getEstadoAccion().getIdEstadoAccion()==2)
				this.acciones.add(acc.get(i));
		}
		System.out.println("Apellido "+this.postulacion.getPostulado().getPersona().getApellido());
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
		System.out.println("dasdasdd: "+this.seleccionada.getIdAccion());
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
			if(this.seleccionada!=null){
				this.postulacion.setAprobado(true);
				this.socio= new Socio();
				socio.setPersona(this.postulacion.getPostulado().getPersona());
				socio.setPostulacion(this.postulacion);
				socio.setNroCarnet(this.getNroCarnet());
				System.out.println("socio es: "+socio.getPersona().getNombre());
				this.accionDao= new AccionDao();
				System.out.println("lllsla: "+socio);
			
				this.socioDao.agregarSocio(this.socio);
				postulacionDao= new PostulacionDao();
				postulacionDao.eliminarPostulacion(this.postulacion);
				
				this.estadoAccionDao= new EstadoAccionDao();
				EstadoAccion est= estadoAccionDao.obtenerEstadoAccion(1);
				seleccionada.setSocio(socio);
				seleccionada.setEstadoAccion(est);
				accionDao.actualizarAccion(seleccionada);
				
				//AQUI CAMBIO EL ESTADO DE LA ACCION
				BindUtils.postGlobalCommand(null, null, "refreshPostulantes", null);
				win.detach();
			} else {
				Messagebox.show("Debe seleccionar un accion a vincular", "Error", Messagebox.OK, Messagebox.EXCLAMATION);
			}
		
		} else {
			Messagebox.show("El campo Nro Carnet no puede estar vacio", "Error", Messagebox.OK, Messagebox.EXCLAMATION);
		}
	}
	
}
	
