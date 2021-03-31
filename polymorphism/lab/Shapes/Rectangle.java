package polymorphism.lab.Shapes;

public class Rectangle extends Shape{

	private Double height;
	private Double width;
	
	public Rectangle(Double height, Double width) {
		this.setHeight(height);
		this.setWidth(width);
	}

	public final Double getHeight() {
		return height;
	}

	private void setHeight(Double height) {
		this.height = height;
	}

	public final Double getWidth() {
		return width;
	}

	private void setWidth(Double width) {
		this.width = width;
	}

	@Override
	public Double calculateArea() {
		if (getArea() == 0) {
			Double area = this.getHeight() * this.getWidth();
			setArea(area);
		}
		return getArea();
	}

	@Override
	public Double calculatePerimeter() {
		if (getPerimeter() == null) {
			Double perimeter = 2*(this.getHeight() + this.getWidth());
			setPerimeter(perimeter);
		}
		return getPerimeter();
	}
	
	
	
}
