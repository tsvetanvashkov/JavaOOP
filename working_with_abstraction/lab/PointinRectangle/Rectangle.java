package working_with_abstraction.lab.PointinRectangle;

public class Rectangle {
	
	private Point bottomLeft;
	private Point topRight;
	
	public Rectangle(Point bottomLeft, Point topRight) {
		super();
		this.bottomLeft = bottomLeft;
		this.topRight = topRight;
	}
	
	public boolean contains(Point point) {
		return point.isGreaderOrEqualByX(bottomLeft)
				&& point.isLeassOrEqualByX(topRight)
				&& point.isGreaderOrEqualByY(bottomLeft)
				&& point.isLeassOrEqualByY(topRight);
	}
	

}
