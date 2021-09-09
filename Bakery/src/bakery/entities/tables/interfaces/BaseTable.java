package bakery.entities.tables.interfaces;

import java.util.ArrayList;
import java.util.Collection;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;

public class BaseTable implements Table{
	
	private Collection<BakedFood> foodOrders;
	private Collection<Drink> drinkOrders;
	private int tableNumber;
	private int capacity;
	private int numberOfPeople;
	private double pricePerPerson;
	private boolean isReserved;
	private double price;
	
	protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
		this.setTableNumber(tableNumber);
		this.setCapacity(capacity);
		this.setPricePerPerson(pricePerPerson);
		this.foodOrders = new ArrayList<BakedFood>();
		this.drinkOrders = new ArrayList<Drink>();
		this.price = 0;
	}

	@Override
	public int getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	@Override
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Capacity has to be greater than 0");
		}
		this.capacity = capacity;
	}

	@Override
	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Cannot place zero or less people!");
		}
		this.numberOfPeople = numberOfPeople;
	}

	@Override
	public double getPricePerPerson() {
		return pricePerPerson;
	}

	public void setPricePerPerson(double pricePerPerson) {
		this.pricePerPerson = pricePerPerson;
	}

	@Override
	public boolean isReserved() {
		return this.isReserved;
	}

	@Override
	public double getPrice() {
		return this.price;
	}

	@Override
	public void reserve(int numberOfPeople) {
		this.setNumberOfPeople(numberOfPeople);
		this.price = numberOfPeople * this.getPricePerPerson();
		this.isReserved = true;
		
	}

	@Override
	public void orderFood(BakedFood food) {
		this.foodOrders.add(food);
	}

	@Override
	public void orderDrink(Drink drink) {
		this.drinkOrders.add(drink);
	}

	@Override
	public double getBill() {
		double bill = this.getPrice();
		bill += this.foodOrders.stream().mapToDouble(f -> f.getPrice()).sum();
		bill += this.drinkOrders.stream().mapToDouble(d -> d.getPrice()).sum();
		return bill;
	}

	@Override
	public void clear() {
		this.foodOrders.clear();
		this.drinkOrders.clear();
		this.isReserved = false;
		this.price = 0;
	}

	@Override
	public String getFreeTableInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Table: %d", this.getTableNumber()))
			.append(System.lineSeparator())
			.append(String.format("Type: %s", this.getClass().getSimpleName()))
			.append(System.lineSeparator())
			.append(String.format("Capacity: %d", this.getCapacity()))
			.append(System.lineSeparator())
			.append(String.format("Price per Person: %.2f", this.getPricePerPerson()));
			
		return sb.toString().trim();
	}

}
