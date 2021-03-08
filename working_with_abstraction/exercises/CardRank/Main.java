package working_with_abstraction.exercises.CardRank;

public class Main {

	public static void main(String[] args) {
		
		CardRank[] cardRanks = CardRank.values();
		System.out.println("Card Ranks:");
		for (CardRank cardRank : cardRanks) {
			int ordinalValue = cardRank.ordinal();
			String nameValue = cardRank.name();
			System.out.printf("Ordinal value: %d; Name value: %s\n", ordinalValue, nameValue);
		}

	}

}
