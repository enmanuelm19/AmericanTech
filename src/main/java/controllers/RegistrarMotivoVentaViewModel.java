package controllers;

import modelos.MotivoVenta;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Window;

import Dao.MotivoVentaDao;

public class RegistrarMotivoVentaViewModel {

	private MotivoVenta motivoVenta;
	private boolean editable;
	private MotivoVentaDao tipoDao;

	@Init
	public void init(@ExecutionArgParam("MotivoVenta") MotivoVenta tipo) {
		if (tipo == null) {
			this.motivoVenta = new MotivoVenta();
			this.editable = false;
		} else {
			this.motivoVenta = tipo;
			this.editable = true;
		}
		tipoDao = new MotivoVentaDao();
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public MotivoVenta getMotivoVenta() {
		return motivoVenta;
	}

	public void setMotivoVenta(MotivoVenta motivoVenta) {
		this.motivoVenta= motivoVenta;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {
		
		if (motivoVenta.getDescripcion() != null && !motivoVenta.getDescripcion().equalsIgnoreCase("") )
		{
			if (!editable)
				tipoDao.agregarMotivoVenta(motivoVenta);

			else tipoDao.actualizarMotivoVenta(motivoVenta);
				
			win.detach();
			BindUtils.postGlobalCommand(null,null,"refreshMotivoVenta",null);
		}
		
		
	}
}
