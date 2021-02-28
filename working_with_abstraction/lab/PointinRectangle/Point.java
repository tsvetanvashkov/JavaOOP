package working_with_abstraction.lab.PointinRectangle;

public class Point {
	
	private int x;
	private int y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public boolean isGreaderOrEqualByX(Point other) {
		return this.x >= other.x;
	}
	
	public boolean isWithEqualX(Point other) {
		return this.x == other.x;
	}
	
	public boolean isLeassOrEqualByX(Point other) {
		return this.x <= other.x;
	}
	
	public boolean isGreaderOrEqualByY(Point other) {
		return this.y >= other.y;
	}
	
	public boolean isWithEqualY(Point other) {
		return this.y == other.y;
	}
	
	public boolean isLeassOrEqualByY(Point other) {
		return this.y <= other.y;
	}

}
