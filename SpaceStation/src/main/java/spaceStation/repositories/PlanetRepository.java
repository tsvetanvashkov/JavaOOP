package spaceStation.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import spaceStation.models.planets.Planet;

public class PlanetRepository implements Repository<Planet>{
	
	private Collection<Planet> planets;
	
	public PlanetRepository() {
		this.planets = new ArrayList<Planet>();
	}

	@Override
	public Collection<Planet> getModels() {
		return Collections.unmodifiableCollection(this.planets);
	}

	@Override
	public void add(Planet model) {
		planets.add(model);
		
	}

	@Override
	public boolean remove(Planet model) {
		return planets.remove(model);
	}

	@Override
	public Planet findByName(String name) {
		for (Planet planet : planets) {
			if (planet.getName().equals(name)) {
				return planet;
			}
		}
		return null;
	}
	
	

}
