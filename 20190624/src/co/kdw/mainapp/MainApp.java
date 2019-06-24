package co.kdw.mainapp;

import co.kdw.tv.Lg;
import co.kdw.tv.Sm;
import co.kdw.tv.TV;

public class MainApp {
	public static void main(String[] args) {
//		Lg lg = new Lg();
//		lg.powerOn();
//		lg.sound();
//		lg.powerOff();
//		
//		Sm sm = new Sm();
//		sm.powerOn();
//		sm.sound();
//		sm.powerOff();
		
		TV lg = new Lg();
		lg.powerOn();
		lg.sound();
		lg.powerOff();
		
		TV sm = new Sm();
		sm.powerOn();
		sm.sound();
		sm.powerOff();

	}
}
