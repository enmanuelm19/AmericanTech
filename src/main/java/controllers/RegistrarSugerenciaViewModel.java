package controllers;

import java.util.Date;
import java.util.List;

import javax.websocket.Session;

import modelos.Sugerencia;
import modelos.TipoSugerencia;
import modelos.Usuario;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Sessions;

import javax.servlet.http.HttpSession;

import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.SugerenciaDao;
import Dao.TipoSugerenciaDao;


	
public class RegistrarSugerenciaViewModel {

	private SugerenciaDao sugerenciaDao;
	private Sugerencia sugerencia;
	private List<TipoSugerencia> allTipoSugerencia;
	private TipoSugerenciaDao tipoSugerenciaDao;


	@Init
	public void init(@ExecutionArgParam("sugerencia") Sugerencia sugerencia) throws Exception {
		this.sugerencia = new Sugerencia();
		this.sugerenciaDao = new SugerenciaDao();
		this.tipoSugerenciaDao = new TipoSugerenciaDao();
		this.allTipoSugerencia = tipoSugerenciaDao.obtenerTodos();
		
		
	}
	

	
	
	public ListModelList<TipoSugerencia> getAllTipoSugerencia() {
		return new ListModelList<TipoSugerencia>(allTipoSugerencia);
	}
	
	
	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception{
			this.sugerencia.setActivo(true);
			Date fecha = new Date();
			org.zkoss.zk.ui.Session session = Sessions.getCurrent();
			Usuario user  = (Usuario)session.getAttribute("Usuario");
			if(sugerencia.getDescripcion() != null && !sugerencia.getDescripcion().equalsIgnoreCase("")) {
				this.sugerencia.setFecha(fecha);
				this.sugerencia.setClienteExterno(null);;
				this.sugerencia.setUsuario(user);
				this.sugerenciaDao.agregarSugerencia(sugerencia);
				this.sugerencia = new Sugerencia();
				this.sugerenciaDao = new SugerenciaDao();
				this.tipoSugerenciaDao = new TipoSugerenciaDao();
				Messagebox.show( "La Sugerenci ha sido registrado exitosamente", "",
							Messagebox.OK, Messagebox.INFORMATION);
				win.detach();
				
				BindUtils.postGlobalCommand(null, null, "refreshSugerencia",null);
			}
			else {
				Messagebox.show("No debe dejar campos vacios",
						"Warning", Messagebox.OK, Messagebox.EXCLAMATION);
			}
	}
	
	
	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	public void setAllTipoSugerencia(List<TipoSugerencia> allTipoSugerencia) {
		this.allTipoSugerencia = allTipoSugerencia;
	}


	public SugerenciaDao getSugerenciaDao() {
		return sugerenciaDao;
	}

	public void setSugerenciaDao(SugerenciaDao sugerenciaDao) {
		this.sugerenciaDao = sugerenciaDao;
	}

	public Sugerencia getSugerencia() {
		return sugerencia;
	}

	public void setSugerencia(Sugerencia sugerencia) {
		this.sugerencia = sugerencia;
	}

	public TipoSugerenciaDao getTipoSugerenciaDao() {
		return tipoSugerenciaDao;
	}

	public void setTipoSugerenciaDao(TipoSugerenciaDao tipoSugerenciaDao) {
		this.tipoSugerenciaDao = tipoSugerenciaDao;
	}

	
	
	
}
