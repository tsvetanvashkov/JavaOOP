package inheritance.exercise.Zoo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String name = scan.nextLine();
		
		Snake snake = new Snake(name);
		
		System.out.println(snake.getName());
		scan.close();

	}

}
