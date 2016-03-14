package util;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;

import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WebApps;

import net.sf.jasperreports.components.table.fill.DatasetCloneObjectFactory;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import waffle.util.Base64;



public class ManejadorArchivo {
	
	public static String subirImagen(Media imagen) throws IOException, ParseException{
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
		String imagenLocal = ruta +"/" + imagen.getName();
		
		return subirImagenImgur(imagenLocal);
	}

	private static String getServerName() {
		String port = ( Executions.getCurrent().getServerPort() == 80 ) ? "" : (":" + Executions.getCurrent().getServerPort());
		String url = Executions.getCurrent().getScheme() + "://" + Executions.getCurrent().getServerName() + 
					port + Executions.getCurrent().getContextPath();
		return url;
	}
	public static String subirImagenImgur(String imagenLocal) throws IOException, ParseException{
		String IMGUR_POST_URI = "https://api.imgur.com/3/upload";
		String IMGUR_API_KEY = "b43b22c6dd0622e";
		BufferedImage image = null;
		File file = new File(imagenLocal);
		image = ImageIO.read(file);
		ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
		ImageIO.write(image, "jpg", byteArray);
		byte[] byteImage = byteArray.toByteArray();
		String dataImage = Base64.encode(byteImage);
		String data = URLEncoder.encode("image", "UTF-8") + "=" +URLEncoder.encode(dataImage, "UTF-8");
		URL url = new URL(IMGUR_POST_URI);
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "Client-ID "+IMGUR_API_KEY);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		
		conn.connect();
		
		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
		wr.write(data);
		wr.flush();
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line = rd.readLine();
		JSONObject dataObject = new JSONObject();
		while(line != null){
			JSONObject jsonObject = (JSONObject) new JSONParser().parse(line);
			 dataObject = (JSONObject) jsonObject.get("data");
			line = rd.readLine();
			
			
		}

		wr.close();
		return dataObject.get("link").toString();
	
	}
}
