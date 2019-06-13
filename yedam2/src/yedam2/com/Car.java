package yedam2.com;

public class Car {
	// 필드
	// 타이어 배열에 담기
//	Tire frontLeftTire = new Tire("앞왼쪽", 6);
//	Tire frontRightTire = new Tire("앞오른쪽", 2);
//	Tire backLeftTire = new Tire("뒤왼쪽", 3);
//	Tire backRightTire = new Tire("뒤오른쪽", 4);
//	
	TireIf[] tireSet = new TireIf[4];
	TireIf[] tireSet2 = { new HankookTireIf("앞왼쪽"), new tireIf("앞오른쪽", 2), new HankookTireIf("뒤왼쪽", 3), new HankookTireIf("뒤오른쪽", 4) };
	
	
	// run()
	int run() {
		System.out.println("자동차 달립니다.");
		for (int i = 0; i < 4; i++) {
			if (tireSet2[i].roll() == false) {
				stop();
				return i+1;
			}
		}
//			}
//			if (TireSet2[2].roll() == false) {
//				stop();
//				return 2;
//			}
//			if (TireSet2[3].roll() == false) {
//				stop();
//				return 3;
//			}
//			if (TireSet2[4].roll() == false) {
//				stop();
//				return 4;
		return 0;

	}

	void stop() {
		System.out.println("자동차가 멈춥니다.");
	}
}
