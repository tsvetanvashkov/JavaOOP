package encapsulation.exercise.PizzaCalories;

public class Dough {

	private String flourType;
	private String bakingTechnique;
	private double weight;
	
	public Dough(String flourType, String bakingTechnique, double weight) {
		this.setFlourType(flourType);
		this.setBakingTechnique(bakingTechnique);
		this.setWeight(weight);
	}

	private void setFlourType(String flourType) {
		try {
			DoughModifiers.valueOf(flourType.toUpperCase());
		} catch (Exception e) {
			throw new IllegalStateException("Invalid type of dough.");
		}
		this.flourType = flourType;
	}

	private void setBakingTechnique(String bakingTechnique) {
		try {
			DoughModifiers.valueOf(bakingTechnique.toUpperCase());
		} catch (Exception e) {
			throw new IllegalStateException("Invalid type of dough.");
		}
		this.bakingTechnique = bakingTechnique;
	}

	private void setWeight(double weight) {
		if ((weight < 1) || (weight > 200)) {
			throw new IllegalStateException("Dough weight should be in the range [1..200].");
		}
		this.weight = weight;
	}
	
	public double calculateCalories() {
		return 2*this.weight
				*DoughModifiers.valueOf(this.flourType.toUpperCase()).getValue()
				*DoughModifiers.valueOf(this.bakingTechnique.toUpperCase()).getValue();
	}
	
}
