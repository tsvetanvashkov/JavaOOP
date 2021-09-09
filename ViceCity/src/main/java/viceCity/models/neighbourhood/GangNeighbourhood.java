package viceCity.models.neighbourhood;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.Repository;

public class GangNeighbourhood implements Neighbourhood{

	@Override
	public void action(Player mainPlayer, Collection<Player> civilPlayers) {
		Repository<Gun> gunRepository = mainPlayer.getGunRepository();
		Deque<Player> players = new ArrayDeque<Player>(civilPlayers);
		Deque<Gun> guns = new ArrayDeque<Gun>(gunRepository.getModels());

		Player player = players.poll();
		Gun gun = guns.poll();
		while (player != null && gun != null) {
			while (gun.canFire() && player.isAlive()) {
				int fire = gun.fire();
				player.takeLifePoints(fire);
			}
			
			if (gun.canFire()) {
				player = players.poll();
			}else if (player.isAlive()) {
				gun = guns.poll();
			}
		}
		
		for (Player civilPlayer : civilPlayers) {
			Deque<Gun> playerGuns = new ArrayDeque<Gun>(civilPlayer.getGunRepository().getModels());
			Gun playerGun = playerGuns.poll();
			while (playerGun != null) {
				while (playerGun.canFire() && mainPlayer.isAlive()) {
					int fire = playerGun.fire();
					mainPlayer.takeLifePoints(fire);
				}
				
				if (!mainPlayer.isAlive()) {
					return;
				}
				playerGun = playerGuns.poll();
			}

		}
		
	}

}
