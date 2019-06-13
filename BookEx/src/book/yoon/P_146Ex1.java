package book.yoon;

public class P_146Ex1 {
	public static void main(String[] args) {
		/*
		 * 인자 원의 반지름 정보 전달 원 넓이 계산후 반환하는 메소드 원 둘레를 계산해서 반환하는 메소드 각각
		 */
		double r = 15;
		System.out.println(ca(r));
		System.out.println(cl(r));
	}

//원 둘레 계산 소수 .0
	static double ca(double r) {
		return 2 * Math.PI * r;
	}

	static double cl(double r) { // 원 넓이
		return Math.PI * r * r;
	}
}