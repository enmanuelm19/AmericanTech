package controllers;

import java.util.Date;
import java.util.List;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.Window;

import Dao.GrupoDao;
import Dao.UsuarioDao;
import modelos.Grupo;
import modelos.Usuario;

public class RegistrarUsuarioViewModel {
	
	private Usuario user;
	private boolean editable;
	private UsuarioDao usuarioDao;
	private List<Grupo> grupos;
	private GrupoDao grupoDao;
	
	@Init
	public void init(@ExecutionArgParam("Usuario") Usuario usuario) throws Exception {
		if (usuario == null) {
			this.user = new Usuario();
			this.editable = false;
		} else {
			this.user = usuario;
			this.editable = true;
		}
		usuarioDao = new UsuarioDao();
		grupoDao = new GrupoDao();
		setGrupos(grupoDao.obtenerTodos());
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	
	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {
		
		if (user.getUsername() != null && !user.getUsername().equalsIgnoreCase("") )
		{
			if (!editable){
				user.setFecha(new Date());
				usuarioDao.agregarUsuario(user);
			}
			else {
				user.setFecha(new Date());
				usuarioDao.actualizarUsuario(user);
			}
			
			win.detach();
			BindUtils.postGlobalCommand(null,null,"refreshUsuarios",null);
		}
		
		
	}

}
