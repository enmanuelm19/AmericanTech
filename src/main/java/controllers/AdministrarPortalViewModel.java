package controllers;

import modelos.Club;
import modelos.Portal;

import org.jfree.ui.about.SystemPropertiesTableModel;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.media.Media;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import util.ManejadorArchivo;
import Dao.PortalDao;;

public class AdministrarPortalViewModel {

	private Portal portal;
	private boolean editable;
	private PortalDao portalDao;
	private Media uploadedImage;
	private Media uploadedImageEvento;
	private Media uploadedImageInstalacion;

	private boolean imagenNuevaSocio = false;
	private boolean imagenNuevaEvento = false;
	private boolean imagenNuevaInstalacion = false;

	@Init
	public void init(@ExecutionArgParam("portal") Portal red) throws Exception {
		if (red == null) {
			this.portal = new Portal();
			this.editable = false;
		} else {
			this.portal = red;
			this.editable = true;
		}
		portalDao = new PortalDao();
		int idPortal = 1;
		portal = portalDao.obtenerPortal(idPortal);
	}

	public Portal getPortal() {
		return portal;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public void setPortal(Portal portal) {
		this.portal = portal;
	}
	/*
	 * @Command public void cerrarModal(@BindingParam("win") Window win) {
	 * win.detach(); }
	 */

	@Command
	@NotifyChange("uploadedImage")
	public void upload(@BindingParam("media") Media myMedia) {
		imagenNuevaSocio = true;
		uploadedImage = myMedia;
	}

	@Command
	@NotifyChange("uploadedImageInstalacion")
	public void uploadInstalacion(@BindingParam("media") Media myMedia) {
		imagenNuevaInstalacion = true;
		uploadedImageInstalacion = myMedia;
	}

	@Command
	@NotifyChange("uploadedImageEvento")
	public void uploadEvento(@BindingParam("media") Media myMedia) {
		imagenNuevaEvento = true;
		uploadedImageEvento = myMedia;
	}

	public Media getUploadedImage() {
		return uploadedImage;
	}

	public Media getUploadedImageEvento() {
		return uploadedImageEvento;
	}

	public Media getUploadedImageInstalacion() {
		return uploadedImageInstalacion;
	}

	public void setUploadedImage(Media uploadedImage) {
		this.uploadedImage = uploadedImage;
	}

	public void setUploadedImageEvento(Media uploadedImage) {
		this.uploadedImageEvento = uploadedImage;
	}

	public void setUploadedImageInstalacion(Media uploadedImage) {
		this.uploadedImageInstalacion = uploadedImage;
	}

	@Command
	public void guardar() throws Exception {

		if (imagenNuevaSocio) {
			this.portal.setFotoSocio(ManejadorArchivo.subirImagen(uploadedImage));
		}

		if (imagenNuevaEvento) {
			this.portal.setFotoEvento(ManejadorArchivo.subirImagen(uploadedImageEvento));
		}
		if (imagenNuevaInstalacion) {
			this.portal.setFotoInstalaciones(ManejadorArchivo.subirImagen(uploadedImageInstalacion));
		}

		if (portal.getEvento().equalsIgnoreCase("") || portal.getInstalacion().equalsIgnoreCase("")
				|| portal.getSocio().equalsIgnoreCase("")) {
			Messagebox.show("Debe llenar todos los campos y adjuntar las imagenes", null, Messagebox.OK,
					Messagebox.EXCLAMATION);

		} else {
			portalDao.actualizarPortal(portal);
			Messagebox.show("El portal  ha sido actualizado exitosamente", "", Messagebox.OK, Messagebox.INFORMATION);

			BindUtils.postGlobalCommand(null, null, "refreshportal", null);

		}
	}

}
