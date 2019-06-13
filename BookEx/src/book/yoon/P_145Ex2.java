package book.yoon;

public class P_145Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 97;
		int i = 1, sum = 0;
		while (i <= num) {              // 1~100까지 소수합
			if (check(i) == true) {
				sum += i;
				System.out.println(i);
			}
			i++;
		}
		System.out.println(sum);
	}

	public static boolean check(int a) { // 소수 판단
		int counter = 0;

		for (int i = 1; i < 10; i++)
			if (a != 1 && a < 10 || a > 10) {
				if (a % i != 0) {
					counter++;
				}
			}
		if (counter == 8 || (a < 10 && counter == 7))
			return true;

		return false;
	}
}

//if (a != 1 && a < 10) {
//for (int i = 1; i < 10; i++) {
//	if (a % i != 0) {
//		counter++;
//	}
//}
//} else if (a > 10) {
//for (int i = 1; i < 10; i++) {
//	if (a % i != 0) {
//		counter++;
//	}
//}
//}

//------------------------------

//		for (int i = 1; i <= a; i++) { // 1~9로 나눠서 나머지가 0이 하나라도 있으면 false, 나머지 0이 없으면 true
//			for (int j = 1; j < 10; j++) {			
//				if (i != 1 && i != j && j != 1 && i % j != 0) {
//					res++;
//
//				}
//
//			}
//			if (i < 10 && res == 7)
//				return i;
//			if (res == 8)
//				return i;
//
//			res = 0;
//		}
//	}
//}
