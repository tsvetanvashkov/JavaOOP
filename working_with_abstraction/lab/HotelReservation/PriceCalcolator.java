package working_with_abstraction.lab.HotelReservation;

public class PriceCalcolator {
	private double pricePerDay;
	private int days;
	private DiscountType discountType;
	private Season season;
	
	public PriceCalcolator(double pricePerDay, int days, DiscountType discountType, Season season) {
		super();
		this.pricePerDay = pricePerDay;
		this.days = days;
		this.discountType = discountType;
		this.season = season;
	}
	
	public double calculate() {
		return pricePerDay * days * season.getMultiplier() * (1.00 - (discountType.getPercentage() / 100.00));
	}

}
