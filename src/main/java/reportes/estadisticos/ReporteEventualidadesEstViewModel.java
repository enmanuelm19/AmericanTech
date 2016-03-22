package reportes.estadisticos;

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



public class ReporteEventualidadesEstViewModel {
	
	private String tipo;
	private Time horaInicio;
	private Time horaFin;
	private Date fechaDesde;
	private Date fechaHasta;
	private InstalacionDao instalacionDao;
	private TipoInstalacion tipoInstalacionSelected;
	private String carnet;
	private boolean hora;
	private boolean horaDesde;
	private boolean horaHasta;
	private boolean instalacioncheck;
	private boolean instalacion;


	@Init
	public void init() {
		this.setHoraDesde(true);
		this.setHoraHasta(true);
		this.setInstalacion(true);

	}

	
	@NotifyChange("tipoInstalacionSelected")
	public TipoInstalacion getTipotipoInstalacionSelected() {
		return tipoInstalacionSelected;
	}

	@NotifyChange("InstalacionPorTipo")
	public void setTipoInstalacionSelected(TipoInstalacion tipoInstalacionSelected) {
		this.tipoInstalacionSelected = tipoInstalacionSelected;
	}


	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
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

	/*public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}*/

	public String getTipo() {
		return tipo;
	}

	@NotifyChange({"disablecarnet","disableinstalaciones"})

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}


	/*@Command
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
	}*/

	public boolean getHora() {
		return hora;
	}

	@NotifyChange({"horaDesde","horaHasta"})
	public void setHora(boolean hora) {
		this.hora = hora;
		if (this.hora == true)
		{
			this.horaDesde = false;
			this.horaHasta = false;
		}
		else
		{
			this.horaDesde = true;
			this.horaHasta = true;			
		}	
	}


	public boolean getHoraDesde() {
		return horaDesde;
	}


	public void setHoraDesde(boolean horaDesde) {
		this.horaDesde = horaDesde;
	}


	public boolean getHoraHasta() {
		return horaHasta;
	}


	public void setHoraHasta(boolean horaHasta) {
		this.horaHasta = horaHasta;
	}


	public boolean getInstalacioncheck() {
		return instalacioncheck;
	}

	@NotifyChange({"instalacion"})
	public void setInstalacioncheck(boolean instalacioncheck) {
		this.instalacioncheck = instalacioncheck;
		if (this.instalacioncheck == true)
		{
			this.instalacion = false;
		}
		else
		{
			this.instalacion = true;
		}
	}


	public boolean getInstalacion() {
		return instalacion;
	}


	public void setInstalacion(boolean instalacion) {
		this.instalacion = instalacion;
	}

	
	
}
