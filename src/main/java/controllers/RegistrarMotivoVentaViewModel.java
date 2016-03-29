package controllers;

import modelos.MotivoVenta;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.MotivoVentaDao;

public class RegistrarMotivoVentaViewModel {

	private MotivoVenta motivoVenta;
	private boolean editable;
	private MotivoVentaDao motivoDao;

	@Init
	public void init(@ExecutionArgParam("MotivoVenta") MotivoVenta motivo) {
		if (motivo == null) {
			this.motivoVenta = new MotivoVenta();
			this.editable = false;
		} else {
			this.motivoVenta = motivo;
			this.editable = true;
		}
		motivoDao = new MotivoVentaDao();
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public MotivoVenta getMotivoVenta() {
		return motivoVenta;
	}

	public void setMotivoVenta(MotivoVenta motivoVenta) {
		this.motivoVenta = motivoVenta;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {

		if (motivoVenta.getDescripcion() != null
				&& !motivoVenta.getDescripcion().equalsIgnoreCase("")) {
			if (motivoDao.obtenerMotivoVenta(motivoVenta.getDescripcion()) == null) {
				if (!editable) {
					motivoDao.agregarMotivoVenta(motivoVenta);
					Messagebox.show(
							"El motivo venta "
									+ motivoVenta.getDescripcion()
									+ " ha sido registrado exitosamente", "American Tech",
							Messagebox.OK, Messagebox.INFORMATION);
				} else {
					motivoDao.actualizarMotivoVenta(motivoVenta);
					Messagebox.show(
							"El motivo venta "
									+ motivoVenta.getDescripcion()
									+ " ha sido actualizado exitosamente", "American Tech",
							Messagebox.OK, Messagebox.INFORMATION);
				}

				win.detach();
				BindUtils.postGlobalCommand(null, null, "refreshMotivoVenta",
						null);
			} else {
				Messagebox.show("El motivo venta con la descripción "
						+ motivoVenta.getDescripcion() + " ya existe",
						"American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
			}
		}else{
			Messagebox.show("Verifique que los campos esten llenos ", "American Tech",
					Messagebox.OK, Messagebox.INFORMATION);
		}

	}
}
