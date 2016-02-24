package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import modelos.Cargo;
import modelos.Cargo;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.CargoDao;
import Dao.MotivoPostulacionDao;


public class RegistrarCargoViewModel {


	private Cargo cargo;
	private boolean editable;
	private CargoDao tipoDao;

	@Init
	public void init(@ExecutionArgParam("Cargo") Cargo tipo) {
		if (tipo == null) {
			this.cargo = new Cargo();
			this.editable = false;
		} else {
			this.cargo= tipo;
			this.editable = true;
		}
		tipoDao = new CargoDao();
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {
		
		if (cargo.getDescripcion() != null && !cargo.getDescripcion().equalsIgnoreCase("") )
		{
			if (!editable)
				tipoDao.agregarCargo(cargo);

			else tipoDao.actualizarCargo(cargo);
				
			win.detach();
			BindUtils.postGlobalCommand(null,null,"refreshCargo",null);
		}
		
		
	}
}

