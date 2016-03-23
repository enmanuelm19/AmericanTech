package controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import modelos.Noticia;
import modelos.NoticiaPreferencia;
import modelos.Preferencia;
import modelos.PreferenciaEvento;
import modelos.TipoNoticia;
import modelos.UsuarioGrupo;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.image.AImage;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.WebApps;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import util.ManejadorArchivo;
import Dao.NoticiaDao;
import Dao.PreferenciaDao;
import Dao.TipoNoticiaDao;

public class RegistrarNoticiaViewModel {
	private Media uploadedImage;
	private List<TipoNoticia> tipoNoticiaAll;
	private TipoNoticiaDao tipoNoticiaDao;
	private TipoNoticia tiponoticia;
	private Noticia noticia;
	private NoticiaDao noticiaDao;
	private boolean editable;
	private boolean publico;
	
	@Init
	public void init(@ExecutionArgParam("noticia") Noticia noticia) throws Exception {
	
		if (noticia == null) {
			this.noticia = new Noticia();
			this.editable = false;
		} else {
			this.noticia = noticia;
			this.editable = true;
		}
		//publico = false;
		noticiaDao= new NoticiaDao();
		tipoNoticiaAll = new ArrayList<TipoNoticia>();
		tipoNoticiaDao = new TipoNoticiaDao();
		tipoNoticiaAll = tipoNoticiaDao.obtenerTodos();
	}
	
	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	

	public boolean isPublico() {
		return publico;
	}

	public void setPublico(boolean publico) {
		this.publico = publico;
	}

	public List<TipoNoticia> getTipoNoticiaAll() {
		return tipoNoticiaAll;
	}


	public void setTipoNoticiaAll(List<TipoNoticia> tipoNoticiaAll) {
		this.tipoNoticiaAll = tipoNoticiaAll;
	}

	

	@NotifyChange("noticia")
	public Noticia getNoticia() {
		return noticia;
	}
	
	@NotifyChange("noticia")
	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
	
	
	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}


	@Command
	@NotifyChange("uploadedImage")
	public void upload(@BindingParam("media") Media myMedia){
		setUploadedImage(myMedia);
	}
	
	
	public Media getUploadedImage() {
		return uploadedImage;
	}

	public void setUploadedImage(Media uploadedImage) {
		this.uploadedImage = uploadedImage;
	}

	
	public void asignarFoto() throws IOException{
		String tmp;
		if(noticia.getFoto() == null){
			tmp = " ";
		}else{
			tmp = noticia.getFoto();
			}
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
		if(f.exists() && noticia.getFoto()!= null){
			URL url = new URL(noticia.getFoto());
			this.uploadedImage = new AImage(url);
		}else{
			URL url = new URL("http://localhost:8081/america/assets/portal/img/img1.jpg");
			this.uploadedImage = new AImage(url);}
	}
	
	
	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception {
		if (noticia.getTitulo()!=null && !noticia.getTitulo().equalsIgnoreCase("")){
			if(!editable){
				noticia.setCaducidad(new Date());
				noticia.setFechaCreacion(new Date());
				noticia.setFoto(ManejadorArchivo.subirImagen(getUploadedImage()));
				noticia.setPublico(this.publico);
				noticia.setActivo(true);
			
				noticiaDao.agregarNoticia(noticia);
				Messagebox.show(
						"La noticia " + noticia.getTitulo()
								+ " ha sido registrada exitosamente", "",
						Messagebox.OK, Messagebox.INFORMATION);
			}else
			{
				noticiaDao.actualizarNoticia(noticia);
					Messagebox.show("La noticia " + noticia.getTitulo() + " ha sido actualizada exitosamente", "",
										Messagebox.OK, Messagebox.INFORMATION);
				
			}
			win.detach();
		}
//		if (preferencia.getDescripcion() != null && !preferencia.getDescripcion().equalsIgnoreCase("")) {
//			if (preferenciaDao.obtenerDescripcion(preferencia.getDescripcion()) == null) {
//			if (!editable) {
//				preferenciaDao.agregarPreferencia(preferencia);
//				Messagebox.show(
//						"La preferencia " + preferencia.getDescripcion()
//								+ " ha sido registrada exitosamente", "",
//						Messagebox.OK, Messagebox.INFORMATION);
//			} else {
//				preferenciaDao.actualizarPreferencia(preferencia);
//				Messagebox.show(
//						"La preferencia " + preferencia.getDescripcion()
//								+ " ha sido actualizada exitosamente", "",
//						Messagebox.OK, Messagebox.INFORMATION);
//			}
//			win.detach();
//			BindUtils.postGlobalCommand(null, null, "refreshPreferencia", null);
//			}else {
//				Messagebox.show("Preferencia con la descripcion "
//						+ preferencia.getDescripcion() + " ya existe",
//						"Warning", Messagebox.OK, Messagebox.EXCLAMATION);
//			}
//			}
//
		}

}
