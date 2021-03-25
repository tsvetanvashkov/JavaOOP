package interfaces_and_abstraction.lab.SayHelloExtend;

public class Bulgarian extends BasePerson{

	public Bulgarian(String name) {
		super(name);
	}

	@Override
	public String sayHello() {
		return "Здравей";
	}

}
