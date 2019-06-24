package co.kdw.abstracttest;

public interface Speaker {
	
	public void model();
	
	default public void sound() {
		System.out.println("스피커 수는 4개 입니다.");
	}
}
