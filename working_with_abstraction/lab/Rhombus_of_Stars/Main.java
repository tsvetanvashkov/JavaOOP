package working_with_abstraction.lab.Rhombus_of_Stars;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		
		System.out.println(getTriengalOfStars(n, true));
		System.out.println(getTriengalOfStars(n, false));
		scan.close();

	}
	
	public static String getTriengalOfStars(int n, boolean isUplwardsOrientated) {
		StringBuilder out = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			int spacesCount = isUplwardsOrientated ? n - i : i;
			int starsCount = isUplwardsOrientated? i : n - i;
			out.append(repeatString(spacesCount, " "));
			out.append(repeatString(starsCount, "* "));
			if (i != n) {
				out.append(System.lineSeparator());
			}
			
		}
		return out.toString();
		
	}
	
	public static String repeatString(int count, String repeat) {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < count; i++) {
			out.append(repeat);
		}
		return out.toString();
	}

}
