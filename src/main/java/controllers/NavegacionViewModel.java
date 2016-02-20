package controllers;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zkmax.zul.Nav;
import org.zkoss.zkmax.zul.Navbar;
import org.zkoss.zkmax.zul.Navitem;
import org.zkoss.zul.Div;
import models.Funcion;
import service.FuncionService;

public class NavegacionViewModel{


	@Wire("#navbar")
	Navbar navbar;

	@Wire("#contenido")
	private Div contenido;

	private Div contenedor;

	private List<Funcion> funciones = FuncionService.getFunciones();

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		cargarMenu();
	}


	public void cargarMenu(){

		List<Funcion> raices = llenarRaices();
		List<Funcion> padres = llenarPadres(raices);
		List<Funcion> hijos = llenarHijos(raices, padres);
		List<Funcion> nietos = llenarNietos(padres);

		//Creo las raices en el navbar
		for(Funcion f : raices){
			Nav root = new Nav();
			root.setLabel(f.getNombre());
			root.setIconSclass(f.getIconUri());
			root.setId(String.valueOf(f.getId()));
			navbar.appendChild(root);

			//Creo los hijos de las raices que a su vez son padres
			for(Funcion fc : padres){

				if(fc.getId_padre() == f.getId()){
					Nav child = new Nav();
					child.setLabel(fc.getNombre());
					child.setIconSclass(fc.getIconUri());
					root.appendChild(child);

					//Creo los hijos de los padres
					for(Funcion nieto : nietos){
						if(nieto.getId_padre() == fc.getId()){
							final Navitem itemNieto = new Navitem();
							itemNieto.setLabel(nieto.getNombre());
							itemNieto.setIconSclass(nieto.getIconUri());
							itemNieto.setId(String.valueOf(nieto.getId()));
							itemNieto.addEventListener("onClick", new EventListener(){
								public void onEvent(Event arg0) throws Exception{
									navegar(itemNieto);
								}
							});
							child.appendChild(itemNieto);
						}
					}

				}

			}
			//Coloco los items directos de la raiz
			for(Funcion hijo : hijos){
				if(hijo.getId_padre() == f.getId()){
					final Navitem item = new Navitem();
					item.setLabel(hijo.getNombre());
					item.setIconSclass(hijo.getIconUri());
					item.setId(String.valueOf(hijo.getId()));
					item.addEventListener("onClick", new EventListener(){
						public void onEvent(Event arg0) throws Exception{
							navegar(item);
						}
					});
					root.appendChild(item);
				}
			}

		}

	}

	private List<Funcion> llenarNietos(List<Funcion> padres) {
		List<Funcion> nietos = new ArrayList<Funcion>();
		//Recorro el arreglo de padres y busco sus respectivos hijos
		for(Funcion padre : padres){
			for(Funcion f : funciones){
				if(f.getId_padre() == padre.getId()){
					nietos.add(f);
				}
			}
		}
		return nietos;
	}


	private List<Funcion> llenarHijos(List<Funcion> raices, List<Funcion> padres) {

		List<Funcion> hijos = new ArrayList<Funcion>();
		//Recorro el arreglo de raices y pregunto quienes son sus hijos
		for(Funcion f : raices){
			for(Funcion fc : funciones){
				if(fc.getId_padre() == f.getId()){
					hijos.add(fc);
				}
			}
		}

		//Recorro el arreglo de hijos y pregunto si el hijo es padre entonces lo saco del arreglo hijos 
		for(Funcion padre : padres){
			for(int i = 0; i<hijos.size(); i++){
				Funcion hijo = hijos.get(i);
				if(hijo.getId() == padre.getId()){
					hijos.remove(i);
				}
			}
		}

		return hijos;
	}


	private List<Funcion> llenarPadres(List<Funcion> raices) {

		List<Funcion> padres = new ArrayList<Funcion>();
		//Recorro el arreglo de raices y pregunto cuales son sus hijos
		for(Funcion raiz : raices){
			for(Funcion f : funciones){
				if(raiz.getId() == f.getId_padre()){
					//recorro el arreglo de funciones y pregunto si el hijo de la raiz tiene hijos
					for(Funcion fc : funciones){
						if(fc.getId_padre() == f.getId()){
							padres.add(f);
							break;
						}
					}
				}
			}
		}
		return padres;
	}


	private List<Funcion> llenarRaices() {
		List<Funcion> raices = new ArrayList<Funcion>();
		//Recorro el arreglo y pregunto si no tiene padres cada funcion
		for (Funcion fc : funciones ) {
			if (fc.getId_padre() == 0) {
				raices.add(fc);
			}
		}
		return raices;
	}


	//Metodo que verifica que opcion se ha marcado
	public void navegar(Component comp){
		for(Funcion fc : funciones) {
			if(comp.getId().equalsIgnoreCase(String.valueOf(fc.getId()))){
				cambiarPantalla(fc);
				break;
			}
		}


	}

	//Metodo que asigna al contenedor que ha de cargar
	private void cambiarPantalla(Funcion fc) {
		if(!fc.getPagina().equalsIgnoreCase("")){
			contenido.getChildren().clear();
			contenedor = (Div) Executions.createComponents(fc.getPagina(), null, null);
			contenido.appendChild(contenedor);
		}
	}


}
