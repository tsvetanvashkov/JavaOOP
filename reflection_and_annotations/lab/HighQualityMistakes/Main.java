package reflection_and_annotations.lab.HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	
	public static class MethodComparator implements Comparator<Method>{

		@Override
		public int compare(Method f, Method s) {
			return f.getName().compareTo(s.getName());
		}
		
	}

	public static void main(String[] args) {
		Class<Reflection> clazz = Reflection.class;
		try {
			Method[] declaredMethods = clazz.getDeclaredMethods();
			
			Arrays.stream(clazz.getDeclaredFields())
						.filter(f -> !Modifier.isPrivate(f.getModifiers()))
						.sorted(Comparator.comparing(Field::getName))
						.forEach(f -> System.out.println(f.getName() + " must be private!"));
			
			Set<Method> getters = new TreeSet<Method>(new MethodComparator());
			Set<Method> setters = new TreeSet<Method>(new MethodComparator());
			
			for (Method m : declaredMethods) {
				if (m.getName().contains("get")) {
					getters.add(m);
				}else if (m.getName().contains("set")) {
					setters.add(m);
				}
			}
			
			for (Method getter : getters) {
				if (!Modifier.isPublic(getter.getModifiers())) {
					System.out.println(getter.getName() + " have to be public!");
				}
			}
			for (Method setter : setters) {
				if (!Modifier.isPrivate(setter.getModifiers())) {
					System.out.println(setter.getName() + " have to be private!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
