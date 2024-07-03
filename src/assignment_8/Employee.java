package assignment_8;

import java.util.UUID;

public abstract class Employee {
	/**
	 * This class will act as the base class of Employee and different
	 * types of employees can be extended from this abstract class
	 */
	
	protected String name;
	protected String id;
	protected double basicSalary;
	protected String deptName;
	
	// Constructor to initialize the Employee
	public Employee(String name, double basicSalary) {
		this.basicSalary = basicSalary;
		this.id = UUID.randomUUID().toString();
		this.name = name;
	}
	
	// Getters and Setters
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public String getDeptName() {
		return deptName;
	}
	
	public double getSalary() {
		return basicSalary;
	}
	
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
	
	// Abstract methods to be overridden
	public abstract double getBasicSalary();
	public abstract double getBonus();
	public abstract double getCompensation();
	
}
