package reflection_and_annotations.exercise.BarracksWars.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
