package home;

import java.util.Scanner;

public class IFMEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		InterfaceMan[] m = new InterfaceMan[10];
		InterfaceMan[] e = new InterfaceMan[20];
		InterfaceMan[] t = new InterfaceMan[2];
		String name, sNum;
		int menu = 0;

		while (true) {// 루틴
			System.out.println("1)입력 2)조회 3)종료");
			menu = sc.nextInt();
			if (menu == 1) {
				System.out.println("입력할 클래스: 1)영어 2)수학");
				menu = sc.nextInt();
				if (menu == 1) { ///입력
					System.out.println("1)영어담임 2)영어학생");
					menu = sc.nextInt();

					if (menu == 1) {// 영어담임 입력
						System.out.println("영어담임 입력: ");
						name = sc.next();
						IFEnglish tn = new IFEnglish();
						tn.setTeacher(name); // 담임이름입력
						setInfo(tn, t);
					}

					if (menu == 2) { // 영어학생 정보
						System.out.println("e학생 입력: ");
						name = sc.next();
						System.out.println("e학번 입력: ");
						sNum = sc.next();
						IFEnglish es = new IFEnglish(name, sNum); //

						setInfo(es, e);
					}
					
				}
				menu =0;
			}
				if (menu == 2) { ///조회
					System.out.println("1)ALL조회 2)영어조회 3)수학조회");
					menu = sc.nextInt();
					if(menu ==1) {
//						for (int i = 0; i < t.length; i++) {
//							if (t != null) {
//								t[i].getInfo();							
//							}
//						}
						for (int i = 0; i < m.length; i++) {
							if (m != null) {
								m[i].getInfoSt();							
							}
						}
						for (int i = 0; i < e.length; i++) {
							if (e != null) {
								e[i].getInfoSt();							
							}
						}
						
					}
					menu =0;
				}
				
					
				
			}
		}
	

	static void setInfo(InterfaceMan man, InterfaceMan[] ary) {
		for (int i = 0; i < ary.length; i++) {
			if (ary[i] == null) {
				ary[i] = man;
				break;
			}
		}
	}
}