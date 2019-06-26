package co.kdw.command;

import java.util.ArrayList;
import java.util.Scanner;

import co.kdw.dao.Dao;
import co.kdw.dto.MemberDto;

public class InsertCommand {
	private MemberDto dto;
	private Dao dao;
	private ArrayList<MemberDto> list;
	
	private void input() {
		Scanner sc = new Scanner(System.in);
		dto = new MemberDto();
		System.out.println("아이디를 입력하세요:");
		dto.setId(sc.nextLine());
		
		System.out.println("이름을 입력하세요:");
		dto.setName(sc.nextLine());
		
		System.out.println("전화번호를 입력하세요:");
		dto.setTel(sc.nextLine());
		
		System.out.println("주소를 입력하세요:");
		dto.setAddr(sc.nextLine());
		
		System.out.println("전공을 입력하세요:");
		dto.setMajor(sc.nextLine());
		sc.close();
	}
	
	private void process() {
		input();
		dao = new Dao();
		list = new ArrayList<MemberDto>();
		if(dao.insert(dto) != 0 ) {
			System.out.println("정상입력");
			list = dao.select();
			for(MemberDto l : list) {	///////////중요  for each 문 arraylist
				l.toString();			////////////
			}
		}else {
			System.out.println("입력실패!!!!!");
		}
		dao.close();
	}
	
	public void run() {		//얘밖에 안보임   //다른사람이 쓸때 매서드 순서 몰라도됨
		process();
	}
}
