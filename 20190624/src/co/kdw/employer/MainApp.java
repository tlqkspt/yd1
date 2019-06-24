package co.kdw.employer;

public class MainApp {

	public static void main(String[] args) {
		
		System.out.println("구 분 : 사 번 : 성 명 : 입사일 : 직 위 : 급 여");
		
		Employer loy1 = new Employer(0, "0001", "홍길동", "2018-03-02","사원");
		loy1.gibon = 1000000;
		loy1.sudang = 500000;
		loy1.run();
		
		System.out.println("===========");
		Employer loy2 = new Employer(1, "0002", "김치국", "2016-03-02","대리");
		loy2.gibon = 2000000;
		loy2.sudang = 500000;
		loy2.run();
		
		
		Employer loy3 = new Employer();
		loy3.setGubun(1);
		loy3.seteId("0003");
		loy3.setsName("이기자");
		loy3.seteDate("2018-03-02");
		loy3.setPosition("사원");
		loy3.gibon = 1000000;
		loy3.sudang = 500000;
		loy3.run();
		
		System.out.println(loy3.getPosition());
	}

}
