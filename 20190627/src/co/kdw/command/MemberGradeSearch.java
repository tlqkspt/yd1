package co.kdw.command;

import java.util.ArrayList;

import co.kdw.dao.SubjectDao;
import co.kdw.dto.MemberSubjectDto;

public class MemberGradeSearch {
	// - Dao
	// - Dto
	
	// - select()
	// + run()
	
	private SubjectDao dao;
	private ArrayList<MemberSubjectDto> list;
	
	private void select() {
		dao = new SubjectDao();
		list = new ArrayList<MemberSubjectDto>();
		
		list = dao.serch();
		view();
	}
	
	private void view() {
		for(MemberSubjectDto dto : list) {
			System.out.print(dto.getId() + " ");
			System.out.print(dto.getName() + " ");
			System.out.print(dto.getTel() + " ");
			System.out.print(dto.getAddr() + " ");
			System.out.print(dto.getMajor() + " ");
			System.out.print(dto.getSname() + " ");
			System.out.println(dto.getSgrade() + " ");
	
		}
	}
	
	public void run() {
		select();
	}
}
