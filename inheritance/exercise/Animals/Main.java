package Animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Animal> animals = new ArrayList<Animal>();
		String anmalType = scan.nextLine();
		while (!anmalType.equals("Beast!")) {
			
			String[] animalInfo = scan.nextLine().split("\\s+");
			String name = animalInfo[0];
			int age = Integer.parseInt(animalInfo[1]);
			String gender = animalInfo[2];
			Animal animal = null;
			try {
				switch (anmalType) {
					case "Dog":
						animal = new Dog(name, age, gender);
						break;
					case "Cat":
						animal = new Cat(name, age, gender);
						break;	
					case "Frog":
						animal = new Frog(name, age, gender);
						break;
					case "Kitten":
						animal = new Kitten(name, age);
						break;
					case "Tomcat":
						animal = new Tomcat(name, age);
						break;
				}
			} catch (IllegalStateException e) {
				System.out.println(e.getMessage());
			}
			animals.add(animal);
			anmalType = scan.nextLine();
		}
		scan.close();
		animals.forEach(e -> System.out.println(e));
		

	}

}
