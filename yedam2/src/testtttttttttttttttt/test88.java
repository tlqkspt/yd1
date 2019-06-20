package testtttttttttttttttt;

import java.util.TreeSet;



public class test88 {
	public static void main(String[] args) {

		TreeSet<Person> set = new TreeSet<>();
		TreeSet<Student> set2 = new TreeSet<>();
		Person p1 = new Person("kang", 175);
		Person p2 = new Person("choi", 180);
		Person p3 = new Person("hong", 184);
		
		set.add(p1);
		set.add(p2);
		set.add(p3);

		for (Person p : set) {
			System.out.println(p.name);
		}
	}
}

class Person implements Comparable<Person> {
	String name;
	int height;
	public Person(String name, int height) {
		this.name = name;
		this.height = height;
	}

	@Override
	public int compareTo(Person p) {
		return this.name.compareTo(p.name);
	}
}
