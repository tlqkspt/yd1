package co.kdw.interfacetest;

public class Lg implements TV {

	public Lg() {
		// TODO Auto-generated constructor stub
		System.out.println("LG TV");
		
	}
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("push switch On");
	}

	@Override
	public void poweroff() {
		// TODO Auto-generated method stub
		System.out.println("push switch Off");
	}

	@Override
	public void volumUp() {
		// TODO Auto-generated method stub
		System.out.println("소리 +");
	}

	@Override
	public void volumDown() {
		// TODO Auto-generated method stub
		System.out.println("소리 -");
	}

}
