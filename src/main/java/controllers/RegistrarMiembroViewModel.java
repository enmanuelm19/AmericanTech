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
	
	@Init
	public void init(@ExecutionArgParam("Junta") JuntaDirectiva junta) throws Exception{
		miembro= new MiembroJunta();
		this.miembroDao= new MiembroJuntaDao();
		this.personaDao= new PersonaDao();
		socio= new Socio();
		this.socioDao= new SocioDao();
		this.carnet="";
		this.cedula="";
		this.cargoDao= new CargoDao();
		//this.cargos=cargoDao.obtenerTodos();
		desactivar=true;
		this.afiliadoDao= new AfiliadoDao();
		this.junta=junta;
		this.persona= new Persona();
		miembro.setPersona(persona);
		this.cargo= new Cargo();
		miembro.setCargo(cargo);
		System.out.println("jldjajdjdksjde");
	}

	public MiembroJunta getMiembro() {
		System.out.println("jsjsjjs "+miembro.getPersona().getDireccion());
		return miembro;
	}

	public void setMiembro(MiembroJunta miembro) {
		this.miembro = miembro;
		System.out.println("entroooooooooo");
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
			Messagebox.show("Debe llenar el campo Cédula", "Error", Messagebox.OK, Messagebox.EXCLAMATION);
		else{
			Persona per= new Persona();
					per=personaDao.obtenerPersonaCedula(miembro.getPersona().getIdentificacion());
			if(per==null){
				Messagebox.show("Cédula no encontrada. Proceda a su registro", "Aviso", Messagebox.OK, Messagebox.EXCLAMATION);
				miembro.setPersona(new Persona());
				desactivar=false;
			}
			else{
				miembro.setPersona(per);
				desactivar=true;
				System.out.println(miembro.getPersona().getCorreo());
			}
		}
	}
	
	public boolean getDesactivar(){
		return desactivar;
	}
	
	@Command
	public void verificar(){
		if(miembro.getCargo().getIdCargo()==1 || miembro.getCargo().getIdCargo()==5){
			for(Iterator<MiembroJunta> i=junta.getMiembroJuntas().iterator(); i.hasNext();){
				MiembroJunta m=i.next();
				if(m.getCargo().getIdCargo()==1||m.getCargo().getIdCargo()==5){
					Messagebox.show("Ya existe un miembro en la junta con el cargo "+miembro.getCargo().getDescripcion(), "Aviso", Messagebox.OK, Messagebox.EXCLAMATION);		
					break;
				}
			}
		}
	}
	
	@Command
	public void guardar(@BindingParam("m") MiembroJunta m) throws Exception{
		if(desactivar){
			System.out.println(m.getIdJuntaMiembro());
			if(miembro.getPersona().getIdentificacion().equalsIgnoreCase("")||miembro.getPersona().getNombre().equalsIgnoreCase("")
					||miembro.getPersona().getApellido().equalsIgnoreCase("")||miembro.getPersona().getCorreo().equalsIgnoreCase("")
					||miembro.getPersona().getDireccion().equalsIgnoreCase("")||miembro.getPersona().getSexo().equalsIgnoreCase("")){
				Messagebox.show("Debe llenar todos los campos", "Error", Messagebox.OK, Messagebox.EXCLAMATION);
				
			}
			else{
				miembroDao.agregarMiembroJunta(miembro);
				Messagebox.show("El miembro ", "Error", Messagebox.OK, Messagebox.EXCLAMATION);
				
			}
		}
	}
}