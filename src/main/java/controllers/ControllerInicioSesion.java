package controllers;


import modelos.Persona;
import modelos.TipoSugerencia;
import modelos.Usuario;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import Dao.PersonaDao;
import Dao.TipoSugerenciaDao;
import Dao.UsuarioDao;

public class ControllerInicioSesion extends SelectorComposer<Component>{
	
	private static final long serialVersionUID = 1L;

	@Wire
    private Textbox usuario;
	@Wire
    private Textbox pass;
	
	private Usuario user = new Usuario();
	private UsuarioDao userDao = new UsuarioDao();
	
	@Listen("onClick =#linkRecuperarContrasenna")
	public void showModal(Event e){
		Window window = (Window)Executions.createComponents(
                "recuperarContrasenna.zul", null, null);
        window.doModal();
	}
	
	@Listen("onClick =#loguear")
	public void ingresar(Event e) throws Exception {
		String usu = usuario.getValue();
		String clave = pass.getValue();
		user = userDao.obtenerUsuario(usu, clave);
		System.out.println(usu);
		System.out.println(clave);
		if(user!=null)
		{
			System.out.println(user.getUsername());
			System.out.println(user.getContrasenna());
			Executions.sendRedirect("/vistas/index.zul");;
		} else{
			System.out.println("Nos jodimos esta vaina no funciona");
		}
	}

}
