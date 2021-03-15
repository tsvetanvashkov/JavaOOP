package encapsulation.exercise.ShoppingSpree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Map<String, Person> persons = personInput(scan);
		Map<String, Product>  products = productInput(scan);
		shopping(persons, products, scan);
		printPersonBags(persons);

	}

	private static void printPersonBags(Map<String, Person> persons) {
		persons.entrySet().forEach(e ->{
			System.out.println(e.getValue().toString());
		});
		
	}

	private static void shopping(Map<String, Person> persons, Map<String, Product> products, Scanner scan) {
		String input = scan.nextLine();
		while (!input.equals("END")) {
			String[] command = input.split("\\s+");
			String person = command[0];
			String product = command[1];
			persons.get(person).buyProduct(products.get(product));
			input = scan.nextLine();
		}
		
	}

	private static Map<String, Product>  productInput(Scanner scan) {
		Map<String, Product> map = new LinkedHashMap<String, Product>();
		String[] input = scan.nextLine().split("[;=]");
		for (int i = 0; i < input.length; i++) {
			String name = input[i++];
			double cost = Double.parseDouble(input[i]);
			Product product = new Product(name, cost);
			map.putIfAbsent(name, product);
		}
		return map;
	}

	private static Map<String, Person> personInput(Scanner scan) {
		Map<String, Person> map = new LinkedHashMap<String, Person>();
		String[] input = scan.nextLine().split("[;=]");
		for (int i = 0; i < input.length; i++) {
			String name = input[i++];
			double money = Double.parseDouble(input[i]);
			Person person = new Person(name, money);
			map.putIfAbsent(name, person);
		}
		return map;
	}

}
