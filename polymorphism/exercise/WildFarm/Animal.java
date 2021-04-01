package polymorphism.exercise.WildFarm;

public abstract class Animal {
	
	private String animalName;
	private String animalType;
	private Double animalWeight;
	private Integer foodEaten = 0;
	
	protected Animal(String animalName, String animalType, Double animalWeight) {
		this.setAnimalName(animalName);
		this.setAnimalType(animalType);
		this.setAnimalWeight(animalWeight);
	}

	public String getAnimalName() {
		return animalName;
	}

	protected void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public String getAnimalType() {
		return animalType;
	}

	protected void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public Double getAnimalWeight() {
		return animalWeight;
	}

	protected void setAnimalWeight(Double animalWeight) {
		this.animalWeight = animalWeight;
	}

	public Integer getFoodEaten() {
		return foodEaten;
	}

	protected void setFoodEaten(Integer foodEaten) {
		this.foodEaten = foodEaten;
	}
	
	public abstract void makeSound();
	
	public abstract void eat(Food food);

}
