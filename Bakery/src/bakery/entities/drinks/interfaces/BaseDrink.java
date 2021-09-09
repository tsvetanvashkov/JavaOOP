package bakery.entities.drinks.interfaces;

public class BaseDrink implements Drink{
	
	private String name;
	private int portion;
	private double price;
	private String brand;
	
	protected BaseDrink(String name, int portion, double price, String brand) {
		this.setName(name);
		this.setPortion(portion);
		this.setPrice(price);
		this.setBrand(brand);
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
	public int getPortion() {
		return portion;
	}

	public void setPortion(int portion) {
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
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		if (brand.trim().length() < 1) {
			throw new IllegalArgumentException("Brand cannot be null or white space!");
		}
		this.brand = brand;
	}

	@Override
	public String toString() {
		return String.format("%s %s - %dml - %.2flv", this.getName(), this.getBrand(), this.getPortion(), this.getPrice());
	}
	
	

}
