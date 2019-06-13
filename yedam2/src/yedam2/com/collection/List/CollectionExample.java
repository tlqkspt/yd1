package yedam2.com.collection.List;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 * 학생정보 저장 프로그램(Ver.1.0)
 * 만든이 : 곽동우 (2019.06.13)
 * 최종수정일: 2019.06.13
 */

class Student{
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
		return sno+","+ name+","+ major;
	}
	
}

public class CollectionExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Student> list = new LinkedList<>();
	
		int menu = 0;  //메뉴선택
		int sno;
		String name;
		String major;
		
		while(true) { //프로그램시작
			System.out.println("1)저장   2)조회(학생번호)   3)삭제(학생번호)");
			menu = sc.nextInt();
			
			if(menu == 1) {	//메뉴 1
				System.out.println("학생 번호: ");
				sno = sc.nextInt();
				System.out.println("학생 이름: ");
				name = sc.next();
				System.out.println("학생 전공: ");
				major = sc.next();
				Student s = new Student();
				list.add(s);
			}
			
			else if(menu ==2) {	//메뉴 2 조회
				System.out.println("학번 입력:");		//학번을 입력하면 입력한 학번이 있을땐 그 학생의 정보. 없을땐 "없는학생" 출력
				sno = sc.nextInt();
				if(((Student) list).getsno() == sno){
						System.out.println(list.toString());	
				}
				else
					System.out.println("없는학생");
				
				
			}
		}
		
	}
}
