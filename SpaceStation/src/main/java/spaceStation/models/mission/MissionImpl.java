package spaceStation.models.mission;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

public class MissionImpl implements Mission{

	@Override
	public void explore(Planet planet, Collection<Astronaut> astronauts) {
		List<String> list = planet.getItems().stream().collect(Collectors.toList());
		for (Astronaut astronaut : astronauts) {
				for (int i = 0; i < list.size(); i++) {
					if (astronaut.canBreath() && !planet.getItems().isEmpty()) {
					String item = list.remove(i);
					astronaut.getBag().getItems().add(item);
					astronaut.breath();
					}else {
						break;
					}
				}
		}
		planet.setItems(list);
		
	}

}
