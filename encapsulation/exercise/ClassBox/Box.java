package encapsulation.exercise.ClassBox;

public class Box {
	private double length;
	private double width;
	private double height;
	
	public Box(double length, double width, double height) {
		this.setLength(length);
		this.setWidth(width);
		this.setHeight(height);
	}
	
	private void setLength(double length) {
		if (length <= 0) {
			throw new IllegalStateException("Length cannot be zero or negative.");
		}
		this.length = length;
	}
	
	private void setWidth(double width) {
		if (width <= 0) {
			throw new IllegalStateException("Width cannot be zero or negative.");
		}
		this.width = width;
	}
	
	private void setHeight(double height) {
		if (height <= 0) {
			throw new IllegalStateException("Height cannot be zero or negative.");
		}
		this.height = height;
	}
	
	public double calculateSurfaceArea() {
		return 2*(this.length*this.width + this.length*this.height + this.width*this.height);
	}
	
	public double calculateLateralSurfaceArea() {
		return 2*(this.length*this.height + this.width*this.height);
	}
	
	public double calculateVolume() {
		return this.length*this.width*this.height;
	}
	
	@Override
	public String toString() {
		return String.format("Surface Area - %.2f\n" + 
				"Lateral Surface Area - %.2f\n" + 
				"Volume – %.2f", calculateSurfaceArea(), calculateLateralSurfaceArea(), calculateVolume());
	}
	
}
