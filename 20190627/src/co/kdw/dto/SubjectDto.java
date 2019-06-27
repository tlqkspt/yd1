package co.kdw.dto;

public class SubjectDto {		//서브젝트 테이블과 동일
	private int numid;
	private String sid;
	private String sname;
	private String sgrade;
	
	public SubjectDto() {
		// TODO Auto-generated constructor stub
	}

	public int getNumid() {
		return numid;
	}

	public void setNumid(int numid) {
		this.numid = numid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSgrade() {
		return sgrade;
	}

	public void setSgrade(String sgrade) {
		this.sgrade = sgrade;
	}
	
	
}
