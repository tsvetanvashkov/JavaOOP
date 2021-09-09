package aquarium.entities.decorations;

public class BaseDecoration implements Decoration{
	
	private int comfort;
	private double price;
	
	protected BaseDecoration(int confort, double price) {
		this.comfort = confort;
		this.price = price;
	}

	@Override
	public int getComfort() {
		return this.comfort;
	}

	@Override
	public double getPrice() {
		return this.price;
	}

}
