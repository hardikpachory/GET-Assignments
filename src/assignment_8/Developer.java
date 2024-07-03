package assignment_8;

public class Developer extends Employee{

	/**
	 * This class is extneded from parent class Employee and has all properties 
	 * of an Employee class
	 */
	
	// Constructor to initialize the Developer object
	public Developer(String name, double basicSalary) {
		super(name, basicSalary);
	}

	//Overriding the abstract methods
	@Override
	public double getBasicSalary() {
		return getSalary();
	}

	@Override
	public double getBonus() {
		return getSalary() * 0.35;
	}

	@Override
	public double getCompensation() {
		return getSalary() + this.getBonus();
	}
}
