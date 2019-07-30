package co.kdw.member.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.kdw.member.dto.MemberDto;

public class JoinDao {
	
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url ="jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "kdw";
	private String password = "1234";
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	private Date birth;
	
	public JoinDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
//메소드구현 	dao 4가지
	public String select(String id) {	//id 중복체크를 위한 select 구문
		String retunId = null;
		String sql = "select memberid from member where memberid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while(rs.next()) {
				retunId = rs.getString("memberid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retunId;
	}
	
	public int insert(MemberDto dto) {	//db에 인서트
		int n = 0;
		String sql = "insert into member values(?,?,?,?,?)";
		birth = Date.valueOf(dto.getMemberBirth());
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getMemberId());
			psmt.setString(2, dto.getMemberPassword());
			psmt.setString(3, dto.getMemberName());
			psmt.setString(4, dto.getMemberAddr());
			psmt.setDate(5, birth);
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
