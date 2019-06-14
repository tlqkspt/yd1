package yedam2.com.collection.List;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 * 학생정보 저장 프로그램(Ver.1.0)
 * 만든이 : 곽동우 (2019.06.13)
 * 최종수정일: 2019.06.13
 */

class St<S, A> {
	private S student;
	// private A

}

class Student {
	int sno;
	String name;
	String major;

	public void setStudent(int sno, String name, String major) {
		this.sno = sno;
		this.name = name;
		this.major = major;
	}

	public String getName() {
		return name;
	}

	public String getMajor() {
		return major;
	}

	public int getsno() {
		return sno;
	}

	public String toString() {
		return "학생번호: " + sno + " 학생이름: " + name + " 학생전공: " + major;
	}

}

public class CollectionExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Student> list = new LinkedList<>();

		int menu = 0; // 메뉴선택
		int sno;
		String name;
		String major;
		boolean search = false;
		boolean err = false;

		while (true) { // 프로그램시작
			System.out.println("1)저장   2)조회[학생번호]   3)삭제[학생번호]  4)종료");
			menu = sc.nextInt();

			if (menu == 1) { // 메뉴 1
				System.out.println("학생 번호: ");
				sno = sc.nextInt();

				for (Student s : list) {
					if (s.getsno() == sno) {
						System.out.println("이미 있는 학번");
						err = true; // 학번 중복 x
					}
				}
				if (!err) { // 중복아닐때
					System.out.println("학생 이름: ");
					name = sc.next();
					System.out.println("학생 전공: ");
					major = sc.next();
					Student s = new Student();
					s.setStudent(sno, name, major);
					list.add(s);
					System.out.println("저장됨");
				} else
					continue; // 중복이면 다시 처음으로
			}

			else if (menu == 2) { // 메뉴 2 조회
				System.out.println("조회 학번 입력:"); // 학번을 입력하면 입력한 학번이 있을땐 그 학생의 정보. 없을땐 "없는학생" 출력
				sno = sc.nextInt();

				// getSearch(); // 입력한 학번과 저장되있는 학번 비교
				for (Student s : list) {
					if (s.getsno() == sno) {
						System.out.println(s.toString());
						search = true;
//						System.out.println("입력성공");
					} else
						search = false;
				}
				if (!search)
					System.out.println("없는학생");
//				list.get(0).getsno();
//				if (list.contains(sno)) {
//					System.out.println(list.toString());
//				} else
//					System.out.println("없는학생");

			}

			else if (menu == 3) { // 3삭제
				System.out.println("삭제 학번 입력:"); // 학번을 입력하면 입력한 학번이 있을땐 그 학생의 정보. 없을땐 "없는학생" 출력
				sno = sc.nextInt();

				// getSearch(); // 입력한 학번과 저장되있는 학번 비교
				CollectionExample col = new CollectionExample();
				col.rmStudent(list, sno);

//				for (Student s : list) {
//					if (s.getsno() == sno) {
//						System.out.println(s.toString());
//						list.remove(s);
//						search = true;
//						System.out.println("삭제성공");
//
//					} else
//						search = false;
//				}
				if (!search)
					System.out.println("없는학생");
			}

			else
				System.out.println("--종료--");
			break;
		}

	}

	public void rmStudent(List<Student> list, int sno) {
		boolean search;
		for (Student s : list) {
			if (s.getsno() == sno) {
				System.out.println(s.toString());
				list.remove(s);
				search = true;
				System.out.println("삭제성공");

			} else
				search = false;
		}
	}
}
