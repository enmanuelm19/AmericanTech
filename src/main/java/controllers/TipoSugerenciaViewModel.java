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
import models.TipoSugerencia;
import service.TipoSugerenciaService;

public class TipoSugerenciaViewModel {

	private List<TipoSugerencia> tiposAll;
	private TipoSugerencia tipoS;

	@Init
	public void init() {
		tipoS = new TipoSugerencia();
		tiposAll = new ArrayList<TipoSugerencia>();
		tiposAll = TipoSugerenciaService.getTipoSugerencia();
	}

	public ListModelList<TipoSugerencia> getAllTipoSugerencia() {

		return new ListModelList<TipoSugerencia>(tiposAll);
	}

	public String getCantRegistros() {
		return tiposAll.size() + " items en la lista";
	}

	public TipoSugerencia getTipoS() {
		return tipoS;
	}

	public void setTipoS(TipoSugerencia tipoS) {
		this.tipoS = tipoS;
	}

	@Command
	public void showModal(@BindingParam("Tipo") TipoSugerencia tipo) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("TipoSugerencia", tipo);
		Window window = (Window) Executions.createComponents("configuracion/categoria/registrarTipoSugerencia.zul",
				null, args);
		window.doModal();
	}

	@Command
	@NotifyChange({ "allTipoSugerencia", "cantRegistros" })
	public void eliminar(@BindingParam("Tipo") final TipoSugerencia tipo) {

		Messagebox.show("Estas seguro de eliminar " + tipo.getDescripcion(), "Confirmar",
				Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event evt) throws InterruptedException {
						if (evt.getName().equals("onOK")) {
							try {
								tipo.setEstatus("E");
								TipoSugerenciaService.updateTipoSugerencia(tipo);
								tiposAll = TipoSugerenciaService.getTipoSugerencia();
								Messagebox.show(tipo.getDescripcion() + " ha sido eliminado", "", Messagebox.OK,
										Messagebox.INFORMATION);
								BindUtils.postGlobalCommand(null, null, "refreshTipoSugerencia", null);
							} catch (Exception e) {
								Messagebox.show(e.getMessage(), tipo.getDescripcion() + " No se pudo eliminar",
										Messagebox.OK, Messagebox.ERROR);
							}
						}
					}
				});
	}

	@Command
	@NotifyChange({ "allTipoSugerencia", "cantRegistros" })
	public void filtro() {
		List<TipoSugerencia> tip = new ArrayList<TipoSugerencia>();
		String desc = tipoS.getDescFiltro().toLowerCase();
		String id = tipoS.getIdFiltro().toLowerCase();

		for (Iterator<TipoSugerencia> i = TipoSugerenciaService.getTipoSugerencia().iterator(); i.hasNext();) {
			TipoSugerencia tmp = i.next();
			if (tmp.getDescripcion().toLowerCase().contains(desc)
					&& String.valueOf(tmp.getId()).toLowerCase().contains(id)) {
				tip.add(tmp);
			}
		}
		tiposAll = tip;
	}

	@GlobalCommand
	@NotifyChange({ "allTipoSugerencia", "cantRegistros" })
	public void refreshTipoSugerencia() {
		tiposAll = TipoSugerenciaService.getTipoSugerencia();
	}

}
