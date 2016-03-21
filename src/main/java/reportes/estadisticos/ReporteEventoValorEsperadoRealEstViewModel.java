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



public class ReporteEventoValorEsperadoRealEstViewModel {
	
	private String tipo;
	private Time horaInicio;
	private Time horaFin;
	private Date fechaDesde;
	private Date fechaHasta;
	//private InstalacionDao instalacionDao;
	//private TipoInstalacion tipoInstalacionSelected;
	private String carnet;
	private boolean fechades;
	private boolean fechahas;
	private boolean fechacheck;
	private boolean eventocheck;
	private boolean textbuscar;
	private boolean discheckevento;
	private boolean discheckfecha;

	@Init
	public void init() {
		this.setFechades(true);
		this.setFechahas(true);
		this.setTextbuscar(true);

	}

	
	/*@NotifyChange("tipoInstalacionSelected")
	public TipoInstalacion getTipotipoInstalacionSelected() {
		return tipoInstalacionSelected;
	}

	@NotifyChange("InstalacionPorTipo")
	public void setTipoInstalacionSelected(TipoInstalacion tipoInstalacionSelected) {
		this.tipoInstalacionSelected = tipoInstalacionSelected;
	}*/


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



	/*@NotifyChange({"horaDesde","horaHasta"})
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
	}*/


	public boolean getFechades() {
		return fechades;
	}


	public void setFechades(boolean fechades) {
		this.fechades = fechades;
	}


	public boolean getFechahas() {
		return fechahas;
	}


	public void setFechahas(boolean fechahas) {
		this.fechahas = fechahas;
	}


	public boolean getFechacheck() {
		return fechacheck;
	}

	@NotifyChange({"fechades","fechahas","discheckevento","textbuscar"})
	public void setFechacheck(boolean fechacheck) {
		this.fechacheck = fechacheck;
		if (this.fechacheck == true)
		{
			this.setFechades(false);
			this.setFechahas(false);
			//this.setEventocheck();
			this.setDischeckevento(true);
			if (this.discheckevento == true)
			{
				this.setTextbuscar(true);
			}
			else
			{
				this.setTextbuscar(false);
			}
		}
		else
		{
			this.setFechades(true);
			this.setFechahas(true);
			this.setDischeckevento(false);
		}	
	}


	public boolean getEventocheck() {
		return eventocheck;
	}

	@NotifyChange({"fechades","fechahas","discheckfecha","textbuscar"})
	public void setEventocheck(boolean eventocheck) {
		this.eventocheck = eventocheck;
		if (this.eventocheck == true)
		{
			this.setTextbuscar(false);
			this.setDischeckfecha(true);
			if (this.discheckfecha == true)
			{
				this.setFechades(true);
				this.setFechahas(true);			
			}
			else
			{
				this.setFechades(false);
				this.setFechahas(false);	
			}
		}
		else
		{
			this.setTextbuscar(true);
			this.setDischeckfecha(false);
		}
	}


	public boolean getTextbuscar() {
		return textbuscar;
	}


	public void setTextbuscar(boolean textbuscar) {
		this.textbuscar = textbuscar;
	}


	public boolean getDischeckevento() {
		return discheckevento;
	}


	public void setDischeckevento(boolean discheckevento) {
		this.discheckevento = discheckevento;
	}


	public boolean getDischeckfecha() {
		return discheckfecha;
	}


	public void setDischeckfecha(boolean discheckfecha) {
		this.discheckfecha = discheckfecha;
	}

	
	
}
