package viceCity.models.guns;

public abstract class BaseGun implements Gun{
	
	private String name;
	private int bulletsPerBarrel;
	private int totalBullets;
	@SuppressWarnings("unused")
	private boolean canFire;
	
	protected BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
		this.setName(name);
		this.setBulletsPerBarrel(bulletsPerBarrel);
		this.setTotalBullets(totalBullets);
		this.canFire = true;
	}

	private void setName(String name) {
		if (name.trim().length() < 1) {
			throw new NullPointerException("Name cannot be null or whitespace!");
		}
		this.name = name;
	}

	protected void setBulletsPerBarrel(int bulletsPerBarrel) {
		if (bulletsPerBarrel < 0) {
			throw new IllegalArgumentException("Bullets cannot be below zero!");
		}
		this.bulletsPerBarrel = bulletsPerBarrel;
	}

	protected void setTotalBullets(int totalBullets) {
		if (totalBullets < 0) {
			throw new IllegalArgumentException("Total bullets cannot be below zero!");
		}
		this.totalBullets = totalBullets;
	}
	
	protected void setCanFire(boolean canFire) {
		this.canFire = canFire;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getBulletsPerBarrel() {
		return this.bulletsPerBarrel;
	}

	@Override
	public boolean canFire() {
		return this.totalBullets > 0 || this.bulletsPerBarrel > 0;
	}

	@Override
	public int getTotalBullets() {
		return this.totalBullets;
	}

	@Override
	public abstract int fire();

}
