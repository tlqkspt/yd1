package co.kdw.member.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import co.kdw.member.dto.MemberDto;

public class JoinDao {
	
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url ="jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "kdw";
	private String password = "1234";
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	private Date birth;		//java.sql.Date
	
	public JoinDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
//메소드구현 	dao 4가지
	
	public ArrayList<MemberDto> select(){
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		MemberDto dto;
		String sql = "select * from member";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");			//날짜 스트링으로 처리위한 format 주의! MM 대문자  (*시간  HH:mm:ss 형식)
			//Date date = new Date();	//java.sql.Date  //String Date타입변환
			//date = Date.valueof(str);
			
			while(rs.next()) {
				dto = new MemberDto();
				dto.setMemberId(rs.getString("memberid"));
				dto.setMemberName(rs.getString("memberName"));
				dto.setMemberAddr(rs.getString("memberaddr"));
				dto.setMemberBirth(date.format(rs.getDate("memberbirthday")));
				list.add(dto);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list; 
	}
	
	
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
	
	public MemberDto serch(String id) {
		MemberDto dto = new MemberDto();
		String sql = "select * from member where memberid = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto.setMemberId(rs.getString("memberid"));
				dto.setMemberPassword(rs.getString("password"));
				dto.setMemberName(rs.getString("membername"));
				dto.setMemberAddr(rs.getString("memberaddr"));
				dto.setMemberBirth(date.format(rs.getDate("memberbirthday")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return dto;
	}
	
	public int update(MemberDto dto) {	//db에 인서트
		int n = 0;
		String sql = "update member set password = ?, membername = ?, memberaddr = ?, memberbirthday = ?  where"
				+ " memberid = ?";
		birth = Date.valueOf(dto.getMemberBirth());		//String >>> date 포맷으로 변환
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getMemberPassword());
			psmt.setString(2, dto.getMemberName());
			psmt.setString(3, dto.getMemberAddr());
			psmt.setDate(4, birth);
			psmt.setString(5, dto.getMemberId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
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
