package working_with_abstraction.exercises.CardsWithPower;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String rank = scan.nextLine();
		String suit = scan.nextLine();
		scan.close();
		Card card = new Card(CardSuit.valueOf(suit), CardRank.valueOf(rank));
		System.out.println(card.toString());

	}

}
