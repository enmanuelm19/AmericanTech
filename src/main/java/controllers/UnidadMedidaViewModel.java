package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;
import Dao.UnidadMedidaDao;
import modelos.UnidadMedida;

public class UnidadMedidaViewModel {

	private List<UnidadMedida> unidadAll;
	private UnidadMedidaDao unidadDao;
	private String descFiltro;
	private String idFiltro;

	@Init
	public void init() throws Exception {
		
		unidadAll = new ArrayList<UnidadMedida>();
		unidadDao = new UnidadMedidaDao();
		unidadAll = unidadDao.obtenerTodos();
	}

	public ListModelList<UnidadMedida> getAllUnidadMedida() {

		return new ListModelList<UnidadMedida>(unidadAll);
	}

	public String getCantRegistros() {
		return unidadAll.size() + " items en la lista";
	}

	public String getDescFiltro() {
		if(descFiltro==null)
			return "";
		return descFiltro;
	}

	public void setDescFiltro(String descFiltro) {
		this.descFiltro = descFiltro==null?"":descFiltro.trim();
	}

	public String getIdFiltro() {
		if(idFiltro==null)
			return "";
		return idFiltro;
	}

	public void setIdFiltro(String idFiltro) {
		this.idFiltro = idFiltro==null?"":idFiltro.trim();
	}

	@Command
	public void showModal(@BindingParam("unidadM") UnidadMedida unidaM) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("unidadM", unidaM);
		Window window = (Window) Executions.createComponents("configuracion/categoria/registrarUnidadMedida.zul",
				null, args);
		window.doModal();
	}

	@Command
	@NotifyChange({ "allUnidadMedida", "cantRegistros" })
	public void eliminar(@BindingParam("unidadM") final UnidadMedida unidadM) {

		Messagebox.show("Estas seguro de eliminar " + unidadM.getNombre(), "Confirmar",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {
								unidadDao.eliminarUnidadMedida(unidadM);
								unidadAll = unidadDao.obtenerTodos();
								Messagebox.show(unidadM.getNombre() + " ha sido eliminado", "", Messagebox.OK,
										Messagebox.INFORMATION);
								BindUtils.postGlobalCommand(null, null, "refreshUnidadMedida", null);
							} catch (Exception e) {
								Messagebox.show(e.getMessage(), unidadM.getNombre() + " No se pudo eliminar",
										Messagebox.OK, Messagebox.ERROR);
							}
						}
					}
				});
	}

	@Command
	@NotifyChange({ "allUnidadMedida", "cantRegistros" })
	public void filtro() throws Exception {
		List<UnidadMedida> tip = new ArrayList<UnidadMedida>();
		String desc = getDescFiltro().toLowerCase();
		String id = getIdFiltro().toLowerCase();

		for (Iterator<UnidadMedida> i = unidadDao.obtenerTodos().iterator(); i.hasNext();) {
			UnidadMedida tmp = i.next();
			if (tmp.getNombre().toLowerCase().contains(desc)
					&& String.valueOf(tmp.getIdUnidadMedida()).toLowerCase().contains(id)) {
				tip.add(tmp);
			}
		}
		unidadAll = tip;
	}

	@GlobalCommand
	@NotifyChange({ "allUnidadMedida", "cantRegistros" })
	public void refreshUnidadMedida() throws Exception {
		unidadAll = unidadDao.obtenerTodos();
	}
}
