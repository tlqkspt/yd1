package co.kdw.command;

import co.kdw.controller.KeyIn;
import co.kdw.dao.StudentDao;
import co.kdw.dto.MemberDto;

public class MemberInsert {
	private MemberDto dto;
	private StudentDao dao = new StudentDao();
	
	private void input() {
		dto = new MemberDto();
		System.out.println("====== 입  력 ======");
		System.out.println("아이디를 입력하세요");
		dto.setId(KeyIn.sc.next());
		System.out.println("이름을 입력하세요");
		dto.setName(KeyIn.sc.next());
		System.out.println("전화번호를 입력하세요");
		dto.setTel(KeyIn.sc.next());
		System.out.println("주소를 입력하세요");
		dto.setAddr(KeyIn.sc.next());
		System.out.println("전공학과를 입력하세요");
		dto.setMajor(KeyIn.sc.next());
	}
	
	private void insert() {
		input();
		dao.insert(dto);
	}
	
	public void run() {
		insert();
	}
}
