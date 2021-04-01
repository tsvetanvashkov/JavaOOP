package polymorphism.exercise.VehiclesExtension;

import java.text.DecimalFormat;

public class Vehicle implements Drivable, Refuelable{
	
	private double fuelQuantity;
	private double fuelConsumption;
	private double tankCapacity;
	
	public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
		this.setFuelQuantity(fuelQuantity);
		this.setFuelConsumption(fuelConsumption);
		this.setTankCapacity(tankCapacity);
	}

	public double getTankCapacity() {
		return tankCapacity;
	}

	protected void setTankCapacity(double tankCapacity) {
		this.tankCapacity = tankCapacity;
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
		if (liters <= 0) {
			throw new IllegalStateException("Fuel must be a positive number");
		}
		if ((this.fuelConsumption + liters) > this.tankCapacity) {
			throw new IllegalStateException("Cannot fit fuel in tank");
		}
		this.fuelQuantity += liters;
	}

	@Override
	public String toString() {
		return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
	}
	
	

}
