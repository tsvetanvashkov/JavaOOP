package reflection_and_annotations.exercise.BarracksWars.core.commands;

import reflection_and_annotations.exercise.BarracksWars.interfaces.Executable;
import reflection_and_annotations.exercise.BarracksWars.interfaces.Repository;
import reflection_and_annotations.exercise.BarracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable{

	private String[] data;
	private Repository repository;
	private UnitFactory unitFactory;
	
	protected Command(String[] data, Repository repository, UnitFactory unitFactory) {
		this.data = data;
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	protected String[] getData() {
		return data;
	}

	protected Repository getRepository() {
		return repository;
	}

	protected UnitFactory getUnitFactory() {
		return unitFactory;
	}
	
	

}
