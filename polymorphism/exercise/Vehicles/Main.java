package polymorphism.exercise.Vehicles;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Vehicle car = newVehicle(scan);
		Vehicle truck = newVehicle(scan);
		int numberOfCommands = Integer.parseInt(scan.nextLine());
		while (numberOfCommands-- > 0) {
			String[] command = scan.nextLine().split("\\s+");
			switch (command[0]) {
			case "Drive":
				double distance = Double.parseDouble(command[2]);
				switch (command[1]) {
				case "Car":
					System.out.println(car.drive(distance));
					break;
				case "Truck":
					System.out.println(truck.drive(distance));
					break;
				}
				break;
			case "Refuel":
				double liters = Double.parseDouble(command[2]);
				switch (command[1]) {
				case "Car":
					car.refuel(liters);
					break;
				case "Truck":
					truck.refuel(liters);
					break;
				}
				break;
			}
		}
		
		System.out.println(car.toString());
		System.out.println(truck.toString());

	}

	private static Vehicle newVehicle(Scanner scan) {
		String[] input = scan.nextLine().split("\\s+");
		double fuelQuantity = Double.parseDouble(input[1]);
		double fuelConsumption = Double.parseDouble(input[2]);
		Vehicle vehicle = null;
		switch (input[0]) {
		case "Car":
			vehicle = new Car(fuelQuantity, fuelConsumption);
			break;
		case "Truck":
			vehicle = new Truck(fuelQuantity, fuelConsumption);
			break;
		}
		return vehicle;
	}

}
