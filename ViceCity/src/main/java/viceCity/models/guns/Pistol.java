package viceCity.models.guns;

public class Pistol extends BaseGun{
	
	private static final int BULLETSPERBARREL = 10;
	private static final int TOTALBULLETS = 100;

	public Pistol(String name) {
		super(name, BULLETSPERBARREL, TOTALBULLETS);
	}

	@Override
	public int fire() {
		if (getBulletsPerBarrel() == 0 && getTotalBullets() > 0) {
			reload();
		}
		if (getBulletsPerBarrel() > 0) {
			setBulletsPerBarrel(getBulletsPerBarrel() - 1);
		}
		return 1;
	}

	private void reload() {
		setTotalBullets(getTotalBullets() - BULLETSPERBARREL);
		setBulletsPerBarrel(BULLETSPERBARREL);
	}

}
