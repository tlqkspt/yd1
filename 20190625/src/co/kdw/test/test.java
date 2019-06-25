package co.kdw.test;

import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = { 1, 2, 3, 4, 5 };

		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(a).equals(Arrays.toString(b)));
		System.out.println(a.equals(b));
		System.out.println(Arrays.equals(a, b));
		
		Eq eq = new Eq();
		System.out.println();
		eq.a = a;
		System.out.println(eq.equals(b));

	}

	
}

class Eq {
	int[] a;

	public boolean equals(int[] arr) {
		boolean result = true;
		
		for (int i = 0; i < this.a.length; i++) {
			if (this.a[i] != arr[i]) {
				System.out.println("다르다");
				result = false;
				break;
			}
		}
		return result;
	}
}

