package reflection_and_annotations.exercise.HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Class<RichSoilLand> clazz = RichSoilLand.class;
		String input = scan.nextLine();
		while (!input.equals("HARVEST")) {
			fieldsInfo(clazz, input);
			input = scan.nextLine();
		}
		scan.close();
		
	}

	private static void fieldsInfo(Class<RichSoilLand> clazz, String modifier) {
		Field[] declaredFields = clazz.getDeclaredFields();
		if (modifier.equals("all")) {
			printFilds(declaredFields);
		}else {
			Field[] fields = Arrays.stream(declaredFields)
								.filter(f -> Modifier.toString(f.getModifiers()).equals(modifier))
								.toArray(Field[]::new);
			printFilds(fields);
		}
		
	}

	private static void printFilds(Field[] fields) {
		Arrays.stream(fields).forEach(f -> System.out.printf("%s %s %s\n",
				Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName()));
	}
}
