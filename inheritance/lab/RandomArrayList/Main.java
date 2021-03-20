package inheritance.lab.RandomArrayList;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
	
	public static void main(String[] args) {
		
		RandomArrayList<Integer> randomArrayList = new RandomArrayList<Integer>();
		ThreadLocalRandom.current().ints(10)
						.forEach(randomArrayList::add);
		
		System.out.println(randomArrayList.getRandomElement());
		
	}

}
