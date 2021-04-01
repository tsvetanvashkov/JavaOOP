package polymorphism.exercise.WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Animal animal = null;
		Food food = null;
		List<Animal> listAnimals = new ArrayList<Animal>();
		String input = scan.nextLine();
		while (!input.equals("End")) {
			animal = newAnimal(input);
			food = newFood(scan);
			animal.makeSound();
			try {
				animal.eat(food);
			} catch (IllegalStateException e) {
				System.out.println(e.getMessage());
			}
			listAnimals.add(animal);
			input = scan.nextLine();
		}
		scan.close();
		printAnimals(listAnimals);

	}
	
	private static void printAnimals(List<Animal> listAnimals) {
		for (Animal animal : listAnimals) {
			System.out.println(animal.toString());
		}
		
	}

	private static Food newFood(Scanner scan) {
		String[] input = scan.nextLine().split("\\s+");
		Food food = null;
		String foodType = input[0];
		int quantity  = Integer.parseInt(input[1]);
		switch (foodType) {
		case "Vegetable":
			food = new Vegetable(quantity);
			break;
		case "Meat":
			food = new Meat(quantity);
			break;
		}
		return food;
	}

	private static Animal newAnimal(String input) {
		Animal animal = null;
		String[] inputArray = input.split("\\s+");
		String animalName = inputArray[1];
		String animalType = inputArray[0];
		Double animalWeight = Double.parseDouble(inputArray[2]);
		String livingRegion = inputArray[3];
		switch (animalType) {
		case "Cat":
			String breed = inputArray[4];
			animal = new Cat(animalName, animalType, animalWeight, livingRegion, breed);
			break;
		case "Tiger":
			animal = new Tiger(animalName, animalType, animalWeight, livingRegion);
			break;
		case "Zebra":
			animal = new Zebra(animalName, animalType, animalWeight, livingRegion);
			break;
		case "Mouse":
			animal = new Mouse(animalName, animalType, animalWeight, livingRegion);
			break;

		}
		return animal;
	}

}
