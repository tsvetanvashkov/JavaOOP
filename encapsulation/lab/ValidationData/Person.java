package encapsulation.lab.ValidationData;

public class Person {
	
	private String firstName;
	private String lastName;
	private int age;
	private double salary;
	
	public Person(String firstName, String lastName, int age, double salary) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAge(age);
		this.setSalary(salary);
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public double getSalary() {
		return this.salary;
		
	}
	
	public void setFirstName(String firstName) {
		nameValidation(firstName);
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		nameValidation(lastName);
		this.lastName = lastName;
	}
	
	public void setAge(int age) {
		if (age <= 0) {
			throw new IllegalStateException("Age cannot be zero or negative integer");
		}
		this.age = age;
	}
	
	public void setSalary(double salary) {
		if (salary < 460) {
			throw new IllegalStateException("Salary cannot be less than 460 leva");
		}
		this.salary = salary;
	}
	
	public void increaseSalary(double percentage) {
		if (this.getAge() < 30) {
			this.setSalary(this.getSalary() + (this.getSalary() * percentage / 200));
		} else {
			this.setSalary(this.getSalary() + (this.getSalary() * percentage / 100));
		}
	}
	
	private void nameValidation(String name) {
		if (name == null || name.trim().length() < 3) {
			throw new IllegalStateException("Name cannot be less than 3 symbols");
		}
	}
	
	@Override
	public String toString() {
		return String.format("%s %s gets %f leva",
				this.getFirstName(),
				this.getLastName(),
				this.getSalary());
	}

}
