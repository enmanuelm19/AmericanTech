package controllers;

import modelos.Indicador;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.IndicadorDao;

public class RegistrarIndicadorViewModel {

	private Indicador indicador;
	private boolean editable;
	private IndicadorDao indicadorDao;

	@Init
	public void init(@ExecutionArgParam("indicador") Indicador indicador) {
		if (indicador == null) {
			this.indicador = new Indicador();
			this.editable = false;
		} else {
			this.indicador = indicador;
			this.editable = true;
		}
		indicadorDao = new IndicadorDao();
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public Indicador getIndicador() {
		return indicador;
	}

	public void setUnidadMedida(Indicador indicador) {
		this.indicador = indicador;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {

		if (indicador.getDescripcion() != null
				&& !indicador.getDescripcion().equalsIgnoreCase("")) {
			if (indicadorDao.obtenerIndicador(indicador.getDescripcion()) == null) {
				if (!editable) {
					indicadorDao.agregarIndicador(indicador);
					Messagebox.show(
							"El indicador " + indicador.getDescripcion()
									+ " ha sido registrado exitosamente", "",
							Messagebox.OK, Messagebox.INFORMATION);
				} else {
					indicadorDao.actualizarIndicador(indicador);
					Messagebox.show(
							"El indicador " + indicador.getDescripcion()
									+ " ha sido actualizado exitosamente", "",
							Messagebox.OK, Messagebox.INFORMATION);
				}
				win.detach();
				BindUtils.postGlobalCommand(null, null, "refreshIndicador",
						null);
			} else {
				Messagebox.show(
						"Indicador con la descripcion "
								+ indicador.getDescripcion() + " ya existe",
						"Warning", Messagebox.OK, Messagebox.EXCLAMATION);
			}
		}

	}
}

