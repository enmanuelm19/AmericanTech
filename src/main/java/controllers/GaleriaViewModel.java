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

import modelos.Foto;
import Dao.FotoDao;

public class GaleriaViewModel {

	// private List<Club> clubAll;
	private List<Foto> fotos;
	private FotoDao fotosDao;


	@Init
	public void init() throws Exception {
		fotos = new ArrayList<Foto>();
		fotosDao = new FotoDao();
		fotos = fotosDao.obtenerTodos();
	}

	public ListModelList<Foto> getfotos() {
		return new ListModelList<Foto>(fotos);
	}

}