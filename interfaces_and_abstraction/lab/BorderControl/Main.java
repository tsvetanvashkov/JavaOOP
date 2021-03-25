package interfaces_and_abstraction.lab.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Identifiable> identifiables = new ArrayList<Identifiable>();
		
		String input = scan.nextLine();
		while (!input.equals("End")) {
			String[] inputInfo = input.split("\\s+");
			if (inputInfo.length == 3) {
				String name = inputInfo[0];
				int age = Integer.parseInt(inputInfo[1]);
				String id = inputInfo[2];
				identifiables.add(new Citizen(name, age, id));
			}else {
				String model = inputInfo[0];
				String id = inputInfo[1];
				identifiables.add(new Robot(model, id));
			}
			
			input = scan.nextLine();
		}
		String postfixId = scan.nextLine();
		scan.close();
		for (Identifiable identifiable : identifiables) {
			if (identifiable.getId().endsWith(postfixId)) {
				System.out.println(identifiable.getId());
			}
		}
		

	}

}
