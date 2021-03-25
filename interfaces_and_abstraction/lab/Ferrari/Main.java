package interfaces_and_abstraction.lab.Ferrari;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String driverName = scan.nextLine();
		scan.close();
		Ferrari ferrari = new Ferrari(driverName);
		System.out.println(ferrari.toString());

	}

}
