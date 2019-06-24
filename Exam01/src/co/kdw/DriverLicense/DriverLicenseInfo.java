package co.kdw.DriverLicense;

public class DriverLicenseInfo {
	private String dId;
	private String dName;
	private String dAddr;
	private String dType;
	private String dDate;
	private String dExDate;
	public DriverLicenseInfo[] dLList; //= new DriverLicenseInfo[9]; //체크ㅡㅡ
	
	         
	
	public DriverLicenseInfo() {	}
	
	public DriverLicenseInfo(String dId, String dName, String dAddr, String dType, String dDate, String dExDate) {
		this.dId = dId;
		this.dName = dName;
		this.dAddr = dAddr;
		this.dType = dType;
		this.dDate = dDate;
		this.dExDate = dExDate;
	}
	
	public void showInfo() {
		System.out.println("고유번호: "+dId);
		System.out.println("성 명: "+dName);
		System.out.println("지 역: "+dAddr);
		System.out.println("종 목: "+dType);
		System.out.println("발급일자: "+dDate);
		System.out.println("유효기간: "+dExDate);
	}
	public String getdId() {
		return dId;
	}
	public void setdId(String dId) {
		this.dId = dId;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getdAddr() {
		return dAddr;
	}
	public void setdAddr(String dAddr) {
		this.dAddr = dAddr;
	}
	public String getdType() {
		return dType;
	}
	public void setdType(String dType) {
		this.dType = dType;
	}
	public String getdDate() {
		return dDate;
	}
	public void setdDate(String dDate) {
		this.dDate = dDate;
	}
	public String getdExDate() {
		return dExDate;
	}
	public void setdExDate(String dExDate) {
		this.dExDate = dExDate;
	}
	
	
}
