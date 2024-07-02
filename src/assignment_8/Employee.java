package assignment_8;

public abstract class Employee {
	
	protected String name;
	protected int id;
	protected double basicSalary;
	
	public Employee(String name, int id, double basicSalary) {
		this.basicSalary = basicSalary;
		this.id = id;
		this.name = name;
	}
	
	public abstract double getBasicSalary();
	public abstract double getBonus();
	public abstract double getCompensation();
}
