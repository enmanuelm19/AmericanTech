package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelos.Sancion;

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
	@NotifyChange({"sancionesAll","cantidadSanciones"})
	public void refreshSancionados() throws Exception{
		this.sanciones=this.sancionDao.obtenerTodos();
	}
	
	@Command
	@NotifyChange({"cantidadSanciones"})
	public void eliminar(@BindingParam("Sancion") final Sancion sancion) throws Exception{
		Messagebox.show("Esta seguro de eliminar la sanción al Sr(a) " + sancion.getSocio().getPersona().getNombre()+ " "+sancion.getSocio().getPersona().getApellido(), "Confirmar",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {
								sancionDao= new SancionDao();
								sancion.setActivo(false);
								sancionDao.actualizarSancion(sancion);
								Messagebox.show("La sancion ha sido eliminada", "", Messagebox.OK, Messagebox.INFORMATION);
								BindUtils.postGlobalCommand(null, null, "refreshSancionados",null);
								
							} catch (Exception e) {
								Messagebox.show(e.getMessage(), "La sancion no se pudo eliminar",
										Messagebox.OK, Messagebox.ERROR);
							}
						}
					}
				});
	}
	
}
