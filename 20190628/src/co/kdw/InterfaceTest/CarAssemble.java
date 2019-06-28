package co.kdw.InterfaceTest;

public class CarAssemble {
	private Part part;		//인터페이스를 사용할 접점
	
	public void setPart(Part part) {	//기능 교환
		this.part = part;
	}
	
	public void carAssemble() {		//위임한다 인터페이스에게 기능을	
		if(part == null) {
			System.out.println("트럭 차체 입니다");
		} else {
		part.partAssemble();
		}
	}
}
