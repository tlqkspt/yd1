package co.kdw.interfacetest;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV lg = new Lg();
		lg.powerOn();
		lg.volumUp();
		lg.volumDown();
		lg.poweroff();
		
		TV sm = new Sm();
		sm.powerOn();
		sm.volumUp();
		sm.volumDown();
		sm.poweroff();
		
		Lg lg1 = new Lg();
		lg1.powerOn();
		
	}

}
