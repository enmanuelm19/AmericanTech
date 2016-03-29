package controllers;

import modelos.Recurso;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.RecursoDao;

public class RegistrarRecursoViewModel {

	private Recurso recurso;
	private boolean editable;
	private RecursoDao recursoDao;

	@Init
	public void init(@ExecutionArgParam("Recurso") Recurso recurso) {
		if (recurso == null) {
			this.recurso = new Recurso();
			this.editable = false;
		} else {
			this.recurso = recurso;
			this.editable = true;
		}
		recursoDao = new RecursoDao();
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {

		if (recurso.getDescripcion() != null
				&& !recurso.getDescripcion().equalsIgnoreCase("")) {
			if (recursoDao.obtenerRecurso(recurso.getDescripcion()) == null) {
				if (!editable) {
					recursoDao.agregarRecurso(recurso);
					Messagebox.show("El recurso " + recurso.getDescripcion()
							+ " ha sido registrado exitosamente", "American Tech",
							Messagebox.OK, Messagebox.INFORMATION);
				} else {
					recursoDao.actualizarRecurso(recurso);
					Messagebox.show("El recurso " + recurso.getDescripcion()
							+ " ha sido actualizado exitosamente", "American Tech",
							Messagebox.OK, Messagebox.INFORMATION);
				}
				win.detach();
				BindUtils.postGlobalCommand(null, null, "refreshRecurso", null);
			} else {
				Messagebox.show(
						"El recurso con la descripción "
								+ recurso.getDescripcion() + " ya existe",
						"Warning", Messagebox.OK, Messagebox.EXCLAMATION);
			}
		}

	}
}
