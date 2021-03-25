package interfaces_and_abstraction.lab.CarShopExtend;

public class Seat extends CarImpl implements Sellable{
	
	private Double price;
	
	public Seat(String model, String color, Integer horsepower, String countryProducted, Double price) {
		super(model, color, horsepower, countryProducted);
		this.price = price;
	}

	@Override
	public Double getPrice() {
		return this.price;
	}

	@Override
	public String toString() {
		return super.toString() + System.lineSeparator() +
				String.format("%s sells for %f",
							super.getModel(),
							getPrice());
	}

	

}
