package co.kdw.board.impl;

import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import co.kdw.board.BoardDto;

public class BoardDAO {
	private String driver;
	private String url;
	private String user;
	private String pw;

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	BoardDto dto;

	private void init() {
		String path = "config/db.properties";
		Properties profile = new Properties();

		try {
			profile.load(new FileReader(path));
			driver = profile.getProperty("driver");
			url = profile.getProperty("url");
			user = profile.getProperty("user");
			pw = profile.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BoardDAO() {
		init();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertBoard(BoardDto board) {
		String sql = " {call write_board(?,?,?) }";
		try {
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setString(1, board.getTitle());
			cstmt.setString(2, board.getContent());
			cstmt.setString(3, board.getWriter());
			cstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getMemberInfo(String id, String pw) {
		String sql = "select id, pw, name from login_test where id =? and pw =?";
		String name = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			if (rs.next()) {
				name = rs.getString("name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return name;
	}

	public List<BoardDto> getBoardList() {
		List<BoardDto> list = new ArrayList<BoardDto>();
		String sql = "select * from board order by board_no";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BoardDto dto = new BoardDto();
				dto.setBoardNo(rs.getInt("board_No"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWriter(rs.getString("writer"));
				dto.setCreationDate(rs.getString("creation_Date"));
				dto.setParentNo(rs.getInt("parent_No"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	//한건조회
	public BoardDto getBoard(int boardNo) {
		dto = new BoardDto();
		String sql = "select * from board where board_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			rs = psmt.executeQuery();
			if (rs.next()) {
				dto.setBoardNo(rs.getInt("board_No"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWriter(rs.getString("writer"));
				dto.setCreationDate(rs.getString("creation_Date"));
				dto.setParentNo(rs.getInt("parent_No"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return dto;
	}
	
	//댓글 쓰기
	public void writeReply(BoardDto reply) {
		String sql = " {call write_reply(?,?,?) }";
		try {
			CallableStatement cstmt = conn.prepareCall(sql);
//			cstmt.setString(1, reply.getTitle());
			cstmt.setString(1, reply.getContent());
			cstmt.setString(2, reply.getWriter());
			cstmt.setInt(3, reply.getParentNo());
			cstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//댓글리스트
	public List<BoardDto> getReplyList(int boardNo){
		List<BoardDto> list = new ArrayList<BoardDto>();
		BoardDto reply;
		String sql = "select * from board where parent_no = ? ";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			rs = psmt.executeQuery();
			while(rs.next()) {
				reply = new BoardDto();
				reply.setBoardNo(rs.getInt("board_no"));
				reply.setContent(rs.getString("content"));
				reply.setWriter(rs.getString("writer"));
				reply.setParentNo(rs.getInt("parent_no"));
				list.add(reply);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void updateBoard(BoardDto board) {
		String sql = "update board set title =?, content = ? where board_no = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setInt(3, board.getBoardNo());
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteBoard(int id) {
		String sql = "delete from board where board_no = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.executeQuery();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
