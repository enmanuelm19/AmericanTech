package reportes.estructurados;

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
import modelos.Instalacion;
import modelos.TipoInstalacion;
import modelos.TipoPreferencia;



public class ReporteAlquilerViewModel {
	

	private int estadoinstalacion;
	private Date fechadesde;
	private Date fechahasta;
	private InstalacionDao instalacionDao;
	private TipoInstalacion tipoInstalacionSelected;


	@Init
	public void init() {
		instalacionDao = new InstalacionDao();
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
	/*public void setFechahasta(Date fechahasta) {
		this.fechahasta = fechahasta;
	}*/

}
