package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import modelos.Accion;
import modelos.Opinion;
import modelos.Postulacion;
import modelos.Preferencia;
import modelos.PreferenciaPersona;
import modelos.Socio;
import modelos.TipoActividad;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

import Dao.PostulacionDao;
import Dao.PreferenciaDao;
import Dao.SocioDao;


public class OpinionesDePostulanteViewModel {
	private Postulacion postulacion;
	private PostulacionDao postulacionDao;
	private Set<Opinion> opiniones;
	private Socio padrino1;
	private Socio padrino2;
	private SocioDao socioDao= new SocioDao();
	private String star1,star2,star3,star4,star5;
	private Set<Preferencia> preferencias;
	private PreferenciaDao prefDao= new PreferenciaDao();
	
	@Init
	public void init(@ExecutionArgParam("Postulacion") Postulacion postulacion) {
		this.postulacionDao= new PostulacionDao();
		this.postulacion = postulacion;
		this.opiniones= new HashSet<Opinion>();
		this.opiniones= postulacion.getOpinions();
		this.preferencias= new HashSet<Preferencia>();
		for (Iterator<PreferenciaPersona> i = postulacion.getPostulado().getPersona().getPreferenciaPersonas().iterator(); i.hasNext();) {
			PreferenciaPersona tmp = i.next();
			this.preferencias.add(tmp.getPreferencia());
		}
		
		star1=star2=star3=star4=star5="";
		if(Integer.parseInt(getEstrellas())==1){
			star1="select";
			star2="no_select";
			star3="no_select";
			star4="no_select";
			star5="no_select";
		} else if(Integer.parseInt(getEstrellas())==2){
			star1="select";
			star2="select";
			star3="no_select";
			star4="no_select";
			star5="no_select";
		}else if(Integer.parseInt(getEstrellas())==3){
			star1="select";
			star2="select";
			star3="select";
			star4="no_select";
			star5="no_select";
		}else if(Integer.parseInt(getEstrellas())==4){
			star1="select";
			star2="select";
			star3="select";
			star4="select";
			star5="no_select";
		}else if(Integer.parseInt(getEstrellas())==5){
			star1="select";
			star2="select";
			star3="select";
			star4="select";
			star5="select";
		}
		//this.padrino1= socioDao.obtenerSocioCarnet(postulacion.getCarnetPadrino1());
		//this.padrino2= socioDao.obtenerSocioCarnet(postulacion.getCarnetPadrino2());
	}
	
	public ListModelList<Opinion> getOpinionesAll(){
		 return new ListModelList<Opinion>(opiniones);
	}
	public ListModelList<Preferencia> getPreferenciasAll(){
		 return new ListModelList<Preferencia>(preferencias);
	}
	public String getCantidadPreferencias(){
		return this.preferencias.size() + " items en la lista";
	}
	public String getCantidadOpiniones(){
		return opiniones.size() + " items en la lista";
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
	public Socio getPadrino1() {
		return padrino1;
	}

	public Socio getPadrino2() {
		return padrino2;
	}
	public String getNombrePadrino1(){
		return this.padrino1.getPersona().getNombre() + " "+ this.padrino1.getPersona().getApellido();
	}
	public String getNombrePadrino2(){
		return this.padrino2.getPersona().getNombre() + " "+ this.padrino2.getPersona().getApellido();
	}

	public String getStar1() {
		return star1;
	}

	public String getStar2() {
		return star2;
	}

	public String getStar3() {
		return star3;
	}

	public String getStar4() {
		return star4;
	}

	public String getStar5() {
		return star5;
	}
	@NotifyChange({"star1","star2","star3","star4","star5"})
	public void setEstrellas(String s){
		if(Integer.parseInt(s)==1){
			star1="select";
			star2="no_select";
			star3="no_select";
			star4="no_select";
			star5="no_select";
		} else if(Integer.parseInt(s)==2){
			star1="select";
			star2="select";
			star3="no_select";
			star4="no_select";
			star5="no_select";
		}else if(Integer.parseInt(s)==3){
			star1="select";
			star2="select";
			star3="select";
			star4="no_select";
			star5="no_select";
		}else if(Integer.parseInt(s)==4){
			star1="select";
			star2="select";
			star3="select";
			star4="select";
			star5="no_select";
		}else if(Integer.parseInt(s)==5){
			star1="select";
			star2="select";
			star3="select";
			star4="select";
			star5="select";
		}
	}
	public String getEstrellas() {
		return "1";
	}
	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}
}
