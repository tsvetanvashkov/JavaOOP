package interfaces_and_abstraction.lab.SayHello;

public class European implements Person{
	
	private String name;
	
	public European(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
