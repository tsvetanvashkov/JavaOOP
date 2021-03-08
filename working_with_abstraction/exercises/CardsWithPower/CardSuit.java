package working_with_abstraction.exercises.CardsWithPower;

public enum CardSuit {
	
	CLUBS(0), 
	DIAMONDS(13), 
	HEARTS(26), 
	SPADES(39);
	
	private int value;
	
	private CardSuit(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

}
