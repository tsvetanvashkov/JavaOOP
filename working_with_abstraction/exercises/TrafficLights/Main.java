package working_with_abstraction.exercises.TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split("\\s+");
		int numberCount = Integer.parseInt(scan.nextLine());
		scan.close();
		List<TrafficLight> trafficLightsList = new ArrayList<TrafficLight>();
		
		for (String initialTraficLight : input) {
			TrafficLight trafficLight = new TrafficLight(Lights.valueOf(initialTraficLight));
			trafficLightsList.add(trafficLight);
		}
		
		for (int i = 0; i < numberCount; i++) {
			for (TrafficLight trafficLight : trafficLightsList) {
				trafficLight.update();
				System.out.print(trafficLight + " ");
			}
			System.out.println();
		}

	}

}
