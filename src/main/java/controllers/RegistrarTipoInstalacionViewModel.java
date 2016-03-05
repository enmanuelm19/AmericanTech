package controllers;

import modelos.TipoInstalacion;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.TipoInstalacionDao;

public class RegistrarTipoInstalacionViewModel {

	private TipoInstalacion tipoInstalacion;
	private boolean editable;
	private TipoInstalacionDao tipoDao;

	@Init
	public void init(@ExecutionArgParam("TipoInstalacion") TipoInstalacion tipo) {
		if (tipo == null) {
			this.tipoInstalacion = new TipoInstalacion();
			this.editable = false;
		} else {
			this.tipoInstalacion = tipo;
			this.editable = true;
		}
		tipoDao = new TipoInstalacionDao();
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public TipoInstalacion getTipoInstalacion() {
		return tipoInstalacion;
	}

	public void setTipoInstalacion(TipoInstalacion tipoInstalacion) {
		this.tipoInstalacion = tipoInstalacion;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {

		if (tipoInstalacion.getDescripcion() != null
				&& !tipoInstalacion.getDescripcion().equalsIgnoreCase("")) {
			if (tipoDao
					.obtenerTipoDescripcion(tipoInstalacion.getDescripcion()) == null) {
				if (!editable) {
					tipoDao.agregarTipoInstalacion(tipoInstalacion);
					Messagebox.show(
							"El tipo de instalacion "
									+ tipoInstalacion.getDescripcion()
									+ " ha sido registrado exitosamente", "",
							Messagebox.OK, Messagebox.INFORMATION);
				} else {
					tipoDao.actualizarTipoInstalacion(tipoInstalacion);
					Messagebox.show(
							"El tipo de instalacion "
									+ tipoInstalacion.getDescripcion()
									+ " ha sido actualizado exitosamente", "",
							Messagebox.OK, Messagebox.INFORMATION);
				}
				win.detach();
				BindUtils.postGlobalCommand(null, null,
						"refreshTipoInstalacion", null);
			} else {
				Messagebox.show("tipo de instalacion con la descripcion "
						+ tipoInstalacion.getDescripcion() + " ya existe",
						"Warning", Messagebox.OK, Messagebox.EXCLAMATION);
			}
		}
	}
}
