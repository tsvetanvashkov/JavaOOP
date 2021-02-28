package working_with_abstraction.lab.HotelReservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	

}
