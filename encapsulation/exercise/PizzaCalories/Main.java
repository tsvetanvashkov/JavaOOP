package encapsulation.exercise.PizzaCalories;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Pizza pizza = inputPizza(scan);
		inputDough(scan, pizza);
		inputToppings(scan, pizza);
		printPizzaCalories(pizza); 

	}

	private static void printPizzaCalories(Pizza pizza) {
		System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
		
	}

	private static void inputToppings(Scanner scan, Pizza pizza) {
		String input = scan.nextLine();
		while (!input.equals("END")) {
			String[] command = input.split("\\s+");
			String toppingType = command[1];
			double weight = Double.parseDouble(command[2]);
			Topping topping = new Topping(toppingType, weight);
			pizza.addTopping(topping);
			input = scan.nextLine();
		}
		
	}

	private static void inputDough(Scanner scan, Pizza pizza) {
		String[] input = scan.nextLine().split("\\s+");
		String flourType = input[1];
		String bakingTechnique = input[2];
		double weight = Double.parseDouble(input[3]);
		Dough dought = new Dough(flourType, bakingTechnique, weight);
		pizza.setDough(dought);
		
	}

	private static Pizza inputPizza(Scanner scan) {
		String[] input = scan.nextLine().split("\\s+");
		String name = input[1];
		int numberOfToppings = Integer.parseInt(input[2]);
		Pizza pizza = new Pizza(name, numberOfToppings);
		return pizza;
	}

}
