package controllers;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.PatrocinanteDao;
import modelos.Patrocinante;

public class RegistrarPatrocinanteViewModel {

	private Patrocinante patrocinante;
	private boolean editable;
	private PatrocinanteDao patrocinanteDao;

	@Init
	public void init(@ExecutionArgParam("Patrocinante") Patrocinante patrocinante) {
		if (patrocinante == null) {
			this.patrocinante = new Patrocinante();
			this.editable = false;
		} else {
			this.patrocinante = patrocinante;
			this.editable = true;
		}
		patrocinanteDao = new PatrocinanteDao();
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public Patrocinante getPatrocinante() {
		return patrocinante;
	}

	public void setPatrocinante(Patrocinante patrocinante) {
		this.patrocinante = patrocinante;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {

		if (!isCamposVacios()) {
			if (this.patrocinanteDao.obtenerPatrocinante(patrocinante.getIdPatrocinante()) == null) {

				if (!editable)
					patrocinanteDao.agregarPatrocinante(patrocinante);

				else
					patrocinanteDao.actualizarPatrocinante(patrocinante);

				win.detach();
				BindUtils.postGlobalCommand(null, null, "refreshPatrocinante", null);
			} else {
				Messagebox.show("patrocinante con el identificador " + patrocinante.getIdPatrocinante() + "ya existe",
						"Warning", Messagebox.OK, Messagebox.EXCLAMATION);
			}
		}

	}

	public boolean isCamposVacios() {

		if (patrocinante.getNombre() != null && !patrocinante.getNombre().equalsIgnoreCase("")
				&& patrocinante.getDireccion() != null && !patrocinante.getDireccion().equalsIgnoreCase("")
				&& String.valueOf(patrocinante.getTelefono()) != null
				&& !String.valueOf(patrocinante.getTelefono()).equalsIgnoreCase("")
				&& String.valueOf(patrocinante.getCorreo()) != null
				&& !String.valueOf(patrocinante.getCorreo()).equalsIgnoreCase(""))
			return false;
		return true;
	}
}

