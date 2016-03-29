package controllers;

import java.util.Iterator;
import java.util.List;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.media.Media;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import util.ManejadorArchivo;
import Dao.AfiliadoDao;
import Dao.CargoDao;
import Dao.MiembroJuntaDao;
import Dao.PersonaDao;
import Dao.SocioDao;
import modelos.Accion;
import modelos.Afiliado;
import modelos.Cargo;
import modelos.JuntaDirectiva;
import modelos.MiembroJunta;
import modelos.Persona;
import modelos.Socio;

public class RegistrarMiembroViewModel {
	private MiembroJunta miembro;
	private MiembroJuntaDao miembroDao;
	private Persona persona;
	private PersonaDao personaDao;
	private Socio socio;
	private SocioDao socioDao;
	private String carnet, cedula;
	private CargoDao cargoDao;
	private List<Cargo> cargos;
	private boolean desactivar;
	private Afiliado afiliado;
	private AfiliadoDao afiliadoDao;
	private Cargo cargo;
	private JuntaDirectiva junta;
	private Media uploadedImage;
	private boolean imagenNueva=false;
	private boolean editar;
	@Init
	public void init(@ExecutionArgParam("Junta") JuntaDirectiva junta,@ExecutionArgParam("m") MiembroJunta m) throws Exception{
		this.miembroDao= new MiembroJuntaDao();
		this.personaDao= new PersonaDao();
		this.cargoDao= new CargoDao();
		this.afiliadoDao= new AfiliadoDao();
		this.socioDao= new SocioDao();
		
		if(m==null){
			editar=false;
			miembro= new MiembroJunta();
			socio= new Socio();
			this.carnet="";
			this.cedula="";
			//this.cargos=cargoDao.obtenerTodos();
			desactivar=false;
			this.junta=junta;
			this.persona= new Persona(0,"","","",false);
			this.persona.setFoto("http://localhost:8080/america/assets/portal/img/img1.jpg");
			miembro.setPersona(persona);
			this.cargo= new Cargo();
			miembro.setCargo(cargo);
			miembro.setJuntaDirectiva(junta);
		}
		else{
			editar=true;
			miembro= m;
			cedula=miembro.getPersona().getIdentificacion();
			desactivar=true;
			this.junta=junta;
		}
	}

	public MiembroJunta getMiembro() {
		return miembro;
	}

	public void setMiembro(MiembroJunta miembro) {
		this.miembro = miembro;
	}
	
	public ListModelList<Cargo> getCargosAll() throws Exception{
		return new ListModelList<Cargo>(cargoDao.obtenerTodos());
	}
	@Command
	@NotifyChange("uploadedImage")
	public void uploadImage(@BindingParam("media") Media myMedia) {
		imagenNueva = true;
		uploadedImage = myMedia;
	}
	
	public Media getUploadedImage() {
		return uploadedImage;
	}
	
