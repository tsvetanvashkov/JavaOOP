package interfaces_and_abstraction.lab.SayHelloExtend;

public class European extends BasePerson{
	
	public European(String name) {
		super(name);
	}
	
	@Override
	public String sayHello() {
		return "Hello";
	}

}
