package co.kdw.Test;

public class TestThread extends Thread {

	private int LoofCounter = 1000;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i = 1; i<= LoofCounter; i++) {
			System.out.print("A");
			
			if(i%50==0) {
				System.out.println();
			}
		}
		
		super.run();
	}
	
	

}
