package encapsulation.exercise.PizzaCalories;

public class Topping {
	
	private String toppingType;
	private double weight;
	
	public Topping(String toppingType, double weight) {
		this.setToppingType(toppingType);
		this.setWeight(weight);
	}

	private void setToppingType(String toppingType) {
		try {
			ToppingsModifiers.valueOf(toppingType.toUpperCase());
		} catch (Exception e) {
			throw new IllegalStateException(String.format("Cannot place %s on top of your pizza.", this.toppingType));
		}
		this.toppingType = toppingType;
	}

	private void setWeight(double weight) {
		if ((weight < 1) || (weight > 50)) {
			throw new IllegalStateException(String.format("%s weight should be in the range [1..50].", this.toppingType));
		}
		this.weight = weight;
	}
	
	public double calculateCalories() {
		return 2*this.weight*ToppingsModifiers.valueOf(this.toppingType.toUpperCase()).getValue();
	}

}
