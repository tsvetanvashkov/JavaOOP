package interfaces_and_abstraction.lab.SayHello;

public interface Person {
	
	String getName();
	default String sayHello() {
		return "Hello";
	};

}
