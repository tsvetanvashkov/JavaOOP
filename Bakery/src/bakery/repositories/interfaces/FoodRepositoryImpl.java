package bakery.repositories.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import bakery.entities.bakedFoods.interfaces.BakedFood;

public class FoodRepositoryImpl implements FoodRepository<BakedFood>{

	private Collection<BakedFood> models;
	
	public FoodRepositoryImpl() {
		this.models = new ArrayList<BakedFood>();
	}

	@Override
	public Collection<BakedFood> getAll() {
		return Collections.unmodifiableCollection(this.models);
	}

	@Override
	public void add(BakedFood food) {
		this.models.add(food);
	}

	@Override
	public BakedFood getByName(String name) {
		return this.models.stream()
				.filter(f -> f.getName().equals(name))
				.findFirst()
				.orElse(null);
	}

}
