package yedam2.com.gen;

class Pairs<K,V>{
	private K key;
	private V value;
	public Pairs(K key, V value) {
		this.key = key;
		this.value = value;		
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
}

class Utils {
	public static <T> Box<T> boxing(T value) {
		Box<T> box = new Box<>();
		box.set(value);
		return box;
	}
	public static <K, V> boolean compare(Pairs<K,V> p1, Pairs<K,V> p2 ) {
		
		boolean b1 = p1.getKey().equals(p2.getKey());
		boolean b2 = p1.getValue().equals(p2.getValue());
		
		return b1 && b2;
	}
	
	public static <K, V> boolean compare2(Pairs<K,V> p1, Pairs<K,V> p2 ) {
		
		if(p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue()))
		return true;
		else 
			return false;
	}
	
	public static <T extends Number> int compare(T t1, T t2) {
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		return Double.compare(v1, v2);	//v1, v2 비교해서 -1,0,1 리턴해줌
	}
}
public class BoxingMethodExample {
	public static void main(String[] args) {
//		Box<String> box = Util.boxing(new String("qkqh"));
//		System.out.println(box);
//		
//		Box<Integer> box1 = Util.boxing(new Integer(55));
//		System.out.println(box1);
		///////////////////////////////////////////////////////////////////////////
//		Pairs<Integer, String> p1 = new Pairs<Integer, String>(1,"na");
//		Pairs<Integer, String> p2 = new Pairs<>(1,"na");
//		
//		boolean result = Utils.compare(p1,p2);
//		if(result)
//			System.out.println("동일객체");
//		else
//			System.out.println("동일객체 아닙니다");
//		
//		boolean result2 = Utils.compare2(p1,p2);
//		if(result2)
//			System.out.println("동일객체");
//		else
//			System.out.println("동일객체 아닙니다");
		/////////////////////////////////////////////////////////////////////////////
		
		int result = Utils.compare(10.2, 20.6);
		System.out.println(result);
		
	}
}
