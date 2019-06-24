package co.kdw.interfacetest;

public class Sm implements TV {
	
	public Sm() {
		// TODO Auto-generated constructor stub
		System.out.println("삼성 TV");
	}
	
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("Switch ON");
		
	}

	@Override
	public void poweroff() {
		// TODO Auto-generated method stub
		System.out.println("Switch Off");
	}

	@Override
	public void volumUp() {
		// TODO Auto-generated method stub
		System.out.println("소리 높임");
	}

	@Override
	public void volumDown() {
		// TODO Auto-generated method stub
		System.out.println("소리 줄임");
		
	}

}
