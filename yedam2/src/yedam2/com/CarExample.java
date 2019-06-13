package yedam2.com;

public class CarExample {
	public static void main(String[] args) {
		Car car = new Car();
		for(int i=0; i<5; i++) {
			int problemLocation = car.run();
			
			switch(problemLocation) {
			case 1: 
				System.out.println("앞왼쪽 금호타이어 교채.");
				car.tireSet2[0] = new HankookTireIf("앞왼쪽", 10);
				break;
			case 2:
				System.out.println("앞오른쪽 타이어 교체.");
				car.tireSet2[1] = new HankookTireIf("앞오른쪽", 9);
				break;
			case 3 :
				System.out.println("뒤왼쪽 한국타이어 교체.");
				car.tireSet2[2] = new HankookTireIf("뒤왼쪽", 8);
				break;
			case 4 :
				System.out.println("뒤오른쪽타이어 교체");
				car.tireSet2[3] = new HankookTireIf("뒤오른쪽", 6);
				break;
			}
			System.out.println("------------------------------------------------------");
		}
	}
}
