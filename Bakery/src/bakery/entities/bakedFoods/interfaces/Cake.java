package bakery.entities.bakedFoods.interfaces;

public class Cake extends BaseFood{
	
	private final static double INITIAL_BREAD_PORTION = 254;
	
	public Cake(String name, double price) {
		super(name, INITIAL_BREAD_PORTION, price);
	}

}
