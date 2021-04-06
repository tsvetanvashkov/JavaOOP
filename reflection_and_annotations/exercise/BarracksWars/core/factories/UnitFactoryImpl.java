package reflection_and_annotations.exercise.BarracksWars.core.factories;

import java.lang.reflect.InvocationTargetException;

import reflection_and_annotations.exercise.BarracksWars.interfaces.Unit;
import reflection_and_annotations.exercise.BarracksWars.interfaces.UnitFactory;


public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"reflection_and_annotations.exercise.BarracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		Unit unit = null;
		Class<?> clazz;
		try {
			clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
			unit = (Unit)clazz.getDeclaredConstructor().newInstance();
		} catch (ClassNotFoundException | InstantiationException 
				| IllegalAccessException | IllegalArgumentException 
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return unit;
	}
}
