package co.kdw.tv;

public class Lg extends TV {	// TV Class 특성을 상속한다.
	public Lg() {
		System.out.println("나는 LG TV");
	}
	
	public void soundoff() {
		System.out.println("소리끈다.");
	}
//	public void sound() {
//		System.out.println("소리를 켠다.");
//	}
}
