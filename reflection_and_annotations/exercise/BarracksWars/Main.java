package reflection_and_annotations.exercise.BarracksWars;

import reflection_and_annotations.exercise.BarracksWars.interfaces.Repository;
import reflection_and_annotations.exercise.BarracksWars.interfaces.Runnable;
import reflection_and_annotations.exercise.BarracksWars.interfaces.UnitFactory;
import reflection_and_annotations.exercise.BarracksWars.core.Engine;
import reflection_and_annotations.exercise.BarracksWars.core.factories.UnitFactoryImpl;
import reflection_and_annotations.exercise.BarracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
