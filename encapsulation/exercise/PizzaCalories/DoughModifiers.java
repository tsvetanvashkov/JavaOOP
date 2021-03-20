package encapsulation.exercise.PizzaCalories;

public enum DoughModifiers {
	
	WHITE(1.5),
	WHOLEGRAIN(1.0),
	CRISPY(0.9),
	CHEWY(1.1),
	HOMEMADE(1.0);
	
	private double value;
	
	private DoughModifiers(double value) {
		this.value = value;
	}
	
	public double getValue() {
		return value;
	}

}
