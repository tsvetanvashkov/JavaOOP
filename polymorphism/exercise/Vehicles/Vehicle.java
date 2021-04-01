package polymorphism.exercise.Vehicles;

import java.text.DecimalFormat;

public class Vehicle implements Drivable, Refuelable{
	
	private double fuelQuantity;
	private double fuelConsumption;
	
	public Vehicle(double fuelQuantity, double fuelConsumption) {
		this.setFuelQuantity(fuelQuantity);
		this.setFuelConsumption(fuelConsumption);
	}

	public double getFuelQuantity() {
		return fuelQuantity;
	}

	protected void setFuelQuantity(double fuelQuantity) {
		this.fuelQuantity = fuelQuantity;
	}

	public double getFuelConsumption() {
		return fuelConsumption;
	}

	protected void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	@Override
	public String drive(double distance) {
		double fuelNeeded = distance * this.getFuelConsumption();
		DecimalFormat df = new DecimalFormat("#.##");
		if (fuelNeeded > this.getFuelQuantity()) {
			return " needs refueling";
		}else {
			this.fuelQuantity -= fuelNeeded;
			return String.format(" travelled %s km", df.format(distance));
		}
	}

	@Override
	public void refuel(double liters) {
		this.fuelQuantity += liters;
	}

	@Override
	public String toString() {
		return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
	}
	
	

}
