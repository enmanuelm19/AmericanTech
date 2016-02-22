package controllers;

import modelos.MotivoDesvinculacion;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Window;

import Dao.MotivoDesvinculacionDao;

public class RegistrarMotivoDesvinculacionViewModel {

	private MotivoDesvinculacion motivoDesvinculacion;
	private boolean editable;
	private MotivoDesvinculacionDao tipoDao;

	@Init
	public void init(@ExecutionArgParam("MotivoDesvinculacion") MotivoDesvinculacion tipo) {
		if (tipo == null) {
			this.motivoDesvinculacion = new MotivoDesvinculacion();
			this.editable = false;
		} else {
			this.motivoDesvinculacion= tipo;
			this.editable = true;
		}
		tipoDao = new MotivoDesvinculacionDao();
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public MotivoDesvinculacion getMotivoDesvinculacion() {
		return motivoDesvinculacion;
	}

	public void setMotivoDesvinculacion(MotivoDesvinculacion motivoDesvinculacion) {
		this.motivoDesvinculacion = motivoDesvinculacion;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {
		
		if (motivoDesvinculacion.getDescripcion() != null && !motivoDesvinculacion.getDescripcion().equalsIgnoreCase("") )
		{
			if (!editable)
				tipoDao.agregarMotivoDesvinculacion(motivoDesvinculacion);

			else tipoDao.actualizarMotivoDesvinculacion(motivoDesvinculacion);
				
			win.detach();
			BindUtils.postGlobalCommand(null,null,"refreshMotivoDesvinculacion",null);
		}
		
		
	}
}


