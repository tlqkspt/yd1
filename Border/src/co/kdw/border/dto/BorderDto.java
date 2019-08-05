package co.kdw.border.dto;

public class BorderDto {
	private int bNo;
	private String writer;
	private String subject;
	private String contents;
	private String wdate;
	private int hit;
	private String fileName;
	
	public BorderDto() {
		
	}
	
	//인서트용 생성자
	public BorderDto(String writer, String subject, String contents, String file) {
		this.writer = writer;
		this.subject = subject;
		this.contents = contents;
		this.fileName = file;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	
}
