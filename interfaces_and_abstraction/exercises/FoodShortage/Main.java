package interfaces_and_abstraction.exercises.FoodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberPersons = Integer.parseInt(scan.nextLine());
		Map<String, Buyer> persons = new HashMap<String, Buyer>();
		while (numberPersons-- > 0) {
			String[] input = scan.nextLine().split("\\s+");
			String name = input[0];
			int age = Integer.parseInt(input[1]);
			if (input.length == 4) {
				String id = input[2];
				String birthDate = input[3];
				persons.putIfAbsent(name, new Citizen(name, age, id, birthDate));
			}else {
				String group = input[2];
				persons.putIfAbsent(name, new Rebel(name, age, group));
			}
		}
		String inputName = scan.nextLine();
		while (!inputName.equals("End")) {
			if (persons.containsKey(inputName)) {
				persons.get(inputName).buyFood();
			}
			inputName = scan.nextLine();
		}
		scan.close();
		int sum = 0;
		for (Entry<String, Buyer> entry : persons.entrySet()) {
			sum += entry.getValue().getFood();
		}
		System.out.println(sum);
		
	}

}
