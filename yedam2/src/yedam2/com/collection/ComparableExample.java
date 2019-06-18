package yedam2.com.collection;

import java.util.TreeSet;

class Person implements Comparable{
	String name;
	int age;
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	@Override
	public int compareTo(Object o) {
		Person p = (Person)o;
		// TODO Auto-generated method stub
		//return this.age - ((Person) o).age;   // 음수값-오름차순, 양수값-내림차순
				
		//return this.name.compareTo(p.name);
		//return p.name.compareTo(this.name);
		
		//Q. name 필드의 문자의 갯수로 정렬
		//return this.name.length() - p.name.length();
		return p.name.length() - this.name.length();
	}
}

public class ComparableExample {
	public static void main(String[] args) {
		Person p1 = new Person("aaaa", 30);
		Person p2 = new Person("bbbbb", 9);
		Person p3 = new Person("cc", 10);
		Person p4 = new Person("c", 10);
		
		TreeSet<Person> set = new TreeSet<>();
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);
		for(Person p: set) {
			System.out.println(p.age+"-"+p.name);
		}
	}
}
