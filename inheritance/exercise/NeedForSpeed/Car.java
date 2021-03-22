package inheritance.exercise.NeedForSpeed;

public class Car extends Vehicle{
	
	final static double DEFAULT_FUEL_CONSUMPTION = 3;
	
	public Car(double fuel, int horsePower) {
		super(fuel, horsePower);
		super.setFuelConsumption(Car.DEFAULT_FUEL_CONSUMPTION);
	}

}
