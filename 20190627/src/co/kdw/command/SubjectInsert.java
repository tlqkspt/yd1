package co.kdw.command;

import co.kdw.controller.KeyIn;
import co.kdw.dao.SubjectDao;
import co.kdw.dto.SubjectDto;

public class SubjectInsert {
	private SubjectDao dao = new SubjectDao();
	private SubjectDto dto;
	
	private void input() {
		dto = new SubjectDto();
		System.out.println("====== 입  력 ======");
		System.out.println("numid 를 입력하세요");
		dto.setNumid(KeyIn.sc.nextInt());
		System.out.println("학번을 입력하세요");
		dto.setSid(KeyIn.sc.next());
		System.out.println("과목명을 입력하세요");
		dto.setSname(KeyIn.sc.next());
		System.out.println("점수 를 입력하세요");
		dto.setSgrade(KeyIn.sc.next());
	}
	
	private void insert() {
		input();
		if(dao.insert(dto) != 0)
			System.out.println("정상입력 되었습니다.");
		else
			System.out.println("입력 실패!!!!!!!!");
	}
	
	public void run() {
		insert();
	}
}
