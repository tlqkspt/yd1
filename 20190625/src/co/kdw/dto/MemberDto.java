package co.kdw.dto;

public class MemberDto {
	private String id;		//테이블 가지고있는 데이터 타입만맞으면됨
	private String name;
	private String tel;
	private String addr;
	private String major;
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberDto(String id, String name, String tel, String addr, String major) {
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.addr = addr;
		this.major = major;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getAddr() {
		return addr;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public String toString() {		//출력용		//수업용 현장에선 여기 안쓴다
		System.out.print(id + " ");
		System.out.print(name + " ");
		System.out.print(tel + " ");
		System.out.print(addr + " ");
		System.out.println(major + " ");
		return null;
	}
	
}
