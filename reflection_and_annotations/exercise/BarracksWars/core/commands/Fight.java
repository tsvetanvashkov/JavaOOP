package reflection_and_annotations.exercise.BarracksWars.core.commands;

import reflection_and_annotations.exercise.BarracksWars.interfaces.Repository;
import reflection_and_annotations.exercise.BarracksWars.interfaces.UnitFactory;

public class Fight extends Command{

	public Fight(String[] data, Repository repository, UnitFactory unitFactory) {
		super(data, repository, unitFactory);
	}

	@Override
	public String execute() {
		return "fight";
	}

}
