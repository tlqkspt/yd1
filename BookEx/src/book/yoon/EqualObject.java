package book.yoon;


class Point {
	private int xPos;
	private int yPos;
	public Point(int x, int y) {
		xPos = x;
		yPos = y;
	
	}
	
	public boolean equals(Object obj) {
		
		if(this.xPos == ((Point) obj).xPos && this.yPos == ((Point)obj).yPos)
			return true;
		else
			return false;
	}
}

class Rectangle{
	private Point upperLeft;		//좌측 상단 좌표
	private Point lowerRight;		//우측 하단 좌표
	public Rectangle(int x1, int y1, int x2, int y2) {
		upperLeft = new Point(x1,y1);
		lowerRight = new Point(x2,y2);
		
	}

	public boolean equals(Object obj) {
		
		System.out.println(upperLeft.equals(((Rectangle) obj).upperLeft));
		
		if(this.upperLeft.equals(((Rectangle) obj).upperLeft) && this.lowerRight.equals(((Rectangle) obj).lowerRight)) // && this.lowerRight == ((Rectangle)obj).lowerRight
			return true;
		else
			return false;
	}
}

public class EqualObject {
	public static void main(String[] args) {
		Point point1 = new Point(3,6);
		Point point2 = new Point(3,6);
		
		if(point1.equals(point2))
			System.out.println("두 점은 같은자리 입니다");
		else
			System.out.println("두 점은 다른자리 입니다");
		
		
		System.out.println("----------------------------------");
		
		Rectangle rectangle1 = new Rectangle(1,2,3,1);
		Rectangle rectangle2 = new Rectangle(1,2,3,1);
		
		if(rectangle1.equals(rectangle2))
			System.out.println("같은자리");
		else
			System.out.println("다른자리");
	}

}
