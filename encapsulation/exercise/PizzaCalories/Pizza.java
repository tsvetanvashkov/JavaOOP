package encapsulation.exercise.PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

	private String name;
	private Dough dought;
	private List<Topping> toppings;
	
	public Pizza(String name, int numberOfToppings) {
		this.setName(name);
		this.setToppings(numberOfToppings);
	}
	
	public String getName() {
		return this.name;
	}

	private void setName(String name) {
		if ((name.trim().length() < 1) || (name.trim().length() > 15)) {
			throw new IllegalStateException("Pizza name should be between 1 and 15 symbols.");
		}
		this.name = name;
	}

	public void setDough(Dough dought) {
		this.dought = dought;
	}

	private void setToppings(int numberOfToppings) {
		if ((numberOfToppings < 0) || (numberOfToppings > 10)) {
			throw new IllegalStateException("Number of toppings should be in range [0..10].");
		}
		this.toppings = new ArrayList<Topping>();
		
	}
	
	public void addTopping(Topping topping) {
		this.toppings.add(topping);
	}
	
	public double getOverallCalories() {
		double doughCalories = dought.calculateCalories();
		double toppingsCalories = 0;
		for (Topping topping : toppings) {
			toppingsCalories += topping.calculateCalories();
		}
		return doughCalories + toppingsCalories;
	}
	
}
