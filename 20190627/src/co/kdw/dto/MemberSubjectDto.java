package co.kdw.dto;

public class MemberSubjectDto extends MemberDto{
	
	private String sname;
	private String sgrade;
	
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
