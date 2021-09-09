package viceCity.models.guns;

public class Rifle extends BaseGun{
	
	private static final int BULLETSPERBARREL = 50;
	private static final int TOTALBULLETS = 500;

	public Rifle(String name) {
		super(name, BULLETSPERBARREL, TOTALBULLETS);
	}

	@Override
	public int fire() {
		if (getBulletsPerBarrel() == 0 && getTotalBullets() > 0) {
			reload();
		}
		if (getBulletsPerBarrel() > 0) {
			setBulletsPerBarrel(getBulletsPerBarrel() - 5);
		}
		return 5;
	}

	private void reload() {
		setTotalBullets(getTotalBullets() - BULLETSPERBARREL);
		setBulletsPerBarrel(BULLETSPERBARREL);
	}
	
}
