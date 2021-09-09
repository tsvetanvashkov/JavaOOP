package spaceStation.core;

import java.util.Collection;

import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

public class ControllerImpl implements Controller {
	
	private AstronautRepository astrinauts;
	private PlanetRepository planets;
	
	public ControllerImpl() {
		this.astrinauts = new AstronautRepository();
		this.planets = new PlanetRepository();
	}

    @Override
    public String addAstronaut(String type, String astronautName) {
    	switch (type) {
		case "Biologist":
			this.astrinauts.add(new Biologist(astronautName));
			break;
		case "Geodesist":
			this.astrinauts.add(new Geodesist(astronautName));
			break;
		case "Meteorologist":
			this.astrinauts.add(new Meteorologist(astronautName));
			break;

		default:
			throw new NullPointerException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
		}
        return String.format("Successfully added %s: %s!", type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, Collection<String> items) {
    	planets.add(new PlanetImpl(planetName, items));
        return String.format("Successfully added Planet: %s!", planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
    	if (astrinauts.findByName(astronautName) == null) {
			throw new IllegalArgumentException(String.format("Astronaut %s doesn't exists!", astronautName));
		}
    	astrinauts.remove(astrinauts.findByName(astronautName));
        return String.format("Astronaut %s was retired!", astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
    	Mission mission = new MissionImpl();
    	for (Astronaut astronaut : astrinauts.getModels()) {
			if (astronaut.getOxygen() > 60) {
				mission.explore(planets.findByName(planetName), astrinauts.getModels());
			}
			if (astronaut.canBreath()) {
				
			}
		}
    	
    	return String.format("Planet: %s was explored! Exploration finished with {deadAstronauts} dead astronauts!", planetName);
    }

    @Override
    public String report() {
        return null;
    }
}
