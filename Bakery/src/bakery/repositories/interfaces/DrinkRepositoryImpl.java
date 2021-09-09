package bakery.repositories.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import bakery.entities.drinks.interfaces.Drink;

public class DrinkRepositoryImpl implements DrinkRepository<Drink>{
	
	private Collection<Drink> models;
	
	public DrinkRepositoryImpl() {
		this.models = new ArrayList<Drink>();
	}

	@Override
	public Collection<Drink> getAll() {
		return Collections.unmodifiableCollection(this.models);
	}

	@Override
	public void add(Drink drink) {
		this.models.add(drink);
	}

	@Override
	public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
		return this.models.stream()
				.filter(d -> d.getName().equals(drinkName) && d.getBrand().equals(drinkBrand))
				.findFirst()
				.orElse(null);
	}


}
