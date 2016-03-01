package controllers;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;
import Dao.UnidadMedidaDao;
import modelos.UnidadMedida;

public class RegistrarUnidadMedidaViewModel {

	private UnidadMedida unidadMedida;
	private boolean editable;
	private UnidadMedidaDao unidadDao;

	@Init
	public void init(@ExecutionArgParam("unidadM") UnidadMedida unidad) {
		if (unidad == null) {
			this.unidadMedida = new UnidadMedida();
			this.editable = false;
		} else {
			this.unidadMedida = unidad;
			this.editable = true;
		}
		unidadDao = new UnidadMedidaDao();
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public UnidadMedida getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {
		
		if (unidadMedida.getNombre() != null && !unidadMedida.getNombre().equalsIgnoreCase("") )
		{
			if(unidadDao.obtenerUnidadNombre(unidadMedida.getNombre())==null){
			if (!editable)
				unidadDao.agregarUnidadMedida(unidadMedida);

			else unidadDao.actualizarUnidadMedida(unidadMedida);
				
			win.detach();
			BindUtils.postGlobalCommand(null,null,"refreshUnidadMedida",null);
			}
			else{
				Messagebox.show("Unidad medida con el nombre " + unidadMedida.getNombre() + " ya existe",
						"Warning", Messagebox.OK, Messagebox.EXCLAMATION);
			}
		}
		
		
	}
}
