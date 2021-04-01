package polymorphism.exercise.WildFarm;

public class Tiger extends Felime{
	

	public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
		super(animalName, animalType, animalWeight, livingRegion);
	}


	@Override
	public void makeSound() {
		System.out.println("ROAAR!!!");
	}

	@Override
	public void eat(Food food) {
		if (food instanceof Meat) {
			super.eat(food);
		}else {
			throw new IllegalStateException(String.format("%ss are not eating that type of food!", this.getAnimalType()));
		}
	}

}
