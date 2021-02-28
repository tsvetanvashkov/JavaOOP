package working_with_abstraction.lab.PointinRectangle;

public class Main {

	public static void main(String[] args) {
		ConsoleReader reader = new ConsoleReader();
		int[] rectangleInfo = InputParser.parseArray(reader.readLine(), "\\s+");
		Rectangle rectangle = GeometryFactory.creaeteRectangle(rectangleInfo);
		
		int n = Integer.parseInt(reader.readLine());
		
		while (n-- > 0) {
			int[] pointInfo = InputParser.parseArray(reader.readLine(), "\\s+");
			Point point = GeometryFactory.createPoint(pointInfo);
			System.out.println(rectangle.contains(point));
		}
		
	}

}
