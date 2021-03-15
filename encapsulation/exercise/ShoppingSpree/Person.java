package encapsulation.exercise.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	private String name;
	private double money;
	private List<Product> products;
	
	public Person(String name, double money) {
		this.setName(name);
		this.setMoney(money);
		this.products = new ArrayList<Product>();
		
	}
	
	private void setName(String name) {
		if (name.trim().isEmpty()) {
			throw new IllegalStateException("Name cannot be empty");
		}
		this.name = name;
	}
	
	private void setMoney(double money) {
		if (money <= 0) {
			throw new IllegalStateException("Money cannot be negative");
		}
		this.money = money;
	}
	
	public void buyProduct(Product product) {
		if (product.getCost() > this.money) {
			System.out.printf("%s can't afford %s\n", this.name, product.getName());
		}else {
			this.money -= product.getCost();
			this.products.add(product);
			System.out.printf("%s bought %s\n", this.name, product.getName());
		}
		
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%s - ", this.name));
		if (this.products.isEmpty()) {
			sb.append("Nothing bought");
		}else {
			for (int i = 0; i < this.products.size(); i++) {
				sb.append(this.products.get(i).getName());
				if (i < (this.products.size() - 1)) {
					sb.append(", ");
				}
				
			}
		}
		
		return sb.toString();
	}

}
