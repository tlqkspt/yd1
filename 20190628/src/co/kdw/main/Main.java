package co.kdw.main;

import co.kdw.command.Car;
import co.kdw.command.GradeServiceImpl;
import co.kdw.command.MemberServiceImpl;
import co.kdw.common.Engin;
import co.kdw.common.Handle;
import co.kdw.common.Service;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MemberServiceImpl service = new MemberServiceImpl();
//		service.select();
////		service.daoClose();
//		
//		Service gs = new GradeServiceImpl();
//		gs.delete();
//		
////		GradeServiceImpl gi = new GradeServiceImpl();
////		gi.delete(9);
		
		Car car = new Car();
		car.engin();
		car.speedUp();
		car.breakRun();
		car.speedDown();
		
		Handle handle = new Car();
		handle.handle();
		
		Engin engin = new Car();
		engin.engin();
		engin.oilCheck();
	}

}
