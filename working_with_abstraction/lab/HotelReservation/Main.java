package working_with_abstraction.lab.HotelReservation;

public class Main {

	public static void main(String[] args) {
		runHoliday();

	}

	private static void runHoliday() {
		ConsoleReader reader = new ConsoleReader();
		String input = reader.readLine();
		String[] tokens = InputParser.parseArray(input);
		
		PriceCalcolator calculator = new PriceCalcolator(
				Double.parseDouble(tokens[0]), Integer.parseInt(tokens[1]),
				tokens[3].equals("SecondVisit") ? DiscountType.SECOND_VISIT
						: DiscountType.valueOf(tokens[3].toUpperCase()),
				Season.valueOf(tokens[2].toUpperCase()));
		System.out.printf("%.2f\n", calculator.calculate() );
	}

}
