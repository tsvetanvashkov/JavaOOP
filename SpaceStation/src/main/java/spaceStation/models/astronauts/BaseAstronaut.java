package spaceStation.models.astronauts;

import spaceStation.common.ExceptionMessages;
import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

public class BaseAstronaut implements Astronaut{

	private String name;
	private double oxygen;
	private Bag bag;
	
	protected BaseAstronaut(String name, double oxygen) {
		this.setName(name);
		this.setOxygen(oxygen);
		this.bag = new Backpack();
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.trim().length() < 1) {
			throw new NullPointerException(ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY);
		}
		this.name = name;
	}

	@Override
	public double getOxygen() {
		return oxygen;
	}

	public void setOxygen(double oxygen) {
		if (oxygen < 0) {
			throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
		}
		this.oxygen = oxygen;
	}

	@Override
	public Bag getBag() {
		return bag;
	}

	@Override
	public boolean canBreath() {
		if (this.getOxygen() >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public void breath() {
		this.setOxygen(this.getOxygen() - 10);
	}
	
	
	
}
