package lambda;

interface MyFunctionalInterface {
	public void method(int x,int y);
}

class MyFuntionClass implements MyFunctionalInterface {

	@Override
	public void method(int x, int y) {
		// TODO Auto-generated method stub
//		System.out.println(x + "method call");
	}

}

public class MyFunctionalExample {
	public static void main(String[] args) {
		MyFunctionalInterface interf = new MyFuntionClass();
		interf.method(3,5);

//		 MyFunctionalInterface intefc = new MyFunctionalInterface() {
//			
//			 @Override
//			public void method(int x) {
//				System.out.println(x*3 + " method call");
//				// TODO Auto-generated method stub
//			 }
//		};

		MyFunctionalInterface intefc = (a,y) -> {
			System.out.println("a+b = "+ (a + y) );
		};
		intefc.method(3,6);
	}
}
