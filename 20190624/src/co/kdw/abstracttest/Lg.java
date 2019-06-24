package co.kdw.abstracttest;

public class Lg extends TV {

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("엘지 티비 전원을 켠다.");
	}

	@Override
	public void poweroff() {
		// TODO Auto-generated method stub
		System.out.println("엘지 티비 전원을 끈다.");
	}

	public void model() {
		// TODO Auto-generated method stub
		System.out.println("JCB");
	}

}
