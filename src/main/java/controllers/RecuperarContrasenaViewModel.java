package controllers;

import java.util.EventListener;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;	
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Initiator;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import Dao.UsuarioDao;
import modelos.Usuario;

public class RecuperarContrasenaViewModel implements Initiator {

	@Wire("#usuario")
	private Textbox usuario;
	
	@Wire("#respuesta")
	private Textbox respuesta;
	
	Usuario user = new Usuario();
	UsuarioDao usuarioDao = new UsuarioDao();
	int attemp;

	public Usuario getUser() {
		Session session = Sessions.getCurrent();
		user = (Usuario) session.getAttribute("user");
		return user;
	}

	@Command
	public void enviarRespuesta(){
		final Session session = Sessions.getCurrent();
		if(attemp > 3){
			Messagebox.show("Ha superado el numero de intentos permitido por favor regrese mas tarde", "Confirmar", Messagebox.OK, Messagebox.INFORMATION, new org.zkoss.zk.ui.event.EventListener(){

				public void onEvent(Event arg0) throws Exception {
					if(arg0.getName().equals("onOK")){
						session.removeAttribute("user");
						Executions.sendRedirect("/");
					}
				}
				
			});
		}
		
		if(respuesta.getValue().equalsIgnoreCase(getUser().getRespuesta())){
			Messagebox.show("Su contraseña ha sido enviada a su correo!");
			attemp = 0;
			session.removeAttribute("user");
		}else{
			Messagebox.show("Respuesta incorrecta");
			attemp++;
		}
	}
	
	public void doInit(Page arg0, Map<String, Object> arg1) throws Exception {
		Usuario usuarioSesion = new Usuario();
		Session session = Sessions.getCurrent();
		usuarioSesion = (Usuario) session.getAttribute("user");
		attemp = 0;
	
		if(usuarioSesion == null){
			Messagebox.show("No esta autorizado para ingresar", null, 0, Messagebox.ERROR);
			Executions.sendRedirect("/vistas/layouts/ingreso.zul");
		}
	}

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
	}

	@Command
	public void buscarUsuario() throws Exception{
		Session session = Sessions.getCurrent();
		boolean encontrado = false;
		try{
			for(Usuario u : usuarioDao.obtenerTodos()){
				if(u.getUsername().equalsIgnoreCase(usuario.getValue())){
					encontrado = true;
					session.setAttribute("user", u);
					Executions.sendRedirect("/vistas/layouts/preguntaSeguridad.zul");
					break;		
				}
			}

			if(encontrado == false){
				Messagebox.show("Lo sentimos el usuario que ingreso no existe");
			}
		}catch(WrongValueException ex){

		}
	}

}
