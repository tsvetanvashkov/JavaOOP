package encapsulation.exercise.ShoppingSpree;

public class Product {
	
	private String name;
	private double cost;
	
	public Product(String name, double cost) {
		this.setName(name);
		this.setCost(cost);
	}
	
	private void setName(String name) {
		if (name.trim().isEmpty()) {
			throw new IllegalStateException("Name cannot be empty");
		}
		this.name = name;
	}
	
	private void setCost(double cost) {
		if (cost < 0) {
			throw new IllegalStateException("Cost cannot be a negative");
		}
		this.cost = cost;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getCost() {
		return this.cost;
	}

}
