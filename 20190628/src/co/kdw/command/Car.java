package co.kdw.command;

import co.kdw.common.Break;
import co.kdw.common.Engin;
import co.kdw.common.Handle;
import co.kdw.common.Speed;

public class Car implements Engin, Break, Handle, Speed {

	@Override
	public void engin() {
		// TODO Auto-generated method stub
		System.out.println("나는 5000CC 엔진입니다.");
	}

	@Override
	public void oilCheck() {
		// TODO Auto-generated method stub
		System.out.println("오일 교환 주기는 1년 입니다.");
	}

	@Override
	public void speedUp() {
		// TODO Auto-generated method stub
		System.out.println("속도를 올려라");
	}

	@Override
	public void speedDown() {
		// TODO Auto-generated method stub
		System.out.println("속도를 줄인다");
	}

	@Override
	public void handle() {
		// TODO Auto-generated method stub
		System.out.println("원형 핸들");
	}

	@Override
	public void breakRun() {
		// TODO Auto-generated method stub
		System.out.println("제동장치동작");
	}

}
