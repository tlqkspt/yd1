package yedam2.com.collection.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayListEx {
	public static void main(String[] args) {
//		List<String> list = new ArrayList<String>();
//		list.add("Java");
//		list.add("JDBC");
//		list.add("hello");
//		list.add(2,"index");
//		
//		System.out.println(list.get(2));
//		
//		System.out.println("---------------------");
//		for(int i=0; i< list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//		
//		for(String str : list) {
//			System.out.println(str);
//		}
//		
//		list.add("DataBase");
//		
//		list.remove(4);
//		System.out.println();
//		for (String str : list) {
//			System.out.println(str);
//		}
		
		List<String> list2 = Arrays.asList("java","database","hello");
		for(String str : list2) {
			System.out.println(str);
		}
		List<Integer> intList = Arrays.asList(1,2,3,4,5);
		for(Integer in : intList) {
			System.out.println(in);
		}
		
		List<String> list1 = new ArrayList<>();
		List<String> list = new LinkedList<>();
		
		long startTime;
		long endTime;
		
		startTime = System.currentTimeMillis();
		
		for(int i=0; i<100000; i++) {
			list1.add(0, String.valueOf(i));
		}
		
		endTime = System.currentTimeMillis();
		System.out.println("ArrayList 걸린시간: " +(endTime - startTime));
		
		startTime = System.nanoTime();
		for(int i=0; i<100000; i++) {
			list.add(0, String.valueOf(i));
		}
		
		endTime = System.nanoTime();
		System.out.println("LinkedList 걸린시간: " +(endTime - startTime));
		
//		List<Number> list2 = new ArrayList<Number>();
//		
//		for(int i=0; i< list2.size(); i++) {
//			list2.get(i);
//		}
	}
}
