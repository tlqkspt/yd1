package co.kdw.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.kdw.common.Dao;
import co.kdw.common.Service;
import co.kdw.dto.MemberDto;

public class MemberServiceImpl implements Service{
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public void select() {
		//new Dao();
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		String sql = "select * from member";
		conn = Dao.getConnection();  	//싱글톤패턴
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString("id")+" ");
				System.out.print(rs.getString("name")+" ");
				System.out.print(rs.getString("tel")+" ");
				System.out.print(rs.getString("addr")+" ");
				System.out.println(rs.getString("major")+" ");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
