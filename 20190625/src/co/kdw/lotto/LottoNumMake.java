package co.kdw.lotto;

import java.util.Arrays;
import java.util.Random;

public class LottoNumMake {
	private int[] num;		//배열선ㅇㄴ
	
	private void lotoNum() {	//초기화
		num = new int[6];		//배열생성
		Random randNum = new Random(); //난수
		
		for(int i=0; i<6; i++) {	//난수넣기 시작
			num[i] = (randNum.nextInt(45)+1);
			for(int j=0; j<i; j++) {   		//중복제거
				if(num[i]==num[j]) {
					i--;
					break;
				}
			}	//중복끝
		}//난수끝
			Arrays.sort(num);	//정렬
	}
	
	private void printlotto(int[] num) {		//로또배열 출력
		for(int i=0; i<num.length; i++) {
			System.out.printf("%2d ",num[i]);
		}
		System.out.println();
	}
	public void run() {lotoNum();}
	public void lottoNumRun() {
		lotoNum();
		printlotto(num);
	}

	public int[] getNum() {
		return num;
	}
	
	
}
