package yedam2.com.collection.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Person {
	String ssno;
	String name;
	Person(String ssno, String name){
		this.ssno = ssno;
		this.name = name;
	}
	
	String getName() {
		return this.name;
	}
	
	
	public String toString() {
		return this.name + this.ssno;
	}

	@Override
	public boolean equals(Object obj) {
		Person person = (Person)obj;
		return this.name.equals(person.name) && this.ssno.equals(person.ssno); 
	}

	@Override
	public int hashCode() {
		return ssno.hashCode() + name.hashCode();
	}
}

public class HashMapExample {
	public static void main(String[] args) {
		
		Map<Person, String> map = new HashMap<>();
		
		map.put(new Person("111","hong1"), "hello");
		map.put(new Person("111","hong1"), "nice");
		map.put(new Person("330","hong3"), "good1");
		map.put(new Person("333","hong3"), "good2");
		map.put(new Person("331","hong3"), "good3");
		map.put(new Person("332","hong3"), "good4");
		map.put(new Person("334","hong3"), "good5");
		map.put(new Person("335","hong3"), "good6");
		map.put(new Person("336","hong3"), "good7");
		map.put(new Person("337","hong3"), "good8");
		map.put(new Person("338","hong3"), "good9");
		map.put(new Person("339","hong3"), "good0");
		
		//결과값 hello  good
		Set<Person> set = map.keySet();
		Iterator<Person> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(map.get(itr.next()));
		}
		
		
		
		
		
		
//		Map<String, Person> map = new HashMap<>();
//		//Map<String, Integer> map = new HashMap<>();
//		map.put("111", new Person("1111","홍가"));
//		map.put("122", new Person("1122","최가"));
//		map.put("111", new Person("1133","홍가"));
//		map.put("144", new Person("1144","김가"));
//		
//		System.out.println("총 Entry 수: "+ map.size());
//		System.out.println("홍길동의 점수: "+ map.get("홍길동"));
//		Set<String> set = map.keySet();
//		System.out.println(set);
//		Iterator<String> itr = set.iterator();
//		while(itr.hasNext()) {
//			String key = itr.next();
//			System.out.println("key값은:"+key+"  값은:"+map.get(key).getName());
//			//System.out.println(itr.next());
//		}
	}
}
