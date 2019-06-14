package book.yoon.ex;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueue {
	public static void main(String[] args) {
		Queue<String> que = new LinkedList<>();	//LinkedList<E> 인스턴스 생성!
		que.offer("Box");
		que.offer("Toy");
		que.offer("Robot");
		
		//다음에 뭐가나올지 확인
		System.out.println("next: "+que.peek());
		
		// 첫번째,두번째 인스턴스 꺼내기
		System.out.println(que.poll());
		System.out.println(que.poll());
		
		//뭐가 다음에 나올지 확인
		System.out.println("next: " + que.peek() );
		
		//마지막 인스턴스 꺼내기
		System.out.println(que.poll());
		
		System.out.println(que.poll());
	}
}
