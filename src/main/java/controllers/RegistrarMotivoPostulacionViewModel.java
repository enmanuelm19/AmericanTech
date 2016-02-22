package controllers;

import modelos.MotivoPostulacion;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Window;

import Dao.MotivoPostulacionDao;

public class RegistrarMotivoPostulacionViewModel {

	private MotivoPostulacion motivoPostulacion;
	private boolean editable;
	private MotivoPostulacionDao tipoDao;

	@Init
	public void init(@ExecutionArgParam("MotivoPostulacion") MotivoPostulacion tipo) {
		if (tipo == null) {
			this.motivoPostulacion = new MotivoPostulacion();
			this.editable = false;
		} else {
			this.motivoPostulacion= tipo;
			this.editable = true;
		}
		tipoDao = new MotivoPostulacionDao();
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public MotivoPostulacion getMotivoPostulacion() {
		return motivoPostulacion;
	}

	public void setMotivoPostulacion(MotivoPostulacion motivoPostulacion) {
		this.motivoPostulacion = motivoPostulacion;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {
		
		if (motivoPostulacion.getDescripcion() != null && !motivoPostulacion.getDescripcion().equalsIgnoreCase("") )
		{
			if (!editable)
				tipoDao.agregarMotivoPostulacion(motivoPostulacion);

			else tipoDao.actualizarMotivoPostulacion(motivoPostulacion);
				
			win.detach();
			BindUtils.postGlobalCommand(null,null,"refreshMotivoPostulacion",null);
		}
		
		
	}
}

