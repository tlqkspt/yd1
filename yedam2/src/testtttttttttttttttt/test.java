package testtttttttttttttttt;

public class test {
	public static void main(String[] args) {
		printString(4,5,"*");
	}
	
	public static void printString(int garo, int sero, String star) {
		
		for(int i = 0; i<sero; i++) {
			for(int j=0; j<garo; j++) {
				System.out.print(star);
			}
			System.out.println();
		}
	}
}
