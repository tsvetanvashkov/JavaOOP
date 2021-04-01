package polymorphism.exercise.VehiclesExtension;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Vehicle car = newVehicle(scan);
		Vehicle truck = newVehicle(scan);
		Vehicle bus = newVehicle(scan);
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
				case "Bus":
					System.out.println(bus.drive(distance));
					break;
				}
				break;
			case "Refuel":
				double liters = Double.parseDouble(command[2]);
				try {
					switch (command[1]) {
					case "Car":
						car.refuel(liters);
						break;
					case "Truck":
						truck.refuel(liters);
						break;
					case "Bus":
						bus.refuel(liters);
						break;
					}
				} catch (IllegalStateException e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case "DriveEmpty":
				double distanceE = Double.parseDouble(command[2]);
					System.out.println(bus.drive(distanceE));
				break;
			}
		}
		
		System.out.println(car.toString());
		System.out.println(truck.toString());
		System.out.println(bus.toString());

	}

	private static Vehicle newVehicle(Scanner scan) {
		String[] input = scan.nextLine().split("\\s+");
		double fuelQuantity = Double.parseDouble(input[1]);
		double fuelConsumption = Double.parseDouble(input[2]);
		double tankCapacity = Double.parseDouble(input[3]);
		Vehicle vehicle = null;
		switch (input[0]) {
		case "Car":
			vehicle = new Car(fuelQuantity, fuelConsumption, tankCapacity);
			break;
		case "Truck":
			vehicle = new Truck(fuelQuantity, fuelConsumption, tankCapacity);
			break;
		case "Bus":
			vehicle = new Bus(fuelQuantity, fuelConsumption, tankCapacity);
			break;
		}
		return vehicle;
	}

}
