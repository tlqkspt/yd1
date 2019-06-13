package yedam2.com.interfacePkg;

public class Television implements RemoteControl {
	
	//필드
	int volume;
	
	//메소드재정의
	public void turnOn() {
		System.out.println("Tv를 켭니다.");
	}
	public void turnOff() {
		System.out.println("Tv를 끕니다.");
	}
	public void setVolume(int volume) {
		if(volume>RemoteControl.MAX_VOLUME)
			this.volume = RemoteControl.MAX_VOLUME;
		else if(volume<RemoteControl.MIN_VOLUME)
			this.volume = RemoteControl.MIN_VOLUME;
		else
			this.volume = volume;
		System.out.println("현재볼륨은"+ volume +"입니다.");
			
	}
}
