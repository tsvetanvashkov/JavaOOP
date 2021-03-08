package working_with_abstraction.exercises.CardsWithPower;

public class Card {
	
	private CardSuit suit;
	private CardRank rank;
	private int power;
	
	public Card(CardSuit suit, CardRank rank) {
		this.suit = suit;
		this.rank = rank;
		cardPower();
	}
	
	private void cardPower() {
		this.power = suit.getValue() + rank.getValue();
	}
	
	@Override
	public String toString() {
		return String.format("Card name: %s of %s; Card power: %d", this.rank, this.suit, this.power);
	}

}
