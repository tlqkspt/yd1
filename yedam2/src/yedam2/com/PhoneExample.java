package yedam2.com;

abstract class Phone {
	// 필드
	public String owner;

	// 생성자
	public Phone(String owner) {
		this.owner = owner;
	}

	// 메소드
	public void turnOn() {
		System.out.println("폰 전원을 켭니다.");
	}

	public void turnOff() {
		System.out.println("폰 전원을 끕니다.");
	}
}

class SmartPhone extends Phone {

	public SmartPhone(String owner) {
		super(owner);
	}

	public void internetSearch() {
		System.out.println("인터넷 검색을 합니다.");
	}

}

public class PhoneExample {
	public static void main(String[] args) {
		// Phone phone = new Phone(); 생성자를 호출할 수 없다..에러발생.
		SmartPhone smartPhone = new SmartPhone("홍길동");
		smartPhone.turnOn();
		smartPhone.internetSearch();
		smartPhone.turnOff();
		System.out.println("===================");

		// 다형성.
		AnimalExample.main();
	}
}

abstract class Animal {
	public String kind;

	public void breathe() {
		System.out.println("숨을 쉰다.");
	}

	public abstract void sound(); // 추상메소드.
}

class Dog extends Animal {

	public Dog() {
		this.kind = "포유류";
	}

	@Override
	public void sound() {
		System.out.println("멍멍멍");
	}

}

class Cat extends Animal {
	public Cat() {
		this.kind = "포유류";
	}

	@Override
	public void sound() {
		System.out.println("야옹야옹");
	}

}

class AnimalExample {
	public static void main() {
		Dog dog = new Dog();
		Cat cat = new Cat();
		dog.sound();
		cat.sound();
		System.out.println("-----------------------");
		Animal animal = null;
		animal = new Dog();
		animal.sound();
		animal = new Cat();
		animal.sound();

		animalSound(new Dog());
		animalSound(new Cat());
	}

	static void animalSound(Animal animal) {
		animal.sound();
	}
}
