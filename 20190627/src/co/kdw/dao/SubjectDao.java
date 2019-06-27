package co.kdw.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import co.kdw.dto.MemberSubjectDto;
import co.kdw.dto.SubjectDto;

public class SubjectDao extends Dao {

	public SubjectDao() {
		super();
	}

	public ArrayList<MemberSubjectDto> serch() {
		ArrayList<MemberSubjectDto> list = new ArrayList<MemberSubjectDto>();
		MemberSubjectDto dto;
		String sql = "select id, name, tel,addr, major, sname, sgrade " + "from member left join subject "
				+ "on member.id = subject.sid";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				dto = new MemberSubjectDto();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dto.setAddr(rs.getString("addr"));
				dto.setMajor(rs.getString("major"));
				dto.setSname(rs.getString("sname"));
				dto.setSgrade(rs.getString("sgrade"));
				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// select() .....
	public ArrayList<SubjectDto> select() {
		ArrayList<SubjectDto> list = new ArrayList<SubjectDto>();
		SubjectDto dto;
		String sql = "select * from subject";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				dto = new SubjectDto();
				dto.setNumid(rs.getInt("numid"));
				dto.setSid(rs.getString("sid"));
				dto.setSname(rs.getString("sname"));
				dto.setSgrade(rs.getString("sgrade"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 업데이트
	public int update(String sql) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n;
	}

	public int delete(SubjectDto dto) {
		int n = 0;
		String sql = "delete subject where numid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getNumid());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return n;
	}
	
	public int insert(SubjectDto dto) {
		int n = 0;
		String sql = "insert into subject values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getNumid());
			psmt.setString(2, dto.getSid());
			psmt.setString(3, dto.getSname());
			psmt.setString(4, dto.getSgrade());
			n = psmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}

}
