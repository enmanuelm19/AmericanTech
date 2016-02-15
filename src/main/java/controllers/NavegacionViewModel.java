package controllers;

import java.util.List;

import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Path;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zkmax.zul.Nav;
import org.zkoss.zkmax.zul.Navbar;
import org.zkoss.zkmax.zul.Navitem;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

import models.Funcion;
import service.FuncionService;

public class NavegacionViewModel {
	
	
	@Wire("#navbar")
	Navbar navbar;
	
	private List<Funcion> funciones = FuncionService.getFunciones();
	
	 @AfterCompose
	    public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
	        Selectors.wireComponents(view, this, false);
	    }

	
	@Command
	public void cargarMenu(){
		for(Funcion fc : funciones){
			Navitem nav = new Navitem();
			nav.setLabel(fc.getNombre());
			navbar.appendChild(nav);
		}
		
	}
	
}
