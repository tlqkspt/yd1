package co.kdw.controller;

import co.kdw.command.MemberDelete;
import co.kdw.command.MemberInsert;
import co.kdw.command.MemberSerch;
import co.kdw.command.MemberUpdate;

public class StudentMenu {
	private int choice;
	private boolean sw = true;
	
	public void menu() {
		do {
			System.out.println("1. 입 력");
			System.out.println("2. 삭 제");
			System.out.println("3. 조 회");
			System.out.println("4. 수 정");
			System.out.println("5. 돌아가기");
			System.out.println("==========");
			System.out.println("원하는 작업번호 입력하세요? ");
			choice = KeyIn.sc.nextInt();	//Scanner 객체를 Static 해서 원하는 곳에서 사용
			
			KeyIn.sc.nextLine();
			
			switch (choice) {
			case 1 :
				insert();
				break;
			case 2 :
				delete();
				break;
			case 3 :
				select();
				break;
			case 4 :
				update();
				break;
			case 5:
				System.out.println("메인메뉴로 돌아갑니다.");
				sw = false;
				break;
			}
			
		} while(sw);
	}
	
	/*
	 * Connmand 를 연결하는 부분
	 */
	private void update() {
		//수행할 command
		MemberUpdate up = new MemberUpdate();
		up.run();
		
	}

	private void select() {
		MemberSerch ms = new MemberSerch();
		ms.run();
	}

	private void delete() {
		MemberDelete del = new MemberDelete();
		del.run();
	}

	private void insert() {
		MemberInsert in = new MemberInsert();
		in.run();
	}
}
