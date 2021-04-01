package polymorphism.exercise.VehiclesExtension;

public class Car extends Vehicle{

	public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
		super(fuelQuantity, fuelConsumption, tankCapacity);
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
