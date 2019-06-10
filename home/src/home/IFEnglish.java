package home;

public class IFEnglish implements InterfaceMan {

	String sName, teacher, sNum;

	IFEnglish() {
	}

	IFEnglish(String sName, String sNum) {
		this.sName = sName;
		this.sNum = sNum;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public void getInfoSt() {
		System.out.println("학생: " + sName + "학번: " + sNum);
	}
	
	public void getInfoTe() {
		System.out.println("영어담임: " + teacher );
	}
}