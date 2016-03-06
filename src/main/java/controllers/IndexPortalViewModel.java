package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import modelos.Club;

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

import Dao.ClubDao;


public class IndexPortalViewModel {

//	private List<TipoPreferencia> tiposAll;
//	private TipoPreferenciaDao tipoDao;
//	private String descFiltro;
//	private String idFiltro;
	private List<Club> clubAll;
	private ClubDao clubDao;
//	private 

	@Init
	public void init() throws Exception {
		
		clubAll = new ArrayList<Club>();
		clubDao = new ClubDao();
		clubAll = clubDao.obtenerTodos();
	}

	public ListModelList<Club> getAllClub() {
		return new ListModelList<Club>(clubAll);
	}
	

	
	
}	