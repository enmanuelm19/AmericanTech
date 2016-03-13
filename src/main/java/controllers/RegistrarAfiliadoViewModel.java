package controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import Dao.AfiliadoDao;
import Dao.PersonaDao;
import Dao.PreferenciaDao;
import Dao.PreferenciaPersonaDao;
import Dao.TipoAfiliadoDao;
import Dao.TipoPreferenciaDao;
import modelos.Afiliado;
import modelos.Persona;
import modelos.Preferencia;
import modelos.PreferenciaPersona;
import modelos.Socio;
import modelos.TipoAfiliado;
import modelos.TipoPreferencia;

public class RegistrarAfiliadoViewModel {
	private Socio socio;
	private Persona persona;
	private PersonaDao personaDao;
	private List<TipoAfiliado> tipoAfiliados;
	private TipoAfiliadoDao tipoAfiliadoDao;
	private Afiliado afiliado;
	private AfiliadoDao afiliadoDao;
	private TipoPreferencia tipoPreferencia;
	private List<TipoPreferencia> tiposPreferencias;
	private List<Preferencia> preferencias;
	private List<Preferencia> preferenciasAll;
	private TipoPreferenciaDao tipoPreferenciaDao;
	private PreferenciaDao preferenciaDao;
	private Preferencia preferencia;
	private PreferenciaPersona preferenciaPersona;
	private PreferenciaPersonaDao preferenciaPersonaDao;
	private Date fechaNac;
	
	@Init
	public void init(@ExecutionArgParam("socioss") Socio socioss) throws Exception{
		this.socio= socioss;
		persona= new Persona();
		tipoAfiliadoDao= new TipoAfiliadoDao();
		tipoAfiliados= tipoAfiliadoDao.obtenerTodos();
		afiliado= new Afiliado();
		preferenciaDao= new PreferenciaDao();
		tipoPreferenciaDao= new TipoPreferenciaDao();
		tipoPreferencia= new TipoPreferencia();
		preferencia= new Preferencia();
		tiposPreferencias= tipoPreferenciaDao.obtenerTodos();
		preferencias= new ArrayList<Preferencia>();
		preferenciasAll= new ArrayList<Preferencia>();
		System.out.println("dasdadasdiijijjl: "+socioss.getIdSocio());
		
	}
	
	public Persona getPersona() {
		return persona;
	}
	
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	public ListModelList<TipoAfiliado> getTiposAfiliados(){
		return new ListModelList<TipoAfiliado>(tipoAfiliados);
	}
	
	public ListModelList<TipoPreferencia> getTiposPreferencias(){
		return new ListModelList<TipoPreferencia>(tiposPreferencias);
	}
	
	public ListModelList<Preferencia> getPreferencias(){
		return new ListModelList<Preferencia>(preferencias);
	}
	public ListModelList<Preferencia> getPreferenciasAll(){
		return new ListModelList<Preferencia>(preferenciasAll);
	}
	public Afiliado getAfiliado() {
		return afiliado;
	}
	
	public void setAfiliado(Afiliado afiliado) {
		this.afiliado = afiliado;
	}
	

