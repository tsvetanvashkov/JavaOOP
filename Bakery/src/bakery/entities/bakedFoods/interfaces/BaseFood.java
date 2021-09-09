package bakery.entities.bakedFoods.interfaces;

public class BaseFood implements BakedFood{
	
	private String name;
	private double portion;
	private double price;
	
	protected BaseFood(String name, double portion, double price) {
		this.setName(name);
		this.setPortion(portion);
		this.setPrice(price);
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.trim().length() < 1) {
			throw new IllegalArgumentException("Name cannot be null or white space!");
		}
		this.name = name;
	}

	@Override
	public double getPortion() {
		return portion;
	}

	public void setPortion(double portion) {
		if (portion <= 0) {
			throw new IllegalArgumentException("Portion cannot be less or equal to zero!");
		}
		this.portion = portion;
	}

	@Override
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price <= 0) {
			throw new IllegalArgumentException("Price cannot be less or equal to zero!");
		}
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("%s: %.2fg - %.2f", this.getName(), this.getPortion(), this.getPortion());
	}

}
