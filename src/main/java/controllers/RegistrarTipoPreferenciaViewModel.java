package controllers;

import modelos.TipoPreferencia;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;
import Dao.TipoPreferenciaDao;

public class RegistrarTipoPreferenciaViewModel {

	private TipoPreferencia tipoPreferencia;
	private boolean editable;
	private TipoPreferenciaDao tipoDao;

	@Init
	public void init(@ExecutionArgParam("TipoPreferencia") TipoPreferencia tipo) {
		if (tipo == null) {
			this.tipoPreferencia = new TipoPreferencia();
			this.editable = false;
		} else {
			this.tipoPreferencia = tipo;
			this.editable = true;
		}
		tipoDao = new TipoPreferenciaDao();
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public TipoPreferencia getTipoPreferencia() {
		return tipoPreferencia;
	}

	public void setTipoSugerencia(TipoPreferencia tipoPreferncia) {
		this.tipoPreferencia = tipoPreferncia;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {

		if (tipoPreferencia.getDescripcion() != null
				&& !tipoPreferencia.getDescripcion().equalsIgnoreCase("")) {
			if (tipoDao
					.obtenerTipoDescripcion(tipoPreferencia.getDescripcion()) == null) {
				if (!editable) {
					tipoDao.agregarTipoPreferencia(tipoPreferencia);
					Messagebox.show(
							"El tipo de sugerencia "
									+ tipoPreferencia.getDescripcion()
									+ " ha sido registrado exitosamente", "American Tech",
							Messagebox.OK, Messagebox.INFORMATION);
				} else {
					tipoDao.actualizarTipoPreferencia(tipoPreferencia);
					Messagebox.show(
							"El tipo de preferencia "
									+ tipoPreferencia.getDescripcion()
									+ " ha sido actualizado exitosamente", "American Tech",
							Messagebox.OK, Messagebox.INFORMATION);
				}
				win.detach();
				BindUtils.postGlobalCommand(null, null,
						"refreshTipoPreferencia", null);
			} else {
				Messagebox.show("El tipo de preferencia con la descripción "
						+ tipoPreferencia.getDescripcion() + " ya existe",
						"American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
			}
		}else{
			Messagebox.show("Verifique que los campos estén llenos ", "American Tech",
					Messagebox.OK, Messagebox.INFORMATION);
		}

	}
}
