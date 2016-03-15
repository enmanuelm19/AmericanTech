package util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import Dao.ClubDao;
import modelos.Club;

public class ManejadorMail {
	
	private static ClubDao clubDao = new ClubDao();
	private static Club club;
	private static String username;
	private static String password;
	
	
	public static void enviarEmail(String mensaje, String destinatario, String asunto) throws Exception{
		
		club = clubDao.obtenerClub(1);
		//username = club.getCorreo();
		//password = club.getClaveCorreo();
		
		username = "centro.atletico.america.si@gmail.com";
		password = "c12345678";
		
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
		
		try {
			Message msg = new MimeMessage(sesion);
			msg.setFrom(new InternetAddress(username));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
			msg.setSubject(asunto);
			msg.setText(mensaje);
			Transport.send(msg);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}