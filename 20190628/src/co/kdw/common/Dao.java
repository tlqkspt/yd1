package co.kdw.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Dao { //인스턴스 생성하지 않고 Stack 영역을 직접 참조(공유)해서 사용하는 Dao
		
		private static String driver;
		private static String url;
		private static String user;
		private static String pw;
		
//		private static Connection conn;
		
		public Dao() {  	///상속 dao / 각각넣기 / 스태틱쓰기 등
			init();
		}
		
		private  void init() {
			String path = "config/db.properties";
			Properties profile = new Properties();
			try {
				profile.load(new FileReader(path));
				driver = profile.getProperty("driver");
				url = profile.getProperty("url");
				user = profile.getProperty("user");
				pw = profile.getProperty("password");
			} catch(IOException e){
				e.printStackTrace();
			}
		}
		
		public static Connection getConnection() {
			//init();
			new Dao();  // ??테스트해보기
			Connection conn = null;
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, pw);
				
			} catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}
		
}
