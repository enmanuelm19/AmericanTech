package controllers;


import modelos.Usuario;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import javax.servlet.http.HttpSession;

import Dao.UsuarioDao;

public class SesionViewModel {

	@Wire("#usuario")
	private Textbox usuario;

	@Wire("#password")
	private Textbox pass;

	private Usuario user = new Usuario();
	private UsuarioDao userDao = new UsuarioDao();

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
	}

	@Command
	public void showModal(){
		Window window = (Window)Executions.createComponents(
				"recuperarContrasenna.zul", null, null);
		window.doModal();
	}

	@Command
	public void ingresar() throws Exception {
		if(usuario.getValue().equalsIgnoreCase("")){
			Messagebox.show("Ingrese sus datos", "warning", Messagebox.OK, Messagebox.EXCLAMATION);
		}else{
			String usu = usuario.getValue();
			String clave = pass.getValue();
			user = userDao.obtenerUsuario(usu, clave);
			if(user!=null)
			{
				Executions.sendRedirect("/vistas/index.zul");;
			} else{

			}
		}
	}

}
