package controllers;

import modelos.TipoEventualidad;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.TipoEventualidadDao;

public class RegistrarTipoEventualidadViewModel {


	private TipoEventualidad tipoEventualidad;
	private boolean editable;
	private TipoEventualidadDao tipoDao;

	@Init
	public void init(@ExecutionArgParam("TipoEventualidad") TipoEventualidad tipo) {
		if (tipo == null) {
			this.tipoEventualidad = new TipoEventualidad();
			this.editable = false;
		} else {
			this.tipoEventualidad = tipo;
			this.editable = true;
		}
		tipoDao = new TipoEventualidadDao();
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public TipoEventualidad getTipoEventualidad() {
		return tipoEventualidad;
	}

	public void setTipoEventualidad(TipoEventualidad tipoEventualidad) {
		this.tipoEventualidad = tipoEventualidad;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {

		if (tipoEventualidad.getDescripcion() != null
				&& !tipoEventualidad.getDescripcion().equalsIgnoreCase("")) {
			if (tipoDao.obtenerTipoEventualidad(tipoEventualidad.getDescripcion()) == null) {
				if (!editable) {
					tipoDao.agregarTipoEventualidad(tipoEventualidad);
					Messagebox.show(
							"El tipo de eventualidad "
									+ tipoEventualidad.getDescripcion()
									+ " ha sido registrado exitosamente", "",
							Messagebox.OK, Messagebox.INFORMATION);
				} else {
					tipoDao.actualizarTipoEventualidad(tipoEventualidad);
					Messagebox.show(
							"El tipo de eventualidad "
									+ tipoEventualidad.getDescripcion()
									+ " ha sido actualizado exitosamente", "",
							Messagebox.OK, Messagebox.INFORMATION);
				}
				win.detach();
				BindUtils.postGlobalCommand(null, null, "refreshTipoEventualidad",
						null);
			} else {
				Messagebox.show("tipo de eventualidad con la descripcion "
						+ tipoEventualidad.getDescripcion() + " ya existe",
						"Warning", Messagebox.OK, Messagebox.EXCLAMATION);
			}
		}

	}
}

