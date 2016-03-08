package controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.image.AImage;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WebApps;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import java.nio.file.Files;

import Dao.GrupoDao;
import Dao.PersonaDao;
import Dao.UsuarioDao;
import Dao.UsuarioGrupoDao;
import modelos.FuncionGrupo;
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
	private Media uploadedImage;
	private List<UsuarioGrupo> usuarioGrupos;
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
			usuarioGrupos = new ArrayList<UsuarioGrupo>(user.getUsuarioGrupos());
		} else {
			this.user = usuario;
			this.editable = true;
			String tmp;
			if(user.getPersona().getDireccion() == null){
			tmp = " ";
			}else{
			tmp = user.getPersona().getDireccion();}
			String nombre = "";
			String ruta = WebApps.getCurrent().getServletContext().getInitParameter("upload.location");
			int index;
			for(int i=tmp.length()-1;i>0;i--){
				if(tmp.charAt(i) == '/'){
					index = i;
					nombre = tmp.substring(index);
					break;
				}
			}
			File f = new File(ruta, nombre); 
			if(f.exists() && user.getPersona().getDireccion()!= null){
				URL url = new URL(user.getPersona().getDireccion());
				this.uploadedImage = new AImage(url);
			}else{
			URL url = new URL("http://localhost:8080/america/assets/portal/img/img1.jpg");
			this.uploadedImage = new AImage(url);}
			this.setUsuarioGrupo(new ArrayList<UsuarioGrupo>(user.getUsuarioGrupos()));
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
				user.getPersona().setDireccion(subirImagen(getUploadedImage()));
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
	

	public List<UsuarioGrupo> getUsuarioGrupo() {
		List<UsuarioGrupo> tmp = new ArrayList<UsuarioGrupo>();
		for(UsuarioGrupo u: usuarioGrupos){
			if(u.isActivo()){
				tmp.add(u);
			}
		}
		usuarioGrupos = tmp;
		return usuarioGrupos;
	}

	public void setUsuarioGrupo(List<UsuarioGrupo> usuarioGrupo) {
		this.usuarioGrupos = usuarioGrupo;
	}
	
	public String getCantRegistros() {
		if(usuarioGrupos!=null){
		return usuarioGrupos.size() + " items en la lista";
		}else{
			return "No hay items en la lista";
		}
	}
	
	@Command
	@NotifyChange({"usuarioGrupo", "cantRegistros"})
	public void eliminarGrupos(@BindingParam("Grupo") final UsuarioGrupo grupo){
		Messagebox.show("Estas seguro de eliminar " + grupo.getGrupo().getDescripcion()+ "del usuario", "Confirmar",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {
								usuarioGrupoDao.eliminarUsuarioGrupo(grupo);
								usuarioGrupos = usuarioGrupoDao.obtenerTodos();
								Messagebox.show(grupo.getGrupo().getDescripcion() + " ha sido eliminado", "", Messagebox.OK,
										Messagebox.INFORMATION);
								BindUtils.postGlobalCommand(null, null, "refreshUsuarioGrupo", null);
							} catch (Exception e) {
								Messagebox.show(e.getMessage(), grupo.getGrupo().getDescripcion() + " No se pudo eliminar",
										Messagebox.OK, Messagebox.ERROR);
							}
						}
					}
				});
	}
	
	@Command
	@NotifyChange({"usuarioGrupo", "cantRegistros"})
	public void agregarGrupo() throws Exception{
		UsuarioGrupo usGroup = new UsuarioGrupo();
		usGroup.setGrupo(getGrupo());
		usGroup.setUsuario(getUser());
		usGroup.setActivo(true);
		usuarioGrupoDao.agregarUsuarioGrupo(usGroup);
		BindUtils.postGlobalCommand(null, null, "refreshUsuarioGrupo", null);
	}
	
	@GlobalCommand
	@NotifyChange({ "usuarioGrupo", "cantRegistros" })
	public void refreshUsuarioGrupo() throws Exception {
		usuarioGrupos = new ArrayList<UsuarioGrupo>(user.getUsuarioGrupos());
	}
	
	@Command
	@NotifyChange("uploadedImage")
	public void upload(@BindingParam("media") Media myMedia){
		System.out.println("Entro");
		System.out.println(myMedia.getName());
		setUploadedImage(myMedia);
	}

	public Media getUploadedImage() {
		return uploadedImage;
	}

	public void setUploadedImage(Media uploadedImage) {
		this.uploadedImage = uploadedImage;
	}
	
	public String subirImagen(Media imagen){
		String rutaFinal = null;
		String ruta = WebApps.getCurrent().getServletContext().getInitParameter("upload.location");
		File imageFile = new File(ruta, imagen.getName());
		try {
			InputStream is = imagen.getStreamData();
			if(!imageFile.exists()){
				Files.copy(is, imageFile.toPath());
				rutaFinal = getServerName()+"/uploadedImages/"+imagen.getName();
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rutaFinal;
	}

	private String getServerName() {
		String port = ( Executions.getCurrent().getServerPort() == 80 ) ? "" : (":" + Executions.getCurrent().getServerPort());
		String url = Executions.getCurrent().getScheme() + "://" + Executions.getCurrent().getServerName() + 
					port + Executions.getCurrent().getContextPath();
		return url;
	}
}
