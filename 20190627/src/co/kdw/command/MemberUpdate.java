package co.kdw.command;

import co.kdw.controller.KeyIn;
import co.kdw.dao.StudentDao;
import co.kdw.dto.MemberDto;

public class MemberUpdate {
	private StudentDao dao = new StudentDao();
	private MemberDto dto;
	
	private void input() {
		dto = new MemberDto();
		System.out.println("변경할 학생 학번");
		dto.setId(KeyIn.sc.next());
		System.out.println("변경할 이름");
		dto.setName(KeyIn.sc.next());
		System.out.println("변경할 전화번호");
		dto.setTel(KeyIn.sc.next());
		System.out.println("변경할 주소");
		dto.setAddr(KeyIn.sc.next());
		System.out.println("변경할 전공");
		dto.setMajor(KeyIn.sc.next());
	}
	
	private void update() {
		
		input();
		System.out.println("dfsdf");
		if(dao.update(dto) != 0)
			System.out.println("데이터 변경 성공");
		else
			System.out.println("데이터 변경 실패!!!");
		dao.close();
	}
	
	public void run() {
		MemberSerch ms = new MemberSerch();
		ms.run();
		update();
		ms.run();
	}
	
}
