package co.kdw.InterfaceTest;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarAssemble assemble = new CarAssemble();	//게임 프로그램 아이템추가? 시씀
		assemble.carAssemble();
		assemble.setPart(new Engin()); 	//사용할 접점 에 값을 전달한다.
		assemble.carAssemble();
		assemble.setPart(new Whell());
		assemble.carAssemble();
		assemble.setPart(new OilTank());
		assemble.carAssemble();
		assemble.setPart(new TruckTop());
		assemble.carAssemble();
	}

}
