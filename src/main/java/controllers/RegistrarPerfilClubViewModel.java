package controllers;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.image.AImage;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WebApps;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import util.ManejadorArchivo;
import bsh.This;
import modelos.Club;
import modelos.RedClub;
import modelos.RedSocial;
import modelos.TipoAfiliado;
import modelos.TipoSugerencia;
import Dao.ClubDao;
import Dao.RedClubDao;
import Dao.RedSocialDao;

public class RegistrarPerfilClubViewModel {

	private ClubDao ClubDao;
	private Club club;
	private Set<RedClub> allRedClub;
	private RedClub redClub;
	private RedSocial redSocial;
	private RedSocialDao redSolcialDao;
	private RedClubDao redClubDao;
	private Media uploadedImage;
	private boolean imagenNueva = false;

	@Init
	public void init() throws Exception {
		this.ClubDao = new ClubDao();
		this.club = new Club();

		this.redSolcialDao = new RedSocialDao();
		this.redClub = new RedClub();
		this.redSocial = new RedSocial();
		this.redClubDao = new RedClubDao();
		
		this.club = ClubDao.obtenerTodos().get(0);
//		this.allRedClub = (Set<RedClub>) redClubDao.obtenerRedClub(club.getIdClub());
		this.allRedClub = club.getRedClubs();
		System.out.println("PASOOOOOO");
		System.out.println(club.getCorreo());
		System.out.println(allRedClub);
	}
	

	public ListModelList<RedClub> getAllRedClubs() {
		return new ListModelList<RedClub>(allRedClub);
	}
	
	
	public ListModelList<RedSocial> getAllRedSocials() throws Exception {
		return new ListModelList<RedSocial>(redSolcialDao.obtenerTodos());
	}
	
	
	
	@Command
	@NotifyChange({"allRedClubs","redClub"})
	public void agregarEnlaceRedSocial(){
		if(this.redClub.getRedSocial()!=null){
			for (RedClub redClub: this.allRedClub) {
				if(redClub.getRedSocial().getIdRedSocial()==this.redClub.getRedSocial().getIdRedSocial())
					return;
			}
			this.redClub.setClub(club);
			this.allRedClub.add(this.redClub);
			this.redClub = new RedClub();

		}
	}
	
	
	@Command
	@NotifyChange({"allRedClubs","redClub"})
	public void eliminarEnlaceRedSocial(@BindingParam("redClub") RedClub in){
		
		this.allRedClub.remove(in);
	}
	
	
	public RedClub getRedClub() {
		return redClub;
	}


	public void setRedClub(RedClub redClub) {
		this.redClub = redClub;
	}

	
	@Command
	public void cancelar() {
		Executions.sendRedirect("/vistas/index.zul");
	}
	
	@Command
	public void guardar() throws Exception {
		this.club.setActivo(true);
		if(imagenNueva){
			this.club.setLogo(ManejadorArchivo.subirImagen(uploadedImage));
		}
		if (club.getRif() == null || club.getRif().equalsIgnoreCase("")) {
			Messagebox.show("El RIF no puede estar blanco", "Warning",
					Messagebox.OK, Messagebox.EXCLAMATION);
			} else if (club.getNombre() == null
					|| club.getNombre().equalsIgnoreCase("")) {
				Messagebox.show("El NOMBRE no puede estar en blanco", "Warning",
						Messagebox.OK, Messagebox.EXCLAMATION);
					} else if (club.getDireccion() == null
							|| club.getDireccion().equalsIgnoreCase("")) {
						Messagebox.show("La DIRECCION no puede estar en blanco ",
								"Warning", Messagebox.OK, Messagebox.EXCLAMATION);
						} else if (club.getTelefono() == null
								|| club.getTelefono().equalsIgnoreCase("")) {
							Messagebox.show("El TELEFONO no puede estar en blanco", "Warning",
									Messagebox.OK, Messagebox.EXCLAMATION);
							} else if (club.getMision() == null
									|| club.getMision().equalsIgnoreCase("")) {
								Messagebox.show("La MISIÓN no puede estar en blanco", "Warning",
										Messagebox.OK, Messagebox.EXCLAMATION);
								} else if (club.getVision() == null
										|| club.getVision().equalsIgnoreCase("")) {
									Messagebox.show("La MISIÓN no puede estar en blanco", "Warning",
												Messagebox.OK, Messagebox.EXCLAMATION);
									} 
//									else if (club.getLogo() == null) {
//										Messagebox.show("Debe cargar un Logo", "Warning",
//													Messagebox.OK, Messagebox.EXCLAMATION);
//										}
									else {
										this.club.setRedClubs(allRedClub);
										this.ClubDao.actualizarClub(club);
										
										Messagebox.show("El perfil del club  " + club.getNombre()
												+ " ha sido Modificado con exito", "", Messagebox.OK,
												Messagebox.INFORMATION);
									}
		}
	
	
	@Command
	@NotifyChange("uploadedImage")
	public void upload(@BindingParam("media") Media myMedia){
		imagenNueva=true;
		uploadedImage = myMedia;
	}

	public Media getUploadedImage() {
		return uploadedImage;
	}


	public void setUploadedImage(Media uploadedImage) {
		this.uploadedImage = uploadedImage;
	}

	


	public RegistrarPerfilClubViewModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegistrarPerfilClubViewModel(ClubDao ClubDao, Club club) {
		super();
		this.ClubDao = ClubDao;
		this.club = club;
	}

	public ClubDao getClubDao() {
		return ClubDao;
	}

	public void setPerfilClub(ClubDao ClubDao) {
		this.ClubDao = ClubDao;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}


	public RedSocial getRedSocial() {
		return redSocial;
	}


	public void setRedSocial(RedSocial redSocial) {
		this.redSocial = redSocial;
	}
	
	

}
