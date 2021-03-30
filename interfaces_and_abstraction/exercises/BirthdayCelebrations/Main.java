package interfaces_and_abstraction.exercises.BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Birthable> birthables = new ArrayList<Birthable>();
		
		String input = scan.nextLine();
		while (!input.equals("End")) {
			String[] inputInfo = input.split("\\s+");
			switch (inputInfo[0]) {
			case "Citizen":
				String name = inputInfo[1];
				int age = Integer.parseInt(inputInfo[2]);
				String id = inputInfo[3];
				String birthDate = inputInfo[4];
				birthables.add(new Citizen(name, age, id, birthDate));
				break;
			case "Pet":
				String nameP = inputInfo[1];
				String birthDatePet = inputInfo[2];
				birthables.add(new Pet(nameP, birthDatePet));
				break;
			}
			
			input = scan.nextLine();
		}
		String postfixId = scan.nextLine();
		scan.close();
		for (Birthable birthable : birthables) {
			if (birthable.getBirthDate().endsWith(postfixId)) {
				System.out.println(birthable.getBirthDate());
			}
		}

	}

}
