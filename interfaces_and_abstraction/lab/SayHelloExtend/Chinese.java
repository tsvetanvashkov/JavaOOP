package interfaces_and_abstraction.lab.SayHelloExtend;

public class Chinese extends BasePerson{
	
	public Chinese(String name) {
		super(name);
	}

	@Override
	public String sayHello() {
		return "Djydjybydjy";
	}

}
