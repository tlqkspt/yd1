package yedam2.Exception;

public class NullPointExceptionExample {
	public static void main(String[] args) {
		String data = "Hello";
		data = null;
		System.out.println(data.toString());
	}
}