	public void setUploadedImage(Media uploadedImage) {
		this.uploadedImage = uploadedImage;
	}
	@Command
	@NotifyChange({"miembro","desactivar"})
	public void buscarCedula() throws Exception{
		if(miembro.getPersona().getIdentificacion()==null || miembro.getPersona().getIdentificacion().equalsIgnoreCase(""))
			Messagebox.show("Debe llenar el campo Cedula", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
		else{
			String id=miembro.getPersona().getIdentificacion();
			Persona per= new Persona();
			per=personaDao.obtenerPersonaCedula(miembro.getPersona().getIdentificacion());
			if(per==null){
				Messagebox.show("Cedula no encontrada. Proceda a su registro", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
				miembro.setPersona(new Persona());
				miembro.getPersona().setIdentificacion(id);
				desactivar=false;
			}
			else{
				boolean v=false;
				for(Iterator<MiembroJunta> i=junta.getMiembroJuntas().iterator(); i.hasNext();){
					MiembroJunta t=i.next();
					if(t.getPersona().getIdentificacion().equalsIgnoreCase(per.getIdentificacion()))
						v=true;
				}
				if(v==true)
					Messagebox.show("Esta persona ya esta registrada en esta junta directiva", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
				else{
					miembro.setPersona(per);
					desactivar=true;
					imagenNueva=true;
				}
			}
		}
	}
	
	public boolean getDesactivar(){
		return desactivar;
	}
	
	@Command
	public void verificar(){
		if(miembro.getCargo().getIdCargo()==1 || miembro.getCargo().getIdCargo()==2){
			for(Iterator<MiembroJunta> i=junta.getMiembroJuntas().iterator(); i.hasNext();){
				MiembroJunta m=i.next();
				if(m.getCargo().getIdCargo()==1 && miembro.getCargo().getIdCargo()==1){
					Messagebox.show("Ya existe un miembro en la junta con el cargo "+miembro.getCargo().getDescripcion(), "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);		
					break;
	
				}else if(m.getCargo().getIdCargo()==2 && miembro.getCargo().getIdCargo()==2){
					Messagebox.show("Ya existe un miembro en la junta con el cargo "+miembro.getCargo().getDescripcion(), "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);		
					break;
				}
			}
		}
	}
	
	@Command
	public void guardar(@BindingParam("win") Window win) throws Exception{
		if(!editar){
			if(desactivar){
				if(miembro.getCargo()==null || miembro.getPersona()==null||miembro.getPersona().getIdentificacion().equalsIgnoreCase("")||miembro.getPersona().getNombre().equalsIgnoreCase("")
						||miembro.getPersona().getApellido().equalsIgnoreCase("")||miembro.getPersona().getCorreo().equalsIgnoreCase("")
						||miembro.getPersona().getDireccion().equalsIgnoreCase("")||miembro.getPersona().getSexo().equalsIgnoreCase("")||
						imagenNueva!=true){
					Messagebox.show("Verifique que los datos esten llenos", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
				}
				else{
					miembroDao.agregarMiembroJunta(miembro);
					Messagebox.show("El Sr(a) "+miembro.getPersona().getNombre()+" "+miembro.getPersona().getApellido()+" ahora es "+
					miembro.getCargo().getDescripcion()+" de la junta directiva", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
					win.detach();
					BindUtils.postGlobalCommand(null, null, "refreshJuntas",null);
				}
			}
			else{
				if(miembro.getPersona().getIdentificacion().equalsIgnoreCase("")||miembro.getPersona().getNombre().equalsIgnoreCase("")
						||miembro.getPersona().getApellido().equalsIgnoreCase("")||miembro.getPersona().getCorreo().equalsIgnoreCase("")
						||miembro.getPersona().getDireccion().equalsIgnoreCase("")||miembro.getPersona().getSexo().equalsIgnoreCase("")||
						imagenNueva!=true){
					Messagebox.show("Verifique que todo los datos esten llenos", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
				}
				else{
					if(imagenNueva==true){
						miembro.getPersona().setFoto(ManejadorArchivo.subirImagen(uploadedImage));
					}
					personaDao.agregarPersona(miembro.getPersona());
					miembroDao.agregarMiembroJunta(miembro);
					Messagebox.show("El Sr(a) "+miembro.getPersona().getNombre()+" "+miembro.getPersona().getApellido()+" ahora es "+
					miembro.getCargo().getDescripcion()+" de la junta directiva", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
					win.detach();
					BindUtils.postGlobalCommand(null, null, "refreshJuntas",null);
				}
			}
		}
		else{
			miembroDao.actualizarMiembroJunta(miembro);
			Messagebox.show("El Miembro "+miembro.getPersona().getNombre()+" "+miembro.getPersona().getApellido()+" ha sido actualizado", "American Tech", Messagebox.OK, Messagebox.EXCLAMATION);
			win.detach();
			BindUtils.postGlobalCommand(null, null, "refreshJuntas",null);
		}
	}
	
	@Command
	public void cancelar(@BindingParam("win") Window win){
		win.detach();
	}
}