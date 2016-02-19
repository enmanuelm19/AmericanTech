package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;








import models.TipoEvento;

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

import service.TipoEventoService;

public class TipoEventoViewModel {
	
	//Declararcion de Variables a utilizar
	TipoEventoService service= new TipoEventoService(); //Enlace a clase servicio --Luego cambiar por el DAO--
	private TipoEvento seleccionado=new TipoEvento(); //indicara que registro de la grid seleccione para edición
	private boolean editar=false; //manejo de visibilidad del grid editor.
	private List<TipoEvento> tiposAll= new ArrayList<TipoEvento>(); //contendra los todos registros
	private TipoEvento tipoE=new TipoEvento(); //enlace con el modelo
	//CONSTRUCTOR DE LA CLASE --INICIALIZACIÓN DE TODOS LOS REGISTROS--
	
	public TipoEventoViewModel() {
		// TODO Auto-generated constructor stub
		try {
			tiposAll=service.getTipoEvento();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Command
	public void cerrarModal(@BindingParam("win")  Window win){
		win.detach();
	}
	
	//Método para mostrar el formulario de registro
	@Command
	public void showModal(){
		this.tipoE= new TipoEvento();
		Window window = (Window)Executions.createComponents("configuracion/categoria/registrarTipoEvento.zul", null,null);
     	window.doModal();
	}
	
	
	//Método que gestiona la visualización de la grid edición
	public boolean getActivarEdicion(){
		return this.editar;
	}
		
	//Método que retorna todos los registros. este metodo se llamara en la grid.
	public List<TipoEvento> getAllTipoEvento(){
		return new ListModelList<TipoEvento>(tiposAll);
	}
	
	//Método de conteo de registros, llamado en el footer de la grid
	public String getCantRegistros(){
		return getAllTipoEvento().size()+" items en la lista";
	}

	public TipoEvento getTipoE() {
		return tipoE;
	}
	public void setTipoE(TipoEvento tipoE) {
		this.tipoE = tipoE;
	}
	
/****************************AGREGAR*************************/
	@Command
	public void agregarTipoEvento(@BindingParam("win")  Window win){
		if(tipoE.getDescripcion() != null && !tipoE.getDescripcion().equalsIgnoreCase("")){
			service.agregarTipoEvento(this.tipoE);
			BindUtils.postGlobalCommand(null,null,"refresh",null);
			win.detach();
		}
	}
	@GlobalCommand
	@NotifyChange({"allTipoEvento","cantRegistros"})
	public void refresh(){
		tiposAll=service.getTipoEvento();
	}
/****************************EDICIÓN*************************/
	//Método activado cuando selecciono la opcion editar
	@Command
	public void seleccionEdicion(@BindingParam("Tipo") TipoEvento tipo){ //recibe del activador una variable llamada Tipo.
		System.out.println("ssj: "+tipo.getDescripcion());
		final HashMap<String, Object> map = new HashMap<String, Object>();
	    map.put("tipoE", tipo );
		Executions.createComponents("configuracion/categoria/registrarTipoEvento.zul", null,map);
		
		//guardo temporalmente el registro a editar
	}
	
	@GlobalCommand
	@NotifyChange({"tipoE"})
	public void mode(){
		this.tipoE=this.seleccionado;
		System.out.println("nose: "+tipoE.getDescripcion());
	}
	//Método que retorna el registro a editar
	public TipoEvento getSeleccionEdicion(){
		return this.seleccionado;
	}
	
	//Método activado cuando cancelo la edición
	@Command
	@NotifyChange({"activarEdicion"})
	public void cancelarEdicion(){
		this.editar=false;
		this.seleccionado=new TipoEvento();
	}
	
	@Command
	@NotifyChange({"allTipoEvento","activarEdicion"})
	public void guardarEdicion(@BindingParam("Tipo") TipoEvento tipo){
		this.editar=false;
	}
	
/*****************************ELIMINAR REGISTRO*****************************/
	@Command
	@NotifyChange({"allTipoEvento","cantRegistros"})
	public void eliminarTipo(@BindingParam("Tipo") TipoEvento tipo){
		tipo.setEstatus("E");
		service.updateTipoEvento(tipo);
		tiposAll=service.getTipoEvento();
	}
		
/**********************************FILTRO**********************************/
	@Command
	@NotifyChange({"allTipoEvento","cantRegistros"})//Notificar que hay cambios en el metodo getAllTipoEvento() y getCantRegistros()
	public void filtroTipo(){
		List<TipoEvento> tip = new ArrayList<TipoEvento>();
		String desc = tipoE.getDescFiltro().toLowerCase();//asignar las letras escritas en el campo filtro
		
		for (Iterator<TipoEvento> i = service.getTipoEvento().iterator(); i.hasNext();) {
			TipoEvento tmp = i.next();
			if (tmp.getDescripcion().toLowerCase().contains(desc)) {//comparo si en el campo descripcion estan las letras que tipee.
				tip.add(tmp);
			}
		}
			tiposAll= tip; 
	}
}	



