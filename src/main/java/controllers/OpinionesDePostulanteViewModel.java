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
import modelos.TipoOpnion;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

import util.ContadorOpinion;
import util.StarRating;
import Dao.OpinionDao;
import Dao.PostulacionDao;
import Dao.PreferenciaDao;
import Dao.SocioDao;
import Dao.TipoOpnionDao;


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
	private StarRating starRating;
	private List<StarRating> starsRatings;
	private boolean verDatos;
	private TipoOpnion tipoOpinion;
	private TipoOpnionDao tipoOpinionDao;
	private List<TipoOpnion> tiposOpinions;
	private OpinionDao opinionDao;
	private List<ContadorOpinion> contadores;
	
	@Init
	public void init(@ExecutionArgParam("Postulacion") Postulacion postulacion, @ExecutionArgParam("verDatos") boolean ver) throws Exception {
		this.postulacionDao= new PostulacionDao();
		this.postulacion = postulacion;
		this.opiniones= new HashSet<Opinion>();
		this.opiniones= postulacion.getOpinions();
		this.preferencias= new HashSet<Preferencia>();
		this.tipoOpinionDao= new TipoOpnionDao();
		this.tiposOpinions= tipoOpinionDao.obtenerTodos();
		this.opinionDao= new OpinionDao();
		this.tipoOpinion= new TipoOpnion();
		contadores= new ArrayList<ContadorOpinion>();
		verDatos=ver;
		Contador();
		for (Iterator<PreferenciaPersona> i = postulacion.getPostulado().getPersona().getPreferenciaPersonas().iterator(); i.hasNext();) {
			PreferenciaPersona tmp = i.next();
			this.preferencias.add(tmp.getPreferencia());
		}
		
		this.padrino1= socioDao.obtenerSocioCarnet(postulacion.getCarnetPadrino1());
		this.padrino2= socioDao.obtenerSocioCarnet(postulacion.getCarnetPadrino2());
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
	
	public ListModelList<TipoOpnion> getTiposOpiniones(){
		return new ListModelList<TipoOpnion>(tiposOpinions);
	}
	
	public TipoOpnion getTipoOpinion() {
		return tipoOpinion;
	}
	
	@NotifyChange({"opinionesAll"})
	public void setTipoOpinion(TipoOpnion tipoOpinion) throws Exception {
		this.tipoOpinion = tipoOpinion;
		this.opiniones=new HashSet<Opinion>(this.opinionDao.obtenerOpinionesPostulacionbyTipo(postulacion, tipoOpinion));
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

	
	public boolean isVerDatos() {
		return verDatos;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}
	
	public ListModelList<StarRating> getStarRatings(){
		return new ListModelList<StarRating>(starsRatings);
	}
	
	public void agregarEstrellas(){
		for (Iterator<Opinion> i = opiniones.iterator(); i.hasNext();) {
			Opinion tmp = i.next();
			StarRating star=new StarRating();
			if(tmp.getCalificacion()==1){
				star=new StarRating("select", "no_select","no_select","no_select","no_select");
			} else if(tmp.getCalificacion()==2){
				star=new StarRating("select", "select","no_select","no_select","no_select");
			}else if(tmp.getCalificacion()==3){
				star=new StarRating("select", "select","select","no_select","no_select");
			}else if(tmp.getCalificacion()==4){
				star=new StarRating("select", "select","select","select","no_select");
			}else if(tmp.getCalificacion()==5){
				star=new StarRating("select", "select","select","no_select","select");
			}
			starsRatings.add(star);
		}		
	}
	public int getPromediarStars(){
		float promedio=0;
		for (Iterator<Opinion> i = opiniones.iterator(); i.hasNext();) {
			Opinion tmp = i.next();
			promedio+=tmp.getCalificacion();
		}
		return (int) (promedio/opiniones.size());
	}
	
	public void Contador(){
		for(int i=0; i<this.tiposOpinions.size(); i++){
			contadores.add(new ContadorOpinion(this.tiposOpinions.get(i), this.tiposOpinions.get(i).getcantidadOpinions(postulacion)));
		}
	}
	public ListModelList<ContadorOpinion> getContadores(){
		return new ListModelList<ContadorOpinion>(contadores);
	}
}
