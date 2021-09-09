package spaceStation.core;

import java.util.Collection;

public interface Controller {
    String addAstronaut(String type, String astronautName);

    String addPlanet(String planetName, Collection<String> items);

    String retireAstronaut(String astronautName);

    String explorePlanet(String planetName);

    String report();

}
