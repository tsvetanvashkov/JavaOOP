package working_with_abstraction.lab.PointinRectangle;

public class GeometryFactory {
	
	public static Rectangle creaeteRectangle(int[] pointsInfo) {
		return new Rectangle(createPoint(pointsInfo[0], pointsInfo[1]),
				createPoint(pointsInfo[2], pointsInfo[3]));
	}
	
	public static Point createPoint(int x, int y) {
		return new Point(x, y);
	}
	
	public static Point createPoint(int[] pointInfo) {
		if (pointInfo.length != 2) {
			throw new IllegalStateException("Point can becreated only by X an Y cordinates.");
		}
		return createPoint(pointInfo[0], pointInfo[1]);
	}

}
