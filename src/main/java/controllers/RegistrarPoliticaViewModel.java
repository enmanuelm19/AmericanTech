package controllers;

import modelos.Politica;
import modelos.TipoPreferencia;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.ClubDao;
import Dao.PoliticaDao;



public class RegistrarPoliticaViewModel {
	
	private Politica politica;
	private boolean editable;
	private PoliticaDao tipoDao;
	private ClubDao ClubDao;
	@Init
	public void init(@ExecutionArgParam("Politica") Politica politica) {
		if (politica == null) {
			this.politica = new Politica();
			this.editable = false;
		} else {
			this.politica = politica;
			this.editable = true;
		}
		tipoDao = new PoliticaDao();
		ClubDao= new ClubDao();
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public Politica getPolitica() {
		return politica;
	}

	public void setPolitica(Politica politica) {
		this.politica = politica;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {
		if (politica.getDescripcion() != null && !politica.getDescripcion().equalsIgnoreCase("")) {
				if (!editable) {
					politica.setClub(ClubDao.obtenerClub(1));
					politica.setActivo(true);
					tipoDao.agregarPolitica(politica);
					Messagebox.show("Se ha registrado la regla exitosamente", "Exito", Messagebox.OK, Messagebox.INFORMATION);
				} else {
					tipoDao.actualizarPolitica(politica);
					Messagebox.show("La regla ha sido actualizado exitosamente", "Exito", Messagebox.OK, Messagebox.INFORMATION);
				}
				win.detach();
				BindUtils.postGlobalCommand(null, null,"refreshReglas", null);
			}
		else{

			Messagebox.show("Debe llenar los campos","Error", Messagebox.OK, Messagebox.EXCLAMATION);
		}
		}

	}

