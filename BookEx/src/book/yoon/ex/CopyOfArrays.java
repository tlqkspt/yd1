package book.yoon.ex;

import java.util.Arrays;

public class CopyOfArrays {
	public static void main(String[] args) {
		double[] arOrg = {6.6, 8.8, 7.7, 4.4, 5.5};
		
		double[] cpy = new double[3];
		
		//배열 전체를 복사
		double[] arCpy1 = Arrays.copyOf(arOrg, arOrg.length);
		
		//세번쨰 요소까지만 복사
		double[] arCpy2 = Arrays.copyOf(arOrg, 3);
		
		//일부만 복사
		double[] arCpy3 = Arrays.copyOfRange(arOrg, 3,5);
		
		
		//존재하는 배열에 배열복사
		System.arraycopy(arOrg, 2, cpy, 0, 3);
		double[] cpy1 = Arrays.copyOf(cpy, cpy.length);
		
		//배열의 정렬
		Arrays.sort(arCpy1);
		
		
		for(double d : arCpy1)
			System.out.print(d+ "\t");
		System.out.println();
		
		for(double d : arCpy2)
			System.out.print(d+"\t");
		System.out.println();
		
		for(double d : arCpy3)
			System.out.print(d+"\t");
		System.out.println();
		
		for(double d : cpy)
			System.out.print(d+"\t");
		System.out.println();
	
		System.out.println(Arrays.equals(arCpy1, arCpy2));
		System.out.println(Arrays.equals(cpy,cpy1));
		
	}
	
}
