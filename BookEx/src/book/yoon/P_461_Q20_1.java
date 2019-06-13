package book.yoon;

import java.util.Random;

public class P_461_Q20_1 {
	public static void main(String[] args) {

		int num1 = 55; // 임의의정수1 num1 < num2
		int num2 = 44; // 임의의정수2
		int tmp = 0;
		Random rand = new Random();
		for(;;) {
		if (num1 < num2) {
			for (int i = 0; i < 10; i++) {
				System.out.print(rand.nextInt(num2 - num1) + num1 + "   ");
			}
			break;
		}
		else
			tmp = num1;
			num1 = num2;
			num2 = tmp;
		}

//		Random rand = new Random();
//		for(int i = 0; i < 7; i++)
//			System.out.println(rand.nextInt(1000));
	}
}
