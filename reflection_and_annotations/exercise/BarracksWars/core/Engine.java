package reflection_and_annotations.exercise.BarracksWars.core;

import reflection_and_annotations.exercise.BarracksWars.interfaces.Executable;
import reflection_and_annotations.exercise.BarracksWars.interfaces.Repository;
import reflection_and_annotations.exercise.BarracksWars.interfaces.Runnable;
import reflection_and_annotations.exercise.BarracksWars.interfaces.UnitFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {
	private static final String COMMANDS_PATH = "reflection_and_annotations.exercise.BarracksWars.core.commands.";
	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private String interpretCommand(String[] data, String commandName) {
		Executable command = null;
		commandName = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1);
		try {
			Class<?> clazz = Class.forName(COMMANDS_PATH + commandName);
			Constructor<?> ctor = clazz.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
			command = (Executable)ctor.newInstance(data, this.repository, this.unitFactory);
		} catch (ClassNotFoundException | NoSuchMethodException 
				| SecurityException | InstantiationException 
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return command.execute();
	}

	
}
