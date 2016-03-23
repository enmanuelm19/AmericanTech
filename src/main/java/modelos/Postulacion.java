package modelos;

// Generated 05/03/2016 11:15:24 PM by Hibernate Tools 4.3.1

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import util.StarRating;

/**
 * Postulacion generated by hbm2java
 */
public class Postulacion implements java.io.Serializable {

	private int idPostulacion;
	private MotivoPostulacion motivoPostulacion;
	private Postulado postulado;
	private Date fecha;
	private String carnetPadrino1;
	private String carnetPadrino2;
	private boolean aprobado;
	private boolean activo;
	private Set<Socio> socios = new HashSet<Socio>(0);
	private Set<Opinion> opinions = new HashSet<Opinion>(0);
	private Set<Venta> ventas = new HashSet<Venta>(0);
	private Set<Noticia> noticias = new HashSet<Noticia>(0);

	public Postulacion() {
	}

	public Postulacion(int idPostulacion, MotivoPostulacion motivoPostulacion,
			Postulado postulado, Date fecha, String carnetPadrino1,
			String carnetPadrino2, boolean aprobado, boolean activo) {
		this.idPostulacion = idPostulacion;
		this.motivoPostulacion = motivoPostulacion;
		this.postulado = postulado;
		this.fecha = fecha;
		this.carnetPadrino1 = carnetPadrino1;
		this.carnetPadrino2 = carnetPadrino2;
		this.aprobado = aprobado;
		this.activo = activo;
	}

	public Postulacion(int idPostulacion, MotivoPostulacion motivoPostulacion,
			Postulado postulado, Date fecha, String carnetPadrino1,
			String carnetPadrino2, boolean aprobado, boolean activo,
			Set<Socio> socios, Set<Opinion> opinions, Set<Venta> ventas,
			Set<Noticia> noticias) {
		this.idPostulacion = idPostulacion;
		this.motivoPostulacion = motivoPostulacion;
		this.postulado = postulado;
		this.fecha = fecha;
		this.carnetPadrino1 = carnetPadrino1;
		this.carnetPadrino2 = carnetPadrino2;
		this.aprobado = aprobado;
		this.activo = activo;
		this.socios = socios;
		this.opinions = opinions;
		this.ventas = ventas;
		this.noticias = noticias;
	}

	public int getIdPostulacion() {
		return this.idPostulacion;
	}

	public void setIdPostulacion(int idPostulacion) {
		this.idPostulacion = idPostulacion;
	}

	public MotivoPostulacion getMotivoPostulacion() {
		return this.motivoPostulacion;
	}

	public void setMotivoPostulacion(MotivoPostulacion motivoPostulacion) {
		this.motivoPostulacion = motivoPostulacion;
	}

	public Postulado getPostulado() {
		return this.postulado;
	}

	public void setPostulado(Postulado postulado) {
		this.postulado = postulado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCarnetPadrino1() {
		return this.carnetPadrino1;
	}

	public void setCarnetPadrino1(String carnetPadrino1) {
		this.carnetPadrino1 = carnetPadrino1;
	}

	public String getCarnetPadrino2() {
		return this.carnetPadrino2;
	}

	public void setCarnetPadrino2(String carnetPadrino2) {
		this.carnetPadrino2 = carnetPadrino2;
	}

	public boolean isAprobado() {
		return this.aprobado;
	}

	public void setAprobado(boolean aprobado) {
		this.aprobado = aprobado;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<Socio> getSocios() {
		return this.socios;
	}

	public void setSocios(Set<Socio> socios) {
		this.socios = socios;
	}

	public Set<Opinion> getOpinions() {
		return this.opinions;
	}

	public void setOpinions(Set<Opinion> opinions) {
		this.opinions = opinions;
	}

	public Set<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(Set<Venta> ventas) {
		this.ventas = ventas;
	}

	public Set<Noticia> getNoticias() {
		return this.noticias;
	}

	public void setNoticias(Set<Noticia> noticias) {
		this.noticias = noticias;
	}
	
	
	
	
	
	/*****************ESTRELLAS****************************/
	public StarRating getEstrellas(){
		float promedio=0;
		int prom=0;
		StarRating star= new StarRating();
		for (Iterator<Opinion> i = opinions.iterator(); i.hasNext();) {
			Opinion tmp = i.next();
			promedio+=tmp.getCalificacion();
		}
		prom=(int) (promedio/opinions.size());
		if(prom==0){
			star=new StarRating("no_select", "no_select","no_select","no_select","no_select");
		}
		if(prom==1){
			star=new StarRating("select", "no_select","no_select","no_select","no_select");
		} else if(prom==2){
			star=new StarRating("select", "select","no_select","no_select","no_select");
		}else if(prom==3){
			star=new StarRating("select", "select","select","no_select","no_select");
		}else if(prom==4){
			star=new StarRating("select", "select","select","select","no_select");
		}else if(prom==5){
			star=new StarRating("select", "select","select","select","select");
		}
		return star;
	}
	public String getFechaParse(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");  
		  
		 return sdf.format(this.fecha);
	}
}
