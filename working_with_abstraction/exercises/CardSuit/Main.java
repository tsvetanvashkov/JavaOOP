package working_with_abstraction.exercises.CardSuit;

public class Main {

	public static void main(String[] args) {
		
		CardSuit[] cardSuits = CardSuit.values();
		System.out.println("Card Suits:");
		for (CardSuit cardSuit : cardSuits) {
			int ordinalValue = cardSuit.ordinal();
			String nameValue = cardSuit.name();
			System.out.printf("Ordinal value: %d; Name value: %s\n", ordinalValue, nameValue);
		}

	}

}
