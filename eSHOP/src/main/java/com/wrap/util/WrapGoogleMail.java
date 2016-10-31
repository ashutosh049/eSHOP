/**
 * 
 */
package com.wrap.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.sun.mail.smtp.SMTPTransport;

/**
 * DESCRIPTION GOES HERE<br>
 * <br>
 * Copyright (c) 2016 kumar.ashutosh@skillnetinc.com
 * 
 * @author ashu
 * @created Oct 22, 2016
 * @version $Revision$
 */
@Service
public class WrapGoogleMail {
	private static Logger logger = LoggerFactory
			.getLogger(WrapGoogleMail.class);
	public static Boolean isNotificationEnable = false;

	/**
	 * 
	 */
	private WrapGoogleMail() {
		// TODO Auto-generated constructor stub
	}

	public static void Send(final String username, final String password,
			String recipientEmail, String title, String message)
					throws AddressException, MessagingException {
		WrapGoogleMail.send(username, password, recipientEmail, "", title,
				message);
	}

	public static void sendMail(String senderEmail, String senderPassword,
			String recipientEmail, String ccEmail, String title, String message)
					throws AddressException, MessagingException {

		send(senderEmail, senderPassword, recipientEmail, ccEmail, title,
				message);
	}

	@SuppressWarnings("restriction")
	public static void send(final String username, final String password,
			String recipientEmail, String ccEmail, String title, String message)
					throws AddressException, MessagingException {
		
		System.out.println("username " + username);
		System.out.println("password " + password);
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		final String sslFactory = "javax.net.ssl.SSLSocketFactory";

		Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.socketFactory.class", sslFactory);
		// Commented because in prod  mail are sent without this props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.setProperty("mail.smtp.auth", "true");

		Session session = Session.getInstance(props, null);
		session.setDebug(true);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(username));

		logger.debug("sending to email address : {}", recipientEmail);
		msg.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(recipientEmail, false));

		if (ccEmail != null) {
			if (ccEmail.length() > 0) {
				msg.setRecipients(Message.RecipientType.CC,
						InternetAddress.parse(recipientEmail, false));
			}
		}

		msg.setSubject(title);
		msg.setSentDate(new Date());
		msg.setDataHandler(new DataHandler(new HTMLDataSource(message)));
		SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
		t.setLocalHost("localhost");
		logger.debug(" SMTP Transport ");

		t.connect("smtp.gmail.com", Integer.parseInt("465"), username, password);

		logger.debug("Now sending Email");
		t.sendMessage(msg, msg.getAllRecipients());
		logger.debug("Email sent successfully");
		t.close();
	}

	public static void SendEmail(String senderemail, String senderPassword,
			String recipientEmail, String ccEmail, String title, String message)
					throws AddressException, MessagingException {
		send(senderemail, senderPassword, recipientEmail, ccEmail, title,
				message);
	}

	public static void main(String args[]) {

	}

	static class HTMLDataSource implements DataSource {
		private String html;

		public HTMLDataSource(String htmlString) {
			html = htmlString;
		}

		public InputStream getInputStream() throws IOException {
			if (html == null) {
				throw new IOException("Null HTML");
			}
			return new ByteArrayInputStream(html.getBytes());
		}

		public OutputStream getOutputStream() throws IOException {
			throw new IOException("This DataHandler cannot write HTML");
		}

		public String getContentType() {
			return "text/html";
		}

		public String getName() {
			return "JAF text/html dataSource to send e-mail only";
		}
	}

}
