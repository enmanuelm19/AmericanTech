package reportes.estructurados;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;







import Dao.InstalacionDao;
import Dao.PersonaDao;
import Dao.SocioDao;
import modelos.Instalacion;
import modelos.Persona;
import modelos.Socio;
import modelos.TipoInstalacion;
import modelos.TipoPreferencia;



public class ReporteSancionesViewModel {
	
	private Socio socio;
	private SocioDao socioDao;
	private String carnet;	
	private int tipo;
	private int estadoinstalacion;
	private Date fechadesde;
	private Date fechahasta;
	private InstalacionDao instalacionDao;
	private TipoInstalacion tipoInstalacionSelected;
	private boolean nrocarnet;
	private boolean sancionados;
	private boolean check;


	@Init
	public void init() {
		instalacionDao = new InstalacionDao();
		this.socio = new Socio();
		this.nrocarnet = true;
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

	public int getEstadoinstalacion() {
		return estadoinstalacion;
	}

	public void setEstadoinstalacion(int estadoinstalacion) {
		this.estadoinstalacion = estadoinstalacion;
	}

	public Date getFechadesde() {
		return fechadesde;
	}

	public void setFechadesde(Date fechadesde) {
		this.fechadesde = fechadesde;
	}

	public Date getFechahasta() {
		return fechahasta;
	}

	public void setFechahasta(Date fechahasta) {
		this.fechahasta = fechahasta;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
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
				Messagebox.show("Carnet encontrado", "Warning", Messagebox.OK, Messagebox.EXCLAMATION);
			}

		}
	}

	public boolean isNrocarnet() {
		return nrocarnet;
	}

	public void setNrocarnet(boolean nrocarnet) {
		this.nrocarnet = nrocarnet;
	}

	public boolean isSancionados() {
		return sancionados;
	}

	public void setSancionados(boolean sancionados) {
		this.sancionados = sancionados;
	}

	public boolean isCheck() {
		return check;
	}

	@NotifyChange({"nrocarnet","sancionados"})
	public void setCheck(boolean check) {
		this.check = check;
		if (this.check == true )
		{
			this.nrocarnet = false;
			this.sancionados =true;
		}
		
	}

}
