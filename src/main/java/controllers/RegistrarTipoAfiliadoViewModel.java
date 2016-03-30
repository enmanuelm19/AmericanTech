package controllers;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.TipoAfiliadoDao;
import modelos.TipoAfiliado;

public class RegistrarTipoAfiliadoViewModel {

	private TipoAfiliado tipoAfiliado;
	private TipoAfiliadoDao tipoDao;
	private boolean editable;

	@Init
	public void init(@ExecutionArgParam("TipoAfiliado") TipoAfiliado tipo) {
		if (tipo == null) {
			this.tipoAfiliado = new TipoAfiliado();
			this.editable = false;
		} else {
			this.tipoAfiliado = tipo;
			this.editable = true;
		}
		this.tipoDao = new TipoAfiliadoDao();
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {
		this.tipoAfiliado.setActivo(true);
		if (tipoAfiliado.getDescripcion() != null && !tipoAfiliado.getDescripcion().equalsIgnoreCase("") && tipoAfiliado.getSubfijo()!=null &&
				!tipoAfiliado.getSubfijo().equalsIgnoreCase("")) {
			if (this.tipoDao.obtenerTipoDescripcion(tipoAfiliado.getDescripcion()) == null) {
				if (!editable) {
					tipoDao.agregarTipoAfiliado(tipoAfiliado);
					Messagebox.show("El tipo de afiliado "+ tipoAfiliado.getDescripcion()+ " ha sido registrado exitosamente", "American Tech",
							Messagebox.OK, Messagebox.INFORMATION);
				} else {
					tipoDao.actualizarTipoAfiliado(tipoAfiliado);
					Messagebox.show("El tipo de afiliado "+ tipoAfiliado.getDescripcion()+ " ha sido actualizado exitosamente", "American Tech",
							Messagebox.OK, Messagebox.INFORMATION);
				}
				win.detach();
				BindUtils.postGlobalCommand(null, null, "refreshTipoAfiliado",null);
			} else {
				Messagebox.show("El tipo de afiliado con la descripcion"
						+ tipoAfiliado.getDescripcion() + " ya existe",
						"American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
			}
		}
		else{
			Messagebox.show("Verifique que los campos estén llenos ", "American Tech",
					Messagebox.OK, Messagebox.INFORMATION);
		}
	}

	public TipoAfiliado getTipoAfiliado() {
		return tipoAfiliado;
	}

	public void setTipoAfiliado(TipoAfiliado tipoAfiliado) {
		this.tipoAfiliado = tipoAfiliado;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
	
}
