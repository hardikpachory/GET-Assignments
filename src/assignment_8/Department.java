package assignment_8;

import java.util.ArrayList;
import java.util.List;

public class Department {
	/**
	 * The class Department will be able to let employees join their department and to 
	 * relieve them from the department. It will also maintain the list of employees in it.
	 */
	
	// Data Members
	private String name;
	private List<Employee> employees;
	
	// Constructor to initialize the Department object
	public Department(String name) {
		this.name = name;
		employees = new ArrayList<Employee>();
	}
	
	// Add the emplpoyee to the department
	public boolean join(Employee employee) {
		employee.setDeptName(name);
		return employees.add(employee);
	}
	
	// Relieves the employee to the department
	public boolean relieve(Employee employee) {
		return employees.remove(employee);
	}
	
	// Get list of the employees in this department
	public List<Employee> getEmployess(){
		return employees;
	}

	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
