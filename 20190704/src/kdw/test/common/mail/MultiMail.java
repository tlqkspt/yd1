package kdw.test.common.mail;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiMail {
	List<String> account = new ArrayList<String>();
	String id;
	Scanner sc = new Scanner(System.in);

	private List<String> multiSent() {
		while (true) {
			System.out.println("받는사람 메일주소 입력   [ 0 입력시 종료 ] ");
			id = sc.nextLine();

			if (!(id.equals("0"))) {
				account.add(id);
				int num = 1;
				for (String mailId : account) {
					System.out.print(mailId + "    ");
					if (num++ % 3 == 0) {
						System.out.println();
					}
				}
			} else {
				System.out.println("메일 보내는중...");
				break;
			}
			System.out.println();
		}
		return account;
	}

	public void run() {
		multiSent();
	}

}
