package co.kdw.student;

import co.kdw.gugudan.GuguDan;

public class StudentInfo {
	
	private String sId;
	private String sName;
	private String sAddr;
	private String sMajor;
	
	private GuguDan gu;	//GuguDan Class를 멤버 변수로 사용하는 예시
	
	public String sTel;
	
	public StudentInfo() {
		
	}
	
	public StudentInfo(String id, String name, String addr, String major){
		this.sId = id;
		this.sName = name;
		this.sAddr = addr;
		this.sMajor = major;
	}
	
	public void show() {
		System.out.println("학번 : " + sId);
		System.out.println("성명 : " + sName);
		System.out.println("주소 : " + sAddr);
		System.out.println("전공 : " + sMajor);
	}
	
	public void showGuguDan() {
		gu = new GuguDan();   //Class 초기화
		gu.guguDan();
	}
	
	public void setSId(String id) {
		this.sId = id;
	}
	public String getSId() {
		return sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsAddr() {
		return sAddr;
	}

	public void setsAddr(String sAddr) {
		this.sAddr = sAddr;
	}

	public String getsMajor() {
		return sMajor;
	}

	public void setsMajor(String sMajor) {
		this.sMajor = sMajor;
	}
	
}
