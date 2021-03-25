package interfaces_and_abstraction.lab.CarShopExtend;

public class Audi extends CarImpl implements Rentable{
	
	private Integer minRentDay;
	private Double pricePerDay;

	public Audi(String model, String color, Integer horsepower, String countryProducted,
			Integer minRentDay, Double pricePerDay) {
		super(model, color, horsepower, countryProducted);
		this.minRentDay = minRentDay;
		this.pricePerDay = pricePerDay;
	}

	@Override
	public Integer getMinRentDay() {
		return this.minRentDay;
	}

	@Override
	public Double getPricePerDay() {
		return this.pricePerDay;
	}

	@Override
	public String toString() {
		return super.toString() + System.lineSeparator() +
				String.format("Minimum rental period of %d days. Price per day %f",
							getMinRentDay(),
							getPricePerDay());
	}
	

}