	public int getCalcularEdad() {
		Calendar birth = new GregorianCalendar();
		Calendar today = new GregorianCalendar();
		int age=0;
		int factor=0;
		
		Date birthDate;
		if(this.getFechaNac()==null)
			return 0;
		else{
			birthDate=this.getFechaNac();
			Date currentDate=new Date(); //current date
			birth.setTime(birthDate);
			today.setTime(currentDate);
			if (today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)) {
				if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
					if (today.get(Calendar.DATE) > birth.get(Calendar.DATE)) {
						factor = -1; //Aun no celebra su cumpleaños
					}
				} else {
			factor = -1; //Aun no celebra su cumpleaños
			}
			
			} 
			age=(today.get(Calendar.YEAR)-birth.get(Calendar.YEAR))+factor;
			return age;
		}
	}

	public Preferencia getPreferencia() {
		return preferencia;
	}
	
	@NotifyChange({"preferencias","preferenciasAll","cantidadInteres","preferencia"})
	public void setPreferencia(Preferencia preferencia) {
		this.preferencia = preferencia;
		//boolean encontro=false;
		/*if(preferenciasAll.size()==0){
			preferenciasAll.add(preferencia);
		}
		else{
			for(int i=0; i<preferenciasAll.size(); i++){
				if(preferenciasAll.get(i).getDescripcion()==preferencia.getDescripcion()){
					System.out.println("dio: "+true);
					}
				else{
					if(encontro==false){
						System.out.println("dio: "+false);
						preferenciasAll.add(preferencia);
						encontro=true;
					}
				}
			}
		}
		*/
			preferenciasAll.add(preferencia);
			preferencia= new Preferencia();
	}

	public TipoPreferencia getTipoPreferencia() {
		return tipoPreferencia;
	}
	@NotifyChange({"preferencias"})
	public void setTipoPreferencia(TipoPreferencia tipoPreferencia) throws Exception {
		this.tipoPreferencia = tipoPreferencia;
		preferencias= preferenciaDao.obtenerPreferenciasTipo(tipoPreferencia);
	/*	for(int i=0; i<preferenciasAll.size(); i++){
			for(int j=0; j<preferencias.size(); j++){
				if(preferenciasAll.get(i).getDescripcion()==preferencias.get(j).getDescripcion()){
					preferencias.remove(preferenciasAll.get(i));
					System.out.println("kkskskk");
				}
			}
		}*/
	}
	
	@Command
	@NotifyChange({"preferenciasAll","cantidadInteres"})
	public void eliminarInteres(@BindingParam("Interes") Preferencia pref){
		preferenciasAll.remove(pref);
	}
	
	public String getCantidadInteres(){
		return preferenciasAll.size()+" items en la lista";
	}
	
	@Command
	public void registrarAfiliado(@BindingParam("win") Window win) throws Exception{
		if(persona.getIdentificacion().equalsIgnoreCase("") || persona.getNombre().equalsIgnoreCase("")||
				persona.getApellido().equalsIgnoreCase("")|| persona.getTelefono().equalsIgnoreCase("")||
				persona.getCorreo().equalsIgnoreCase("")|| persona.getSexo().equalsIgnoreCase("")||
				persona.getDireccion().equalsIgnoreCase("")|| afiliado.getTipoAfiliado().equals(null)){
					Messagebox.show("Debe llenar todos los campos", "Warning", Messagebox.OK, Messagebox.EXCLAMATION);
				}
				else{
					personaDao= new PersonaDao();
					persona.setFechaNac(fechaNac);
					personaDao.agregarPersona(persona);
					afiliado.setNroCarnet(socio.getNroCarnet()+"-wq");
					afiliado.setPersona(persona);
					afiliado.setSocio(socio);
					afiliado.setActivo(true);
					afiliadoDao= new AfiliadoDao();
					afiliadoDao.agregarAfiliado(afiliado);
					preferenciaPersonaDao= new PreferenciaPersonaDao();
					if(preferenciasAll.size()>0){
						for(int i=0; i<preferenciasAll.size(); i++){
							preferenciaPersona=new PreferenciaPersona();
							preferenciaPersona.setPersona(persona);
							preferenciaPersona.setPreferencia(preferenciasAll.get(i));
							preferenciaPersona.setActivo(true);
							preferenciaPersonaDao.agregarPreferenciaPersona(preferenciaPersona);
						}
						
					}
					win.detach();
					Messagebox.show(
							"El Sr(a) "	+ afiliado.getPersona().getNombre() +" "+afiliado.getPersona().getApellido()
							+ " es ahora un afiliado del Sr. "+socio.getPersona().getNombre()+" "+socio.getPersona().getApellido(), "",
							Messagebox.OK, Messagebox.INFORMATION);
				}
	}
	
	@Command
	public void cancelar(@BindingParam("win") Window win){
		win.detach();
	}

	public Date getFechaNac() {
		return fechaNac;
	}
	@NotifyChange({"calcularEdad"})
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	
}
