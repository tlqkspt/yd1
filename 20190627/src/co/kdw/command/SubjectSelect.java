package co.kdw.command;

import java.util.ArrayList;

import co.kdw.dao.SubjectDao;
import co.kdw.dto.SubjectDto;

public class SubjectSelect {
	private SubjectDao dao = new SubjectDao();
	private ArrayList<SubjectDto> list = new ArrayList<SubjectDto>();
	
	
	
	private void select() {
		list = dao.select();
		view();
	}
	
	private void view() {
		for(SubjectDto dto : list) {
			System.out.print(dto.getNumid() + " ");
			System.out.print(dto.getSid() + " ");
			System.out.print(dto.getSname() + " ");
			System.out.println(dto.getSgrade() + " ");
		}
		System.out.println();
	}
	
	public void run() {
		select();

	}

}
