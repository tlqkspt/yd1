package co.kdw.board.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.kdw.board.BoardDto;
import co.kdw.board.BoardService;
import co.kdw.board.impl.BoardServiceImpl;

public class BoardProc {
	Scanner sc = new Scanner(System.in);
	String id, pw, name, parentNo;
	BoardServiceImpl service = new BoardServiceImpl();
	List<BoardDto> list;
	BoardDto board;

	public void execute() {
		checkLogin();

		while (true) {
			System.out.println("메뉴를 선택하세요 1.입력 2.수정 3.삭제 4.조회 5.리스트 9.종료");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				writeBoard();
				break;
			case 2:
				getBoardList();
				updateBoard();
				break;
			case 3:
				getBoardList();
				deleteBoard();
				break;
			case 4:
				getBoard();
				writeReply(board);
				break;
			case 5:
				getBoardList();
				break;
			case 9:

				break;

			}
			if (menu == 9) {
				System.out.println("종료");
				break;
			}
		}
	}

	// 글쓰기
	public void writeBoard() {
		System.out.println("제목입력: ");
		String title = sc.nextLine();
		System.out.println("내용입력: ");
		String content = sc.nextLine();
//		System.out.println("작성자: ");
//		String writer = sc.nextLine();
		BoardDto board = new BoardDto(title, content, id);
		service.writeBoard(board);
		System.out.println("입력됨");
	}

	// 로그인확인
	public void checkLogin() {
		while (true) {
			System.out.println("id 입력:");
			id = sc.nextLine();
			System.out.println("pw 입력:");
			pw = sc.nextLine();
			name = service.checkLogin(id, pw);
			if (name == null || name.equals(" "))
				System.out.println("로그인 실패.");
			else {
				System.out.println(name + "님 환영합니다.");
				break;
			}
		}
	}

	// 전체 게시판 조회
	public void getBoardList() {
		list = new ArrayList<BoardDto>();
		System.out.println("전체 게시판");
		System.out.println("==========================================================================================");
//		System.out.println("번호    제목      내용      작성자     작성일시      댓글");
		System.out.println(
				" 번호 |   제목    |   내용    |  작성자 |      작성일시          |    댓글위치 ");
		list = service.getBoardList();
		list.toString();
//		for(BoardDto dto : list) {
//			System.out.println(dto.getBoardNo());
//			System.out.println(dto.getContent());
//			System.out.println(dto.getWriter());
//			System.out.println(dto.getParentNo());
//		}

	}

	// 단건조회 & 댓글
	public void getBoard() {
		board = new BoardDto();
		int boardNum = 0;

		getBoardList();
		System.out.println("조회할 게시글 번호입력:");
		boardNum = sc.nextInt();
		sc.nextLine();

		board = service.getBoard(boardNum);

		System.out.println("-------[원본글]-------");
		System.out.println("No:" + board.getBoardNo());
		System.out.println("제목:" + board.getTitle());
		System.out.println("내용:" + board.getContent());
		System.out.println("작성자:" + board.getWriter());
		System.out.println("작성일:" + board.getCreationDate());

		getReplyList(board.getBoardNo());

//		writeReply(board);
	}

	// 댓글쓰기
	public void writeReply(BoardDto board) {
		System.out.println("댓글달것? y/n ");
		String replyChoice = sc.nextLine();
		if (replyChoice.equals("y")) {
			BoardDto reply = new BoardDto();
			reply.setParentNo(board.getBoardNo());
			reply.setWriter(id);
			System.out.println("댓글 내용:");
			String replyContents = sc.nextLine();
			reply.setContent(replyContents);
			service.writeReply(reply);
		} else
			System.out.println("=====");
	}

	// 댓글리스트
	public void getReplyList(int boardNo) {
		list = new ArrayList<BoardDto>();

		list = service.getReplyList(boardNo);
		System.out.println("------[댓글]------");
		if (!(list.isEmpty())) {
			for (BoardDto dto : list) {
				System.out.println(
						dto.getBoardNo() + "  " + dto.getContent() + "  " + dto.getWriter() + "  " + dto.getParentNo());
			}
		} else
			System.out.println("[댓글없음]");

	}

	// 수정
	public void updateBoard() {
		BoardDto board = new BoardDto();
		String title;

		System.out.println("수정할 게시글번호:");
		int boardNo = sc.nextInt();
		sc.nextLine();
		board.setBoardNo(boardNo);

		board = service.getBoard(boardNo);
		// System.out.println(board.getTitle());

		System.out.println("제목:" + board.getTitle());
		System.out.println("내용:" + board.getContent());
		
		if (board.getWriter().equals(id)) {
			System.out.println("수정할 제목 (같은제목 쓰려면 [스페이스+엔터]):");
			title = sc.nextLine();

			if (title.equals(" ")) // 왜 엔터누르면 안됨?
				title = board.getTitle();
			else
				board.setTitle(title);

			System.out.println("내용:");
			board.setContent(sc.nextLine());

			service.updateBoard(board);
		}else {
			System.out.println("=============");
			System.out.println("수정실패!!");
			System.out.println("작성자가 아닙니다!");
		}
	}
	
	public void deleteBoard() {
		System.out.println("삭제할 게시글 번호입력");
		int boardNum = sc.nextInt(); sc.nextLine();
		
		board = service.getBoard(boardNum);
	
		if(id.equals(board.getWriter())) {
			service.deleteBoard(boardNum);
			System.out.println("삭제성공");
		}
		else {
			System.out.println("삭제실패!!!!");
			System.out.println("작성자만 삭제가능!!");
		}
	}

}
