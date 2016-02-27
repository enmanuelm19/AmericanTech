package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.UsuarioDao;
import modelos.Usuario;

public class UsuarioViewModel{

	private List<Usuario> usuariosAll;
	private UsuarioDao usuarioDao;
	private String descFiltro;
	private String idFiltro;
	
	@Init
	public void init() throws Exception{
		usuariosAll = new ArrayList<Usuario>();
		usuarioDao = new UsuarioDao();
		usuariosAll = usuarioDao.obtenerTodos();
	}
	
	public String getCantRegistros(){
		return usuariosAll.size() + " items en la lista";
	}
	
	public ListModelList<Usuario> getAllUsuarios(){
		return new ListModelList<Usuario>(usuariosAll);
	}
	
	public String getDescFiltro() {
		if(descFiltro==null)
			return "";
		return descFiltro;
	}

	public void setDescFiltro(String descFiltro) {
		this.descFiltro = descFiltro==null?"":descFiltro.trim();
	}

	public String getIdFiltro() {
		if(idFiltro==null)
			return "";
		return idFiltro;
	}

	public void setIdFiltro(String idFiltro) {
		this.idFiltro = idFiltro==null?"":idFiltro.trim();
	}
	
	@Command
	@NotifyChange({ "allUsuarios", "cantRegistros" })
	public void filtro() throws Exception {
		List<Usuario> tip = new ArrayList<Usuario>();
		String desc = getDescFiltro().toLowerCase();
		String id = getIdFiltro().toLowerCase();

		for (Iterator<Usuario> i = usuarioDao.obtenerTodos().iterator(); i.hasNext();) {
			Usuario tmp = i.next();
			if (tmp.getUsername().toLowerCase().contains(desc)
					&& String.valueOf(tmp.getPersona().getNombre()).toLowerCase().contains(id)) {
				tip.add(tmp);
			}
		}
		usuariosAll = tip;
	}
	
	@Command
	public void showModal(@BindingParam("Usuario") Usuario usuario) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("Usuario", usuario);
		Window window = (Window) Executions.createComponents("administracion/seguridad/agregarUsuario.zul",
				null, args);
		window.doModal();
	}
	
	@Command
	@NotifyChange({ "allUsuarios", "cantRegistros" })
	public void eliminar(@BindingParam("Usuario") final Usuario usuario) {

		Messagebox.show("Estas seguro de eliminar " + usuario.getUsername(), "Confirmar",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {
								usuarioDao.eliminarUsuario(usuario);
								usuariosAll = usuarioDao.obtenerTodos();
								Messagebox.show(usuario.getUsername() + " ha sido eliminado", "", Messagebox.OK,
										Messagebox.INFORMATION);
								BindUtils.postGlobalCommand(null, null, "refreshUsuarios", null);
							} catch (Exception e) {
								Messagebox.show(e.getMessage(), usuario.getUsername() + " No se pudo eliminar",
										Messagebox.OK, Messagebox.ERROR);
							}
						}
					}
				});
	}
	
	@GlobalCommand
	@NotifyChange({ "allUsuarios", "cantRegistros" })
	public void refreshUsuarios() throws Exception {
		usuariosAll = usuarioDao.obtenerTodos();
	}
}
