package bakery.core;

import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.bakedFoods.interfaces.Bread;
import bakery.entities.bakedFoods.interfaces.Cake;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.drinks.interfaces.Tea;
import bakery.entities.drinks.interfaces.Water;
import bakery.entities.tables.interfaces.InsideTable;
import bakery.entities.tables.interfaces.OutsideTable;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.*;

public class ControllerImpl implements Controller {
	
	private FoodRepository<BakedFood> foodRepository;
	private DrinkRepository<Drink> drinkRepository;
	private TableRepository<Table> tableRepository;
	private double totalIncome;


    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {
    	this.foodRepository = foodRepository;
    	this.drinkRepository = drinkRepository;
    	this.tableRepository = tableRepository;
    	this.totalIncome = 0.0;
    }


    @Override
    public String addFood(String type, String name, double price) {
    	BakedFood bakedFood = this.foodRepository.getByName(name);
        if (bakedFood == null) {
			switch (type) {
			case "Bread":
				bakedFood = new Bread(name, price);
				break;
			case "Cake":
				bakedFood = new Cake(name, price);
				break;
			}
			foodRepository.add(bakedFood);
			return String.format("Added %s (%s) to the menu", name, type);
		}else {
			throw new IllegalArgumentException(String.format("%s %s is already in the menu", type, name));
		}
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        Drink drink = this.drinkRepository.getByNameAndBrand(name, brand);
        if (drink == null) {
			switch (type) {
			case "Tea":
				drink = new Tea(name, portion, brand);				
				break;
			case "Water":
				drink = new Water(name, portion, brand);
				break;
			}
			drinkRepository.add(drink);
			return String.format("Added %s (%s) to the drink menu", name, brand);
		} else {
			throw new IllegalArgumentException(String.format("%s %s is already in the menu", type, name));
		}
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = this.tableRepository.getByNumber(tableNumber);
        if (table == null) {
			switch (type) {
			case "InsideTable":
				table = new InsideTable(tableNumber, capacity);
				break;
			case "OutsideTable":
				table = new OutsideTable(tableNumber, capacity);
				break;
			}
			tableRepository.add(table);
			return String.format("Added table number %d in the bakery", tableNumber);
		}else {
			throw new IllegalArgumentException(String.format("Table %d is already added to the restaurant", tableNumber));
		}
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        for (Table table : tableRepository.getAll()) {
			if (!table.isReserved() && table.getCapacity() >= numberOfPeople) {
				table.reserve(numberOfPeople);
				return String.format("Table %d has been reserved for %d people",
						table.getTableNumber(), numberOfPeople);
			}
		}
        return String.format("No available table for %d people", numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
    	Table table = tableRepository.getByNumber(tableNumber);
    	if (table == null || !table.isReserved()) {
			return String.format("Could not find table with %d", tableNumber);
		}else {
			BakedFood food = foodRepository.getByName(foodName);
			if (food == null) {
				return String.format("No %s in the menu", foodName);
			}else {
				table.orderFood(food);
				return String.format("Table %d ordered %s", tableNumber, foodName);
			}
		}
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
    	Table table = tableRepository.getByNumber(tableNumber);
    	if (table == null || !table.isReserved()) {
			return String.format("Could not find table %d", tableNumber);
		}else {
			Drink drink = drinkRepository.getByNameAndBrand(drinkName, drinkBrand);
			if (drink == null) {
				return String.format("There is no %s %s available", drinkName, drinkBrand);
			}else {
				table.orderDrink(drink);
				return String.format("Table %d ordered %s %s", tableNumber, drinkName, drinkBrand);
			}
		}
    }

    @Override
    public String leaveTable(int tableNumber) {
        Table table = tableRepository.getByNumber(tableNumber);
        double bill = table.getBill();
        this.totalIncome += bill;
        table.clear();
        return String.format("Table: %d\nBill: %.2f", tableNumber, bill);
    }

    @Override
    public String getFreeTablesInfo() {
    	StringBuilder sb = new StringBuilder();
    	for (Table table : tableRepository.getAll()) {
			if (!table.isReserved()) {
				sb.append(table.getFreeTableInfo())
					.append(System.lineSeparator());
			}
		}
        return sb.toString().trim();
    }

    @Override
    public String getTotalIncome() {
        return String.format("Total income: %.2flv", this.totalIncome);
    }
}
