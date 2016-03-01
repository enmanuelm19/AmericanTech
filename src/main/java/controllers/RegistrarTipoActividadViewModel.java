package controllers;

import modelos.TipoActividad;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.TipoActividadDao;

public class RegistrarTipoActividadViewModel {

	private TipoActividad tipoActividad;
	private boolean editable;
	private TipoActividadDao tipoDao;

	@Init
	public void init(@ExecutionArgParam("TipoActividad") TipoActividad tipo) {
		if (tipo == null) {
			this.tipoActividad = new TipoActividad();
			this.editable = false;
		} else {
			this.tipoActividad = tipo;
			this.editable = true;
		}
		tipoDao = new TipoActividadDao();
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public TipoActividad getTipoActividad() {
		return tipoActividad;
	}

	public void setTipoActividad(TipoActividad tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {

		if (tipoActividad.getDescripcion() != null
				&& !tipoActividad.getDescripcion().equalsIgnoreCase("")) {
			if (tipoDao
					.obtenerTipoDescripcion(tipoActividad.getDescripcion()) == null) {
				if (!editable)
					tipoDao.agregarTipoActividad(tipoActividad);

				else
					tipoDao.actualizarTipoActividad(tipoActividad);

				win.detach();
				BindUtils.postGlobalCommand(null, null,
						"refreshTipoActividad", null);
			} else {
				Messagebox.show("tipo de actividad con la descripcion "
						+ tipoActividad.getDescripcion() + " ya existe",
						"Warning", Messagebox.OK, Messagebox.EXCLAMATION);
			}
		}

	}
}

