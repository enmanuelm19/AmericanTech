package controllers;

import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;

import Dao.AfiliadoDao;
import Dao.CargoDao;
import Dao.MiembroJuntaDao;
import Dao.PersonaDao;
import Dao.SocioDao;
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
	@Init
	public void init(@ExecutionArgParam("Junta") JuntaDirectiva junta) throws Exception{
		this.miembro= new MiembroJunta();
		this.miembroDao= new MiembroJuntaDao();
		this.persona= new Persona();
		this.personaDao= new PersonaDao();
		socio= new Socio();
		this.socioDao= new SocioDao();
		this.carnet="";
		this.cedula="";
		this.cargoDao= new CargoDao();
		this.cargos=cargoDao.obtenerTodos();
		desactivar=true;
		this.afiliadoDao= new AfiliadoDao();
	}
	public MiembroJunta getMiembro() {
		return miembro;
	}
	public void setMiembro(MiembroJunta miembro) {
		this.miembro = miembro;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public String getCarnet() {
		return carnet;
	}
	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public ListModelList<Cargo> getCargosAll(){
		return new ListModelList<Cargo>(cargos);
	}
	public boolean isDesactivar() {
		return desactivar;
	}
	
	@Command
	@NotifyChange({"carnet","persona","cedula"})
	public void buscarCarnet() throws Exception{
		if(carnet==""||carnet==null){
			Messagebox.show("Campo Carnet Vacio", "Error", Messagebox.OK, Messagebox.EXCLAMATION);
		}
		else{
			this.socioDao= new SocioDao();
			this.socio=socioDao.obtenerSocioCarnet(carnet);
			this.afiliado=this.afiliadoDao.obtenerPorNroCarnet(carnet);
			if(this.socio==null && this.afiliado==null){
				Messagebox.show("Carnet no encontrado", "Error", Messagebox.OK, Messagebox.EXCLAMATION);
				this.carnet="";
			}
			else{
				try{
				if(!this.socio.equals(null)){
					this.persona=socio.getPersona();
				}
				}
				catch(NullPointerException e){
					this.persona=afiliado.getPersona();
				}

				this.cedula=persona.getIdentificacion();
			}
		}
	}
	
	@Command
	@NotifyChange({"cedula","persona","carnet"})
	public void buscarCedula() throws Exception{
		if(cedula==""||cedula==null){
			Messagebox.show("Campo Cédula Vacio", "Error", Messagebox.OK, Messagebox.EXCLAMATION);
		}
		else{
			this.personaDao= new PersonaDao();
			this.persona=personaDao.obtenerPersonaCedula(cedula);
			this.socio=this.socioDao.obtenerSocioPersona(persona);
			this.afiliado=this.afiliadoDao.obtenerPorPersona(persona);
			if(this.socio==null && this.afiliado==null){
				Messagebox.show("Cédula no encontrada", "Error", Messagebox.OK, Messagebox.EXCLAMATION);
				this.cedula="";
				this.persona=new Persona();
			}
			else{
				try{
				if(!this.socio.equals(null)){
					carnet=socio.getNroCarnet();
				}
				}
				catch(NullPointerException e){
					carnet=afiliado.getNroCarnet();
				}
			}
		}
	}	
}
