package book.yoon;

public class ReculFactorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fa(10));
	}
	
	static int fa(int num) {
		int res = 0;
		if(num > 1)res = num*fa(num-1);
		if(num==1) res = res+1;
		return res;
	}

}
