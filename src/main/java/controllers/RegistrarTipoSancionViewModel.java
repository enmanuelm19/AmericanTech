package controllers;

import modelos.TipoSancion;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.TipoSancionDao;

public class RegistrarTipoSancionViewModel {

	private TipoSancion tipoSancion;
	private boolean editable;
	private TipoSancionDao tipoDao;

	@Init
	public void init(@ExecutionArgParam("TipoSancion") TipoSancion tipo) {
		if (tipo == null) {
			this.tipoSancion = new TipoSancion();
			this.editable = false;
		} else {
			this.tipoSancion = tipo;
			this.editable = true;
		}
		tipoDao = new TipoSancionDao();
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public TipoSancion getTipoSancion() {
		return tipoSancion;
	}

	public void setMotivoSancion(TipoSancion tipoSancion) {
		this.tipoSancion = tipoSancion;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {

		if (tipoSancion.getDescripcion() != null
				&& !tipoSancion.getDescripcion().equalsIgnoreCase("")) {
			if (tipoDao.obtenerTipoDescripcion(tipoSancion.getDescripcion()) == null) {
				if (!editable) {
					tipoDao.agregarTipoSancion(tipoSancion);
					Messagebox.show(
							"El motivo de sanción "
									+ tipoSancion.getDescripcion()
									+ " ha sido registrado exitosamente", "American Tech",
							Messagebox.OK, Messagebox.INFORMATION);
				} else {
					tipoDao.actualizarTipoSancion(tipoSancion);
					Messagebox.show(
							"El motivo de sanción "
									+ tipoSancion.getDescripcion()
									+ " ha sido actualizado exitosamente", "American Tech",
							Messagebox.OK, Messagebox.INFORMATION);
				}

				win.detach();
				BindUtils.postGlobalCommand(null, null, "refreshTipoSancion",
						null);
			} else {
				Messagebox.show("El motivo sanción con la descripción "
						+ tipoSancion.getDescripcion() + " ya existe",
						"American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
			}
		}else{
			Messagebox.show("Verifique que los campos esten llenos ", "American Tech",
					Messagebox.OK, Messagebox.INFORMATION);
		}

	}
}
