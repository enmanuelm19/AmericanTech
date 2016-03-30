package controllers;

import modelos.TipoPago;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.TipoPagoDao;

public class RegistrarTipoPagoViewModel {

	private TipoPago tipoPago;
	private boolean editable;
	private TipoPagoDao tipoDao;

	@Init
	public void init(@ExecutionArgParam("TipoPago") TipoPago tipo) {
		if (tipo == null) {
			this.tipoPago = new TipoPago();
			this.editable = false;
		} else {
			this.tipoPago = tipo;
			this.editable = true;
		}
		tipoDao = new TipoPagoDao();
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public TipoPago getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {

		if (tipoPago.getDescripcion() != null
				&& !tipoPago.getDescripcion().equalsIgnoreCase("")) {
			if (tipoDao.obtenerTipoDescripcion(tipoPago.getDescripcion()) == null) {
				if (!editable) {
					tipoDao.agregarTipoPago(tipoPago);
					Messagebox.show(
							"El tipo pago "
									+ tipoPago.getDescripcion()
									+ " ha sido registrado exitosamente", "American Tech",
							Messagebox.OK, Messagebox.INFORMATION);
				} else {
					tipoDao.actualizarTipoPago(tipoPago);
					Messagebox.show(
							"El tipo pago "
									+ tipoPago.getDescripcion()
									+ " ha sido actualizado exitosamente", "",
							Messagebox.OK, Messagebox.INFORMATION);
				}
				win.detach();
				BindUtils.postGlobalCommand(null, null, "refreshTipoPago",
						null);
			} else {
				Messagebox.show("El tipo pago con la descripción "
						+ tipoPago.getDescripcion() + " ya existe",
						"American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
			}
		}else{
			Messagebox.show("Verifique que los campos estén llenos ", "American Tech",
					Messagebox.OK, Messagebox.INFORMATION);
		}

	}
}


