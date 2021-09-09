package spaceStation.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import spaceStation.models.astronauts.Astronaut;

public class AstronautRepository implements Repository<Astronaut>{
	
	private Collection<Astronaut> astronauts;
	
	public AstronautRepository() {
		this.astronauts = new ArrayList<Astronaut>();
	}

	@Override
	public Collection<Astronaut> getModels() {
		return Collections.unmodifiableCollection(this.astronauts);
	}

	@Override
	public void add(Astronaut model) {
		astronauts.add(model);
	}

	@Override
	public boolean remove(Astronaut model) {
		return astronauts.remove(model);
	}

	@Override
	public Astronaut findByName(String name) {
		for (Astronaut astronaut : astronauts) {
			if (astronaut.getName().equals(name)) {
				return astronaut;
			}
		}
		return null;
	}

}
