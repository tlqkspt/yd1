package yedam2.com;

class INum {
	private int num;
	private int age;
	private String str;

	public INum(int num) {
		this.num = num;
	}
	public INum(int num, int age , String str) {
		this.num = num;
		this.age = age;
		this.str = str;
	}

	public boolean equals(Object obj) {
//		if (this.num == ((INum) obj).num && this.age == ((INum) obj).age)
		System.out.println(((INum) obj).str);
		if (this.str == ((INum) obj).str)
			return true;
		else
			return false;
	}
}

public class ObjectEquality {
	public static void main(String[] args) {
		INum num1 = new INum(10,15, "aaa");
		INum num2 = new INum(12,12, "bbb");
		INum num3 = new INum(10,12, "aaa");
		
		if(num1.equals(num2))
			System.out.println("num1,num2 내용 동일하다.");
		else
			System.out.println("num1,num2 내용 다르다.");
		if(num1.equals(num3))
			System.out.println("num1,num3 내용 동일하다.");
		else
			System.out.println("num1,num3 내용 다르다.");
	}
}
