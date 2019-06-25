package co.kdw.dao;

import java.util.ArrayList;

import co.kdw.dto.MemberDto;

public class MainApp {
	public static void main(String[] args) {
		Dao dao = new Dao();
//		MemberDto dto = new MemberDto("20180106","김치국","010-4444-4444","경상남도","전기공학");

		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		list = dao.select();
		for (MemberDto rs : list) { // for each 문 향상된for문
			rs.toString();
		}
//		if(dao.delete("20180101") != 0) {		// 체크부위 반드시 들어가야함
//			System.out.println("정상적으로 삭제 되었다.");
//		} else {
//			System.out.println("삭제 실패!!!!");
//		}

//		String sql = "update member set name = '박길자', tel = '010-1111-3333' where id = '20180102'";
		
		MemberDto dto = new MemberDto("20180106","김치국","010-4444-4444","제주도","기계공학");
		if (dao.update(dto) != 0) {
			System.out.println("정상적으로 변경");
		} else {
			System.out.println("변경 실패!!!!");
		}
		dao.close();
	}
}
