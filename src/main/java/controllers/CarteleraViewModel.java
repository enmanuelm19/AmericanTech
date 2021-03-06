package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelos.Afiliado;
import modelos.Noticia;
import modelos.Preferencia;
import modelos.PreferenciaPersona;
import modelos.Socio;
import modelos.Usuario;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.image.AImage;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.AfiliadoDao;
import Dao.NoticiaDao;
import Dao.NoticiaPreferenciaDao;
import Dao.PreferenciaPersonaDao;
import Dao.SocioDao;


public class CarteleraViewModel {

	private List<Noticia> noticiaAll;
	private List<PreferenciaPersona> ListPrefPersona;
	private PreferenciaPersonaDao preferenciaPersDao;
	private NoticiaPreferenciaDao noticiaPreferenciaDao;
	private NoticiaDao noticiaDao;
	private List<Noticia> noticiasPublicasAll;
	private Usuario usuario;
	
	@Init
	public void init() throws Exception {
		ListPrefPersona = new ArrayList<PreferenciaPersona>();
		noticiaAll      = new ArrayList<Noticia>();
	
		noticiaDao  = new NoticiaDao();
		noticiaPreferenciaDao = new NoticiaPreferenciaDao();
		preferenciaPersDao = new PreferenciaPersonaDao();
		
		noticiaAll  = noticiaDao.obtenerNoticiasVigentes(new Date());
		noticiasPublicasAll = noticiaDao.obtenerNoticiasPublicas(new Date());
		
		usuario = (Usuario) Sessions.getCurrent().getAttribute("Usuario");
	}

	public void setNoticiaAll(List<Noticia> noticiaAll) {
		this.noticiaAll = noticiaAll;
	}

	public List<Noticia> getNoticiaAll() {
		return new ListModelList<Noticia>(noticiaAll);
	}
	
	public String getCantidadRegistros() {
		return noticiaAll.size() + " items en la lista";
	}

	public List<Noticia> getNoticiasPublicasAll() {
		return noticiasPublicasAll;
	}

	public void setNoticiasPublicasAll(List<Noticia> noticiasPublicasAll) {
		this.noticiasPublicasAll = noticiasPublicasAll;
	}

	@GlobalCommand
	@NotifyChange({ "allNoticia", "cantRegistros" })
	public void refreshNoticia() throws Exception {
		noticiaAll = noticiaDao.obtenerTodos();
	}

	@Command
	public void showModal(@BindingParam("noticia") Noticia noticia) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("noticia", noticia);
		Window window = (Window) Executions.createComponents("administracion/agregarNoticia.zul",
				null, args);
		window.doModal();
	}
	
	@GlobalCommand
	@NotifyChange("noticiaAll")
	public void refreshPostulaciones() throws Exception {
		 noticiaAll.clear();
		 
		 for(int i=0;i< noticiaDao.obtenerNoticiasVigentes(new Date()).size();i++)
		 {
			 if (noticiaDao.obtenerNoticiasVigentes(new Date()).get(i).getPostulacion() != null)
				 noticiaAll.add(noticiaDao.obtenerNoticiasVigentes(new Date()).get(i));
		 }
		 this.setNoticiaAll(noticiaAll);
	}
	
	@GlobalCommand
	@NotifyChange("noticiaAll")
	public void refreshCarteleraGeneral() throws Exception {
	 noticiaAll.clear();
	 noticiaAll = noticiaDao.obtenerNoticiasVigentes(new Date());
	}
	
	@GlobalCommand
	@NotifyChange("noticiaAll")
	public void refreshEventos() throws Exception {
		noticiaAll.clear();
		ListPrefPersona = preferenciaPersDao.obtenerPreferenciasPersona(this.usuario.getPersona());
		
		 for(int j=0;j< noticiaPreferenciaDao.obtenerTodos().size();j++){
			 for(int i=0; i< ListPrefPersona.size(); i++){
				 if(noticiaPreferenciaDao.obtenerTodos().get(j).getPreferencia().getIdPreferencia()==ListPrefPersona.get(i).getPreferencia().getIdPreferencia())
				 {
					 noticiaAll.add(noticiaPreferenciaDao.obtenerTodos().get(j).getNoticia());
				 }
			 }
		 }
	}
	
	@Command
	@NotifyChange({ "allNoticia", "cantRegistros" })
	public void eliminar(@BindingParam("noticia") final Noticia noticia) {

		Messagebox.show("Estas seguro de eliminar " + noticia.getDescripcion(), "Confirmar",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {
								noticiaDao.eliminarNoticia(noticia);
								noticiaAll = noticiaDao.obtenerTodos();
								Messagebox.show(noticia.getDescripcion() + " ha sido eliminado", "", Messagebox.OK,
										Messagebox.INFORMATION);
								BindUtils.postGlobalCommand(null, null, "refreshPreferencia", null);
							} catch (Exception e) {
								Messagebox.show(e.getMessage(), noticia.getDescripcion() + " No se pudo eliminar",
										Messagebox.OK, Messagebox.ERROR);
							}
						}
					}
				});
	}
}