package controllers;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import modelos.Accion;
import modelos.EstadoAccion;
import modelos.Noticia;
import modelos.Preferencia;
import Dao.AccionDao;
import Dao.EstadoAccionDao;

public class RegistrarAccionViewModel {
	private AccionDao accionDAO= new AccionDao();
	private List<EstadoAccion> estados;
	private EstadoAccionDao estdao;
	private Accion accion;
	private boolean editable;
	private Noticia noticia;

	@Init
	public void init(@ExecutionArgParam("accion") Accion accion) throws Exception {
		if(accion==null){
			this.accion=new Accion();
			this.editable = false;
		} else {
			this.accion=accion;
			this.editable=true;
		}
		this.estdao= new EstadoAccionDao();
		this.estados= estdao.obtenerTodos();
	}
	public ListModelList<EstadoAccion> getEstadosAll() {
		 return new ListModelList<EstadoAccion>(estados);
	}
	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public Accion getAccion() {
		return accion;
	}
	public void setAccion(Accion accion) {
		this.accion = accion;
	}
	
	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {
		System.out.println("valor "+accion.getValor());
		if ((accion.getNroAccion() != null && !accion.getNroAccion().equalsIgnoreCase("")) || (accion.getValor() > 0.0 && !String.valueOf(accion.getValor()).equalsIgnoreCase(""))) {
			accion.setActivo(true);
			if (!editable){				
				accionDAO.agregarAccion(accion);
				Messagebox.show("La Acción " +accion.getNroAccion()+ " ha sido registrada exitosamente", "", Messagebox.OK, Messagebox.INFORMATION);
			}
			else{
				if(accion.getEstadoAccion().getIdEstadoAccion()==2){
					accion.setSocio(null);
				}
				accionDAO.actualizarAccion(accion);
				Messagebox.show("La Acción " +accion.getNroAccion()+ " ha sido actualizada exitosamente", "", Messagebox.OK, Messagebox.INFORMATION);		
			}
			win.detach();
			BindUtils.postGlobalCommand(null, null, "refreshAcciones", null);
		}

	}
}
