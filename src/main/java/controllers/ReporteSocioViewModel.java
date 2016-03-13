package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;

import Dao.PreferenciaDao;
import Dao.TipoPreferenciaDao;
import modelos.TipoPreferencia;
import modelos.Preferencia;
import modelos.PreferenciaEvento;


public class ReporteSocioViewModel {

	private TipoPreferencia tipoPreferenciaSelected;
	private TipoPreferenciaDao tPreferenciaDao;
	private Preferencia preferenciaSelected;
	private PreferenciaDao preferenciaDao;	
	private ArrayList<Preferencia> temporalPreferencia;
	private ArrayList<Preferencia> seleccionPreferencia;
	private Set<Preferencia> preferenciaEventos;
	@Init
	public void init(@ExecutionArgParam("elTipo") TipoPreferencia tpreferencia) {
		tPreferenciaDao = new TipoPreferenciaDao();		
		preferenciaDao = new PreferenciaDao();
		temporalPreferencia = new ArrayList<Preferencia>();
		preferenciaEventos = new HashSet<Preferencia>();
	}

	@NotifyChange("preferenciasPorTipo")
	public TipoPreferencia getTipoPreferenciaSelected() {
		return tipoPreferenciaSelected;
	}	

	public ListModelList<TipoPreferencia> getAllTipoPreferencia() throws Exception {
		return new ListModelList<TipoPreferencia>(tPreferenciaDao.obtenerTodos());
	}
	@NotifyChange("preferenciasPorTipo")
	public void setTipoPreferenciaSelected(TipoPreferencia tipoPreferenciaSelected) {
		this.tipoPreferenciaSelected = tipoPreferenciaSelected;
	}	
	public ListModelList<Preferencia> getPreferenciasPorTipo() throws Exception {
		if (tipoPreferenciaSelected != null) {
			return new ListModelList<Preferencia>(preferenciaDao.obtenerPreferenciasTipo(tipoPreferenciaSelected));
		}
		return new ListModelList<Preferencia>();
	}
	public ArrayList<Preferencia> getTemporalPreferencia() {

		return temporalPreferencia;
	}

	public void setTemporalPreferencia(ArrayList<Preferencia> temporalPreferencia) {
		this.temporalPreferencia = temporalPreferencia;
	}
	
	
	public Set<Preferencia> getPreferenciaEventos() {
		return preferenciaEventos;
	}	
	public void setPreferenciaEventos(Set<Preferencia> preferenciaEventos) {
		this.preferenciaEventos = preferenciaEventos;
	}	
	
	@Command
	@NotifyChange({"preferenciaEventos"})
	public void agregarSeleccionPreferencia() {
		Set<Preferencia> tmp = new HashSet<Preferencia>();
		for(Preferencia p : getTemporalPreferencia()){
			tmp.add(p);
		}
		setPreferenciaEventos(tmp);
	}
	//metodo para elliminar los datos de la tabla temporal
//	@Command
//	@NotifyChange({ "preferenciasEventos"})
//	public void eliminarPreferenciaEvento(@BindingParam("preferenciaEvento") PreferenciaEvento p) {
//		if(this.editable)
//			p.setActivo(false);
//		else listPreferenciaEvento.remove(p);
//		
//	}
}





