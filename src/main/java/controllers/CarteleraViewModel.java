package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelos.Noticia;
import modelos.Preferencia;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.image.AImage;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.NoticiaDao;


public class CarteleraViewModel {

	private List<Noticia> noticiaAll;
	private NoticiaDao noticiaDao;
	private List<Noticia> noticiasPublicasAll;
	
	@Init
	public void init() throws Exception {
		
		noticiaAll = new ArrayList<Noticia>();
		noticiaDao = new NoticiaDao();
		noticiaAll = noticiaDao.obtenerNoticiasVigentes(new Date());
		noticiasPublicasAll = noticiaDao.obtenerNoticiasPublicas(new Date());
	}

	public ListModelList<Noticia> getAllNoticia() {
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
	public void refreshPreferencia() throws Exception {
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