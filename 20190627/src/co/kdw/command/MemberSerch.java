package co.kdw.command;

import java.util.ArrayList;

import co.kdw.dao.StudentDao;
import co.kdw.dto.MemberDto;

public class MemberSerch {
	
	private ArrayList<MemberDto> list;
	private StudentDao dao;
	
	private void select() {
//		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
//		StudentDao dao = new StudentDao();
		
		list = new ArrayList<MemberDto>();
		dao = new StudentDao();
		list = dao.select();
		dao.close();
		memberView(list);
	}

	private void memberView(ArrayList<MemberDto> list) {
		for(MemberDto dto : list) {
			System.out.print(dto.getId() + " ");
			System.out.print(dto.getName() + " ");
			System.out.print(dto.getTel() + " ");
			System.out.print(dto.getAddr() + " ");
			System.out.println(dto.getMajor() + " ");
			
		}
	}
	
	public void run() {
		select();
	}
}
