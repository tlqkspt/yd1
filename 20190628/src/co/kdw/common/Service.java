package co.kdw.common;


public interface Service {	//기능 정의
	
	public void select();
	public void insert();
	public void delete();
	public void update();
//	default public void daoClose() {
//		System.out.println("항상포함 메소드");
//	}
}
