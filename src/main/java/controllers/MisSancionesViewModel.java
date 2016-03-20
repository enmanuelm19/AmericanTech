package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelos.Sancion;
import modelos.Socio;
import modelos.Usuario;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.SancionDao;
import Dao.SocioDao;

public class MisSancionesViewModel {

	
	private SancionDao sancionDao;
	private Sancion sancion;
	private List<Sancion> sanciones;
	private SocioDao socioDao;
	
	@Init
	public void init() throws Exception{
		this.sancionDao= new SancionDao();
		this.sanciones = new ArrayList<Sancion>();
		//this.sanciones = this.sancionDao.obtenerTodos();
		this.socioDao= new SocioDao();
		this.cargarSancionesSocio();
	}
	
	
	public void cargarSancionesSocio() throws Exception {
		Session session = Sessions.getCurrent();
		Usuario user = (Usuario) session.getAttribute("Usuario");
		Socio socio = socioDao.obtenerSocioPersona(user.getPersona());
		try {
			this.sanciones= this.sancionDao.obtenerSancionesSocio(socio);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public ListModelList<Sancion> getSancionesAll(){
		return new ListModelList<Sancion>(sanciones);
	}
	
	public String getCantidadSanciones(){
		return this.sanciones.size() +" items en la lista";
	}
	


	

}
