package controllers;

import java.util.Date;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.ClubDao;
import Dao.JuntaDirectivaDao;
import modelos.JuntaDirectiva;

public class RegistrarJuntaDirectiva {
	private JuntaDirectiva juntaDirectiva;
	private JuntaDirectivaDao juntaDirectivaDao;
	private Date fechaInicio;
	private Date fechaFin;
	private ClubDao clubDao;
	@Init
	public void init(){
		juntaDirectiva=new JuntaDirectiva();
		juntaDirectivaDao= new JuntaDirectivaDao();
		fechaInicio=new Date();
		fechaFin=new Date();
		clubDao= new ClubDao();
	}
	public JuntaDirectiva getJuntaDirectiva() {
		return juntaDirectiva;
	}
	public void setJuntaDirectiva(JuntaDirectiva juntaDirectiva) {
		this.juntaDirectiva = juntaDirectiva;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		if(fechaInicio.after(fechaFin)){
			Messagebox.show("Fecha de inicio del per�odo ser antes a la de fin del per�odo", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
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
			Messagebox.show("Fecha de fin del per�odo debe ser despues a la de inicio del per�odo", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		}
		else{
			this.fechaFin = fechaFin;
		}
	}

	@Command
	public void guaradrJunta(@BindingParam("win") Window win) throws Exception{
		if(this.fechaInicio.compareTo(this.fechaFin)==0){
			Messagebox.show("Debe Ingresar un rango de fechas correcto", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);			
		}
		else{
			this.juntaDirectiva.setFechaInic(fechaInicio);
			this.juntaDirectiva.setFechaFin(fechaFin);
			this.juntaDirectiva.setActivo(true);
			this.juntaDirectiva.setClub(clubDao.obtenerClub(1));
			this.juntaDirectivaDao.agregarJuntaDirectiva(juntaDirectiva);

			Messagebox.show("La Junta Directiva del per�odo "+this.juntaDirectiva.getFechaInic()+" a "+this.juntaDirectiva.getFechaFin()+" ha sido registrada exitosamente", "American Tech", Messagebox.OK, Messagebox.INFORMATION);
			win.detach();
			BindUtils.postGlobalCommand(null, null, "refreshJuntas",null);
			
		}
	}

	@Command
	public void cancelar(@BindingParam("win") Window win){
		win.detach();
	}
}
