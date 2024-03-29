package viceCity.models.players;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.GunRepository;
import viceCity.repositories.interfaces.Repository;


public abstract class BasePlayer implements Player{

	private String name;
	private int lifePoints;
	private Repository<Gun> gunRepository;
	
	protected BasePlayer(String name, int lifePoints) {
		this.setName(name);
		this.setLifePoints(lifePoints);
		this.gunRepository = new GunRepository();
	}
	
	private void setName(String name) {
		if (name.trim().length() < 1) {
			throw new NullPointerException("Player's name cannot be null or a whitespace!");
		}
		this.name = name;
	}

	private void setLifePoints(int lifePoints) {
		if (lifePoints < 0) {
			throw new IllegalArgumentException("Player life points cannot be below zero!");
		}
		this.lifePoints = lifePoints;
	}

	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public int getLifePoints() {
		return this.lifePoints;
	}
	@Override
	public boolean isAlive() {
		if (this.lifePoints > 0) {
			return true;
		}
		return false;
	}
	@Override
	public Repository<Gun> getGunRepository() {
		return this.gunRepository;
	}
	@Override
	public void takeLifePoints(int points) {
		this.lifePoints = Math.max(0, this.lifePoints - points);
	}
	
	
	
}
