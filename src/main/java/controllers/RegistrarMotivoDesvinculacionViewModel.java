package controllers;

import modelos.MotivoDesvinculacion;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.MotivoDesvinculacionDao;

public class RegistrarMotivoDesvinculacionViewModel {

	private MotivoDesvinculacion motivoDesvinculacion;
	private boolean editable;
	private MotivoDesvinculacionDao motivoDao;

	@Init
	public void init(
			@ExecutionArgParam("MotivoDesvinculacion") MotivoDesvinculacion motivo) {
		if (motivo == null) {
			this.motivoDesvinculacion = new MotivoDesvinculacion();
			this.editable = false;
		} else {
			this.motivoDesvinculacion = motivo;
			this.editable = true;
		}
		motivoDao = new MotivoDesvinculacionDao();
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

	public void setMotivoDesvinculacion(
			MotivoDesvinculacion motivoDesvinculacion) {
		this.motivoDesvinculacion = motivoDesvinculacion;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {

		if (motivoDesvinculacion.getDescripcion() != null
				&& !motivoDesvinculacion.getDescripcion().equalsIgnoreCase("")) {
			if (motivoDao.obtenerMotivoDesvinculacion(motivoDesvinculacion
					.getDescripcion()) == null) {
				if (!editable) {
					motivoDao.agregarMotivoDesvinculacion(motivoDesvinculacion);
					Messagebox.show("El motivo de desvinculacion "
							+ motivoDesvinculacion.getDescripcion()
							+ " ha sido registrado exitosamente", "",
							Messagebox.OK, Messagebox.INFORMATION);
				} else {
					motivoDao
							.actualizarMotivoDesvinculacion(motivoDesvinculacion);
					Messagebox.show("El motivo de desvinculacion "
							+ motivoDesvinculacion.getDescripcion()
							+ " ha sido actualizado exitosamente", "",
							Messagebox.OK, Messagebox.INFORMATION);
				}
				win.detach();
				BindUtils.postGlobalCommand(null, null,
						"refreshMotivoDesvinculacion", null);
			} else {
				Messagebox.show("motivo desvinculacion con la descripcion "
						+ motivoDesvinculacion.getDescripcion() + " ya existe",
						"Warning", Messagebox.OK, Messagebox.EXCLAMATION);
			}
		}

	}
}
