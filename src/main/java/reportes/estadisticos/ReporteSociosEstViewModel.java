package reportes.estadisticos;

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
import Dao.PreferenciaDao;
import Dao.SocioDao;
import Dao.TipoPreferenciaDao;
import modelos.Instalacion;
import modelos.Persona;
import modelos.Preferencia;
import modelos.Socio;
import modelos.TipoInstalacion;
import modelos.TipoPreferencia;



public class ReporteSociosEstViewModel {
	
	private Socio socio;
	private SocioDao socioDao;
	private String carnet;	
	private String tipo;
	private int estadoinstalacion;
	private Date fechadesde;
	private Date fechahasta;
	private InstalacionDao instalacionDao;
	private TipoInstalacion tipoInstalacionSelected;
	private TipoPreferencia tipoPreferenciaSelected;
	private PreferenciaDao preferenciaDao;
	
	private int edaddesde;
	private int edadhasta;
	private String sexo;
	private String categoria;
	private String preferencia;
	private TipoPreferenciaDao tipopreferenciaDao;
	private boolean checkedad;
	private boolean checksexo;
	private boolean checkcategoria;
	private boolean checkpreferencia;
	


	@Init
	public void init() {
		instalacionDao = new InstalacionDao();
		preferenciaDao = new PreferenciaDao();
		tipopreferenciaDao = new TipoPreferenciaDao();
		this.socio = new Socio();
	}

	@NotifyChange("preferenciasPorTipo")
	public TipoPreferencia getTipoPreferenciaSelected() {
		return tipoPreferenciaSelected;
	}

	@NotifyChange("preferenciasPorTipo")
	public void setTipoPreferenciaSelected(TipoPreferencia tipoPreferenciaSelected) {
		this.tipoPreferenciaSelected = tipoPreferenciaSelected;
	}
	
	public ListModelList<Preferencia> getPreferenciasPorTipo() throws Exception {
		if (tipoPreferenciaSelected != null) {
			return new ListModelList<Preferencia>(preferenciaDao.obtenerPreferenciasTipo(tipoPreferenciaSelected));
		}
		return new ListModelList<Preferencia>();
	}		
	
	public ListModelList<TipoPreferencia> getTipoPreferencia() throws Exception {

		return new ListModelList<TipoPreferencia>(tipopreferenciaDao.obtenerTodos());

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
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

	public int getEdaddesde() {
		return edaddesde;
	}

	public void setEdaddesde(int edaddesde) {
		this.edaddesde = edaddesde;
	}

	public int getEdadhasta() {
		return edadhasta;
	}

	public void setEdadhasta(int edadhasta) {
		this.edadhasta = edadhasta;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(String preferencia) {
		this.preferencia = preferencia;
	}

	public boolean isCheckedad() {
		return checkedad;
	}

	public void setCheckedad(boolean checkedad) {
		this.checkedad = checkedad;
	}

	public boolean isChecksexo() {
		return checksexo;
	}

	public void setChecksexo(boolean checksexo) {
		this.checksexo = checksexo;
	}

	public boolean isCheckcategoria() {
		return checkcategoria;
	}

	public void setCheckcategoria(boolean checkcategoria) {
		this.checkcategoria = checkcategoria;
	}

	public boolean isCheckpreferencia() {
		return checkpreferencia;
	}

	public void setCheckpreferencia(boolean checkpreferencia) {
		this.checkpreferencia = checkpreferencia;
	}


}
