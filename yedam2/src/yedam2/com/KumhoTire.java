package yedam2.com;

public class KumhoTire extends Tire {
	
	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation); // 매개값이 2인 생성자를 super 호출/
	}

	@Override
	public boolean roll() {
		++accumulateRotation;
		if(accumulateRotation < maxRotation) {
			System.out.println(location + " KumhoTire 수명: " +
					(maxRotation - accumulateRotation)+ "회");
			return true;
		}else {
			System.out.println("***" + location + " KumhoTire 펑크 ***");
			return false;
		}
	}
}