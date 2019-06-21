package quest;

public class Calculator {
	public static void main(String[] args) {
		
		int num1;
		int num2;
		String giho;
		
		num1 = 5;
		num2 = 2;
		giho = "/";
		Calculator c = new Calculator();
		System.out.println(c.getResult(num1,num2,giho));
		
	}
	
	public double getResult(int num1,int num2, String giho) {
		
		double result = 0;
		if(giho.equals("+")) {
			result = num1+num2;
		}else if(giho.equals("-")) {
			result = num1-num2;
		}else if(giho.equals("*")) {
			result = num1*num2;
		}else if(giho.equals("/")) {
		
			if(num2 != 0)
				result = (double)num1/num2;
			else
				result = -1;
		}
		return result;
	}
}
