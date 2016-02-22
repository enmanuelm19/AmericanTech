package controllers;

import modelos.MotivoSancion;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Window;

import Dao.MotivoSancionDao;

public class RegistrarMotivoSancionViewModel {

	private MotivoSancion motivoSancion;
	private boolean editable;
	private MotivoSancionDao tipoDao;

	@Init
	public void init(@ExecutionArgParam("MotivoSancion") MotivoSancion tipo) {
		if (tipo == null) {
			this.motivoSancion = new MotivoSancion();
			this.editable = false;
		} else {
			this.motivoSancion = tipo;
			this.editable = true;
		}
		tipoDao = new MotivoSancionDao();
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public MotivoSancion getMotivoSancion() {
		return motivoSancion;
	}

	public void setMotivoSancion(MotivoSancion motivoSancion) {
		this.motivoSancion = motivoSancion;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {
		
		if (motivoSancion.getDescripcion() != null && !motivoSancion.getDescripcion().equalsIgnoreCase("") )
		{
			if (!editable)
				tipoDao.agregarMotivoSancion(motivoSancion);

			else tipoDao.actualizarMotivoSancion(motivoSancion);
				
			win.detach();
			BindUtils.postGlobalCommand(null,null,"refreshMotivoSancion",null);
		}
		
		
	}
}
