package yedam2.com.gen;

class Pair5<K, V> {
	private K key;
	private V value;

	public Pair5(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}

class ChildPair<K, V> extends Pair5<K, V> {
	public ChildPair(K key, V value) {
		super(key, value);
	}
}

class OtherPair<K, V> {
	private K key;
	private V value;

	public OtherPair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

}

class Util5 {
	public static <K,V> V getValue(Pair5<K,V> p, String K){
//		if(p.getKey().equals(K))		//제네릭 Pair 와 스트링타입 이름 받아서
//			return (int) p.getValue();	//Pair 의 이름이랑 K가 같으면 Pair의 v출력
//		return 0;
		boolean result = p.getKey().equals(K);
		if(result)
			return p.getValue();
		else
			return null;
			
	}
}

	public class GenQ {
		public static void main(String[] args) {
			Pair5<String, Integer> pair = new Pair5<>("홍길동", 35);
			Integer age = Util5.getValue(pair, "홍0길동");
			System.out.println(age);

			ChildPair<String, Integer> child = new ChildPair<>("홍삼원", 20);
			Integer cage = Util5.getValue(child, "홍삼원");
			System.out.println(cage);

//			OtherPair<String, Integer> other = new OtherPair("홍삼원", 20);
//			Integer oage = Util.getValue(other, "홍삼원");
//			System.out.println(oage);
		}
	}

