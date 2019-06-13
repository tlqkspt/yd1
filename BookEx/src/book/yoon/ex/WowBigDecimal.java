package book.yoon.ex;

import java.math.BigDecimal;

public class WowBigDecimal {
	public static void main(String[] args) {
		BigDecimal d1 = new BigDecimal("1.6");
		BigDecimal d2 = new BigDecimal("0.1");
		System.out.println("덧셈 결과: " + d1.add(d2));
		System.out.println("곱셈 결과: " + d1.multiply(d2));
		
		//실수는 표현되는 순간부터 오차를 가진다
		
		BigDecimal d3 = new BigDecimal(1.6);
		BigDecimal d4 = new BigDecimal(0.1);
		System.out.println("덧셈 결과: " + d3.add(d4));
		System.out.println("곱셈 결과: " + d3.multiply(d4));
	}
}
