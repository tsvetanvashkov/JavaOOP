package inheritance.lab.RandomArrayList;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("serial")
public class RandomArrayList<T> extends ArrayList<T>{
	
	public T getRandomElement() {
		int index = ThreadLocalRandom.current().nextInt(super.size());
		return remove(index);
	}

}
