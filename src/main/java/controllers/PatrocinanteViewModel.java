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

import Dao.PatrocinanteDao;
import modelos.Patrocinante;

public class PatrocinanteViewModel {

	private List<Patrocinante> patrocinanteAll;
	private PatrocinanteDao patrocinanteDao;
	private String nombFiltro;
	private String idFiltro;

	@Init
	public void init() throws Exception {
		
		patrocinanteAll = new ArrayList<Patrocinante>();
		patrocinanteDao = new PatrocinanteDao();
		patrocinanteAll = patrocinanteDao.obtenerTodos();
	}

	public ListModelList<Patrocinante> getAllPatrocinante() {

		return new ListModelList<Patrocinante>(patrocinanteAll);
	}

	public String getCantRegistros() {
		return patrocinanteAll.size() + " items en la lista";
	}

	public String getNombFiltro() {
		if(nombFiltro==null)
			return "";
		return nombFiltro;
	}

	public void setNombFiltro(String nombFiltro) {
		this.nombFiltro = nombFiltro==null?"":nombFiltro.trim();
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
	public void showModal(@BindingParam("Patrocinante") Patrocinante patrocinante) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("Patrocinante", patrocinante);
		Window window = (Window) Executions.createComponents("configuracion/registrarPatrocinante.zul",
				null, args);
		window.doModal();
	}

	@Command
	@NotifyChange({ "allPatrocinante", "cantRegistros" })
	public void eliminar(@BindingParam("Patrocinante") final Patrocinante patrocinante) {

		Messagebox.show("Estas seguro de eliminar " + patrocinante.getNombre(), "Confirmar",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {
								patrocinanteDao.eliminarPatrocinante(patrocinante);
								patrocinanteAll = patrocinanteDao.obtenerTodos();
								Messagebox.show(patrocinante.getNombre() + " ha sido eliminado", "", Messagebox.OK,
										Messagebox.INFORMATION);
								BindUtils.postGlobalCommand(null, null, "refreshPatrocinante", null);
							} catch (Exception e) {
								Messagebox.show(e.getMessage(), patrocinante.getNombre() + " No se pudo eliminar",
										Messagebox.OK, Messagebox.ERROR);
							}
						}
					}
				});
	}

	@Command
	@NotifyChange({ "allPatrocinante", "cantRegistros" })
	public void filtro() throws Exception {
		List<Patrocinante> patrocinante = new ArrayList<Patrocinante>();
		String nomb = getNombFiltro().toLowerCase();
		String id = getIdFiltro().toLowerCase();

		for (Iterator<Patrocinante> i = patrocinanteDao.obtenerTodos().iterator(); i.hasNext();) {
			Patrocinante tmp = i.next();
			if (tmp.getNombre().toLowerCase().contains(nomb)
					&& String.valueOf(tmp.getIdPatrocinante()).toLowerCase().contains(id)) {
				patrocinante.add(tmp);
			}
		}
		patrocinanteAll = patrocinante;
	}

	@GlobalCommand
	@NotifyChange({ "allPatrocinante", "cantRegistros" })
	public void refreshPatrocinante() throws Exception {
		patrocinanteAll = patrocinanteDao.obtenerTodos();
	}
}

