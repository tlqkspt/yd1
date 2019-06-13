package yedam2.com.interfacePkg;

public class SmartTelevision implements RemoteControl, Searchable {

	@Override
	public void search(String url) {
		System.out.println(url+" 을 검색합니다.");
		
	}

	@Override
	public void turnOn() {
		System.out.println("SmartTv를 켭니다.");
		
	}

	@Override
	public void turnOff() {
		System.out.println("SmartTv를 끕니다.");
		
	}

	@Override
	public void setVolume(int volume) {
		System.out.println("");
		
	}
	
}
