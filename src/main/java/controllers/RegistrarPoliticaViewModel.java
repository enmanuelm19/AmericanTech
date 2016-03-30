package controllers;

import java.util.List;

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
			this.politica.setValor(new Long(0));
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
		if (politica.getDescripcion() != null && !politica.getDescripcion().equalsIgnoreCase("") ||politica.getValor().equals(new Long(0))) {
			System.out.println(politica.getValor());	
			if (!editable) {
					if(validarDescripcion()){
						Messagebox.show("Ya existe una regla con esa descripcion", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
					}
					else{
						politica.setClub(ClubDao.obtenerClub(1));
						politica.setActivo(true);
						tipoDao.agregarPolitica(politica);
						Messagebox.show("Se ha registrado la regla exitosamente", "American Tech", Messagebox.OK, Messagebox.INFORMATION);
						win.detach();
						BindUtils.postGlobalCommand(null, null,"refreshReglas", null);
					}
				} else {
					tipoDao.actualizarPolitica(politica);
					Messagebox.show("La regla ha sido actualizado exitosamente", "American Tech", Messagebox.OK, Messagebox.INFORMATION);
					win.detach();
					BindUtils.postGlobalCommand(null, null,"refreshReglas", null);
				}
				
			}
		else{

			Messagebox.show("Debe llenar los campos","American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		}
	}
	
	public boolean validarDescripcion() throws Exception{
		List<Politica> pol= tipoDao.obtenerTodos();
		boolean validar= false;
		for(int i=0; i< pol.size(); i++){
			if(pol.get(i).getDescripcion().equalsIgnoreCase(politica.getDescripcion()))
				validar=true;
		}
		return validar;
	}
}

