package controllers;

import modelos.MotivoSancion;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.MotivoSancionDao;

public class RegistrarTipoSancionViewModel {

	private MotivoSancion motivoSancion;
	private boolean editable;
	private MotivoSancionDao motivoDao;

	@Init
	public void init(@ExecutionArgParam("MotivoSancion") MotivoSancion motivo) {
		if (motivo == null) {
			this.motivoSancion = new MotivoSancion();
			this.editable = false;
		} else {
			this.motivoSancion = motivo;
			this.editable = true;
		}
		motivoDao = new MotivoSancionDao();
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public MotivoSancion getMotivoSancion() {
		return motivoSancion;
	}

	public void setMotivoSancion(MotivoSancion motivoSancion) {
		this.motivoSancion = motivoSancion;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {

		if (motivoSancion.getDescripcion() != null
				&& !motivoSancion.getDescripcion().equalsIgnoreCase("")) {
			if (motivoDao.obtenerMotivoSancion(motivoSancion.getDescripcion()) == null) {
				if (!editable) {
					motivoDao.agregarMotivoSancion(motivoSancion);
					Messagebox.show(
							"El tipo de sancion "
									+ motivoSancion.getDescripcion()
									+ " ha sido registrado exitosamente", "",
							Messagebox.OK, Messagebox.INFORMATION);
				} else {
					motivoDao.actualizarMotivoSancion(motivoSancion);
					Messagebox.show(
							"El tipo de sancion "
									+ motivoSancion.getDescripcion()
									+ " ha sido actualizado exitosamente", "",
							Messagebox.OK, Messagebox.INFORMATION);
				}

				win.detach();
				BindUtils.postGlobalCommand(null, null, "refreshMotivoSancion",
						null);
			} else {
				Messagebox.show("tipo sancion con la descripcion "
						+ motivoSancion.getDescripcion() + " ya existe",
						"Warning", Messagebox.OK, Messagebox.EXCLAMATION);
			}
		}

	}
}
