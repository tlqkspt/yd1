package yedam2.com.collection.Map;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HashtableExample {
	public static void main(String[] args) {
		Map<String, String> map = new Hashtable<>();
		map.put("spring","11");
		map.put("summer", "111");
		map.put("fall", "1111");
		map.put("winter", "11111");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("아이디와 비밀번호를 입력하세요.");
			System.out.println("아이디: ");
			String id = sc.nextLine();	// scanner 읽은 값을 id에 대입
			System.out.println("비밀번호: ");
			String pw = sc.nextLine();
			System.out.println();
			
			if(map.containsKey(id)) {
				if(map.get(id).equals(pw)) {
					System.out.println("로그인 되었습니다.");
					break;
				}
				else
					System.out.println("비밀번호가 일치하지 않습니다.");
			}else {
				System.out.println("입력하신 아이디 존재하지않습니다.");
			}
		}
		System.out.println("end of program");
	}
}
