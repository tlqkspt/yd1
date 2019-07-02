package mail;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSend {
	public static void main(String[] args) {

		MailAccount login = new MailAccount();
		login.run();

		System.out.println(login.user);

		String host = "smtp.gmail.com";
		final String USER = login.getUser();
		final String PASSWORD = login.getPassword();

//		String to = "udon1@naver.com";

		MultiMail mm = new MultiMail();
		mm.run();
		
		//제목입력
		Title title = new Title();
		title.title();
		
		for (String id : mm.account) {
			String to = id;

			// Get the session object
			Properties props = new Properties();
			props.put("mail.transport.protocol", "smtp"); // 추가
			props.put("mail.smtp.starttls.enable", "true");// 추가
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", "true");

			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(USER, PASSWORD);
				}
			});

			// Compose the message

			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(USER));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

				// Subject
				message.setSubject(title.title);

				// Text
				message.setText("메일 가즈아아아");

				// send the message
				Transport.send(message);
				System.out.println("message sent successfully...  to)"+to);

			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
		System.out.println("종료");
	}
}
