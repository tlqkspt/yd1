package co.kdw.dto;

public class GradeDto {
	private int num;
	private String sid;
	private String sname;
	private String sgrade;
	
	public GradeDto() {
		
	}
	
	public GradeDto(int num, String id, String name, String grade) {
		this.num = num;
		this.sid = id;
		this.sname = name;
		this.sgrade = grade;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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
	
	public String toString() {
		System.out.print(num +" ");
		System.out.print(sid +" ");
		System.out.print(sname +" ");
		System.out.println(sgrade +" ");
		return null;
	}
}
