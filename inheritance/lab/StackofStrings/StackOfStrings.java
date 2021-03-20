package inheritance.lab.StackofStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
	
private List<String> data;
	
	public StackOfStrings() {
		this.data = new ArrayList<String>();
	}
	
	public void push(String item) {
		this.data.add(item);
	}
	
	public String pop() {
		if (isEmpty()) {
			return null;
		}else {
			return this.data.remove(data.size() - 1);
		}
	}
	
	public String peek() {
		if (isEmpty()) {
			return null;
		}else {
			return this.data.get(data.size() - 1);
		}
		
	}
	
	public boolean isEmpty() {
		return this.data.isEmpty();
	}

}
