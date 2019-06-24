package co.kdw.abstracttest;

public class TV implements Speaker{
	public void powerOn() {
		System.out.println("전원 ON");
	}
	public void poweroff() {
		System.out.println("전원 OFF");
	}
	public void volumUp() {
		System.out.println("소리를 높인다.");
	}
	public void volumDown() {
		System.out.println("소리를 줄인다.");
	}
	@Override
	public void model() {
		// TODO Auto-generated method stub
		System.out.println("Apple");
	}
	
}
