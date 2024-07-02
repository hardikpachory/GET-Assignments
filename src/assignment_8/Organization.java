package assignment_8;

import java.util.ArrayList;
import java.util.List;

public class Organization {
	private String nameOfOrganization;
	private List<Department> departments;
	
	public Organization(String nameOfOrganization) {
		this.nameOfOrganization = nameOfOrganization;
		departments = new ArrayList<Department>();
	}
	
	public boolean addDepartment(Department dept) {
		return departments.add(dept);
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> allEmployee = new ArrayList<Employee>();
		for(Department dept : departments) {
			allEmployee.addAll(dept.getEmployess());
		}
		return allEmployee;
	}

	public String getNameOfOrganization() {
		return nameOfOrganization;
	}

	public void setNameOfOrganization(String nameOfOrganization) {
		this.nameOfOrganization = nameOfOrganization;
	}
	
}
