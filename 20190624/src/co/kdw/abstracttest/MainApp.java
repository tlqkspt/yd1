package co.kdw.abstracttest;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV lg = new Lg();
		lg.powerOn();
		lg.volumUp();
		lg.model();
		lg.sound();
		lg.volumDown();
		lg.poweroff();
		
		System.out.println("===============");
		
		TV sm = new Sm();  			/////코드가독성 좋아짐, 
		sm.powerOn();
		sm.volumUp();					//상위객체로 초기화하면 내꺼못씀
		sm.model();
		sm.sound();
		sm.volumDown();
		sm.poweroff();
		
		System.out.println("===============");
		
		Sm sm1 = new Sm();  			/////코드가독성 좋아짐, 
		sm1.powerOn();
		sm1.volumUp();
		sm1.model();
		sm1.sound();
		sm1.volumDown();
		sm1.smSoung();   /////Sm꺼 쓰려면 Sm 참조변수
		sm1.poweroff();
		
		
		System.out.println();	
		Lg lg1 = new Lg();
		lg1.model();
	}

}
