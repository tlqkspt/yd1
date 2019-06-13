package yedam2.Exception;

public class TryCatchFinalExeptionExample {
	public static void main(String[] args) {
		String data1 = null;
		String data2 = null;
		try {
			data1 = args[0];
			data2 = args[1];
			int num1 = Integer.parseInt(data1);
			int num2 = Integer.parseInt(data2);
			int result = num1 + num2;
			System.out.println(num1 + "+" + num2 + "=" + result);
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.out.println("실행매개값의 수가 부족하거나 숫자로 변환할 수 없습니다.");
			//System.out.println("실행방법: ");
			//System.out.println("java TryCatchFinalExeptionExample num1 num2");
		
		} catch (Exception e) {
			System.out.println("알수없는 예외 발생.");
		} finally { // 실행되거나 예외처리되어도 실행
			System.out.println("다시실행하세요.");
		}
	}
}
