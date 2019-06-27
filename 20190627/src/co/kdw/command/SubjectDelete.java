package co.kdw.command;

import co.kdw.controller.KeyIn;
import co.kdw.dao.SubjectDao;
import co.kdw.dto.SubjectDto;

public class SubjectDelete {
	private SubjectDao dao = new SubjectDao();
	private SubjectDto dto;
	
	private void input() {
		dto = new SubjectDto();
		System.out.println("삭제할 번호");
		dto.setNumid(KeyIn.sc.nextInt());
	}
	
	private void delete() {
		input();
		dao.delete(dto);
	}
	
	public void run() {
		SubjectSelect ss = new SubjectSelect();
		ss.run();
		delete();
		ss.run();
	}
}
