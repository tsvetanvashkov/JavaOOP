package reflection_and_annotations.exercise.BarracksWars.core.commands;

import reflection_and_annotations.exercise.BarracksWars.interfaces.Repository;
import reflection_and_annotations.exercise.BarracksWars.interfaces.UnitFactory;

public class Retire extends Command{

	public Retire(String[] data, Repository repository, UnitFactory unitFactory) {
		super(data, repository, unitFactory);
	}

	@Override
	public String execute() {
		String unitType = getData()[1];
		getRepository().removeUnit(unitType);
		return unitType + " retired!";
	}

}
