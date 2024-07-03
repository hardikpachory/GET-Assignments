package assignment_8;

import java.util.ArrayList;
import java.util.List;

public class Organization {
	/**
	 * The top level class that will have all the departments
	 */
	
	// Data members
	private String nameOfOrganization;
	private List<Department> departments;
	
	// Constructor to initialize the object
	public Organization(String nameOfOrganization) {
		this.nameOfOrganization = nameOfOrganization;
		departments = new ArrayList<Department>();
	}
	
	// Add department to Organization
	public boolean addDepartment(Department dept) {
		return departments.add(dept);
	}
	
	// Return all the employees of the organization
	public List<Employee> getAllEmployees(){
		List<Employee> allEmployee = new ArrayList<Employee>();
		for(Department dept : departments) {
			allEmployee.addAll(dept.getEmployess());
		}
		return allEmployee;
	}
	
	//Getter and Setter
	public String getNameOfOrganization() {
		return nameOfOrganization;
	}

	public void setNameOfOrganization(String nameOfOrganization) {
		this.nameOfOrganization = nameOfOrganization;
	}
	
}
