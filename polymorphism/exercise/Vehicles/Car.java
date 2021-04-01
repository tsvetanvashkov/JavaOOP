package polymorphism.exercise.Vehicles;

public class Car extends Vehicle{

	public Car(double fuelQuantity, double fuelConsumption) {
		super(fuelQuantity, fuelConsumption);
	}

	@Override
	public String drive(double distance) {
		return "Car" + super.drive(distance);
	}

	@Override
	protected void setFuelConsumption(double fuelConsumption) {
		super.setFuelConsumption(fuelConsumption + 0.9);
	}

}
