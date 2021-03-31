package polymorphism.lab.Animals;

public abstract class Animal {
	
	private String name;
	private String favouriteFood;
	
	public Animal(String name, String favouriteFood) {
		this.setName(name);
		this.setFavouriteFood(favouriteFood);
	}
	
	
	protected String getName() {
		return name;
	}


	protected void setName(String name) {
		this.name = name;
	}


	private String getFavouriteFood() {
		return favouriteFood;
	}


	private void setFavouriteFood(String favouriteFood) {
		this.favouriteFood = favouriteFood;
	}


	public  String explainSelf() {
		return String.format("I am %snd my favourite food is %sargs", this.getName(), this.getFavouriteFood());
	};

}
