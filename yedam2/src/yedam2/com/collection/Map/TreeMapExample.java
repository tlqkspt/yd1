package yedam2.com.collection.Map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
	public static void main(String[] args) {
		TreeMap<Integer, String> scores = new TreeMap<>();
		scores.put(new Integer("87"), "홍길동");
		scores.put(new Integer("98"), "리골동");
		scores.put(new Integer("77"), "박실동");
		scores.put(new Integer("95"), "자바동");
		scores.put(new Integer("90"), "스프동");
		Map.Entry<Integer, String> entry = null;
		entry = scores.firstEntry();
		System.out.println(entry.getKey()+"-"+entry.getValue());
		
		entry = scores.lastEntry();
		System.out.println(entry.getKey()+"-"+entry.getValue());
		
		entry = scores.lowerEntry(90);
		System.out.println(entry.getKey()+"-"+entry.getValue());
		
		entry = scores.higherEntry(90);
		System.out.println(entry.getKey()+"-"+entry.getValue());
		
		entry = scores.floorEntry(91);
		System.out.println(entry.getKey()+"-"+entry.getValue());
		
		entry = scores.ceilingEntry(91);
		System.out.println(entry.getKey()+"-"+entry.getValue());
		
		while(!scores.isEmpty()) {
			entry = scores.pollFirstEntry();
			System.out.println(entry + "(남은객체수:"+scores.size()+")");
		}
	}
}
