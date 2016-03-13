package controllers;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zul.Window;

import Dao.TipoOpnionDao;
import modelos.TipoOpnion;

public class RegistrarTipoOpinionViewModel {

	private TipoOpnion tipoOpnion;
	private boolean editable;
	private TipoOpnionDao tipoDao;

	@Init
	public void init(@ExecutionArgParam("TipoOpnion") TipoOpnion tipo) {
		if (tipo == null) {
			this.tipoOpnion = new TipoOpnion();
			this.editable = false;
		} else {
			this.tipoOpnion = tipo;
			this.editable = true;
		}
		tipoDao = new TipoOpnionDao();
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public TipoOpnion getTipoOpnion() {
		return tipoOpnion;
	}

	public void setTipoOpnion(TipoOpnion tipoopnion) {
		this.tipoOpnion = tipoopnion;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {

		if (tipoOpnion.getDescripcion() != null
				&& !tipoOpnion.getDescripcion().equalsIgnoreCase("")) {
			if (tipoDao.obtenerTipoDescripcion(tipoOpnion.getDescripcion()) == null) {
				if (!editable) {
					tipoDao.agregarTipoOpnion(tipoOpnion);
					Messagebox.show(
							"El tipo de opinion "
									+ tipoOpnion.getDescripcion()
									+ " ha sido registrado exitosamente", "",
							Messagebox.OK, Messagebox.INFORMATION);
				} else {
					tipoDao.actualizarTipoOpnion(tipoOpnion);
					Messagebox.show(
							"El tipo de opinion "
									+ tipoOpnion.getDescripcion()
									+ " ha sido actualizado exitosamente", "",
							Messagebox.OK, Messagebox.INFORMATION);
				}
				win.detach();
				BindUtils.postGlobalCommand(null, null, "refreshTipoOpnion",
						null);
			} else {
				Messagebox.show("tipo de opinion con la descripcion "
						+ tipoOpnion.getDescripcion() + " ya existe",
						"Warning", Messagebox.OK, Messagebox.EXCLAMATION);
			}
		}

	}
}
