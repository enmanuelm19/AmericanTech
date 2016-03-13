package controllers;

import modelos.MotivoCancelacion;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.MotivoCancelacionDao;

public class RegistrarMotivoCancelacionViewModel {

	private MotivoCancelacion motivoCancelacion;
	private boolean editable;
	private MotivoCancelacionDao motivoDao;

	@Init
	public void init(
			@ExecutionArgParam("MotivoCancelacion") MotivoCancelacion motivo) {
		if (motivo == null) {
			this.motivoCancelacion = new MotivoCancelacion();
			this.editable = false;
		} else {
			this.motivoCancelacion = motivo;
			this.editable = true;
		}
		motivoDao = new MotivoCancelacionDao();
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public MotivoCancelacion getMotivoCancelacion() {
		return motivoCancelacion;
	}

	public void setMotivoCancelacionn(
			MotivoCancelacion motivoCancelacion) {
		this.motivoCancelacion = motivoCancelacion;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {

		if (motivoCancelacion.getDescripcion() != null
				&& !motivoCancelacion.getDescripcion().equalsIgnoreCase("")) {
			if (motivoDao.obtenerMotivoCancelacion(motivoCancelacion
					.getDescripcion()) == null) {
				if (!editable) {
					motivoDao.agregarMotivoCancelacion(motivoCancelacion);
					Messagebox.show("El motivo de cancelacion "
							+ motivoCancelacion.getDescripcion()
							+ " ha sido registrado exitosamente", "",
							Messagebox.OK, Messagebox.INFORMATION);
				} else {
					motivoDao.actualizarMotivoCancelacion(motivoCancelacion);
					Messagebox.show("El motivo de cancelacion "
							+ motivoCancelacion.getDescripcion()
							+ " ha sido actualizado exitosamente", "",
							Messagebox.OK, Messagebox.INFORMATION);
				}
				win.detach();
				BindUtils.postGlobalCommand(null, null,
						"refreshMotivoCancelacion", null);
			} else {
				Messagebox.show("motivo cancelacion con la descripcion "
						+ motivoCancelacion.getDescripcion() + " ya existe",
						"Warning", Messagebox.OK, Messagebox.EXCLAMATION);
			}
		}

	}
}

