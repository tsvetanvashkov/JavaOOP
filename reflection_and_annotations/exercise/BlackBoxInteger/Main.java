package reflection_and_annotations.exercise.BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, 
    InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
    	Scanner scan = new Scanner(System.in);
    	Constructor<BlackBoxInt> ctor = BlackBoxInt.class.getDeclaredConstructor();
    	ctor.setAccessible(true);
		BlackBoxInt blackBoxInt = ctor.newInstance();
		Method[] methods = BlackBoxInt.class.getDeclaredMethods();
		Field innerValue = BlackBoxInt.class.getDeclaredField("innerValue");
		innerValue.setAccessible(true);
    	String input = scan.nextLine();
    	while (!input.equals("END")) {
    		String[] command = input.split("_");
			String commandName = command[0];
			int value = Integer.parseInt(command[1]);
    		Method method = Arrays.stream(methods).filter(m -> m.getName().equals(commandName)).findFirst().get();
    		method.setAccessible(true);
    		method.invoke(blackBoxInt, value);
    		System.out.println(innerValue.getInt(blackBoxInt));
    		input = scan.nextLine();
		}
    	scan.close();

    }
}