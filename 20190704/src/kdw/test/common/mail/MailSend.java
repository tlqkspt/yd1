package kdw.test.common.mail;

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

import kdw.test.BuyProd.Buy;

public class MailSend {
	//public static void main(String[] args) {

	
	
	public void mailRun(Buy buy) {
		
		MailAccount login = new MailAccount();
		login.run();

		System.out.println(login.user);

		String host = "smtp.gmail.com";
		final String USER = login.getUser();
		final String PASSWORD = login.getPassword();

//		String to = "udon1@naver.com";

		
//		//제목입력
//		Title title = new Title();
//		title.title();
		
			String to = "udon1@naver.com";	//회원 e메일 주소 입력

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
				
				String[] strArr = to.split("@");
				// Subject
				message.setSubject(strArr[0]+"님의 주문내역입니다");

				// Text
				message.setText("주문번호 :"+buy.getOrderNo()+ "\n\r"+"총가격: "+buy.getSumPrice() + "\n\r"+"감사합니다");		//내용입력

				// send the message
				Transport.send(message);
				System.out.println("message sent successfully...  to)"+to);

			} catch (MessagingException e) {
				e.printStackTrace();
			}
		
		System.out.println("종료");
	}
}
