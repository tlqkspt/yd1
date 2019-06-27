package co.kdw.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import co.kdw.dto.MemberDto;

public class StudentDao extends Dao {
	
	public StudentDao() {
		super();		//생성자 쓰면 상위생성자 통해서 만들어짐
	}
	
	public ArrayList<MemberDto> select(){
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		MemberDto dto;
		String sql = "select * from member";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				dto = new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dto.setAddr(rs.getString("addr"));
				dto.setMajor(rs.getString("major"));
				list.add(dto);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int update(MemberDto dto) {
		int n = 0;
		String sql = "update member set name = ?, tel = ?, addr = ?, major = ? where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getTel());
			psmt.setString(3, dto.getAddr());
			psmt.setString(4, dto.getMajor());
			psmt.setString(5, dto.getId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}
	
	public int delete(MemberDto dto) {
		int n = 0;
		String sql = "delete member where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			n = psmt.executeUpdate();
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}
	
	public int insert(MemberDto dto) {
		int n = 0;
		String sql = "insert into member values(?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getTel());
			psmt.setString(4, dto.getAddr());
			psmt.setString(5, dto.getMajor());
			n = psmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}
	
}
