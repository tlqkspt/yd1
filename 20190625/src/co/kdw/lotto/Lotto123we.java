package co.kdw.lotto;

import java.util.Arrays;

public class Lotto123we {
	int[] select = { 32, 25, 12, 43, 2, 8 };
	int count = 0;

	public void lottoSort() {
		Arrays.sort(select);
	}

	public void check() {
		lottoSort();
		LottoNumMake numMake = new LottoNumMake();
		do {
			numMake.run();
			count++;
			System.out.println(count);
//			System.out.println(Arrays.toString(numMake.getNum()));
			
		} while (!(Arrays.equals(select, numMake.getNum())));
		System.out.println(count);
	}
	
}
