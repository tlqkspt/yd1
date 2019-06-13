package book.yoon;


class DBox<L,R>{
	private L left;
	private R right;
	public void set(L o, R r) {
		left = o;
		right = r;
	}
	public String toString() {return left + " & " + right ; }
}

//class DDBox<U,D>{
//	
//	private U up;
//	private D down;
//	public void set(U u,D d ) {
//		up = u;
//		down = d;
//	}
//	public String toString() {return up +"\n" +down; }
//}

public class P_496_Q21_1_2 {
	public static void main(String[] args) {
		///Q 수납공간 둘로 나뉜 상자 제네릭클래스 DBox<L,R> , 새로운 DDBox<U,D>만들어서 거기에 DBox<L,R> 저장
	DBox<String, Integer> box1 = new DBox<>();
	box1.set("Apple", 25);
	DBox<String, Integer> box2 = new DBox<>();
	box2.set("Orange", 33);
	
	DBox<DBox,DBox> UDBox = new DBox<>();
	
	
	
	UDBox.set(box1,box2);		//두 개의 상자를 하나의 상자에 담음
	System.out.println(UDBox);	//상자의 내용물 출력
	System.out.println(UDBox.toString());
	}
}