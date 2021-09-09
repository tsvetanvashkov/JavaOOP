package spaceStation.models.planets;

import java.util.ArrayList;
import java.util.Collection;

import spaceStation.common.ExceptionMessages;

public class PlanetImpl implements Planet{
	
	private String name;
	private Collection<String> items;
	
	public PlanetImpl(String name, Collection<String> items) {
		this.setName(name);
		this.items = new ArrayList<String>();
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.trim().length() < 1) {
			throw new NullPointerException(ExceptionMessages.PLANET_NAME_NULL_OR_EMPTY);
		}
		this.name = name;
	}

	@Override
	public Collection<String> getItems() {
		return this.items;
	}

	@Override
	public void setItems(Collection<String> items) {
		this.items = items;
	}

}
