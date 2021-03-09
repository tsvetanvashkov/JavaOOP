package encapsulation.lab.FirstandReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
	
	private String name;
	private List<Person> firstTeam;
	private List<Person> reserveTeam;
	
	public Team(String name) {
		this.setName(name);
		this.firstTeam = new ArrayList<Person>();
		this.reserveTeam = new ArrayList<Person>();
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addPlayer(Person person) {
		if (person.getAge() < 40) {
			firstTeam.add(person);
		} else {
			reserveTeam.add(person);
		}
	}
	
	public List<Person> getFirstTeam(){
		return Collections.unmodifiableList(this.firstTeam);
	}
	
	public List<Person> getReserveTeam(){
		return Collections.unmodifiableList(this.reserveTeam);
	}

}
