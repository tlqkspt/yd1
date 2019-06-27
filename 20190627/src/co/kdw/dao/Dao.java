package co.kdw.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Dao {
	private String driver;
	private String url;
	private String user;
	private String pw;
	
	public Connection conn;
	public PreparedStatement psmt;
	public ResultSet rs;	//셀렉트할때 반드시필요
	
	public Dao() {
		init();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pw);
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void init() {
		String path = "config/db.properties";
		Properties profile = new Properties();
		try {
			profile.load(new FileReader(path));//파일로드
			driver = profile.getProperty("driver");
			url = profile.getProperty("url");
			user = profile.getProperty("user");
			pw = profile.getProperty("password");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
