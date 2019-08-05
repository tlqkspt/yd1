package co.kdw.member.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.sun.xml.internal.ws.Closeable;

import co.kdw.member.dto.MemberDto;

public class MemberDao {
	private DataSource ds = null;
	private Context context;
	private PreparedStatement psmt;
	private Connection conn;
	private ResultSet rs;
	private MemberDto dto;
	
	public MemberDao() {
		try {
			context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberDto> memberlist(){		//회원 목록
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		SimpleDateFormat fdate = new SimpleDateFormat("yyyy-MM-dd");
		String sql = "select * from member";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				dto = new MemberDto();
				dto.setId(rs.getString("memberid"));
				dto.setPw(rs.getString("password"));
				dto.setName(rs.getString("membername"));
				dto.setAddr(rs.getString("memberaddr"));
				dto.setBirth(fdate.format(rs.getDate("memberbirthday")));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;	
	}
	
	public int memberIn(MemberDto dto) {		//회원가입
		int n =0;
		String sql = "insert into member values(?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getAddr());
			psmt.setDate(5, Date.valueOf(dto.getBirth()));
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}
	
	public int memberUpdate(MemberDto dto) {		//회원수정
		int n =0;
		String sql = "update member set password=?, membername=?, memberaddr=? where memberid=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getPw());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getAddr());
			psmt.setString(4, dto.getId());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public int memberOut(String id) {		//회원삭제
		int n = 0;
		String sql = "delete member where memberid=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
