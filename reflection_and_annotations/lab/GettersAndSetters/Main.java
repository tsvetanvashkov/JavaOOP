package reflection_and_annotations.lab.GettersAndSetters;

import java.lang.reflect.Method;
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
				System.out.println(getter.getName() + " will return " + getter.getReturnType());
			}
			for (Method setter : setters) {
				System.out.println(setter.getName() + " and will set field of " + setter.getParameterTypes()[0]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
