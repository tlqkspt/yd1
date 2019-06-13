package yedam2.com;

public class HankookTireIf	implements TireIf {

	
	public int maxRotation; //사용가능한 최대 회전수
	public int accumulateRotation; //현재누적 회전수
	public String location;	//장착위치.. 왼쪽앞, 왼쪽뒤, 뒤왼, 뒤오른
	
	HankookTireIf(){}
	
	public HankookTireIf(String location) {
		tireIf(location, 9);
	}
	
	
//	public HankookTireIf(String location, int maxRotation) {
//		this(location, maxRotation); // 매개값이 2인 생성자를 super 호출/
//	}
	
	
	public void tireIf(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	
	
	public boolean roll() {
		++accumulateRotation;
		if(accumulateRotation < maxRotation) {
			System.out.println(location + " HankookTire 수명: " +
					(maxRotation - accumulateRotation)+ "회");
			return true;
		}else {
			System.out.println("***" + location + " HankookTire 펑크 ***");
			return false;
		}
	}
}
