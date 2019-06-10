package home.JungSuk;

public class ExCh4 {
	public static void main(String[] args) {

//		//4-1
//		// 1
//		int x =11;
//		if(10<x && x<20) System.out.println("true");
		//
//		// 2
//		char ch = 'a';	
//		if(!(ch==' ' || ch == '\t')) System.out.println("true");
		//
//		// 3	
//		if(ch == 'x' || ch == 'X') System.out.println("true");
		//
//		//4	
//		if('0'<=ch && ch <= '9')System.out.println("true");
		//
//		//5
//		if('A'<=ch && ch <='Z' || 'a'<=ch && ch<='z') System.out.println("true");
		//
//		//6
//		int year = 2004;
//		if(year%400 == 0 || year%4==0 && year%100 != 0 ) System.out.println("true");
		//
//		//7
//		boolean powerOn = false;
//		if(powerOn == false) System.out.println("true");
		//
//		//8
//		String str = "yes";
//		if(str == "yes") System.out.println("true");
		//
//		//********2
		//
//		int num = 1;
//		int sum =0;
		//
//		while(num<=20) {
//			if(!(num%2 == 0 || num%3 == 0)) { sum += num ; System.out.println(num); }
//			
//			num++;
//		}
//		System.out.println(sum);
		//
		//
		// ******3
//			int num = 0, sum = 0;
		//
//			for (int i = 1; i <= 10; i++) {
//				sum += i;
//				num += sum;
//				System.out.println(sum);
//			}
//			System.out.println(num);

//			// ***********4
//			int num =1;
//			int sum =0;
//			
//			while(sum<100) {
//				if(num%2 ==0) {
//					sum -= num;
//				}
//				if(num%2 !=0) sum += num;
//				
//				
//				System.out.println(num);
//				System.out.println(sum);
//				System.out.println();
//				
//				num++;
//			}
//			
		// *****************5
//			for(int i=0; i<=10; i++) {
//				for(int j=0; j<=i; j++)
//				System.out.print("*");
//				System.out.println();
//			}
//			

//			int num =1;
//			int star = 0;
//			while(num <= 11) {
//				while(star < num) {
//					System.out.print("*");
//					star++;
//				}
//				System.out.println();
//				num++;
//				star =0;
//			}

//			//**********6
//			int dice1 =0;
//			int dice2 =0;
//			
//			for(int i=0; i<6; i++) {
//				for(int j=0; j<6; j++) {
//					if(i+j == 6) {
//						System.out.println("주사위1: "+i+" 주사위2: "+j);
//					}
//				}
//			}

//			//*********7
//			int value = (int)(Math.random()*6)+1;
//			System.out.println(value);

//			//*********8
//			for(int x=0;x<=10;x++) {
//				for(int y=0; y<=10; y++) {
//					if((2*x+4*y)==10) {
//						System.out.println("x= "+x+" y= "+y);
//					}
//				}
//			}

//			//********9
//			String str = "12345";
//			int sum = 0;
//			for(int i=0; i < str.length(); i++) {
//				sum+=(str.charAt(i)-48);
//			}
//			System.out.println("sum="+sum);

//		// *******10
//		int num = 12345;
//		int sum = 0;
//		int a = 10;
//		for (int i = 1; i <= 5; i++) { // num을 10,100,1000,10000 으로 나눠서 나머지를 더함
//			
//			if (i == 1) {
//				sum += num % (a);
//				System.out.println("i=1  " + sum);
//			} else if (i != 1) {
//
//				sum += (num % (a) / (a/10));
//				System.out.println("i=" + i + " " + sum);
//			}
//			a = a*10;
//		}
//		System.out.println("sum=" + sum);

//		// **********11
//		// 피보나치 수열
//		// Fibonnaci 수열의 시작의 첫 두 숫자를 1, 1로 한다.
//		int num1 = 1;
//		int num2 = 1;
//		int num3 = 0; // 세번째 값
//		System.out.print(num1 + "," + num2);
//		for (int i = 0; i < 8; i++) {
//			num1 = num2;
//			if (num3 != 0)
//				num2 = num3;
//			num3 = num1 + num2;
//			System.out.print("," + num3);

//		// **********12
//		// 구구단
//		int counter = 0;
//		for (int i = 1; i <= 3; i++) { // j * i
//			for (int j = 2; j <= 4; j++) {// j단
//					System.out.printf("%d*%d=%-2d ",j,i,j*i);
//			}
//			System.out.println();
//		}
//		System.out.println();
//		
//		for (int i = 1; i <= 3; i++) { // j * i
//			for (int j = 5; j <= 7; j++) {// j단
//				System.out.printf("%d*%d=%-2d ",j,i,j*i);
//			}
//			System.out.println();
//		}
//		System.out.println();
//		
//		for (int i = 1; i <= 3; i++) { // j * i
//			for (int j = 8; j <= 9; j++) {// j단
//				System.out.printf("%d*%d=%-2d ",j,i,j*i);
//			}
//			System.out.println();
//		}
//		System.out.println();

		// ************13
		// 숫자판별
//		String value = "125++34";
//		char ch = ' ';
//		boolean isNumber = true;
		// 반복문과 charAt(int i)를 이용해서 문자열의 문자를
		// 하나씩 읽어서 검사한다.
		// charAt(int i)
//		for(int i=0; i < value.length() ;i++) {
//			ch = value.charAt(i);
//			if(!('1'<= ch && ch <= '9')) {
//				System.out.println(ch);
//				isNumber = false;
//			}
//		}
//		if (isNumber) {
//		System.out.println(value+"는 숫자입니다.");
//		} else {
//		System.out.println(value+"는 숫자가 아닙니다.");
//		}

		// ************14
		// 숫자맞추기 게임
		// 1~100값 반복적 으로 입력해서 컴퓨터가 생각한값을 맞추면 끝

		// 1~100사이의 임의의 값을 얻어서 answer에 저장한다.
		
//		int answer = (int) (Math.random() * 100) + 1;
//		int input = 0; // 사용자입력을 저장할 공간
//		int count = 0; // 시도횟수를 세기위한 변수
//		// 화면으로 부터 사용자입력을 받기 위해서 Scanner클래스 사용
//		java.util.Scanner s = new java.util.Scanner(System.in);
//
//		do {
//			count++;
//			System.out.print("1과 100사이의 값을 입력하세요 :");
//			input = s.nextInt(); // 입력받은 값을 변수 input에 저장한다.
//			if (input == answer) {
//				System.out.println("맞췄습니다.");
//				System.out.println("시도횟수는 " + count + "번 입니다.");
//				break;
//			} else if (input != answer) {
//				if (input < answer)
//					System.out.println("더 큰 수를 입력하세요.");
//				if (input > answer)
//					System.out.println("더 작은 수를 입력하세요.");
//			}
//		} while (true); // 무한반복문
		
		//**************15
		//회문수를 구하는 프로그램  회문수 = 숫자를 거꾸로 읽어도 앞으로 읽는것과 같은 수
		
		int number = 12321;
		int tmp = number;
		int result =0; // 변수 number를 거꾸로 변환해서 담을 변수
		while(tmp !=0) {
			int e = 0;
			e = tmp%10;
			tmp = tmp/10;
			
			result = e*10000;
			System.out.println(result);
		}
		if(number == result)
		System.out.println( number + "는 회문수 입니다.");
		else
		System.out.println( number + "는 회문수가 아닙니다.");
	}
}
