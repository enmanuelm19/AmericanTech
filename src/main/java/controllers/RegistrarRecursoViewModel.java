package controllers;

import modelos.Recurso;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Window;

import Dao.RecursoDao;

public class RegistrarRecursoViewModel {

	private Recurso recurso;
	private boolean editable;
	private RecursoDao tipoDao;

	@Init
	public void init(@ExecutionArgParam("Recurso") Recurso tipo) {
		if (tipo == null) {
			this.recurso = new Recurso();
			this.editable = false;
		} else {
			this.recurso = tipo;
			this.editable = true;
		}
		tipoDao = new RecursoDao();
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
		
		if (recurso.getDescripcion() != null && !recurso.getDescripcion().equalsIgnoreCase("") )
		{
			if (!editable)
				tipoDao.agregarRecurso(recurso);

			else tipoDao.actualizarRecurso(recurso);
				
			win.detach();
			BindUtils.postGlobalCommand(null,null,"refreshRecurso",null);
		}
		
		
	}
}

