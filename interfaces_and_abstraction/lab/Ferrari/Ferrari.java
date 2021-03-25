package interfaces_and_abstraction.lab.Ferrari;

public class Ferrari implements Car{
	
	private String driverName;
	private String model;

	public Ferrari(String driverName) {
		this.driverName = driverName;
		this.model = "488-Spider";
	}
	
	@Override
	public String brakes() {
		return "Brakes!";
	}

	@Override
	public String gas() {
		return "brum-brum-brum-brrrrr";
	}

	public String toString() {
		return String.format("%s/%s/%s/%s", this.model, brakes(), gas(), this.driverName);
	}
	
}
