package reflection_and_annotations.exercise.BarracksWars.models.units;

public class Horseman extends AbstractUnit{
	private static final int HORSEMEN_HEALTH = 50;
    private static final int HORSEMEN_DAMAGE = 10;
    
    public Horseman() {
		super(HORSEMEN_HEALTH, HORSEMEN_DAMAGE);
	}
    
}
