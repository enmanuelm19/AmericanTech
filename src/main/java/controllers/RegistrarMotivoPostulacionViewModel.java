package controllers;

import modelos.MotivoPostulacion;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.MotivoPostulacionDao;

public class RegistrarMotivoPostulacionViewModel {

	private MotivoPostulacion motivoPostulacion;
	private boolean editable;
	private MotivoPostulacionDao motivoDao;

	@Init
	public void init(
			@ExecutionArgParam("MotivoPostulacion") MotivoPostulacion motivo) {
		if (motivo == null) {
			this.motivoPostulacion = new MotivoPostulacion();
			this.editable = false;
		} else {
			this.motivoPostulacion = motivo;
			this.editable = true;
		}
		motivoDao = new MotivoPostulacionDao();
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

		if (motivoPostulacion.getDescripcion() != null
				&& !motivoPostulacion.getDescripcion().equalsIgnoreCase("")) {
			if (motivoDao.obtenerMotivoPostulacion(motivoPostulacion.getDescripcion()) == null) {
				if (!editable) {
					motivoDao.agregarMotivoPostulacion(motivoPostulacion);
					Messagebox.show("El motivo postulación "
							+ motivoPostulacion.getDescripcion()
							+ " ha sido registrado exitosamente", "American Tech",
							Messagebox.OK, Messagebox.INFORMATION);
				} else {
					motivoDao.actualizarMotivoPostulacion(motivoPostulacion);
					Messagebox.show("El motivo postulación "
							+ motivoPostulacion.getDescripcion()
							+ " ha sido actualizado exitosamente", "American Tech",
							Messagebox.OK, Messagebox.INFORMATION);
				}

				win.detach();
				BindUtils.postGlobalCommand(null, null,
						"refreshMotivoPostulacion", null);
			} else {
				Messagebox.show("El motivo postulación con la descripción "
						+ motivoPostulacion.getDescripcion() + " ya existe",
						"American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
			}
		}else{
			Messagebox.show("Verifique que los campos estén llenos ", "American Tech",
					Messagebox.OK, Messagebox.INFORMATION);
		}

	}
}
