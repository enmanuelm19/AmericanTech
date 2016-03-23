package util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.zkoss.zul.Messagebox;

import Dao.ClubDao;
import modelos.Club;

public class ManejadorMail {

	private static ClubDao clubDao = new ClubDao();
	private static Club club;
	private static String username;
	private static String password;


	public static void enviarEmail(String mensaje, String destinatario, String asunto) throws Exception{
		
		boolean internet = isInternetReachable();
		club = clubDao.obtenerClub(1);
		//username = club.getCorreo();
		//password = club.getClaveCorreo();

		username = "centro.atletico.america.si@gmail.com";
		password = "c12345678";
		if(internet == true){
		Properties propiedades = new Properties();
		propiedades.put("mail.smtp.auth", "true");
		propiedades.put("mail.smtp.starttls.enable", "true");
		propiedades.put("mail.smtp.host", "smtp.gmail.com");
		propiedades.put("mail.smtp.port", "587");

		Session sesion = Session.getInstance(propiedades, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(username, password);
			}
		});

		final Transport tr = sesion.getTransport("smtp");

		final Message msg = new MimeMessage(sesion);
		msg.setFrom(new InternetAddress(username));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
		msg.setSubject(asunto);
		msg.setText(mensaje);


		new Thread(new Runnable() {
			public void run() {
				try {
					tr.send(msg);
					tr.close();
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
		}).start();
		}else{
			Messagebox.show("En estos momentos tenemos problemas de conexion y no podemos enviar el correo, disculpe las molestias!");
		}
	}
	
    public static boolean isInternetReachable()
    {
        try {
            URL url = new URL("https://www.google.com");

            HttpURLConnection urlConnect = (HttpURLConnection)url.openConnection();

            Object objData = urlConnect.getContent();

        } catch (UnknownHostException e) {

            e.printStackTrace();
            return false;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}