package quest;

import java.util.Calendar;
import java.util.Scanner;

public class CalenderExample {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		// System.out.println(cal.get(Calendar.YEAR));
		// System.out.println((cal.get(Calendar.MONTH)+1)+"월 이번달");
		// System.out.println(cal.get(Calendar.DAY_OF_MONTH)+"오늘");
		// System.out.println(cal.get(Calendar.DAY_OF_WEEK)); //요일 일 월 화 수 목 금 토

//		System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH)); //달 마지막
		// 년, 월,
//		cal.set(Calendar.DAY_OF_MONTH, 1);
//		System.out.println(cal.get(Calendar.DAY_OF_MONTH)); // 달 시작일
//		System.out.println(cal.get(Calendar.DAY_OF_WEEK)); // 달 시작일의 요일

		// cal.getActualMaximum(Calendar.DAY_OF_MONTH)

		// calendarShow(2019,7);

		// if(firstDofW > 1)

		Scanner sc = new Scanner(System.in);

		// 년 월 입력

		int year;
		int month;
		int firstDofW; // 월 시작날의 요일
		int lastDay; // 마지막날

		while (true) {
			try {
				System.out.println("년도 입력: ");
				try {
					year = sc.nextInt();
					System.out.println("월 입력: ");
					month = sc.nextInt();
					
					if (year >= 2999)
						throw new Exception("3000 미만 입력바람");
					else if ( !(1 <= month && month <= 12) )
						throw new Exception("1~12까지 입력");
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
					continue;
				}
				
				int translateMonth = month -1;    // -1 왜 해주냐 월 0~11 까지?

				cal.set(Calendar.YEAR, year);
				cal.set(Calendar.MONTH, translateMonth);
				cal.set(Calendar.DAY_OF_MONTH, 1); // 오늘 1일

				firstDofW = cal.get(Calendar.DAY_OF_WEEK); // 일월화수목금토firstDofW -1 만큼 뒤에서 뿌려줌

				lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 달마지막

				int fDofW = firstDofW;
//			System.out.println(firstDofW + "요일");
//		System.out.println(cal.get(Calendar.YEAR));				//년도체크
//		System.out.println((cal.get(Calendar.MONTH)+1)+"월");	//월체크

				System.out.printf("     %d년  %d월%n", cal.get(Calendar.YEAR), (cal.get(Calendar.MONTH) + 1));
				System.out.println("=====================");
				System.out.println("  일   월   화  수   목  금   토");
				for (int i = 1; i <= lastDay + (firstDofW - 1); i++) {  // 입력한 달의 마지막날 + 월 을 시작하는 날의 요일(1=일,2=월,3=화,....)
																		// 만큼 반복
					if (fDofW > 1) { 									// 월 시작요일-1 만큼 (시작일이 수요일이면 4-1 = 3) 반복해서 공백출력
						System.out.printf("%3s", ""); 					// 월 시작요일 을 증감연산자 써서 감소
						fDofW--;
					} else { // 위 조건 끝나면
						System.out.printf("%3d", i - (firstDofW - 1)); // 반복문 i 이용해서 i - (월시작요일-1) 출력
						if (i % 7 == 0)
							System.out.println();
					}
				}
				System.out.println();
				System.out.println("=====================");

			} catch (Exception e) {
				System.out.println("오류발생");
				e.printStackTrace();
				sc.nextLine();
				// System.out.println("caught exception while doing whatever"+ e);
				// System.out.println("MainLogger.Run.Exception"+ e);
			}
		}
	}
}
