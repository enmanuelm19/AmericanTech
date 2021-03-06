package reportes.estructurados;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.DependsOn;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;











import Dao.InstalacionDao;
import Dao.SocioDao;
import modelos.Evento;
import modelos.Instalacion;
import modelos.Socio;
import modelos.TipoInstalacion;
import modelos.TipoPreferencia;



public class ReporteEventualidadesViewModel {
	

	private Socio socio;
	private SocioDao socioDao;
	private String tipo;
	private Time horaInicio;
	private Time horaFin;
	private Date fechaInicio;
	private Date fechaFin;
	private InstalacionDao instalacionDao;
	private TipoInstalacion tipoInstalacionSelected;
	private String carnet;
	private boolean disablecarnet;
	private boolean disableinstalaciones;


	@Init
	public void init() {
		instalacionDao = new InstalacionDao();
		this.socio= new Socio();
		this.disableinstalaciones = true;
		this.disablecarnet=true;

	}

	public ListModelList<Instalacion> getInstalaciones() throws Exception {

		return new ListModelList<Instalacion>(instalacionDao.obtenerTodos());

	}
	
	@NotifyChange("tipoInstalacionSelected")
	public TipoInstalacion getTipotipoInstalacionSelected() {
		return tipoInstalacionSelected;
	}

	@NotifyChange("InstalacionPorTipo")
	public void setTipoInstalacionSelected(TipoInstalacion tipoInstalacionSelected) {
		this.tipoInstalacionSelected = tipoInstalacionSelected;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Time getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public String getTipo() {
		return tipo;
	}

	@NotifyChange({"disablecarnet","disableinstalaciones"})
	public void setTipo(String tipo) {
		this.tipo = tipo;
		if(this.tipo.equalsIgnoreCase("Instalaciones")){
			this.disableinstalaciones = false;
			this.disablecarnet=true;
		}
		else if(this.tipo.equalsIgnoreCase("Socios") || this.tipo.equalsIgnoreCase("Afiliados"))
		{
			this.disablecarnet = false;
			this.disableinstalaciones = true;
		}
		else
		{
			this.disablecarnet = true;
			this.disableinstalaciones =true;
		}
		
	}
	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}


	@Command
	@NotifyChange({"carnet","socio"})
	public void buscarCarnet() throws Exception{
		if(carnet==""||carnet==null){
			Messagebox.show("Campo Carnet Vacio", "Warning", Messagebox.OK, Messagebox.EXCLAMATION);
		}
		else{
			this.socioDao= new SocioDao();
			this.socio=socioDao.obtenerSocioCarnet(carnet);
			if(this.socio==null){
				Messagebox.show("Carnet no encontrado", "Warning", Messagebox.OK, Messagebox.EXCLAMATION);
				this.carnet="";
			}
			else {
				Messagebox.show("Carnet encontrado", "Warning", Messagebox.OK, Messagebox.EXCLAMATION);	
			}

		}
	}

	public boolean getDisablecarnet() {
		return disablecarnet;
	}

	public void setDisablecarnet(boolean disable) {
		this.disablecarnet = disable;
	}	
	
	public boolean getDisableinstalaciones() {
		return disableinstalaciones;
	}

	public void setDisableinstalacionest(boolean disable) {
		this.disableinstalaciones = disable;
	}	

	
	
}
