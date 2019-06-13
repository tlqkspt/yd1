package book.yoon;

public class Switch {
	public static void main(String[] args) {
		System.out.println("권한");
		System.out.println();

		switch (1) {
		case 1:
			System.out.print("삭제 ");

		case 2:
			System.out.print("편집 ");

		case 3:
			System.out.print("읽기 ");

		case 4:
			System.out.print("실행 ");

			break;
		default:
			System.out.println("0000");
		}
	}
}
