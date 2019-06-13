package book.yoon.ex;

public class UseWrapperClass {
	public static void showData(Object obj) {
		System.out.println(obj);
	}
	
	public static void main(String[] args) {
		Integer iTnst = new Integer(3);		//정수 3을 감싸는 래퍼 인스턴스 생성
		showData(iTnst);
		showData(new Double(7.15));			//7.15 를 감싸는 래퍼 인스턴스 생성 및 전달
	}
	
}
