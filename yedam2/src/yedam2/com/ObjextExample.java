package yedam2.com;

class Const{
	String name;
	Const(String name){
		this.name = name;
	}
	
}


public class ObjextExample {	
	public static void main(String[] args) {
		String str = new String("hello");
		String str1 = new String("hello");
		if(str == str1)
			System.out.println("동일한 값.");
		else
			System.out.println("다른 값.");
	}
}
