package co.kdw.Test;

public class Example {
	public static void main(String[] args) {

		TestThread tThred = new TestThread();
//		
//		tThred.run();

		Thread sThread = new Thread() {

			@Override
			public void run() {

				int LoofCounter = 1000;

				for (int i = 1; i <= LoofCounter; i++) {
					System.out.print("b");

					if (i % 50 == 0) {
						System.out.println();
					}
				}
				super.run();
			}

		};
		
		tThred.start();
		sThread.start();

	}
}
