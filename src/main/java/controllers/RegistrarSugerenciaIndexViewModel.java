package controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.SugerenciaDao;
import Dao.ClienteExternoDao;
import Dao.TipoSugerenciaDao;
import modelos.Sugerencia;
import modelos.TipoSugerencia;
import modelos.ClienteExterno;

public class RegistrarSugerenciaIndexViewModel {

	private Sugerencia sugerencia;
	private boolean editable;
	private SugerenciaDao sugerenciaDao;
	private List<TipoSugerencia> allTipoSugerencia;
	private TipoSugerenciaDao tipoSugerenciaDao;
	Date date = new Date();
	private ClienteExterno clienteExterno;
	

	@Init
	public void init(@ExecutionArgParam("sugerencia") Sugerencia sugerencia) throws Exception {
		if (sugerencia == null) {
			this.sugerencia = new Sugerencia();
			
			this.editable = false;
		} else {
			this.sugerencia = sugerencia;
			this.editable = true;
		}
		sugerenciaDao = new SugerenciaDao();
		tipoSugerenciaDao = new TipoSugerenciaDao();
		allTipoSugerencia = tipoSugerenciaDao.obtenerTodos();
		clienteExterno = new ClienteExterno();
	
	}

	public ListModelList<TipoSugerencia> getAllTipoSugerencia() {

		return new ListModelList<TipoSugerencia>(allTipoSugerencia);
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public Sugerencia getSugerencia() {
		return sugerencia;
	}

	public void setSugerencia(Sugerencia sugerencia) {
		this.sugerencia = sugerencia;
	}
	
	
	public ClienteExterno getClienteExterno() {
		return clienteExterno;
	}

	public void setSugerencia(ClienteExterno clienteExterno) {
		this.clienteExterno = clienteExterno;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}
	


	@Command
	@NotifyChange({"sugerencia","clienteExterno"})
	public void guardar(@BindingParam("win") Window win) throws Exception {

		
		try { 
			if (sugerencia.getDescripcion() == null || sugerencia.getDescripcion().equalsIgnoreCase("") ||
					sugerencia.getTipoSugerencia() == null) {
					Messagebox.show("Verifique que todos los datos esten llenos", "American Tech",
							Messagebox.OK, Messagebox.INFORMATION);
				}
				else{
					if (!editable) {
						this.sugerencia.setClienteExterno(clienteExterno);   
						sugerencia.setFecha(date);
						sugerenciaDao.agregarSugerencia(sugerencia);
						sugerencia= new Sugerencia();
						clienteExterno= new ClienteExterno();
						Messagebox.show("La sugerencia ha sido registrada exitosamente", "American Tech",
								Messagebox.OK, Messagebox.INFORMATION);
					}

				}
			} catch(Exception e) { 
				Messagebox.show("Verifique los campos e intente de nuevo", "American Tech",
						Messagebox.OK, Messagebox.INFORMATION);
			}
		
	

	}
}
