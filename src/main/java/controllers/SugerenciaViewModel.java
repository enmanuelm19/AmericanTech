package controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

import Dao.SugerenciaDao;
import Dao.TipoAfiliadoDao;
import modelos.Sugerencia;
import modelos.TipoAfiliado;
import modelos.Usuario;

public class SugerenciaViewModel {

	
	private List<Sugerencia> allSugerencia;
	private SugerenciaDao sugerenciaDao;
	private Sugerencia sugerencia;
	private String descFiltro;
	
	
	@Init
	public void init() throws Exception{
		this.allSugerencia = new ArrayList<Sugerencia>();
		this.sugerenciaDao = new SugerenciaDao();
		this.cargarSugerenciaSocio();
	}
	
	
	public void cargarSugerenciaSocio() {
		Session session = Sessions.getCurrent();
		Usuario user = (Usuario) session.getAttribute("Usuario");
		try {
			this.allSugerencia = sugerenciaDao.obtenerSugerenciasUsuario(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	public ListModelList<Sugerencia> getAllSugerencia(){
		return new ListModelList<Sugerencia>(allSugerencia);
	}
	
	
	@Command
	public void showModal(@BindingParam("Sugerencia") Sugerencia sugerencia) {
		 Window window = (Window)Executions.createComponents("socio/buzon/registrarSugerencia.zul", null, null);
		 window.doModal();
	 }
	
	
	@GlobalCommand
	@NotifyChange({ "allSugerencia", "cantRegistros" })
	public void refreshSugerencia() throws Exception {
		Session session = Sessions.getCurrent();
		Usuario user = (Usuario) session.getAttribute("Usuario");
		this.allSugerencia = new ArrayList<Sugerencia>();
		this.sugerenciaDao = new SugerenciaDao();
		this.allSugerencia = sugerenciaDao.obtenerSugerenciasUsuario(user);	

	}
	
	@Command
	@NotifyChange({ "allSugerencia", "cantRegistros" })
	public void filtro() throws Exception {
		List<Sugerencia> tip = new ArrayList<Sugerencia>();
		String desc = getDescFiltro().toLowerCase();
		Session session = Sessions.getCurrent();
		Usuario user = (Usuario) session.getAttribute("Usuario");
		for (Iterator<Sugerencia> i = sugerenciaDao.obtenerSugerenciasUsuario(user).iterator(); i.hasNext();) {
			Sugerencia tmp = i.next();
			if (tmp.getTipoSugerencia().getDescripcion().toLowerCase().contains(desc)) {
				tip.add(tmp);
			}
		}
		allSugerencia = tip;
	}
	
	
	public String getCantRegistros() {
		return allSugerencia.size() + " Sugerencia realizas";
	}


	
	public String getDescFiltro() {
		if(descFiltro==null) 
			return"";
		return descFiltro;
	}



	public void setDescFiltro(String descFiltro) {
		this.descFiltro = descFiltro==null?"":descFiltro.trim();
	}
	
	

	
}			
