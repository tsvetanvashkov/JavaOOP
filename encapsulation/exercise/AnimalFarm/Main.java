package encapsulation.exercise.AnimalFarm;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		int age = Integer.parseInt(scan.nextLine());
		scan.close();
		Chicken chicken = new Chicken(name, age);
		System.out.println(chicken.toString());

	}

}
