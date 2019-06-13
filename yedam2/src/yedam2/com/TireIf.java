package yedam2.com;

public interface TireIf {
	

	
	void tireIf(String location, int maxRotation);
	boolean roll();
	
	
	
	
	
	
//	public int maxRotation; //사용가능한 최대 회전수
//	public int accumulateRotation; //현재누적 회전수
//	public String location;	//장착위치.. 왼쪽앞, 왼쪽뒤, 뒤왼, 뒤오른
//	
//	public Tire(String location, int maxRotation) {
//		this.location = location;
//		this.maxRotation = maxRotation;
//	}
//	
//	public boolean roll() {
//		++accumulateRotation;
//		if(accumulateRotation < maxRotation) {
//			System.out.println(location + "Tire 수명" +
//					(maxRotation - accumulateRotation));
//			return true;
//		} else {
//			System.out.println("***"+ location + "Tire 펑크 ***");
//			return false;
//		}
}
