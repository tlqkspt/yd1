package co.kdw.controller;

import co.kdw.command.MemberGradeSearch;
import co.kdw.command.SubjectDelete;
import co.kdw.command.SubjectInsert;
import co.kdw.command.SubjectSelect;
import co.kdw.command.SubjectUpdate;

public class GradeMenu {
	private int choice;
	private boolean sw = true;
	
	public void menu() {
		do {
			System.out.println("1. 입 력");
			System.out.println("2. 삭 제");
			System.out.println("3. 조 회");
			System.out.println("4. 수 정");
			System.out.println("5. 성적확인");
			System.out.println("6. 돌아가기");
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
				search();
				break;
			case 6:
				System.out.println("메인메뉴로 돌아갑니다.");
				sw = false;
				break;
			}
			
		} while(sw);
	}

/*
 * Command를 연결하는 부분
 */
	private void select() {
		SubjectSelect ss = new SubjectSelect();
		ss.run();
	}
	
	private void update() {
		//다르게
		SubjectUpdate up = new SubjectUpdate();
		up.run();
	}

	private void delete() {
		SubjectDelete del = new SubjectDelete();
		del.run();
	}

	private void insert() {
		//처음할일 :dao 확인 존재하지않으면 Dao에 insert()추가
		//Dto 확인
		//command 만들고
		//여기다 command연결
		
		SubjectInsert in = new SubjectInsert();
		in.run();
	}

	private void search() {
		//MemberSubjectDto 이용 구현
		MemberGradeSearch mgs = new MemberGradeSearch();
		mgs.run();
	}
}
