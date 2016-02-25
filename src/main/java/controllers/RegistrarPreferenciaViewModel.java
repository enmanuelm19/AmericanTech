package controllers;

import java.util.List;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;
import Dao.PreferenciaDao;
import Dao.TipoPreferenciaDao;
import modelos.Preferencia;
import modelos.TipoPreferencia;

public class RegistrarPreferenciaViewModel {
	
	private Preferencia preferencia;
	private boolean editable;
	private PreferenciaDao preferenciaDao;
	private List<TipoPreferencia> allTipoPreferencia;
	private TipoPreferenciaDao tipoPreferenciaDao;
	

	@Init
	public void init(@ExecutionArgParam("preferencia") Preferencia preferencia) throws Exception {
		if (preferencia == null) {
			this.preferencia = new Preferencia();
			this.editable = false;
		} else {
			this.preferencia = preferencia;
			this.editable = true;
		}
		preferenciaDao = new PreferenciaDao();
		tipoPreferenciaDao = new TipoPreferenciaDao();
		allTipoPreferencia = tipoPreferenciaDao.obtenerTodos();
	}
	
	public ListModelList<TipoPreferencia> getAllTipoPreferencia() {

		return new ListModelList<TipoPreferencia>(allTipoPreferencia);
	}


	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public Preferencia getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(Preferencia preferencia) {
		this.preferencia = preferencia;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {

		if (preferencia.getDescripcion() != null && !preferencia.getDescripcion().equalsIgnoreCase("")) {
			if (!editable){
				
				System.out.println(" preferencia a guardar "+preferencia.getDescripcion());
				
				preferenciaDao.agregarPreferencia(preferencia);}

			else
				preferenciaDao.actualizarPreferencia(preferencia);

			win.detach();
			BindUtils.postGlobalCommand(null, null, "refreshPreferencia", null);
		}

	}
}
