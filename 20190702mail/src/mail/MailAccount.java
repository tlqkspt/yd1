package mail;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MailAccount {

	String user ="1";
	String password="" ;
	
	private void init() {
		System.out.println(user);
		String path = "config/google.properties";
		Properties profile = new Properties();
		
		try {
			profile.load(new FileReader(path));
			user = profile.getProperty("user");
			System.out.println(user);
			password = profile.getProperty("password");
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	
	
	
	
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void run() {
		init();
	}
	
}
