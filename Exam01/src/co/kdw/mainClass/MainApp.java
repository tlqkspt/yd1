package co.kdw.mainClass;

import co.kdw.student.StudentInfo;

public class MainApp {

	public static void main(String[] args) {  // String[] args 어떤 아규먼트 전달할건가
//		GuguDan gu = new GuguDan();
//		gu.guguDan();
		
		StudentInfo st = new StudentInfo("2019001", "홍길동", "대구광역시", "전산공학");
		st.show();
		st.sTel = "053-555-5555";
		System.out.println(st.sTel);
		System.out.println(st.getsAddr());
		
		System.out.println("=====================");
		
		StudentInfo st1 = new StudentInfo();
		st1.setSId("2019002");
		st1.setsName("김치국");
		st1.setsAddr("서울");
		st1.setsMajor("산업공학");
		st1.show();
		st1.sTel = "02-111-1111";
		System.out.println(st1.sTel);
		System.out.println(st1.getsName());
		st1.showGuguDan();
	}
}
