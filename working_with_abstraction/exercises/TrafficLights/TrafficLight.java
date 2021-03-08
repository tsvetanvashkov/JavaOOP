package working_with_abstraction.exercises.TrafficLights;

public class TrafficLight {
	
	private Lights light;

	public TrafficLight(Lights light) {
		super();
		this.light = light;
	}
	
	public void update() {
		switch (this.light) {
		case RED:
			this.light = Lights.GREEN;
			break;
		case GREEN:
			this.light = Lights.YELLOW;
			break;
		case YELLOW:
			this.light = Lights.RED;
			break;
		}
	}
	
	public String toString() {
		return this.light.toString();
	}
	

}
