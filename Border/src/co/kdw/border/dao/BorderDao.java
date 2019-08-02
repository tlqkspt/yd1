package co.kdw.border.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import co.kdw.border.dto.BorderDto;

public class BorderDao {
	private DataSource ds = null;
	private Context context;
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private BorderDto dto;
//	private Date date;

	public BorderDao() { // DBCP 통해 데이터베이스 연결
		try {
			context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<BorderDto> select() { // 게시판 전체 목록을 가져오는것
		ArrayList<BorderDto> list = new ArrayList<BorderDto>();
		SimpleDateFormat fdate = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		String sql = "select bno, writer, subject, wdate, hit from border order by bno";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				dto = new BorderDto();
				dto.setbNo(rs.getInt(1));
				dto.setWriter(rs.getNString(2));
				dto.setSubject(rs.getString(3));
				dto.setWdate(fdate.format(rs.getTimestamp(4)));
				dto.setHit(rs.getInt(5));
				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public int insert(BorderDto dto) { // border테이블에 입력
		int n = 0;
		String sql = "insert into border(bno, writer, subject, contents) values(border_seq.nextval, ?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getWriter());
			psmt.setString(2, dto.getSubject());
			psmt.setString(3, dto.getContents());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	public int delete(int bNo) {		//게시글 삭제
		int n = 0;
		String sql = "delete from border where bno = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bNo);
			n = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}
	
	public BorderDto editSerch(int id) {	//수정을 위한select
		SimpleDateFormat fdate = new SimpleDateFormat("yyyy-MM-dd");
		String sql ="select * from border where bno = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto = new BorderDto();
				dto.setbNo(rs.getInt("bno"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContents(rs.getString("contents"));
				dto.setWdate(fdate.format(rs.getDate("wdate")));
				dto.setHit(rs.getInt("hit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	
	public BorderDto serch(int bNo) {					//한놈만 가져옴
		SimpleDateFormat fdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql ="select * from border where bno = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto = new BorderDto();
				dto.setbNo(rs.getInt("bno"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContents(rs.getString("contents"));
				dto.setWdate(fdate.format(rs.getTimestamp("wdate")));		
				///rs.getDate("wdate") 2019-08-02 ->> rs.getTimestamp("wdate") 2019-08-02 14:50:33.0  버전?차이
				//System.out.println(rs.getTimestamp("wdate"));
				dto.setHit(rs.getInt("hit"));
				hitUpdate(bNo);	//글읽으면 조회수 증가		// 여기넣으면 로드가 많이걸린다??????
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	
	public int update(BorderDto dto) {			//글내용 수정
		int n = 0;
		String sql = "update border set contents = ?, hit = 0 where bno = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getContents());
			psmt.setInt(2, dto.getbNo());
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	
	
	public void hitUpdate(int bNo) {		//조회수 1증가시키는 매서드
		String sql="update border set hit = hit + 1 where bno = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bNo);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
