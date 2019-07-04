package test93.savelog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import test93.savelog.common.DAO;


public class logDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	public void setLog(logDTO log) {
		conn = DAO.getConnet();
		int n =0;
		String sql ="insert into values(?,?,?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, log.getId());
			psmt.setString(2, log.getChat());
			psmt.setString(3, log.getDate());
			
			n = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		
	}
	
}
