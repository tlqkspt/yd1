package co.kdw.lotto;

import java.util.Scanner;

public class LottoMoney {
	private int money;
	private int count;
	Scanner sc = new Scanner(System.in);

	LottoMoney() {
	}

	private void setMoney() {			//금액입력
		System.out.println("금액입력(게임당 1000) :");
		money = sc.nextInt();
	}

	private void howManyLotto() {		//로또 횟수
		count = money / 1000;
	}

	public int getCount() {
		return count;
	}

	public void lottoStart() {
		setMoney();
		howManyLotto();
		if (getCount() != 0) {
			LottoNumMake l = new LottoNumMake();
			for (int i = 0; i < getCount(); i++) {
				if (i % 5 == 0)
					System.out.println("========================");
				l.lottoNumRun();		
			}
		}
		System.out.println("========================");
	}
}
