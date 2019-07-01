package co.kdw.board.impl;

import java.util.List;

import co.kdw.board.BoardDto;
import co.kdw.board.BoardService;

public class BoardServiceImpl implements BoardService{

	BoardDAO dao = new BoardDAO();
	
	@Override
	public String checkLogin(String id, String pw) {
		
		return dao.getMemberInfo(id, pw);
	}

	@Override
	public void writeBoard(BoardDto board) {
		dao.insertBoard(board);
		
	}

	@Override
	public void writeReply(BoardDto board) {
		dao.writeReply(board);
	}

	@Override
	public void updateBoard(BoardDto board) {
		dao.updateBoard(board);
	}

	@Override
	public List<BoardDto> getBoardList() {
		// TODO Auto-generated method stub
		return dao.getBoardList();
	}

	@Override
	public BoardDto getBoard(int boardNo) {
		return dao.getBoard(boardNo);
	}

	@Override
	public List<BoardDto> getReplyList(int boardNo) {
		return dao.getReplyList(boardNo);
	}
}
