package co.kdw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.kdw.dto.MemberDto;

public class Dao {
	private String driver;		//사용할 드라이버 명
	private String url;			//DB 접속위치
	private String user;		//사용자 계정(DB)
	private String pw;			//사용자계정 패스워드
	
	private Connection conn;	//컨넥션 객체
	private PreparedStatement psmt;	//Statement 객체로 Sql구문을 실행요청 (데이터베이스 명령을 실행하는역할) 자바시큐어~~  보안에유리
	private ResultSet rs;		//select 구문 실행 레코드 셋을 담기위한 객체
	private String sql;			//Sql구문
	
	public Dao() {
		init();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);	//db져있으면 접속 x
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int delete(String id) {
		sql = "delete from member where id = ?";
		int n=0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,id);
			n = psmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}
	
	public int update(MemberDto dto) {
		sql = "update member set name = ?, tel = ?, addr = ?, major = ? where id = ?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getTel());
			psmt.setString(3, dto.getAddr());
			psmt.setString(4, dto.getMajor());
			psmt.setString(5, dto.getId());
			n = psmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}
	
	public void close() {
			try {
				if(rs != null)	rs.close();
				if(psmt != null) psmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	private void init() {//초기화메서드		//원래는 소스코드안에 안두고 프롬포트? 파일로 만듬  코드안에있으면 변경시 컴파일 다시해야함
		driver = "oracle.jdbc.driver.OracleDriver";  //오라클제공 드라이버명  / 제공하는애들이 만들어줌
		url = "jdbc:oracle:thin:@localhost:1521:xe";	//xe=오라클xe 디폴트 SID
		user = "kdw";
		pw = "1234";
	}
	
	public ArrayList<MemberDto> select() {		// 중요 현업 대부분 리스트로씀 
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		MemberDto dto;
		sql = "select * from member";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {					//될수있으면 인덱스보다 컬럼명줘서 코드가독성 up
				dto = new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dto.setAddr(rs.getString("addr"));
				dto.setMajor(rs.getString("major"));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int insert(MemberDto dto) {
		sql = "insert into member values(?,?,?,?,?)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getTel());
			psmt.setString(4, dto.getAddr());
			psmt.setString(5, dto.getMajor());
			n = psmt.executeUpdate();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
}
