package viceCity.core;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

public class ControllerImpl implements Controller{
	
	private Player mainPlayer;
	private Map<String, Player> players;
	private Deque<Gun> guns;
	private Neighbourhood neighbourhood;
	
	public ControllerImpl() {
		this.mainPlayer = new MainPlayer();
		this.players = new LinkedHashMap<String, Player>();
		this.guns = new ArrayDeque<>();
		this.neighbourhood = new GangNeighbourhood();
	}

	@Override
	public String addPlayer(String name) {
		players.putIfAbsent(name, new CivilPlayer(name));
		return String.format("Successfully added civil player: %s!", name);
	}

	@Override
	public String addGun(String type, String name) {
		Gun gun = null;
		switch (type) {
		case "Pistol":
			gun = new Pistol(name);
			break;
		case "Rifle":
			gun = new Rifle(name);
			break;
		default:
			return "Invalid gun type!";
		}
		guns.offer(gun);
		return String.format("Successfully added %s of type: %s", name, type);
	}

	@Override
	public String addGunToPlayer(String name) {
		Gun gun = guns.poll();
		if (gun == null) {
			return "There are no guns in the queue!";
		}
		if (name.equals("Vercetti")) {
			mainPlayer.getGunRepository().add(gun);
			return String.format("Successfully added %s to the Main Player: %s",
					gun.getName(), mainPlayer.getName());
		}
		Player player = players.get(name);
		if (player == null) {
			return "Civil player with that name doesn't exists!";
		}
		player.getGunRepository().add(gun);
		return String.format("Successfully added %s to the Civil Player: %s", gun.getName(), player.getName());
	}

	@Override
	public String fight() {
		neighbourhood.action(mainPlayer, players.values());
		if (mainPlayer.getLifePoints() == 100 
				&& players.values().stream().allMatch(p -> p.getLifePoints() == 50)) {
			return "Everything is okay!";
		}
		List<Player> deadPlayers = players.values().stream()
								.filter(p -> !p.isAlive())
								.collect(Collectors.toList());
		
		StringBuilder sbOut = new StringBuilder("A fight happened:");
		sbOut.append(System.lineSeparator())
				.append(String.format("Tommy live points: %d!", mainPlayer.getLifePoints()))
				.append(System.lineSeparator())
				.append(String.format("Tommy has killed: %d players!", deadPlayers.size()))
				.append(System.lineSeparator())
				.append(String.format("Left Civil Players: %d!",players.size() - deadPlayers.size()));

		for (Player player : deadPlayers) {
			players.remove(player.getName());
		}
		
		return sbOut.toString().trim();
	}

}
