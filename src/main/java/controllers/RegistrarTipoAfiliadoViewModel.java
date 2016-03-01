package controllers;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.TipoAfiliadoDao;
import modelos.TipoAfiliado;

public class RegistrarTipoAfiliadoViewModel {
	
	private TipoAfiliado tipoAfiliado;
	private TipoAfiliadoDao tipoDao;
	private boolean editable;
	
	@Init
	public void init(@ExecutionArgParam("TipoAfiliado")TipoAfiliado tipo){
		if(tipo == null){
			this.tipoAfiliado = new TipoAfiliado();
			this.editable = false;
		}else{
				this.tipoAfiliado = tipo;
				this.editable = true;
			}
		this.tipoDao = new TipoAfiliadoDao();
	}
		
	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}
		
	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {
		this.tipoAfiliado.setActivo(true);
		if (tipoAfiliado.getDescripcion() != null && !tipoAfiliado.getDescripcion().equalsIgnoreCase("") )
		{
			if(this.tipoDao.obtenerTipoDescripcion(tipoAfiliado.getDescripcion())==null){
			if (!editable)
				tipoDao.agregarTipoAfiliado(tipoAfiliado);
			else tipoDao.actualizarTipoAfiliado(tipoAfiliado);
			win.detach();
			BindUtils.postGlobalCommand(null,null,"refreshTipoAfiliado",null);
			}else{
				Messagebox.show("tipo de afiliado con la descripción" + tipoAfiliado.getDescripcion() + " ya existe",
						"Warning", Messagebox.OK, Messagebox.EXCLAMATION);
			}
		}			
	}
	
	public TipoAfiliado getTipoAfiliado() {
		return tipoAfiliado;
	}
	public void setTipoAfiliado(TipoAfiliado tipoAfiliado) {
		this.tipoAfiliado = tipoAfiliado;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	} 
	
}
