package reflection_and_annotations.lab.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		Class<Reflection> clazz = Reflection.class;
		System.out.println(clazz);
		
		Class<? super Reflection> baseClazz = clazz.getSuperclass();
		System.out.println(baseClazz);
		
		Arrays.stream(clazz.getInterfaces())
				.forEach(i -> System.out.println(i));
		
		try {
			Constructor<Reflection> ctor = clazz.getDeclaredConstructor();
			Reflection reflection = ctor.newInstance();
			System.out.println(reflection.toString());
		} catch (NoSuchMethodException | InstantiationException 
				| IllegalAccessException | IllegalArgumentException 
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}

}
