package co.kdw.lotto;

import java.util.Arrays;

public class Lotto123we {
	int[] select = { 21, 11, 3, 7, 44, 38 };
	long count = 0;
	int[] counter = new int[45];

	public void myLottoSort() {
		Arrays.sort(select);
	}

	public void lottoNumCount(int[] makeNum) {

		int num = 0;
		for (int i = 0; i < 6; i++) {
			num = makeNum[i];
			counter[num - 1]++;
		}
	}
//	public void hi() {
//		myLottoSort();
//		LottoNumMake numMake = new LottoNumMake();
//		numMake.run();
//		System.out.println(numMake.getNum()[1]);
//	}

	public void check() {
		myLottoSort();
		LottoNumMake numMake = new LottoNumMake();
		do {
			numMake.run();
			count++;
			System.out.println(count);
			lottoNumCount(numMake.getNum());
//			System.out.println(Arrays.toString(numMake.getNum()));

		} while (!(Arrays.equals(select, numMake.getNum())));
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("횟수: " + count);
		System.out.println("돈:" + count * 1000 + "원");
		System.out.println(Arrays.toString(counter));
		counter.toString();

	}

	@Override
	public String toString() {
		for (int i = 0; i < 45; i++) {
			System.out.println(i + 1 + "번 :" + counter[i]);
		}
		return null;
	}
}
