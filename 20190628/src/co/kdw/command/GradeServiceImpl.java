package co.kdw.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import co.kdw.common.Dao;
import co.kdw.common.Service;

public class GradeServiceImpl implements Service{
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public void select() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		System.out.println("삭제할 순번을 입력.");
		Scanner sc = new Scanner(System.in);
		int key = sc.nextInt();
		String sql = "delete from subject where numid = ?";
		try {
			conn = Dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, key);
			if(psmt.executeUpdate() != 0) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int key) {
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
