package com.akushwah.java8.examples;

public class Employee {
	private String firstName;
	private String lastName;
	private int salary;
	private String city;
	private String level;

	public Employee(String firstName, String lastName, int salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String getCity() {
		return "Metro";
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + ", city=" + city
				+ ", level=" + level + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + salary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}

	

	

}
