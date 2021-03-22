package inheritance.exercise.NeedForSpeed;

public class SportCar extends Car{

	final static double DEFAULT_FUEL_CONSUMPTION = 10;
	
	public SportCar(double fuel, int horsePower) {
		super(fuel, horsePower);
		super.setFuelConsumption(SportCar.DEFAULT_FUEL_CONSUMPTION);
	}
	
}
