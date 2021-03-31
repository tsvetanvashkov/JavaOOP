package polymorphism.lab.Shapes;

public class Circle extends Shape{
	
	private Double radius;
	
	public Circle(Double radius) {
		this.setRadius(radius);
	}
	
	public final Double getRadius() {
		return radius;
	}

	private void setRadius(Double radius) {
		this.radius = radius;
	}
	
	@Override
	public Double calculateArea() {
		if (getArea() == null) {
			Double area = Math.PI * this.getRadius() * this.getRadius();
			setArea(area);
		}
		return getArea();
	}

	@Override
	public Double calculatePerimeter() {
		if (getPerimeter() == null) {
			Double perimeter = Math.PI * 2 * this.getRadius();
			setPerimeter(perimeter);
		}
		return getPerimeter();
	}
	
	

}
