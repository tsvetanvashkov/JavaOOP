package reflection_and_annotations.exercise.BarracksWars.core.commands;

import reflection_and_annotations.exercise.BarracksWars.interfaces.Repository;
import reflection_and_annotations.exercise.BarracksWars.interfaces.Unit;
import reflection_and_annotations.exercise.BarracksWars.interfaces.UnitFactory;

public class Add extends Command{

	public Add(String[] data, Repository repository, UnitFactory unitFactory) {
		super(data, repository, unitFactory);
	}

	@Override
	public String execute() {
		String unitType = getData()[1];
		Unit unitToAdd = getUnitFactory().createUnit(unitType);
		getRepository().addUnit(unitToAdd);
		return unitType + " added!";
	}

}
