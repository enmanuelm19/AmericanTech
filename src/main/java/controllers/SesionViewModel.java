package controllers;


import modelos.Grupo;
import modelos.Persona;
import modelos.Usuario;
import modelos.UsuarioGrupo;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Initiator;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import Dao.PersonaDao;
import Dao.UsuarioDao;
import Dao.UsuarioGrupoDao;

public class SesionViewModel implements Initiator {

	@Wire("#usuario")
	private Textbox usuario;

	@Wire("#password")
	private Textbox pass;

	private Usuario user = new Usuario();
	private UsuarioDao userDao = new UsuarioDao();
	private UsuarioGrupoDao userGroupDao = new UsuarioGrupoDao();

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
	
 
	public Usuario chequearCredenciales() throws Exception{
		String usu = usuario.getValue();
		String clave = pass.getValue();
		user = userDao.obtenerUsuario(usu, clave);
		return user;
	}
	
	@Command
	public void ingresar() throws Exception {
		if(usuario.getValue().equalsIgnoreCase("") || pass.getValue().equalsIgnoreCase("")){
			Messagebox.show("Ingrese sus datos", "warning", Messagebox.OK, Messagebox.EXCLAMATION);
		}else{
			Usuario user = chequearCredenciales();
			Session session = Sessions.getCurrent();
			session.setAttribute("Usuario", user);
			List<Grupo> grupos = new ArrayList<Grupo>();
			/*List<UsuarioGrupo> userGroup = userGroupDao.obtenerGruposUsuario(user.getPersona().getIdPersona());
			for(UsuarioGrupo ug : userGroup){
				grupos.add(ug.getGrupo());
			}
			session.setAttribute("Grupos", grupos);*/
			if(user!=null)
			{
				Executions.sendRedirect("/vistas/index.zul");;
			}else{
				Messagebox.show("Usuario o contraseña invalidos", "warning", Messagebox.OK, Messagebox.EXCLAMATION);
			}
		}
	}
	
	@Command
	public void salir() throws Exception{
		Session session = Sessions.getCurrent();
		session.removeAttribute("Usuario");
		session.removeAttribute("Grupos");
	}

	public void doInit(Page arg0, Map<String, Object> arg1) throws Exception {
		Usuario usuarioSesion = new Usuario();
		Session session = Sessions.getCurrent();
		usuarioSesion = (Usuario) session.getAttribute("Usuario");
	
		if(usuarioSesion == null){
			Messagebox.show("No esta autorizado para ingresar", null, 0, Messagebox.ERROR);
			Executions.sendRedirect("/vistas/layouts/ingreso.zul");
		}
	}
}
