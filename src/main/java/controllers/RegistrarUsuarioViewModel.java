package controllers;

import java.util.Date;
import java.util.List;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.GrupoDao;
import Dao.PersonaDao;
import Dao.UsuarioDao;
import Dao.UsuarioGrupoDao;
import modelos.Grupo;
import modelos.Persona;
import modelos.Usuario;
import modelos.UsuarioGrupo;

public class RegistrarUsuarioViewModel {
	
	private Usuario user;
	private Persona persona;
	private boolean editable;
	private PersonaDao personaDao;
	private UsuarioDao usuarioDao;
	private List<Grupo> grupos;
	private GrupoDao grupoDao;
	private List<Persona> personas;
	private List<Usuario> usuarios;
	private String keyword;
	private Grupo grupo;
	private List<UsuarioGrupo> usuarioGrupo;
	private UsuarioGrupoDao usuarioGrupoDao;
	
	@Init
	public void init(@ExecutionArgParam("Usuario") Usuario usuario) throws Exception {
		
		personaDao = new PersonaDao();
		usuarioDao = new UsuarioDao();
		grupoDao = new GrupoDao();
		setGrupos(grupoDao.obtenerTodos());
		usuarioGrupoDao = new UsuarioGrupoDao();
		if (usuario == null) {
			this.user = new Usuario();
			this.editable = false;
			this.persona = new Persona();
			persona.setNombre("Agregar dato aqui");
			persona.setApellido("Agregar dato aqui");
			persona.setSexo("M");
			persona.setActivo(true);
			personaDao.agregarPersona(persona);
			user.setPersona(persona);
		} else {
			this.user = usuario;
			this.editable = true;
			System.out.println(user.getUsuarioGrupos().size());
		}

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
	public void cerrarModal(@BindingParam("win") Window win) throws Exception {
		if(editable == false){
			personaDao.hardDelete(persona);
		}
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
				user.setActivo(true);
				personaDao.actualizarPersona(user.getPersona());
				usuarioDao.agregarUsuario(user);
			}
			else {
				user.setFecha(new Date());
				personaDao.actualizarPersona(user.getPersona());
				usuarioDao.actualizarUsuario(user);
			}
			
			win.detach();
			BindUtils.postGlobalCommand(null,null,"refreshUsuarios",null);
		}
		
		
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	
	@Command
	@NotifyChange("user")
	public void busqueda(@BindingParam("win") Window win) throws Exception{
		personas = personaDao.obtenerTodos();
		usuarios = usuarioDao.obtenerTodos();
		if (keyword!= null) {
			for(Persona p : personas){
				if(keyword.equalsIgnoreCase(p.getIdentificacion())){
					
					for(Usuario u : usuarios){
						if(u.getPersona().getIdentificacion().equalsIgnoreCase(p.getIdentificacion())){
							Messagebox.show("Lo sentimos la persona ya tiene un usuario asignado, editar el usuario en la lista");
							cerrarModal(win);
							break;
						}
					}
					user.setPersona(p);
					break;
				}
			}
		}else{
			Messagebox.show("Por favor ingrese datos en el campo");
		}

	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	@Command
	public void agregarGrupo(){
		
	}
}
