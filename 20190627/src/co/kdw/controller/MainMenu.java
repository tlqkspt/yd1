package co.kdw.controller;


public class MainMenu {
	private int choice;
	private boolean sw;
	
	public void mainMenu() {
		sw = true;
		
		do {
			System.out.println("1. 학생정보 관리");
			System.out.println("2. 학생성적 관리");
			System.out.println("3. 종         료");
			System.out.println("원하는 번호를 입력하세요.");
			
			choice = KeyIn.sc.nextInt();
			KeyIn.sc.nextLine();
			switch(choice) {
				case 1:
					studentMenu();
					break;
				case 2:
					gradeMenu();
					break;
				case 3:
					System.out.println("프로그램을 종료합니다");
					sw = false;
					break;
			}
		} while(sw);
	}

	private void gradeMenu() {
		GradeMenu gm = new GradeMenu();
		gm.menu();
	}

	private void studentMenu() {
		StudentMenu st = new StudentMenu();
		st.menu();
	}
}
