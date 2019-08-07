package co.yedam.membermanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.yedam.membermanager.common.DAO;
import co.yedam.membermanager.dto.BorderDto;

public class BorderDao {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private BorderDto dto;

	public BorderDao() {
		conn = DAO.conn();
	}

	public ArrayList<BorderDto> select() { // 게시판 전체 목록을 가져오는것
		ArrayList<BorderDto> list = new ArrayList<BorderDto>();
		String sql = "select bno, writer, subject, wdate, filename, hit from border order by bno";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
				while (rs.next()) {
					dto = new BorderDto();
					dto.setNo(rs.getInt(1));
					dto.setWriter(rs.getString(2));
					dto.setSubject(rs.getString(3));
					dto.setDate((rs.getDate(4)));
					dto.setFileName(rs.getString(5));
					dto.setHit(rs.getInt(6));
					list.add(dto);
				}
				
		
//				list = null; // borderlist.jsp 에서 비교대상으로 쓸때 결과가 하나도없으면 null담아서넘김
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public int insert(BorderDto dto) { // border테이블에 입력
		int n = 0;
		String sql = "insert into border(bno, writer, subject, contents, filename, userid) values(b_seq.nextval, ?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getWriter());
			psmt.setString(2, dto.getSubject());
			psmt.setString(3, dto.getContents());
			psmt.setString(4, dto.getFileName()); // 나중에 리스트볼때도 추가되게
			psmt.setString(5, dto.getUserId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	public int delete(int no) { // 게시글 삭제
		int n = 0;
		String sql = "delete from border where bno = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			n = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	public BorderDto editSerch(int id) { // 수정을 위한select
		// SimpleDateFormat fdate = new SimpleDateFormat("yyyy-MM-dd"); //dto 날짜 date로
		// 바꿔서 필요없음
		String sql = "select * from border where bno = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				dto = new BorderDto();
				dto.setNo(rs.getInt("bno"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContents(rs.getString("contents"));
				dto.setDate((rs.getDate("wdate")));
				dto.setHit(rs.getInt("hit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}

	public BorderDto serch(int id) { // 한놈만 가져옴
		String sql = "select * from border where bno = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				dto = new BorderDto();

				dto.setNo(rs.getInt("bno"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContents(rs.getString("contents"));
				dto.setDate(rs.getDate("wdate"));
				/// rs.getDate("wdate") 2019-08-02 ->> rs.getTimestamp("wdate") 2019-08-02
				/// 14:50:33.0 버전?차이
				// System.out.println(rs.getTimestamp("wdate"));
				dto.setHit(rs.getInt("hit"));
				dto.setFileName(rs.getString("filename"));
				dto.setUserId(rs.getString("userid"));
				hitUpdate(id); // 글읽으면 조회수 증가 // 여기넣으면 로드가 많이걸린다??????
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}

	public int update(BorderDto dto) { // 글내용 수정 //제목수정 추가해야함
		int n = 0;
		String sql = "update border set contents = ?, hit = 0 where bno = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getContents());
			psmt.setInt(2, dto.getNo());
			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	public void hitUpdate(int id) { // 조회수 1증가시키는 매서드
		String sql = "update border set hit = hit + 1 where bno = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
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
