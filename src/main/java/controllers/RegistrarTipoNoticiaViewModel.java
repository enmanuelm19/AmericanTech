package controllers;

import modelos.TipoNoticia;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.TipoNoticiaDao;

public class RegistrarTipoNoticiaViewModel {

	private TipoNoticia tipoNoticia;
	private boolean editable;
	private TipoNoticiaDao tipoDao;

	@Init
	public void init(@ExecutionArgParam("TipoNoticia") TipoNoticia tipo) {
		if (tipo == null) {
			this.tipoNoticia = new TipoNoticia();
			this.editable = false;
		} else {
			this.tipoNoticia = tipo;
			this.editable = true;
		}
		tipoDao = new TipoNoticiaDao();
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public TipoNoticia getTipoNoticia() {
		return tipoNoticia;
	}

	public void setTipoNoticia(TipoNoticia tipoNoticia) {
		this.tipoNoticia = tipoNoticia;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {

		if (tipoNoticia.getDescripcion() != null
				&& !tipoNoticia.getDescripcion().equalsIgnoreCase("")) {
//			if (tipoDao
//					.obtenerTipoDescripcion(tipoNoticia.getDescripcion()) == null) {
				if (!editable) {
					tipoDao.agregarTipoNoticia(tipoNoticia);
					Messagebox.show(
							"El tipo de noticia "
									+ tipoNoticia.getDescripcion()
									+ " ha sido registrado exitosamente", "American Tech",
							Messagebox.OK, Messagebox.INFORMATION);
				} else {
					tipoDao.actualizarTipoNoticia(tipoNoticia);
					Messagebox.show(
							"El tipo de noticia "
									+ tipoNoticia.getDescripcion()
									+ " ha sido actualizado exitosamente", "American Tech",
							Messagebox.OK, Messagebox.INFORMATION);
				}
				win.detach();
				BindUtils.postGlobalCommand(null, null,
						"refreshTipoNoticia", null);
		
//			} else {
//				Messagebox.show("tipo de noticia con la descripcion "
//						+ tipoNoticia.getDescripcion() + " ya existe",
//						"American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
//			}
		}

	}
}

