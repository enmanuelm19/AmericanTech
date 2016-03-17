package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;







import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import modelos.Accion;
import modelos.Club;
import modelos.EstadoAccion;
import modelos.Portal;
import modelos.RedClub;
import modelos.RedSocial;
import Dao.AccionDao;
import Dao.ClubDao;
import Dao.EstadoAccionDao;
import Dao.PortalDao;
import Dao.RedSocialDao;
import Dao.RedClubDao;


public class IndexPortalViewModel {

	private List<Club> clubAll;
	//private List<Portal> portalAll;
	private ClubDao clubDao;
	private Portal portal;
	private Club club;
	private PortalDao portalDao;

	private List<RedClub> redesClub;
	private RedClubDao redClubDao;
	
	private List<Accion> acciones;
	private AccionDao accionDao;
	private EstadoAccionDao estadoAccionDao;
	private boolean verPostulacion;
	@Init
	public void init() throws Exception {
		
		clubAll = new ArrayList<Club>();
		club = new Club();
		portal = new Portal();
		redesClub = new ArrayList<RedClub>();
		redClubDao = new RedClubDao();
		clubDao = new ClubDao();
		portalDao = new PortalDao();
		clubAll = clubDao.obtenerTodos();
		int id = 1;
		portal = portalDao.obtenerPortal(id);
		int idClub = 1;
		club = clubDao.obtenerClub(idClub);
		redesClub = redClubDao.obtenerTodos();
		accionDao= new AccionDao();
		estadoAccionDao= new EstadoAccionDao();
		this.acciones=accionDao.obtenerPorEstado(estadoAccionDao.obtenerEstadoAccion(2));
		if(this.acciones.size()>0)
			verPostulacion=true;
		else
			verPostulacion=false;
	}

	public ListModelList<Club> getAllClub() {
		return new ListModelList<Club>(clubAll);
	}
	
	public Portal getPortal() {
		return portal;
	}
	
	public Club getClub(){
		return club;
	}
	
	public ListModelList<RedClub> getRedesClub(){
		return  new ListModelList<RedClub>(redesClub);
	}
	
	public boolean getVerPostulacion(){
		return verPostulacion;
	}
	
}	