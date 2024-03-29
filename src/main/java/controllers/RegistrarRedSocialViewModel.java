package controllers;

import modelos.RedSocial;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.media.Media;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import util.ManejadorArchivo;
import Dao.RedSocialDao;


public class RegistrarRedSocialViewModel {

	private RedSocial RedSocial;
	private boolean editable;
	private RedSocialDao redDao;
	private Media uploadedImage;
	private boolean imagenNueva = false;
	private boolean fotodefault;

	@Init
	public void init(@ExecutionArgParam("RedSocial") RedSocial red) {
		if (red == null) {
			this.RedSocial = new RedSocial();
			this.editable = false;
			this.fotodefault = true;
			System.out.println("entro por el if");
		} else {
			this.RedSocial = red;
			this.editable = true;
			this.fotodefault = false;
		}
		redDao = new RedSocialDao();
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public RedSocial getRedSocial() {
		return RedSocial;
	}

	public void setRedSocial(RedSocial RedSocial) {
		this.RedSocial = RedSocial;
	}

	
	public boolean isFotodefault() {
		return fotodefault;
	}

	public void setFotodefault(boolean fotodefault) {
		this.fotodefault = fotodefault;
	}

	@Command
	public void cerrarModal(@BindingParam("win") Window win) {
		win.detach();
	}

	
	@Command
	@NotifyChange({"uploadedImage", "fotodefault"})
	public void upload(@BindingParam("media") Media myMedia){
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
	public void guardar(@BindingParam("win") Window win) throws Exception {

		if (RedSocial.getDescripcion() != null
				&& !RedSocial.getDescripcion().equalsIgnoreCase("")) {
//			if (redDao
//					.obtenerDescripcion(RedSocial.getDescripcion()) == null) {
				if(!fotodefault){
					this.RedSocial.setImagen(ManejadorArchivo.subirImagen(uploadedImage));
				}else
					this.RedSocial.setImagen("http://i.imgur.com/vEoJMNR.png");
				if (!editable) {
					redDao.agregarRedSocial(RedSocial);
					Messagebox.show(
							"La red social "
									+ RedSocial.getDescripcion()
									+ " ha sido registrado exitosamente", "American Tech",
							Messagebox.OK, Messagebox.INFORMATION);
				} else {
					redDao.actualizarRedSocial(RedSocial);
					Messagebox.show(
							"La red social "
									+ RedSocial.getDescripcion()
									+ " ha sido actualizado exitosamente", "American Tech",
							Messagebox.OK, Messagebox.INFORMATION);
				}
				win.detach();
				BindUtils.postGlobalCommand(null, null,
						"refreshRedSocial", null);
//			} else {
//				Messagebox.show("red social con la descripcion "
//						+ RedSocial.getDescripcion() + " ya existe",
//						"Warning", Messagebox.OK, Messagebox.EXCLAMATION);
//			}
		}else{
			Messagebox.show("Verifique que los campos esten llenos ", "American Tech",
					Messagebox.OK, Messagebox.INFORMATION);
		}

	}
	
	
	
}


