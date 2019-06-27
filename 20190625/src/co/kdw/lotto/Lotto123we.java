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
			counter[num-1]++;
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
			//System.out.println(count);
			lottoNumCount(numMake.getNum());
//			System.out.println(Arrays.toString(numMake.getNum()));

		} while (!(Arrays.equals(select, numMake.getNum())));
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("횟수: " + count);
		System.out.println("돈:" + count * 1000 + "원");
		//System.out.println(Arrays.toString(counter));
		
		//arrString(counter);
		
		for (int i = 1; i <= 45; i++) {
			
			double per = (Math.round((double)counter[i-1]/count*100*100)/100.0);
		
			System.out.print(i + "번 :" + counter[i-1]+"  "+ per +"%" +"   " ); 
			if(i%10 ==0)
				System.out.println();
		}
		System.out.println();

	}

	public String arrString(int[] lotto) {
		for (int i = 0; i < 45; i++) {
			System.out.print(i + 1 + "번 :" + lotto[i]+ "  ");
			if(i%10 ==0)
				System.out.println();
		}
		System.out.println();
		return null;
	}
}
