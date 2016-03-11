package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelos.Sancion;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

import Dao.SancionDao;

public class SancionesViewModel {
	private SancionDao sancionDao;
	private Sancion sancion;
	private List<Sancion> sanciones;
	@Init
	public void init() throws Exception{
		this.sancionDao= new SancionDao();
		this.sanciones= this.sancionDao.obtenerTodos();
	}
	
	public ListModelList<Sancion> getSancionesAll(){
		return new ListModelList<Sancion>(sanciones);
	}
	
	public String getCantidadSanciones(){
		return this.sanciones.size() +" items en la lista";
	}
	
	@Command
	public void showModalRegistroSancion(@BindingParam("Sancion") Sancion sancion){
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("Sancion", sancion);
		
		 Window window = (Window)Executions.createComponents("socio/administrarSocio/agregarSancion.zul", null, args);
		 window.doModal();
	 }
	
	@GlobalCommand
	@NotifyChange({"sancionesAll"})
	public void refreshSancionados() throws Exception{
		this.sanciones=this.sancionDao.obtenerTodos();
	}
	
}
