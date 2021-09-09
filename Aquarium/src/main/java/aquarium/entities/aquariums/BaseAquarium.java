package aquarium.entities.aquariums;

import java.util.ArrayList;
import java.util.Collection;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

public class BaseAquarium implements Aquarium{
	
	private String name;
	private int capacity;
	private Collection<Decoration> decorations;
	private Collection<Fish> fish;
	
	protected BaseAquarium(String name, int capacity) {
		this.setName(name);
		this.setCapacity(capacity);
		this.decorations = new ArrayList<Decoration>();
		this.fish = new ArrayList<Fish>();
	}
	
	public void setName(String name) {
		if (name.trim().length() < 1) {
			throw new NullPointerException("Aquarium name cannot be null or empty.");
		}
		this.name = name;
	}
	
	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("The number of Fish аn Aquarium can have");
		}
		this.capacity = capacity;
	}

	@Override
	public int calculateComfort() {
		int sum = 0;
		for (Decoration decoration : decorations) {
			sum += decoration.getComfort(); 
		}
		return sum;
	}
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public void addFish(Fish fishAdd) {
		if (fishAdd.getSize() > this.getCapacity()) {
			throw new IllegalStateException("Not enough capacity.");
		}
		this.fish.add(fishAdd);
		setCapacity(getCapacity() - fishAdd.getSize());
		
	}
	@Override
	public void removeFish(Fish fishRemove) {
		this.fish.remove(fishRemove);
		
	}
	@Override
	public void addDecoration(Decoration decoration) {
		this.decorations.add(decoration);
		
	}
	@Override
	public void feed() {
		for (Fish fish : fish) {
			fish.eat();
		}
		
	}
	@Override
	public String getInfo() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%s (%s):", this.name, this.getClass().getSimpleName()));
		sb.append(System.lineSeparator());
		sb.append("Fish:");
		if (fish.isEmpty()) {
			sb.append("none");
		}else {
			for (Fish fish : fish) {
				sb.append(" " + fish.getName());
			}
		}
		sb.append(System.lineSeparator());
		sb.append(String.format("Decorations: %d", this.decorations.size()));
		sb.append(System.lineSeparator());
		sb.append(String.format("Comfort: %d", this.calculateComfort()));
		return sb.toString();
	}
	
	@Override
	public Collection<Fish> getFish() {
		return this.fish;
	}
	
	@Override
	public Collection<Decoration> getDecorations() {
		return this.decorations;
	}

}
