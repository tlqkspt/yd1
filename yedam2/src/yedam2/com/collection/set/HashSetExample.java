package yedam2.com.collection.set;


import java.util.*;

class Person{
	String name;
	int age;
	String ssno;
	
	public Person(String name, int age, String ssno) {
		this.name = name;
		this.age = age;
		this.ssno = ssno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSsno() {
		return ssno;
	}
	
	public String toString() {
		return getName() +","+ getAge() +","+ getSsno() ;
	}
	@Override
	public boolean equals(Object obj) {
		Person person = (Person)obj;
//		boolean b1 = this.name.equals(person.name);
//		boolean b2 = this.age == person.age;
//		return b1&&b2;
		return this.name.equals(person.name) && this.age == person.age && this.ssno.equals(person.ssno);
		//		return super.equals(obj); 오버라이딩전
	}
	@Override
	public int hashCode() {
		return name.hashCode() + ssno.hashCode() +age;
		// name.hashcode + 22; 이런식으로됨
		// name.hashcode + 23;
//		return super.hashCode();	오버라이딩전
	}
	
}


public class HashSetExample {
	public static void main(String[] args) {
		Set<Person> set = new HashSet<>();
		// Set 동일 판단 Person으로하면 주소값으로 판단  오버라이딩 해줘야됨
		set.add(new Person("김가",55,"1234"));
		set.add(new Person("이가",15,"5552"));// 주소값 -> hashcode()
		set.add(new Person("최가",24,"5551"));// 주소값 -> hashcode()
		set.add(new Person("박가",52,"2245"));

		set.add(new Person("김가",54,"1234"));
		set.add(new Person("이가",15,"2224"));
		set.add(new Person("최가",24,"5551"));
		set.add(new Person("박가",52,"2245"));
	
		int size = set.size();
		
		Iterator<Person> itr = set.iterator();
		while(itr.hasNext()) {
//			Person per = itr.next();
//			System.out.println(per);
			System.out.println(itr.next().toString());
		}
		
		//		Set<String> set = new HashSet<String>();
//		set.add("Java");
//		set.add("JDBC");
//		set.add("Oracle");
//		set.add("Java");
//		set.add("iBatis");
//		
//		int size = set.size();
//		System.out.println(size);
//		System.out.println(set);
//		
//		Iterator<String> itr = set.iterator();
//		while(itr.hasNext()) {	//다음값이 있냐
//			String str = itr.next();
//			System.out.println(str);
//		}
//		
//		set.remove("JDBC");
//		System.out.println(set.size());
//		itr= set.iterator();
//		while(itr.hasNext()) {	//다음값이 있냐
//			String str = itr.next();
//			System.out.println(str);
//		}
//		set.clear();
//		if(set.isEmpty())
//			System.out.println("비었음");
	}
}
