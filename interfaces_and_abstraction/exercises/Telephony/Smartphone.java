package interfaces_and_abstraction.exercises.Telephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable{
	
	private List<String> numbers;
	private List<String> urls;
	
	public Smartphone(List<String> numbers, List<String> urls) {
		this.numbers = numbers;
		this.urls = urls;
	}

	@Override
	public String browse() {
		StringBuilder sb = new StringBuilder();
		Pattern pattern = Pattern.compile("^[^\\d\\s]+$");
		for (String url : this.urls) {
			Matcher macher = pattern.matcher(url);
			if (macher.find()) {
				sb.append(String.format("Browsing: %s!", url))
					.append(System.lineSeparator());
			}else {
				sb.append("Invalid URL!")
					.append(System.lineSeparator());
			}
		}
		return sb.toString().trim();
	}

	@Override
	public String call() {
		StringBuilder sb = new StringBuilder();
		Pattern pattern = Pattern.compile("^\\d+$");
		for (String number : this.numbers) {
			Matcher macher = pattern.matcher(number);
			if (macher.find()) {
				sb.append(String.format("Calling... %s", number))
					.append(System.lineSeparator());
			}else {
				sb.append("Invalid number!")
					.append(System.lineSeparator());
			}
		}
		return sb.toString().trim();
	}
	
	

}
