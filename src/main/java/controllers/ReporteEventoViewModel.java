package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;










import Dao.PreferenciaDao;
import Dao.TipoPreferenciaDao;
import modelos.Preferencia;
import modelos.TipoPreferencia;



public class ReporteEventoViewModel {
	

	
	private TipoPreferenciaDao tipopreferenciaDao;	
	private PreferenciaDao preferenciaDao;
	private TipoPreferencia tipoPreferenciaSelected;

	
	@Init
	public void init() {
		tipopreferenciaDao = new TipoPreferenciaDao();
	}

	public ListModelList<TipoPreferencia> getTipoPreferencia() throws Exception {

		return new ListModelList<TipoPreferencia>(tipopreferenciaDao.obtenerTodos());

	}
	@NotifyChange("preferenciasPorTipo")
	public TipoPreferencia getTipoPreferenciaSelected() {
		return tipoPreferenciaSelected;
	}

	@NotifyChange("preferenciasPorTipo")
	public void setTipoPreferenciaSelected(TipoPreferencia tipoPreferenciaSelected) {
		this.tipoPreferenciaSelected = tipoPreferenciaSelected;
	}

	public ListModelList<Preferencia> getPreferenciasPorTipo() throws Exception {
		if (tipoPreferenciaSelected != null) {
			return new ListModelList<Preferencia>(tipoPreferenciaSelected.getPreferencias());
		}else{
		return new ListModelList<Preferencia>();}
	}

}
