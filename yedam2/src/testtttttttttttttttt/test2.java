package testtttttttttttttttt;

public class test2 {
	public static void main(String[] args) {
		Student s1 = new Student("hong", 20);
		Student s2 = new Student("hong", 20);
		System.out.println(s1.equals(s2));
	}
}

class Student {
	String name;
	int age;

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		Student student = (Student)obj;
		return this.name.equals(student.name) && this.age == student.age;
	}

}
