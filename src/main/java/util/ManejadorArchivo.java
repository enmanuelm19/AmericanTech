package util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WebApps;

public class ManejadorArchivo {
	
	public static String subirImagen(Media imagen){
		String rutaFinal = null;
		String ruta = WebApps.getCurrent().getServletContext().getInitParameter("upload.location");
		File imageFile = new File(ruta, imagen.getName());
		try {
			InputStream is = imagen.getStreamData();
			if(!imageFile.exists()){
				Files.copy(is, imageFile.toPath());
				rutaFinal = getServerName()+"/uploadedImages/"+imagen.getName();
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rutaFinal;
	}

	private static String getServerName() {
		String port = ( Executions.getCurrent().getServerPort() == 80 ) ? "" : (":" + Executions.getCurrent().getServerPort());
		String url = Executions.getCurrent().getScheme() + "://" + Executions.getCurrent().getServerName() + 
					port + Executions.getCurrent().getContextPath();
		return url;
	}
}
