package reflection_and_annotations.exercise.BarracksWars.interfaces;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	void removeUnit(String unitType);
}
