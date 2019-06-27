package co.kdw.command;

import co.kdw.controller.KeyIn;
import co.kdw.dao.StudentDao;
import co.kdw.dto.MemberDto;

public class MemberDelete {
	private MemberDto dto;
	private StudentDao dao = new StudentDao();
	
	private void input() {
		dto = new MemberDto();
		System.out.println("삭제할 학생번호");
		dto.setId(KeyIn.sc.next());
	}
	
	private void delete() {
		input();
		if(dao.delete(dto) != 0)
			System.out.println("삭제 성공");
		else
			System.out.println("삭제 실패!!!!!");
		
	}
	
	public void run() {
		delete();
	}
	
	
}
