package yedam2.com;

// 자동형변환이 발생한다.
class Parent {
	public String field1;

	void method1() {
		System.out.println("부모클래스의 메소드1");
	}

	void method2() {
		System.out.println("부모클래스의 메소드2");
	}
}

class Child extends Parent {
	public String field2;

	@Override
	void method1() {
		System.out.println("자식클래스의 메소드1");
	}

	@Override
	void method2() {
		System.out.println("자식클래스의 메소드2");
	}

	void method3() {
		System.out.println("자식클래스의 메소드3");
	}

}

// 자동타입변환이 일어난다...parent <- child.
public class ParentExample {
	public static void main(String[] args) {

		Parent parent = new Child();
		System.out.println(parent instanceof Child);
		parent.field1 = "data1";
		parent.method1();
		parent.method2();
		
		
		// parent.field2 = "data2"; <== 에러발생.
		// parent.method3(); <== 에러발생.

		if (parent instanceof Child) {
			Child child = (Child) parent; // 갈제형변환.

			child.field2 = "data2";
			child.method3();
		}

		// 필드의 다형성..Car.java

		InstanceofExample.main();

	}
}

class InstanceofExample {

	// 타입변환이 가능한지 확인...
	static void method1(Parent parent) {
		if (parent instanceof Child) {
			Child child = (Child) parent;
			System.out.println("method1 - Child로 변환 성공.");
		} else {
			System.out.println("method1 - Child로 변환 되지않음.");
		}
	}

	// 타입변환 확인하지 않음...ClassCastException 발생할 가능성 있음.
	static void method2(Parent parent) {
		Child child = (Child) parent;
		System.out.println("method2 - Child로 변환 성공.");
	}

	public static void main() {
		System.out.println("fd");
		Parent parentA = new Child();
		method1(parentA);
		method2(parentA);

		Parent parentB = new Parent();
		method1(parentB);
		method2(parentB);

		// 추상클래스 설명 ==> PhoneExample.java

	}
}
