//Created by: Enmanuel Medina, Team: O'Sillivan
package service;

import java.util.ArrayList;
import java.util.List;

import models.ClienteExterno;

public class ClienteExternoService {

	static int id=0;
	static List<ClienteExterno> clientesExternos = new ArrayList<ClienteExterno>();
	static{
		clientesExternos.add(new ClienteExterno(id++, "Maria", "Josefa", "MariaJ@correo.com"));
		clientesExternos.add(new ClienteExterno(id++, "Jose", "Escalona", "JE@correo.com"));
		clientesExternos.add(new ClienteExterno(id++, "Daniel", "Mendoza", "DM@correo.com"));
		clientesExternos.add(new ClienteExterno(id++, "Carlos", "Moreno", "CM@correo.com"));
		clientesExternos.add(new ClienteExterno(id++, "Sheldon", "Cooper", "SC@correo.com"));
		clientesExternos.add(new ClienteExterno(id++, "Leonard", "Hofstader", "LH@correo.com"));
	}
	public static List<ClienteExterno> getClientesExternos() {
		return clientesExternos;
	}
	public static void setClientesExternos(List<ClienteExterno> clientesExternos) {
		ClienteExternoService.clientesExternos = clientesExternos;
	}
	
}
