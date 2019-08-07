package co.yedam.membermanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.yedam.membermanager.common.DAO;
import co.yedam.membermanager.dto.MemberDto;

public class MemberDao {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private MemberDto dto;
	
	public MemberDao() {
		conn = DAO.conn();
	}
	
	public ArrayList<MemberDto> select(){		//회원전체조회
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		String sql ="select * from member";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				dto = new MemberDto();
				dto.setmId(rs.getString("memberid"));
				dto.setmName(rs.getString("membername"));
				dto.setmAddr(rs.getString("memberaddr"));
				dto.setmDate(rs.getDate("memberregday"));
				dto.setmGrant(rs.getString("membergrant"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	public MemberDto select(String id) {	//특정회원 조회
		String sql ="select * from member where memberid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while(rs.next()) {
				dto = new MemberDto();
				dto.setmId(rs.getString("memberid"));
				dto.setmName(rs.getString("membername"));
				dto.setmAddr(rs.getString("memberaddr"));
				dto.setmDate(rs.getDate("memberregday"));
				dto.setmGrant(rs.getString("membergrant"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	
	
	public boolean memberIdCheck(String id) {	//id체크
		boolean idCheck = false;
		String sql ="select memberid from member where memberid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) idCheck = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return idCheck;
	}
	
	
	public MemberDto login(String id, String password) {
		String sql ="select * from member where memberid = ? and password = ?";
		dto = new MemberDto();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, password);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto.setmId(rs.getString("memberid"));
				dto.setmName(rs.getString("membername"));
				dto.setmAddr(rs.getString("memberaddr"));
				dto.setmDate(rs.getDate("memberregday"));
				dto.setmGrant(rs.getString("membergrant"));
			} else {
				dto.setmId(null);		//id null이면 로그인실패
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	
	public int delete(String id) {	//멤버삭제
		int n = 0;
		String sql = "delete from member where memberid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}
	
	public int update(MemberDto dto) {		//회원정보수정
		int n = 0;
		//String sql = "update from"
		
				
		//Todo 여기기술
		return n;
	}
	
	public int insert(MemberDto dto) {	//회원 등록
		int n = 0;
		//String sql = "update from"
		
				
		//Todo 여기기술
		return n;
	}

	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
