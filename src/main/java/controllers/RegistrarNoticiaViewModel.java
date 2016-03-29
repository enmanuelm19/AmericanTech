package controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import modelos.Foto;
import modelos.Noticia;
import modelos.NoticiaPreferencia;
import modelos.Preferencia;
import modelos.PreferenciaEvento;
import modelos.TipoNoticia;
import modelos.UsuarioGrupo;

import org.json.simple.parser.ParseException;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.image.AImage;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.WebApps;
import org.zkoss.zk.ui.event.Event;
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
	private String foto;
	private boolean fotodefault;
	
	
	@Init
	public void init(@ExecutionArgParam("noticia") Noticia noticia) throws Exception {
	
		//publico = false;
		noticiaDao= new NoticiaDao();
		tipoNoticiaAll = new ArrayList<TipoNoticia>();
		tipoNoticiaDao = new TipoNoticiaDao();
		tipoNoticiaAll = tipoNoticiaDao.obtenerTodos();
		
		if (noticia == null) {
			this.noticia = new Noticia();
			this.editable = false;
			this.fotodefault = true;
		
			
		} else {
			this.noticia = noticia;
			this.editable = true;
			this.fotodefault = false;
			System.out.println("entro por el sino");
		}
	}
	
	
	public boolean isFotodefault() {
		return fotodefault;
	}

	public void setFotodefault(boolean fotodefault) {
		this.fotodefault = fotodefault;
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


	@GlobalCommand
	@NotifyChange({"uploadedImage", "fotodefault"})
	public void upload(@BindingParam("media") final Media myMedia){
		if(!editable){
			fotodefault= false;
			if(myMedia instanceof org.zkoss.image.Image){
				if(myMedia.getByteData().length > 2000*1024){
					Messagebox.show("Escoja una imagen de menor tamaño", "American Tech", Messagebox.OK, Messagebox.INFORMATION);
				}else{
					
					uploadedImage = myMedia;
					setUploadedImage(myMedia);
				}
			}else{
				Messagebox.show("El archivo que intenta subir no es una imagen", "American Tech", Messagebox.OK, Messagebox.INFORMATION);
			}
			
		}else{
			
			
		};
	}
	

	
	public Media getUploadedImage() {
		return uploadedImage;
	}

	public void setUploadedImage(Media uploadedImage) {
		this.uploadedImage = uploadedImage;
	}


	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception 
	{
		
		if(noticia.getCaducidad()!=null && 
		   !noticia.getDescripcion().equalsIgnoreCase("") && noticia.getDescripcion()!=null &&
		   noticia.getTipoNoticia()!=null)
		{
			if (noticia.getTitulo()!=null && !noticia.getTitulo().equalsIgnoreCase(""))
			{
				if(!editable){
					//fotodefault = false;
					noticia.setFechaCreacion(new Date());
					if(!fotodefault)
						noticia.setFoto(ManejadorArchivo.subirImagen(getUploadedImage()));
					else
						noticia.setFoto("http://i.imgur.com/wGVOjvQ.png");
					noticia.setPublico(this.publico);
					noticia.setActivo(true);
				
					noticiaDao.agregarNoticia(noticia);
					Messagebox.show("La noticia " + noticia.getTitulo() + " ha sido registrada exitosamente", "American Tech",
							Messagebox.OK, Messagebox.INFORMATION);
				}else
				{
					noticiaDao.actualizarNoticia(noticia);
						Messagebox.show("La noticia " + noticia.getTitulo() + " ha sido actualizada exitosamente", "American Tech",
											Messagebox.OK, Messagebox.INFORMATION);
				}
				win.detach();
			}
		}else
		{
			
			Messagebox.show("Verifique que todos los campos estén llenos" , "American Tech",	Messagebox.OK, Messagebox.INFORMATION);
		}
	}

}
