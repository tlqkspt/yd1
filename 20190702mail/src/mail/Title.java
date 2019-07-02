package mail;

import java.util.Scanner;

public class Title {
	Scanner sc = new Scanner(System.in);
	String title;
	
	public void title() {
		System.out.println("제목입력: ");
		title = sc.nextLine();
	}
}
