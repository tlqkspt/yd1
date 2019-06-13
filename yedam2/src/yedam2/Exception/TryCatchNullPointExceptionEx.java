package yedam2.Exception;

public class TryCatchNullPointExceptionEx {
	public static void main(String[] args) {
		String data = "Hello";
		data = null;
		try {
			System.out.println(data.toString());
		}catch (NullPointerException e) {
			System.out.println("null값을 참조중입니다");
			System.out.println("실행방법:");
			System.out.println("참조값 확인");
		}finally {
			System.out.println("다시실행");
		}
	}
}
