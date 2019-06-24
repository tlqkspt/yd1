package co.kdw.sort;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
	private int[] num; // 배열 선언

	private void initNum() { // 배열 초기화
		num = new int[100]; // 배열 생성
		Random randnum = new Random(); // 난수발생
//		for (int i = 0; i < 100; i++) {
//			num[i] = (randnum.nextInt(100) + 1); // 1~100사이 숫자만들어줌
//		}
//	//////////////////////////////////////////////////////////
//		for (int i = 0; i < 100; i++) {
//			int numCheck = 0;
//			numCheck = (randnum.nextInt(100) + 1); // 1~100사이 숫자만들어줌 중복x
//			for (int j = 0; j < i; j++) {
//				if (numCheck == num[j]) {
//					i--;
//					break;
//				} else
//					num[i] = numCheck;
//			}
//		}
//////////////////////////////////////////////////////////////////		
		for (int i = 0; i < 100; i++) {
			num[i] = (randnum.nextInt(100) + 1); // 1~100사이 숫자만들어줌 중복x
			for (int j = 0; j < i; j++) {			// 중복제거구문
				if (num[i] == num[j]) {		
					i--;
					break;
				}
			}//중복제거
		}
	}

	private void printArray(int[] num) { // 배열의 수를 10개씩 출력 해본다.
		for (int i = 0; i < 100; i++) {
			System.out.print(num[i] + " ");
			if (i != 0 && i % 9 == 0)
				System.out.println(); // and 연산은 앞쪽이 거짓이 되는 조건이 먼저오는게좋음
		}
	}

	private void sortNum(int[] num) {
		int size = num.length;
		int min;
		int temp;

		for (int i = 0; i < size - 1; i++) { /// select sort
			min = i; // 스왑을 줄이기위해
			for (int j = i + 1; j < size; j++) {
				if (num[min] < num[j]) { // 디센딩 어센딩
					min = j;
				}
			}
			if (min != i) {
				temp = num[min];
				num[min] = num[i];
				num[i] = temp;
			}
		} // sort rutin
	}

	public void sortRun() { // 캡슐화
		initNum();
		System.out.println("처음 배열의 값");
		printArray(num);
		sortNum(num);
		System.out.println("소트후 배열의 값");
		printArray(num);
		Arrays.sort(num); // Acending sort   Arrays 객체를 호출해서 사용함
		System.out.println("어센딩 소트후 배열의 값");
		printArray(num);

	}

}
