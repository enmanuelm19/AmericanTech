package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;
import models.Proveedor;
import service.ProveedorService;


public class ControllerProveedor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Proveedor> proveedores = ProveedorService.getPro();
	
	@Command
	public void showModal(Event e) {
		// create a window programmatically and use it as a modal dialog.
		Window window = (Window) Executions.createComponents("configuracion/registrarProveedor.zul", null, null);
		window.doModal();
	}
	
	public ListModelList<Proveedor> getProveedoresAll(){
		return new ListModelList<Proveedor>(proveedores);
		
	}
	
	public String getNumeroRegistros(){
		return "" +proveedores.size()+ " items en la lista";
		
	}

}
