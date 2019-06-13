package yedam2.Exception;

public class ThrowsExample {
	 public static void main(String[] args) {
		try {
			findClass();
		} catch (ClassNotFoundException e) {
			System.out.println("존재하지 않는 클래스입니다.");
			e.printStackTrace();
		}finally {
			System.out.println("다시실행하세요");
		}
	}
	 static void findClass() throws ClassNotFoundException {
		 Class t = Class.forName("java.lang.Str3ing");
		 System.out.println(t.getName());
	 }
}
