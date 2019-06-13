package yedam2.com.interfacePkg;

public interface RemoteControl {
	
	//상수필드		인터페이스는 변수? 선언안됨
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	// 추상메서드  //인터페이스 구현하는 클래스에서 반드시 정의해줘야함
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	// 디폴트메소드 //인터페이스 구현부에서 굳이 구현하지 않아도됨
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음처리를 합니다.");
		}else {
			System.out.println("무음해제를 합니다.");
		}
	}
	//정적메소드
	static void changeBattery() {
		System.out.println("배터리를 교체합니다.");
	}
	
}
