package book.yoon;

import java.util.Arrays;

public class Ch13_Q13_2 {
	public static void main(String[] args) {

		int[][] ar = { { 11 },
					   { 22, 33 }, 
					   { 44, 55, 66 },
					   { 11, 33, 77, 55} };

		addTwoDArr(ar, 14);
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++)
				System.out.print(ar[i][j] + "  ");
			System.out.println();
		
//	addTwoDArr(ar,0)	;
		}
		int check =0;     //확인용
		check = ar[3][2];
		System.out.println(ar[3][2]);
	}

	public static void addOneDArr(int[] arr, int add) {
		for (int i = 0; i < arr.length; i++)
			arr[i] += add;
	}

	public static void addTwoDArr(int[][] arr, int add) {
		// addOneDArr 메소드 호출 해서 2차원배열 값을 두번째 매개변수 만큼 증가

		// arr0 =1 arr1 =2 arr2 =3
		// 각행마다 열의 길이를 알아야함

		for(int i=0;i<arr.length;i++)
		addOneDArr(arr[i], add);
		
	
		
		
//		
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[i].length; j++) {
//
//				arr[i][j] += add;
//
//			}
//		}	
			}
		}
	