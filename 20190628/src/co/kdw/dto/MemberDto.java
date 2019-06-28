package co.kdw.dto;

public class MemberDto {
	private String id;
	private String name;
	private String tel;
	private String addr;
	private String major;
	
	public MemberDto(){
		
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
	
	@Override
	public String toString() {
		System.out.print(id + " ");
		System.out.print(name + " ");
		System.out.print(tel + " ");
		System.out.print(addr + " ");
		System.out.println(major + " ");
		return null;
	}
}
