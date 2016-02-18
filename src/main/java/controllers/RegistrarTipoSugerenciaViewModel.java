package controllers;


import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Window;
import models.TipoSugerencia;
import service.TipoSugerenciaService;

public class RegistrarTipoSugerenciaViewModel {

	private TipoSugerencia tipoSugerencia;
	private boolean editable;

	@Init
	public void init(@ExecutionArgParam("TipoSugerencia") TipoSugerencia tipo) {
		if (tipo == null) {
			this.tipoSugerencia = new TipoSugerencia();
			this.editable = false;
		} else {
			this.tipoSugerencia = tipo;
			this.editable = true;
		}
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public TipoSugerencia getTipoSugerencia() {
		return tipoSugerencia;
	}

	public void setTipoSugerencia(TipoSugerencia tipoSugerencia) {
		this.tipoSugerencia = tipoSugerencia;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) {
		
		if (tipoSugerencia.getDescripcion() != null && !tipoSugerencia.getDescripcion().equalsIgnoreCase("") )
		{
			if (!editable)
				TipoSugerenciaService.agregarTipoSugerencia(tipoSugerencia);

			else TipoSugerenciaService.updateTipoSugerencia(tipoSugerencia);
				
			win.detach();
			BindUtils.postGlobalCommand(null,null,"refreshTipoSugerencia",null);
		}
		
		
	}
}
