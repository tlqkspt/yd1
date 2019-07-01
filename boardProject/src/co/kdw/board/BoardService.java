package co.kdw.board;

import java.util.List;

import co.kdw.board.impl.BoardDAO;

public interface BoardService {
	
	//id,pw 입력 사람의 로그인 정보를 확인. //
	public String checkLogin(String id, String pw);

	//게시판 작성. //
	public void writeBoard(BoardDto board);

	//게시글에 답글작성 //
	public void writeReply(BoardDto board);
	
	//글 수정.//
	public void updateBoard(BoardDto board);

	//전체 게시판 조회. //
	public List<BoardDto> getBoardList();

	//한건 조회.. 이글에 댓글작성. //
	public BoardDto getBoard(int boardNo);
	
	//한건 작성글에 대해 댓글리스트.//
	public List<BoardDto> getReplyList(int boardNo);
	
	default void deleteBoard(int boardNo) {
		BoardDAO dao = new BoardDAO();
		dao.deleteBoard(boardNo);
	}
	
}
