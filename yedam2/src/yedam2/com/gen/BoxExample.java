package yedam2.com.gen;

public class BoxExample {
	public static void main(String[] args) {
		Box<String> box = new Box<String>();
		box.set(new String("hello"));
		String str = box.get();
		box.set("dgsggdg");
//		Integer intValue = (Integer)box.get();
		box.set("hellow");
//		intValue = (Integer)box.get();	//오류;
		
		Box<Integer> ibox = new Box<Integer>();
		ibox.set(5);  //new Integer 꼭써야??
		Integer inum = ibox.get();
		
		Box<Double> dbox = new Box<Double>();
		dbox.set(1.55);
		Double dnum = dbox.get();
		
		
		System.out.println(box.get());
		System.out.println(inum);
		System.out.println(dnum);
	}
}
