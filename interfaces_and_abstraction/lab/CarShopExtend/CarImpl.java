package interfaces_and_abstraction.lab.CarShopExtend;

public abstract class CarImpl implements Car{
	
	private String model;
	private String color;
	private Integer horsePower;
	private String countryProducted;
	
	protected CarImpl(String model, String color, Integer horsepower, String countryProducted) {
		this.model = model;
		this.color = color;
		this.horsePower = horsepower;
		this.countryProducted = countryProducted;
	}

	@Override
	public String getModel() {
		return this.model;
	}

	@Override
	public String getColor() {
		return this.color;
	}

	@Override
	public Integer getHorsePower() {
		return this.horsePower;
	}

	@Override
	public String getCountryProduced() {
		return this.countryProducted;
	}

	@Override
	public String toString() {
		return String.format("This is %s produced in %s and have %d tires",
							getModel(),
							getCountryProduced(),
							Car.TIRES);
	}

}
