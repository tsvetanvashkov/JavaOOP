package working_with_abstraction.exercises.JediGalaxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ConsoleReader {
	
	private BufferedReader reader;
	
	public ConsoleReader() {
		this.reader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public String readLine() {
		try {
			return this.reader.readLine();
		} catch (IOException e) {
			throw new IllegalStateException();
		}
	}
	
	public int[] readCoordinate(String input) {
		return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

	}

}
