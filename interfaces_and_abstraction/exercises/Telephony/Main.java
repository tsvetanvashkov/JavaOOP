package interfaces_and_abstraction.exercises.Telephony;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<String> numbers = new ArrayList<String>();
		List<String> urls = new ArrayList<String>();
		String[] firstInput = scan.nextLine().split("\\s+");
		String[] secondInput = scan.nextLine().split("\\s+");
		scan.close();
 		numbers = fillList(firstInput);
 		urls = fillList(secondInput);
 		Smartphone smartphone = new Smartphone(numbers, urls);
 		System.out.println(smartphone.call());
 		System.out.println(smartphone.browse());

	}

	private static List<String> fillList(String[] input) {
		List<String> output = new ArrayList<String>();
		for (String string : input) {
			output.add(string);
		}
 		return output;
	}

}
