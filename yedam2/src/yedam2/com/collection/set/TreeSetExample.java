package yedam2.com.collection.set;

import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<>();
		scores.add(new Integer(87));
		scores.add(new Integer(47));
		scores.add(new Integer(97));
		scores.add(new Integer(77));
		scores.add(new Integer(67));
		scores.add(new Integer(87));
		scores.add(new Integer(99));
		scores.add(new Integer(84));
		System.out.println(scores.size());
		
		for(Integer i : scores) {
			System.out.println(i);
		}
		
		Integer score = null;
		score = scores.first();
		System.out.println("가장 낮은 점수:"+score);
		score = scores.last();
		System.out.println("가장 높은 점수:"+score);
		
		score = scores.lower(new Integer(95));
		System.out.println("95점 아래 점수:"+score);

		score = scores.higher(new Integer(95));
		System.out.println("95점 위 점수:"+score);

		score = scores.floor(new Integer(95));
		System.out.println("95점이거나 바로 아래 점수:"+score);
		

		score = scores.ceiling(new Integer(95));
		System.out.println("95점이거나 바로 위의 점수:"+score);
		
		
		while(!scores.isEmpty()) {
			score = scores.pollFirst();
			System.out.println(score +"(남은객체 수: "+scores.size()+")");
			
//		if(!scores.isEmpty()) {
//			score = scores.pollFirst();
//			System.out.println(score +"(남은객체 수: "+scores.size()+")");
//			
//			score = scores.pollFirst();
//			System.out.println(score +"(남은객체 수: "+scores.size()+")");
//			score = scores.pollFirst();
//			System.out.println(score +"(남은객체 수: "+scores.size()+")");
//			score = scores.pollFirst();
//			System.out.println(score +"(남은객체 수: "+scores.size()+")");
//			score = scores.pollFirst();
//			System.out.println(score +"(남은객체 수: "+scores.size()+")");
//			score = scores.pollFirst();
//			System.out.println(score +"(남은객체 수: "+scores.size()+")");
			
		}
	}
}
