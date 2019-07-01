package co.kdw.board;

import javax.swing.border.Border;

public class BoardDto {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private String creationDate;
	private int parentNo;
	
	public BoardDto(int boardNo, String title, String content, String writer, String creationDate, int parentNo) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.creationDate = creationDate;
		this.parentNo = parentNo;
	}

	public BoardDto(String title, String content, String writer) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public BoardDto() {
		// TODO Auto-generated constructor stub
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public int getParentNo() {
		return parentNo;
	}

	public void setParentNo(int parentNo) {
		this.parentNo = parentNo;
	}

	@Override
	public String toString() {
//		int length =0; 
//		if(content != null) {
//			length = content.length();
//		}else
//			length = 0;
//		System.out.println("내용길이" + length);
		
		System.out.printf(" %2d | %.5s  |  %.8s  | %3s|  %10s |  %3d %n",boardNo,title,content,writer,creationDate,parentNo);
		return null;
	}
	
	public void replyPrint() {
		System.out.println("==> "+boardNo+ "  "+ content+ "  "+ writer + "  "+ parentNo);
	}
	
}
