package controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import service.TipoInstalacionService;
import models.TipoEvento;
import models.TipoInstalacion;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

public class TipoInstalacionViewModel {
	
	TipoInstalacionService service = new TipoInstalacionService();
	private TipoInstalacion seleccionado = new TipoInstalacion();
	private boolean editar = false;
	private TipoInstalacion tipoI = new TipoInstalacion();
	private List<TipoInstalacion> tiposAll = new ArrayList<TipoInstalacion>();
	
	
	public TipoInstalacionViewModel() {
		try{
			tiposAll=service.getTipoInstalacion();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Command
	public void cerrarModal(@BindingParam("win") Window win){
		win.detach();
	}
	
	@Command
	public void showModal(){
		this.tipoI= new TipoInstalacion();
		Window window = (Window)Executions.createComponents("configuracion/categoria/registrarTipoInstalacion.zul", null,null);
     	window.doModal();
	}
	
	public boolean getActivarEdicion(){
		return this.editar;
	}
	
	public List<TipoInstalacion> getAllTipoInstalacion(){
		return new ListModelList<TipoInstalacion>(tiposAll);
	}
	
	public String getCantRegistros(){
		return getAllTipoInstalacion().size()+" items en la lista";
	}
	
	public TipoInstalacion getTipoI(){
		return tipoI;
	}
	
	public void setTipoI(TipoInstalacion tipoI){
		this.tipoI = tipoI;
	}
	
	/****************************AGREGAR*************************/
	@Command
	public void agregarTipoInstalacion(@BindingParam("win") Window win){
		if(tipoI.getDescripcion() != null && !tipoI.getDescripcion().equalsIgnoreCase("")){
			service.agregarTipoInstalacion(this.tipoI);
			BindUtils.postGlobalCommand(null, null, "refresh", null);
			win.detach();
		}
	}
	
	@GlobalCommand
	@NotifyChange({"allTipoInstalacion", "cantRegistros"})
	public void refresh(){
		tiposAll=service.getTipoInstalacion();
	}
	
	
	/****************************EDICI�N*************************/
	@Command
	public void seleccionEdicion(@BindingParam("Tipo") TipoInstalacion tipo){
		this.seleccionado= tipo;
		BindUtils.postGlobalCommand(null,null,"mode",null);
		Window window = (Window)Executions.createComponents("configuracion/categoria/registrarTipoInstalacion.zul", null,null);
		window.doModal();
	}
	
	@GlobalCommand
	@NotifyChange({"tipoI"})
	public void mode(){
		this.tipoI=this.seleccionado;
	}
	
	public TipoInstalacion getSeleccionEdicion(){
		return seleccionado;
	}
	
	@Command
	@NotifyChange({"activarEdicion"})
	public void cancelarEdicion(){
		this.editar=false;
		this.seleccionado=new TipoInstalacion();
	}

	@Command
	@NotifyChange({"allTipoInstalacion","activarEdicion"})
	public void guardarEdicion(@BindingParam("Tipo") TipoInstalacion tipo){
		this.editar=false;
	}
	
	/*****************************ELIMINAR REGISTRO*****************************/
	
	@Command
	@NotifyChange({"allTipoInstalacion", "cantRegistros"})
	public void eliminarTipo(@BindingParam("Tipo") TipoInstalacion tipo){
		tipo.setEstatus("E");
		service.updateTipoInstalacion(tipo);
		tiposAll=service.getTipoInstalacion();
	}
	
	/**********************************FILTRO**********************************/
	@Command
	@NotifyChange({"allTipoInstalacion", "cantRegistros"})
	public void filtroTipoDesc(){
		List<TipoInstalacion> tipo = new ArrayList<TipoInstalacion>();
		String desc = tipoI.getDescFiltro().toLowerCase();	
		for(Iterator<TipoInstalacion> i = service.getTipoInstalacion().iterator(); i.hasNext();){
			TipoInstalacion tmp = i.next();
			if(tmp.getDescripcion().toLowerCase().contains(desc)){
				tipo.add(tmp);
			}
		}
		tiposAll = tipo;
	}
	
	@Command
	@NotifyChange({"allTipoInstalacion", "cantRegistros"})
	public void filtroTipoId(){
		List<TipoInstalacion> tipo = new ArrayList<TipoInstalacion>();
		String id = tipoI.getIdFiltro();
		for(Iterator<TipoInstalacion> i = service.getTipoInstalacion().iterator(); i.hasNext();){
			TipoInstalacion tmp = i.next();
			int newint = Integer.valueOf(id);
			if(tmp.getId()== newint){
				tipo.add(tmp);
			}
		}
		tiposAll = tipo;
	}
	
	
}
