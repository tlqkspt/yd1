package ajaxText.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	static Connection conn = null;

	public static Connection getConnection() {
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kdw";
		String passwd = "1234";

		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, user, passwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
